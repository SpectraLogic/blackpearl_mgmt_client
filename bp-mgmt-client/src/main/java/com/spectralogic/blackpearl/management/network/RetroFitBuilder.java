/*
 * ****************************************************************************
 *   Copyright 2016 Spectra Logic Corporation. All Rights Reserved.
 *   Licensed under the Apache License, Version 2.0 (the "License"). You may not use
 *   this file except in compliance with the License. A copy of the License is located at
 *   http://www.apache.org/licenses/LICENSE-2.0
 *   or in the "license" file accompanying this file.
 *   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *   CONDITIONS OF ANY KIND, either express or implied. See the License for the
 *   specific language governing permissions and limitations under the License.
 * **************************************************************************
 */

package com.spectralogic.blackpearl.management.network;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Base64;

public final class RetroFitBuilder {

    private final static String NO_API_PREFIX = "no_api_prefix";

    private final static TrustEveryoneManager trustEveryoneManager = new TrustEveryoneManager();

    public static Retrofit build(final String url, final String username, final String password) throws KeyManagementException, NoSuchAlgorithmException {
        return build(url, username, password, addPrefix());
    }

    public static Retrofit build(final String url, final String username, final String password, final boolean apiPrefix) throws KeyManagementException, NoSuchAlgorithmException {
        final String authorization = "Basic " + Base64
                .getEncoder()
                .encodeToString((username + ":" + password).getBytes(Charset.forName("UTF-8")));
        final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(chain -> {
            final Request original = chain.request();

            final Request request = original.newBuilder()
                    .header("Authorization", authorization)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept", "application/json")
                    .method(original.method(), original.body())
                    .build();

            return chain.proceed(request);
        });

        setProxy(httpClient);

        httpClient.addInterceptor(new LoggingInterceptor());
        httpClient.hostnameVerifier((s, sslSession) -> true);
        httpClient.connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT));
        httpClient.sslSocketFactory(createSslSocketFactory(), trustEveryoneManager);

        final OkHttpClient client = httpClient.build();

        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        final String finalUrl;
        if (apiPrefix) {
            finalUrl = url + "/api/";
        } else {
            finalUrl = url;
        }

        return new Retrofit.Builder()
                    .baseUrl(finalUrl)
                    .addConverterFactory(JacksonConverterFactory.create(mapper))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .build();
    }

    private static void setProxy(final OkHttpClient.Builder httpClient) {
        final String proxy = System.getenv("http_proxy");

        if (proxy != null) {
            try {
                final URL url = new URL(proxy);
                httpClient.proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(url.getHost(), url.getPort())));
            } catch (final MalformedURLException e) {
                throw new RuntimeException("Malformed url: " + proxy, e);
            }
        }
    }

    private static boolean addPrefix() {
        final String envVar = System.getenv(NO_API_PREFIX);

        return envVar == null || !envVar.equals("true");
    }

    private static SSLSocketFactory createSslSocketFactory() throws NoSuchAlgorithmException, KeyManagementException {

        // Install the all-trusting trust manager
        final SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, new TrustManager[]{trustEveryoneManager}, new java.security.SecureRandom());
        // Create an ssl socket factory with our all-trusting manager
        return sslContext.getSocketFactory();
    }

    private static class TrustEveryoneManager implements X509TrustManager {
        public void checkClientTrusted(final X509Certificate[] arg0, final String arg1){}
        public void checkServerTrusted(final X509Certificate[] arg0, final String arg1){}
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[]{};
        }
    }
}

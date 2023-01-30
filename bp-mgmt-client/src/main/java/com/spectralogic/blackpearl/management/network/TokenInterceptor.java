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

import com.spectralogic.blackpearl.management.BlackPearlManagementService;
import com.spectralogic.blackpearl.management.models.Token;
import com.spectralogic.blackpearl.management.models.UserCreds;
import io.reactivex.rxjava3.core.Single;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

class TokenInterceptor implements Interceptor {
    private final String tokenUrl;
    private final String user;
    private final String pass;
    private final static String API_TOKENS = "/api/tokens";

    public TokenInterceptor(String url, String username, String password) {
        tokenUrl = url;
        user = username;
        pass = password;
    }

    @Override public Response intercept(Chain chain) throws IOException {
        final Request original = chain.request();

        if (original.url().encodedPath().contains(API_TOKENS) && original.method().equals("POST")) {
            return  chain.proceed(original);
        }
        try {
            final String token = fetchToken();
            final String authorization = "Bearer " + token;
            final Request request = original.newBuilder()
                    .header("Authorization", authorization)
                    .method(original.method(), original.body())
                    .build();
            return chain.proceed(request);

        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to Fetch JWT Token", e);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to Fetch JWT Token", e);
        } catch (KeyManagementException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to Fetch JWT Token", e);
        }
    }

    private String fetchToken() throws InterruptedException, NoSuchAlgorithmException, KeyManagementException {
        final String tokensEndpoint = tokenUrl;

        BlackPearlManagementService managementService = BlackPearlManagementService.getInstance(tokensEndpoint, user, pass);

        UserCreds userCreds = new UserCreds();
        userCreds.setUserAndPass(user, pass);

        final Single<Token> token = managementService.generateToken(userCreds);

        return token.map(Token::getToken).blockingGet();
    }
}

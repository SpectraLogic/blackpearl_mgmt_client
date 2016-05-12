/*
 * *****************************************************************************
 *   Copyright 2016 Spectra Logic Corporation. All Rights Reserved.
 *   Licensed under the Apache License, Version 2.0 (the "License"). You may not use
 *   this file except in compliance with the License. A copy of the License is located at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   or in the "license" file accompanying this file.
 *   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *   CONDITIONS OF ANY KIND, either express or implied. See the License for the
 *   specific language governing permissions and limitations under the License.
 * ***************************************************************************
 */

package com.spectralogic.blackpearl.management.network;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

class LoggingInterceptor implements Interceptor {

    private final static Logger LOG = LoggerFactory.getLogger(LoggingInterceptor.class);

    @Override public Response intercept(Chain chain) throws IOException {
        final Request request = chain.request();

        final long t1 = System.nanoTime();
        LOG.info(String.format("Sending request %s on %s%n%s",
            request.url(), chain.connection(), request.headers()));

        final Response response = chain.proceed(request);

        final long t2 = System.nanoTime();
        LOG.info(String.format("Received response for %s in %.1fms%n%s",
            response.request().url(), (t2 - t1) / 1e6d, response.headers()));

        return response;
    }
}
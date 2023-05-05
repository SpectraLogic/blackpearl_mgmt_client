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

package com.spectralogic.blackpearl.management;

import com.spectralogic.blackpearl.management.models.*;
import com.spectralogic.blackpearl.management.network.RetroFitBuilder;
import io.reactivex.rxjava3.core.Single;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.http.*;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public interface BlackPearlManagementService {
    @GET("activation_keys")
    Single<ActivationKeys> activationKeys();

    @GET("network_interfaces")
    Single<NetworkInterfaces> networkInterfaces();

    @GET("cpus")
    Single<Cpus> cpus();

    @GET("fans")
    Single<Fans> fans();

    @GET("power_supplies")
    Single<PowerSupplies> powerSupplies();

    @GET("cases")
    Single<Cases> cases();

    @GET("users")
    Single<Users> users();

    @GET("nodes")
    Single<Nodes> nodes();

    @GET("ds3/keys")
    Single<UserKeys> key(@Query("user_id") int userId);

    @GET("logs")
    Single<Logs> logSets();

    @POST("logs")
    Single<LogCreateResponse> createLogSet(@Body final LogCreator logCreator);

    @POST("tokens")
    Single<Token> generateToken(@Body final UserCreds credentials);

    @GET("logs/{logSetName}")
    @Streaming
    Single<ResponseBody> getLogSet(@Path("logSetName") final String logSetName);

    static BlackPearlManagementService getInstance(final String endpoint, final String username, final String password) {
        return getInstance(endpoint, username, password, true);
    }

    static BlackPearlManagementService getInstance(final String endpoint, final String username, final String password, final boolean includeApiPrefix) {
        try {
            final Retrofit retrofit = RetroFitBuilder.build(endpoint, username, password, includeApiPrefix);
            return retrofit.create(BlackPearlManagementService.class);
        } catch (final NoSuchAlgorithmException|KeyManagementException e) {
            throw new RuntimeException("Failed to create BlackPearlManagementService instance", e);
        }
    }
}

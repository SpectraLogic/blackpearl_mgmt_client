package com.spectralogic.blackpearl.management;

import com.spectralogic.blackpearl.management.models.*;
import com.spectralogic.blackpearl.management.network.RetroFitBuilder;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.*;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public interface BlackPearlManagementService {
    @GET("network_interfaces")
    Call<NetworkInterfaces> networkInterfaces();

    @GET("cpus")
    Call<Cpus> cpus();

    @GET("fans")
    Call<Fans> fans();

    @GET("power_supplies")
    Call<PowerSupplies> powerSupplies();

    @GET("cases")
    Call<Cases> cases();

    @GET("users")
    Call<Users> users();

    @GET("ds3/keys")
    Call<UserKeys> key(@Query("user_id") int userId);

    @GET("logs")
    Call<Logs> logSets();

    @POST("logs")
    Call<LogCreateResponse> createLogSet(@Body final LogCreator logCreator);

    @GET("logs/{logSetName}")
    @Streaming
    Call<ResponseBody> getLogSet(@Path("logSetName") final String logSetName);

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

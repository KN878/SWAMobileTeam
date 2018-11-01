package com.swa.swamobileteam.transportApi;

import com.swa.swamobileteam.transportApi.authentication.AuthenticationResponse;
import com.swa.swamobileteam.transportApi.authentication.AuthenticationRequestParams;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface TransportApi {
    @POST("account/login")
    Single<AuthenticationResponse> login(@Body AuthenticationRequestParams request);

    @POST("drivers/pending")
    Single<AuthenticationResponse> getSchedule(@Body AuthenticationRequestParams request);

    @POST("drivers/current")
    Single<AuthenticationResponse> getInProgress(@Body AuthenticationRequestParams request);

    @POST("drivers/co_contact")
    Single<AuthenticationResponse> login(@Body AuthenticationRequestParams request);

    @POST("drivers/location")
    Single<AuthenticationResponse> sendLocation(@Body AuthenticationRequestParams request);
}

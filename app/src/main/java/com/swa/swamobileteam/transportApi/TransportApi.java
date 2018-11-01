package com.swa.swamobileteam.transportApi;

import com.swa.swamobileteam.transportApi.authentication.LoginResponse;
import com.swa.swamobileteam.transportApi.authentication.LoginRequestParams;

import io.reactivex.Completable;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface TransportApi {
    @POST("account/login")
    Single<LoginResponse> login(@Body LoginRequestParams request);


    @POST("account/logout")
    Completable logout(@Header("Authorization") String token);

    @POST("drivers/pending")
    Single<AuthenticationResponse> getSchedule(@Body AuthenticationRequestParams request);

    @POST("drivers/current")
    Single<AuthenticationResponse> getInProgress(@Body AuthenticationRequestParams request);

    @POST("drivers/co_contact")
    Single<AuthenticationResponse> login(@Body AuthenticationRequestParams request);

    @POST("drivers/location")
    Single<AuthenticationResponse> sendLocation(@Body AuthenticationRequestParams request);
}

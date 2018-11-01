package com.swa.swamobileteam.transportApi;

import com.swa.swamobileteam.transportApi.authentication.AuthenticationResponse;
import com.swa.swamobileteam.transportApi.authentication.AuthenticationRequestParams;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface TransportApi {
    @POST("account/login")
    Single<AuthenticationResponse> login(@Body AuthenticationRequestParams request);
}

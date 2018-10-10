package com.swa.swamobileteam.transportApi;

import retrofit2.Retrofit;

public class TransportApiClient {
    private TransportApi api;

    public TransportApiClient(Retrofit retrofit) {
        api = retrofit.create(TransportApi.class);
    }
}

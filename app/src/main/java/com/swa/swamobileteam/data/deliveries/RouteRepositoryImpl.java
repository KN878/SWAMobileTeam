package com.swa.swamobileteam.data.deliveries;

import android.support.annotation.NonNull;

import io.reactivex.Single;

public class RouteRepositoryImpl implements RouteRepository {
    @Override
    public Single<Double> getETA(@NonNull Location location) {
        return Single.just(25.0 * 60.0);
    }
}

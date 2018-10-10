package com.swa.swamobileteam.data.deliveries;

import android.support.annotation.NonNull;

import io.reactivex.Single;

public interface RouteRepository {
    /**
     * Returns minimum the time (in seconds) required to drive to given destination.
     * @param location Location to calculate ETA to.
     */
    Single<Double> getETA(@NonNull Location location);
}

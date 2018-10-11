package com.swa.swamobileteam.data.deliveries;

import com.swa.swamobileteam.ui.delivery.DeliveryInfo;

import io.reactivex.Single;

public class DeliveryDetailsRepositoryImpl implements DeliveryDetailsRepository {
    @Override
    public Single<DeliveryInfo> getDeliveryInfo(String deliveryID) {
        return null; // TODO Rozalia
    }

    @Override
    public Double getRemainingTime(DeliveryPeriod period) {
        return null; // TODO Rozalia
    }
}

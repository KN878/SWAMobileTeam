package com.swa.swamobileteam.ui.delivery;

import com.swa.swamobileteam.data.deliveries.DeliveryDetailsRepository;
import com.swa.swamobileteam.data.deliveries.DeliveryDetailsRepositoryImpl;
import com.swa.swamobileteam.data.deliveries.DeliveryPeriod;

import io.reactivex.Single;

public class DeliveryModel implements DeliveryContract.Model {
    private DeliveryDetailsRepository deliveryDetailsRepository;

    public DeliveryModel() {
        this.deliveryDetailsRepository = new DeliveryDetailsRepositoryImpl();
    }

    @Override
    public Single<DeliveryInfo> getDeliveryInfo(String deliveryID) {
        return deliveryDetailsRepository.getDeliveryInfo(deliveryID);
    }

    @Override
    public Double getRemainingTime(DeliveryPeriod period) {
        return deliveryDetailsRepository.getRemainingTime(period);
    }
}

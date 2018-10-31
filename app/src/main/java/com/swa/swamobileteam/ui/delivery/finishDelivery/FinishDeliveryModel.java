package com.swa.swamobileteam.ui.delivery.finishDelivery;

import com.swa.swamobileteam.data.deliveries.InProgressDeliveriesRepository;
import com.swa.swamobileteam.data.deliveries.InProgressDeliveriesRepositoryImpl;

import javax.inject.Inject;

import io.reactivex.Completable;

public class FinishDeliveryModel implements FinishDeliveryContract.Model {

    private InProgressDeliveriesRepository repo;

    @Inject
    FinishDeliveryModel() {
        repo = new InProgressDeliveriesRepositoryImpl();
    }

    @Override
    public Completable finishDelivery(String id) {
        return repo.markDeliveryAsInProgress(id);
    }
}

package com.swa.swamobileteam.data.deliveries;

import android.support.annotation.NonNull;

import com.swa.swamobileteam.ui.deliveryGroups.DeliveriesListItem;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public class InProgressDeliveriesRepositoryImpl implements InProgressDeliveriesRepository {
    @Override
    public Single<List<DeliveriesListItem>> getInProgressDeliveries() {
        return null; // TODO Rozalia
    }

    @Override
    public Completable markDeliveryAsInProgress(@NonNull String deliveryID) {
        return null; // TODO Rozalia
    }
}

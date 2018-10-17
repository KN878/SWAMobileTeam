package com.swa.swamobileteam.data.deliveries;

import android.support.annotation.NonNull;

import com.swa.swamobileteam.ui.deliveryGroups.DeliveriesListItem;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface InProgressDeliveriesRepository {

    /**
     * Marks the desired delivery as being in progress.
     * @param deliveryID identifier of the delivery.
     */
    Completable markDeliveryAsInProgress(@NonNull String deliveryID);

    /**
     * Refreshes list of deliveries in progress
     */
    Completable refresh();

    /**
     * Returns delivery item given its index
     * @param index of delivery item
     * @return delivery iten on given index
     */
    Single<DeliveriesListItem> getDeliveryListItem(int index);
}

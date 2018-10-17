package com.swa.swamobileteam.data.deliveries;

import android.support.annotation.NonNull;

import com.swa.swamobileteam.ui.deliveryGroups.DeliveriesListItem;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface InProgressDeliveriesRepository {
    /**
     * Returns deliveries that are marked as being currently in progress.
     */
    Single<List<DeliveriesListItem>> getInProgressDeliveries();

    /**
     * Marks the desired delivery as being in progress.
     * @param deliveryID identifier of the delivery.
     */
    Completable markDeliveryAsInProgress(@NonNull String deliveryID);
}

package com.swa.swamobileteam.data.deliveries;

import android.support.annotation.Nullable;

import com.swa.swamobileteam.ui.deliveryGroups.DeliveriesListItem;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * A repository that provides deliveries schedule.
 */
public interface DeliveryScheduleRepository {
    /**
     * Refreshes list of scheduled deliveries
     */
    Single<Integer> refresh();

    /**
     * Returns delivery item given its index
     * @param index of delivery item
     * @return delivery iten on given index
     */
    DeliveriesListItem getDeliveryListItem(int index);

    /**
     * Method loads deliveries from repository and returns their count
     * @return
     */
    Single<Integer> loadDeliveries();
}

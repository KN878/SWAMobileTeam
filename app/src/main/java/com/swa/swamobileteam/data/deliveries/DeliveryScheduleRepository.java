package com.swa.swamobileteam.data.deliveries;

import android.support.annotation.Nullable;

import com.swa.swamobileteam.ui.deliveryGroups.DeliveriesListItem;

import java.util.List;

import io.reactivex.Single;

/**
 * A repository that provides deliveries schedule.
 */
public interface DeliveryScheduleRepository {
    /**
     * Returns available delivery schedule.
     * @param offset Offset, from which the returned list should start, needed for pagination.
     *               If null, list will be returned from its beginning.
     * @param limit Maximum amount of items to receive, needed for pagination.
     */
    Single<List<DeliveriesListItem>> getDeliveriesSchedule(@Nullable Integer offset,
                                                           @Nullable Integer limit);
}

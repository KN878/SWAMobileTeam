package com.swa.swamobileteam.data.deliveries;

import android.support.annotation.Nullable;

import com.swa.swamobileteam.ui.deliveryGroups.DeliveriesListItem;

import java.util.List;

import io.reactivex.Single;

public class DeliveryScheduleRepositoryImpl implements DeliveryScheduleRepository {
    @Override
    public Single<List<DeliveriesListItem>> getDeliveriesSchedule(@Nullable Integer offset, @Nullable Integer limit) {
        return null; // TODO implement dummy repo
    }
}

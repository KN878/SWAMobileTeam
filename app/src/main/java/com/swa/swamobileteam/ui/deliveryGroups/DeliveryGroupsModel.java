package com.swa.swamobileteam.ui.deliveryGroups;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.swa.swamobileteam.data.deliveries.DeliveryScheduleRepository;
import com.swa.swamobileteam.data.deliveries.DeliveryScheduleRepositoryImpl;
import com.swa.swamobileteam.data.deliveries.InProgressDeliveriesRepository;
import com.swa.swamobileteam.data.deliveries.InProgressDeliveriesRepositoryImpl;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public class DeliveryGroupsModel implements DeliveryGroupsContract.Model {
    private DeliveryScheduleRepository scheduleRepository;
    private InProgressDeliveriesRepository inProgressDeliveriesRepository;

    public DeliveryGroupsModel() {
        this.scheduleRepository = new DeliveryScheduleRepositoryImpl();
        this.inProgressDeliveriesRepository = new InProgressDeliveriesRepositoryImpl();
    }

    @Override
    public Single<List<DeliveriesListItem>> getDeliveriesSchedule(@Nullable Integer offset, @Nullable Integer limit) {
        return scheduleRepository.getDeliveriesSchedule(offset, limit);
    }

    @Override
    public Single<List<DeliveriesListItem>> getInProgressDeliveries() {
        return inProgressDeliveriesRepository.getInProgressDeliveries();
    }

    @Override
    public Completable markDeliveryAsInProgress(@NonNull String deliveryID) {
        return inProgressDeliveriesRepository.markDeliveryAsInProgress(deliveryID);
    }
}

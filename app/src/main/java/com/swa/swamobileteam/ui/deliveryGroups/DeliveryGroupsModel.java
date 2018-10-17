package com.swa.swamobileteam.ui.deliveryGroups;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.swa.swamobileteam.data.deliveries.DeliveryScheduleRepository;
import com.swa.swamobileteam.data.deliveries.DeliveryScheduleRepositoryImpl;
import com.swa.swamobileteam.data.deliveries.InProgressDeliveriesRepository;
import com.swa.swamobileteam.data.deliveries.InProgressDeliveriesRepositoryImpl;
import com.swa.swamobileteam.data.deliveries.Location;
import com.swa.swamobileteam.data.deliveries.RouteRepository;
import com.swa.swamobileteam.data.deliveries.RouteRepositoryImpl;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

public class DeliveryGroupsModel implements DeliveryGroupsContract.Model {
    private DeliveryScheduleRepository scheduleRepository;
    private InProgressDeliveriesRepository inProgressDeliveriesRepository;
    private RouteRepository routeRepository;

    @Inject
    public DeliveryGroupsModel() {
        this.scheduleRepository = new DeliveryScheduleRepositoryImpl();
        this.inProgressDeliveriesRepository = new InProgressDeliveriesRepositoryImpl();
        this.routeRepository = new RouteRepositoryImpl();
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

    @Override
    public Single<Double> getETA(@NonNull Location location) {
        return routeRepository.getETA(location);
    }
}

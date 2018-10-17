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

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public class DeliveryGroupsModel implements DeliveryGroupsContract.Model {
    private DeliveryScheduleRepository scheduleRepository;
    private InProgressDeliveriesRepository inProgressDeliveriesRepository;
    private RouteRepository routeRepository;

    public DeliveryGroupsModel() {
        this.scheduleRepository = new DeliveryScheduleRepositoryImpl();
        this.inProgressDeliveriesRepository = new InProgressDeliveriesRepositoryImpl();
        this.routeRepository = new RouteRepositoryImpl();
    }

    @Override
    public Completable markDeliveryAsInProgress(@NonNull String deliveryID) {
        return inProgressDeliveriesRepository.markDeliveryAsInProgress(deliveryID);
    }

    @Override
    public Single<Double> getETA(@NonNull Location location) {
        return routeRepository.getETA(location);
    }

    @Override
    public Completable refreshScheduledDeliveries() {
        return scheduleRepository.refresh();
    }

    @Override
    public DeliveriesListItem getScheduledDeliveryListItem(int index) {
        return scheduleRepository.getDeliveryListItem(index);
    }

    @Override
    public Completable refreshInProgressDeliveries() {
        return inProgressDeliveriesRepository.refresh();
    }

    @Override
    public DeliveriesListItem getInProgressDeliveryListItem(int index) {
        return inProgressDeliveriesRepository.getDeliveryListItem(index);
    }

    @Override
    public Single<Integer> loadInProgressDeliveries() {
        return inProgressDeliveriesRepository.loadDeliveries();
    }

    @Override
    public Single<Integer> loadScheduledDeliveries() {
        return scheduleRepository.loadDeliveries();
    }
}

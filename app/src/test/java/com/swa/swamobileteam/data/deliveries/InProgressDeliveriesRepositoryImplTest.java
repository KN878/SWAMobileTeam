package com.swa.swamobileteam.data.deliveries;

import com.swa.swamobileteam.data.authentication.UserAuthenticationRepositoryImpl;
import com.swa.swamobileteam.ui.deliveryGroups.DeliveriesListItem;

import org.junit.Test;

import java.util.List;

import io.reactivex.observers.TestObserver;

import static org.junit.Assert.*;

public class InProgressDeliveriesRepositoryImplTest {

    @Test
    public void getInProgressDeliveries() {
        InProgressDeliveriesRepositoryImpl deliveryScheduleRepository = new InProgressDeliveriesRepositoryImpl();
        TestObserver<List<DeliveriesListItem>> observer = deliveryScheduleRepository.getInProgressDeliveries().test();
    }

    @Test
    public void markDeliveryAsInProgress() {
        TestObserver<Void> observer = new TestObserver<Void>();
        InProgressDeliveriesRepositoryImpl repository = new InProgressDeliveriesRepositoryImpl();
        repository.markDeliveryAsInProgress("123456").subscribe(observer);
        observer.assertComplete();
    }
}
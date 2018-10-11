package com.swa.swamobileteam.data.deliveries;

import com.swa.swamobileteam.ui.deliveryGroups.DeliveriesListItem;

import org.junit.Test;

import java.util.List;

import io.reactivex.observers.TestObserver;

import static org.junit.Assert.*;

public class DeliveryScheduleRepositoryImplTest {

    @Test
    public void getDeliveriesSchedule() {
        DeliveryScheduleRepositoryImpl deliveryScheduleRepository = new DeliveryScheduleRepositoryImpl();
        TestObserver<List<DeliveriesListItem>> observer = deliveryScheduleRepository.getDeliveriesSchedule(100, 100).test();
    }
}
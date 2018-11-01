package com.swa.swamobileteam.data.deliveries;

import com.swa.swamobileteam.ui.deliveryGroups.DeliveriesListItem;

import org.junit.Test;

import java.util.List;

import io.reactivex.observers.TestObserver;

import static org.junit.Assert.*;

public class RouteRepositoryImplTest {
    @Test
    public void getETA() {
        Location location = new Location(123.0, 123.0);
        RouteRepositoryImpl repository = new RouteRepositoryImpl();
        TestObserver<Double> observer = repository.getETA(location).test().assertValue(1500.0);
    }

    @Test
    public void getETA2() {
        Location location = new Location(125.0, 323.0);
        RouteRepositoryImpl repository = new RouteRepositoryImpl();
        TestObserver<Double> observer = repository.getETA(location).test().assertValue(1500.0);
    }
}
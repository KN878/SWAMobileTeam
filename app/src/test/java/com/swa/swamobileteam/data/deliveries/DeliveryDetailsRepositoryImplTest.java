package com.swa.swamobileteam.data.deliveries;

import com.swa.swamobileteam.ui.delivery.DeliveryInfo;
import com.swa.swamobileteam.ui.deliveryGroups.DeliveriesListItem;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import io.reactivex.Single;
import io.reactivex.observers.TestObserver;

import static org.junit.Assert.*;

public class DeliveryDetailsRepositoryImplTest {

    @Test
    public void getDeliveryInfo() {
        DeliveryDetailsRepository repository = new DeliveryDetailsRepositoryImpl();
        TestObserver<DeliveryInfo> observer = repository.getDeliveryInfo("12343242").test().assertSubscribed();
    }

    @Test
    public void getRemainingTime() {
        String stringStartDate = "12:09:2018, 10:00";
        String stringEndDate = "12:09:2018, 11:30";
        Date startDate = new Date();
        Date finishDate = new Date();

        try {
            startDate = new SimpleDateFormat("dd:MM:yyyy, HH:mm").parse(stringStartDate);
            finishDate = new SimpleDateFormat("dd:MM:yyyy, HH:mm").parse(stringEndDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        Location location = new Location(55.747371, 48.744381);
        Address address = new Address("Innopolis, Baker Street, 221b", location);

        DeliveryPeriod deliveryPeriod = new DeliveryPeriod(startDate, finishDate);

        DeliveryDetailsRepository repository = new DeliveryDetailsRepositoryImpl();
        double remainingTime = repository.getRemainingTime(deliveryPeriod);
        assertEquals(10.0, remainingTime);
    }
}
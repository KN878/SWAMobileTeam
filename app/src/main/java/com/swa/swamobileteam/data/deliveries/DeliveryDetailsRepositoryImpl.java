package com.swa.swamobileteam.data.deliveries;

import com.swa.swamobileteam.ui.delivery.DeliveryInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.reactivex.Single;

public class DeliveryDetailsRepositoryImpl implements DeliveryDetailsRepository {
    @Override
    public Single<DeliveryInfo> getDeliveryInfo(String deliveryID) {

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
        ClientInfo clientInfo = new ClientInfo("Rozaliya", "Amirova", "+79600308025");

        ParcelInfo.Dimensions dimensions = new ParcelInfo.Dimensions(10.0, 20.0, 30.0);
        ParcelInfo parcelInfo = new ParcelInfo(100.0, dimensions);
        DeliveryInfo deliveryInfo = new DeliveryInfo("12345", parcelInfo, clientInfo, address, deliveryPeriod, false);
        return Single.just(deliveryInfo);
    }

    @Override
    public Double getRemainingTime(DeliveryPeriod period) {
        return 10.0;
    }
}

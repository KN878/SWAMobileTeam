package com.swa.swamobileteam.data.deliveries;

import android.annotation.SuppressLint;
import android.support.annotation.Nullable;

import com.swa.swamobileteam.ui.deliveryGroups.DeliveriesListItem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public class DeliveryScheduleRepositoryImpl implements DeliveryScheduleRepository {

    ArrayList<DeliveriesListItem> deliveriesListItems = new ArrayList<DeliveriesListItem>();
    boolean isListUpdated = true;

    public DeliveryScheduleRepositoryImpl() {
        deliveriesListItems = generateData();
    }

    @Override
    public Completable refresh() {
        isListUpdated = !isListUpdated;
        deliveriesListItems = generateData();
        return Completable.complete();
    }

    @Override
    public Single<Integer> loadDeliveries() {
        deliveriesListItems = generateData();
        return Single.just(deliveriesListItems.size());
    }

    @Override
    public DeliveriesListItem getDeliveryListItem(int index) {
        return deliveriesListItems.get(index);
    }

    private ArrayList<DeliveriesListItem> generateData() {
        String stringEndDate6 = "15:10:2018, 23:37";
        String stringStartDate6 = "15:10:2018, 09:10";
        Date startDate1 = new Date();
        Date finishDate1 = new Date();

        String stringStartDate2 = "16:10:2018, 10:15";
        String stringEndDate2 = "16:10:2018, 12:10";
        Date startDate2 = new Date();
        Date finishDate2 = new Date();

        String stringStartDate3 = "16:10:2018, 13:20";
        String stringEndDate3 = "16:10:2018, 14:00";
        Date startDate3 = new Date();
        Date finishDate3 = new Date();

        String stringStartDate4 = "16:10:2018, 15:00";
        String stringEndDate4 = "16:10:2018, 18:10";
        Date startDate4 = new Date();
        Date finishDate4 = new Date();

        String stringEndDate5 = "16:10:2018, 21:00";
        String stringStartDate5 = "16:10:2018, 10:00";
        Date startDate5 = new Date();
        Date finishDate5 = new Date();

        String stringEndDate1 = "17:10:2018, 21:00";
        String stringStartDate1 = "17:10:2018, 10:00";
        Date startDate6 = new Date();
        Date finishDate6 = new Date();


        try {
            startDate1 = new SimpleDateFormat("dd:MM:yyyy, HH:mm").parse(stringStartDate1);
            finishDate1 = new SimpleDateFormat("dd:MM:yyyy, HH:mm").parse(stringEndDate1);

            startDate2 = new SimpleDateFormat("dd:MM:yyyy, HH:mm").parse(stringStartDate2);
            finishDate2 = new SimpleDateFormat("dd:MM:yyyy, HH:mm").parse(stringEndDate2);

            startDate3 = new SimpleDateFormat("dd:MM:yyyy, HH:mm").parse(stringStartDate3);
            finishDate3 = new SimpleDateFormat("dd:MM:yyyy, HH:mm").parse(stringEndDate3);

            startDate4 = new SimpleDateFormat("dd:MM:yyyy, HH:mm").parse(stringStartDate4);
            finishDate4 = new SimpleDateFormat("dd:MM:yyyy, HH:mm").parse(stringEndDate4);

            startDate5 = new SimpleDateFormat("dd:MM:yyyy, HH:mm").parse(stringStartDate5);
            finishDate5 = new SimpleDateFormat("dd:MM:yyyy, HH:mm").parse(stringEndDate5);

            startDate6 = new SimpleDateFormat("dd:MM:yyyy, HH:mm").parse(stringStartDate6);
            finishDate6 = new SimpleDateFormat("dd:MM:yyyy, HH:mm").parse(stringEndDate6);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Location location1 = new Location(51.520664584, -0.15499938);
        Location location2 = new Location(100.520664584, 0.35499938);
        Location location3 = new Location(234.520664584, 123.15499938);
        Location location4 = new Location(20.520664584, 230.15499938);
        Location location5 = new Location(220.520664584, 23.15499938);
        Location location6 = new Location(220.520664584, 23.15499938);

        Address address1 = new Address("New York, Baker Street, 221b", location1);
        Address address2 = new Address("Innopolis, Universitetskaya, 1", location2);
        Address address3 = new Address("Kazan, Kremlevskaya, 1", location3);
        Address address4 = new Address("Tataratan, Vvedenskaya Sloboda, 3", location4);
        Address address5 = new Address("Kemerovo, Centralnaya, 10", location5);
        Address address6 = new Address("Kemerovo, Centralnaya, 10", location5);

        DeliveryPeriod deliveryPeriod1 = new DeliveryPeriod(startDate1, finishDate1);
        DeliveryPeriod deliveryPeriod2 = new DeliveryPeriod(startDate2, finishDate2);
        DeliveryPeriod deliveryPeriod3 = new DeliveryPeriod(startDate3, finishDate3);
        DeliveryPeriod deliveryPeriod4 = new DeliveryPeriod(startDate4, finishDate4);
        DeliveryPeriod deliveryPeriod5 = new DeliveryPeriod(startDate5, finishDate5);
        DeliveryPeriod deliveryPeriod6 = new DeliveryPeriod(startDate6, finishDate6);

        DeliveriesListItem item1 = new DeliveriesListItem("1024843553", address1,
                deliveryPeriod1, false, 12.1);
        DeliveriesListItem item2 = new DeliveriesListItem("1024843554", address2,
                deliveryPeriod2, false, 10.3);
        DeliveriesListItem item3 = new DeliveriesListItem("1024843555", address3,
                deliveryPeriod3, false, 2.7);
        DeliveriesListItem item4 = new DeliveriesListItem("1024843556", address4,
                deliveryPeriod4, false, 32.0);
        DeliveriesListItem item5 = new DeliveriesListItem("1024843557", address5,
                deliveryPeriod5, false, 4.5);
        DeliveriesListItem item6 = new DeliveriesListItem("1024843558", address6,
                deliveryPeriod6, false, 4.89);

        if (isListUpdated) {
            return new ArrayList<DeliveriesListItem>(Arrays.asList(item1, item2, item3, item4, item5));
        }
        return new ArrayList<DeliveriesListItem>(Arrays.asList(item1, item2, item3, item4, item5, item6));
    }
}

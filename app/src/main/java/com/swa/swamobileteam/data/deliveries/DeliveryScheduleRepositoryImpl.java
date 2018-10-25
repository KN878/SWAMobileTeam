package com.swa.swamobileteam.data.deliveries;

import android.annotation.SuppressLint;
import android.support.annotation.Nullable;

import com.swa.swamobileteam.ui.deliveryGroups.DeliveriesListItem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import io.reactivex.Single;

public class DeliveryScheduleRepositoryImpl implements DeliveryScheduleRepository {

    @Override
    public Single<List<DeliveriesListItem>> getDeliveriesSchedule(@Nullable Integer offset, @Nullable Integer limit) {
        List<DeliveriesListItem> deliveries = generateData();
        return Single.just(deliveries);
    }

    private List<DeliveriesListItem> generateData() {

        String stringStartDate1 = "11:09:2018, 23:37";
        String stringEndDate1 = "12:09:2018, 09:10";
        Date startDate1 = new Date();
        Date finishDate1 = new Date();

        String stringStartDate2 = "12:09:2018, 10:15";
        String stringEndDate2 = "12:09:2018, 12:10";
        Date startDate2 = new Date();
        Date finishDate2 = new Date();

        String stringStartDate3 = "12:09:2018, 13:20";
        String stringEndDate3 = "12:09:2018, 14:00";
        Date startDate3 = new Date();
        Date finishDate3 = new Date();

        String stringStartDate4 = "12:09:2018, 15:00";
        String stringEndDate4 = "12:09:2018, 18:10";
        Date startDate4 = new Date();
        Date finishDate4 = new Date();

        String stringStartDate5 = "12:09:2018, 21:00";
        String stringEndDate5 = "13:09:2018, 10:00";
        Date startDate5 = new Date();
        Date finishDate5 = new Date();

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
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Location location1 = new Location(51.520664584, -0.15499938);
        Location location2 = new Location(100.520664584, 0.35499938);
        Location location3 = new Location(234.520664584, 123.15499938);
        Location location4 = new Location(20.520664584, 230.15499938);
        Location location5 = new Location(220.520664584, 23.15499938);

        Address address1 = new Address("New York, Baker Street, 221b", location1);
        Address address2 = new Address("Innopolis, Universitetskaya, 1", location2);
        Address address3 = new Address("Kazan, Kremlevskaya, 1", location3);
        Address address4 = new Address("Tataratan, Vvedenskaya Sloboda, 3", location4);
        Address address5 = new Address("Kemerovo, Centralnaya, 10", location5);

        DeliveryPeriod deliveryPeriod1 = new DeliveryPeriod(startDate1, finishDate1);
        DeliveryPeriod deliveryPeriod2 = new DeliveryPeriod(startDate2, finishDate2);
        DeliveryPeriod deliveryPeriod3 = new DeliveryPeriod(startDate3, finishDate3);
        DeliveryPeriod deliveryPeriod4 = new DeliveryPeriod(startDate4, finishDate4);
        DeliveryPeriod deliveryPeriod5 = new DeliveryPeriod(startDate5, finishDate5);

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
        return Arrays.asList(item1, item2, item3, item4, item5);
    }
}

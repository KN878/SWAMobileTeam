package com.swa.swamobileteam.ui.deliveryGroups;

import android.view.View;

import com.swa.swamobileteam.data.deliveries.Location;
import com.swa.swamobileteam.utils.DateFormatter;
import com.swa.swamobileteam.utils.DeliveryType;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.internal.operators.single.SingleCache;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class DeliveryGroupsPresenter implements DeliveryGroupsContract.Presenter {

    private DeliveryGroupsContract.View view;
    private DeliveryGroupsContract.Model model;
    private CompositeDisposable disposable = new CompositeDisposable();
    private int deliveriesCount = 0;
    private DateFormatter dateFormatter = new DateFormatter();

    @Inject
    DeliveryGroupsPresenter(DeliveryGroupsContract.Model model) {
        this.model = model;
    }

    @Override
    public void attachView(DeliveryGroupsContract.View view, boolean isNew) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void stop() {
        if (disposable != null && disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    @Override
    public void onBindDeliveryGroup(DeliveryGroupsContract.DeliveryView deliveryView, int position) {
        if (view != null) {
            if (view.getType() != null) {
                DeliveriesListItem delivery;
                if (view.getType().equals(DeliveryType.New)) {
                    delivery = model.getScheduledDeliveryListItem(position);
                } else {
                    delivery = model.getScheduledDeliveryListItem(position);
                }

                //Converting time
                Date start = delivery.getDeliveryPeriod().getStart();
                Date end = delivery.getDeliveryPeriod().getEnd();
                deliveryView.setTimePeriod(getTime(start) + " - " + getTime(end));
                deliveryView.setParcelId(delivery.getId());
                deliveryView.setAddress(delivery.getAddress().getAddress());
                deliveryView.setWeight(delivery.getWeight());
                setEstimatedTime(deliveryView, delivery.getAddress().getLocation());
            }
        }
    }

    @Override
    public int getDeliveriesCount() {
        return deliveriesCount;
    }

    @Override
    public void loadDeliveries() {
        if (view != null) {
            if (view.getType() != null) {
                if (view.getType().equals(DeliveryType.New)) {
                    disposable.add(model.loadScheduledDeliveries()
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(
                                    deliveriesCount -> {
                                        view.hideLoadingBar();
                                        if (deliveriesCount > 0) {
                                            this.deliveriesCount += deliveriesCount;
                                            view.notifyDataSetChanged();
                                        } else {
                                            view.showNoDeliveries();
                                        }
                                    },
                                    error -> loadDeliveries()
                            )
                    );
                }
                if (view.getType().equals(DeliveryType.InProgress)) {
                    disposable.add(model.loadInProgressDeliveries()
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(
                                    deliveriesCount -> {
                                        view.hideLoadingBar();
                                        if (deliveriesCount > 0) {
                                            this.deliveriesCount += deliveriesCount;
                                            view.notifyDataSetChanged();
                                        } else {
                                            view.showNoDeliveries();
                                        }
                                    },
                                    error -> loadDeliveries()
                            )
                    );
                }

            }
        }
    }

    private void setEstimatedTime(DeliveryGroupsContract.DeliveryView deliveryView, Location location) {
        disposable.add(model.getETA(location)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        time -> deliveryView.setEstimatedTime(String.valueOf(time)),
                        error -> setEstimatedTime(deliveryView, location)
                )
        );
    }

    private String getTime(Date date) {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        String hours;
        String minutes;
        if (calendar.get(Calendar.HOUR_OF_DAY) < 10) {
            hours = "0" + calendar.get(Calendar.HOUR_OF_DAY);
        } else {
            hours = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
        }
        if (calendar.get(Calendar.MINUTE) < 10) {
            minutes = "0" + calendar.get(Calendar.MINUTE);
        } else {
            minutes = String.valueOf(calendar.get(Calendar.MINUTE));
        }
        return hours + ":" + minutes;
    }
}

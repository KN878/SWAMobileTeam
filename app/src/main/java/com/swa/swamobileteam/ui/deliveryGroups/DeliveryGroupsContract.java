package com.swa.swamobileteam.ui.deliveryGroups;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.swa.swamobileteam.data.deliveries.Location;
import com.swa.swamobileteam.ui.base.BaseModel;
import com.swa.swamobileteam.ui.base.BasePresenter;
import com.swa.swamobileteam.ui.base.BaseView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface DeliveryGroupsContract {

    interface View extends BaseView {

    }

    interface Presenter extends BasePresenter<View> {

    }

    interface Model extends BaseModel {

        /**
         * Marks the desired delivery as being in progress.
         * @param deliveryID identifier of the delivery.
         */
        Completable markDeliveryAsInProgress(@NonNull String deliveryID);

        /**
         * Returns minimum the time (in seconds) required to drive to given destination.
         * @param location Location to calculate ETA to.
         */
        Single<Double> getETA(@NonNull Location location);

        /**
         * Refreshes list of scheduled deliveries
         */
        public Completable refreshScheduledDeliveries();

        /**
         * Returns delivery item given its index
         * @param index of delivery item
         * @return delivery iten on given index
         */
        Single<DeliveriesListItem>  getScheduledDeliveryListItem(int index);

        /**
         * Refreshes list of scheduled deliveries
         */
        public Completable refreshInProgressDeliveries();

        /**
         * Returns delivery item given its index
         * @param index of delivery item
         * @return delivery iten on given index
         */
        Single<DeliveriesListItem>  getInProgressDeliveryListItem(int index);
    }
}

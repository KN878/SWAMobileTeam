package com.swa.swamobileteam.ui.deliveryGroups;

import android.view.View;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.swa.swamobileteam.data.deliveries.Location;
import com.swa.swamobileteam.ui.base.BaseModel;
import com.swa.swamobileteam.ui.base.BasePresenter;
import com.swa.swamobileteam.ui.base.BaseView;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface DeliveryGroupsContract {

    interface View extends BaseView {
        /**
         * Hides the initial loading bar
         */
        void hideLoadingBar();

        /**
         * Shows the message that there are no deliveries
         */
        void showNoDeliveries();

        /**
         * Hides the message about absence of deliveries
         */
        void hideNoDeliveries();
    }
    interface Presenter extends BasePresenter<View> {
        /**
         * Bind delivery view to the adapter
         * @param deliveryView view to be bound
         * @param position binding position
         */
        void onBindDeliveryGroup(DeliveryView deliveryView, int position);

        /**
         * Returns number of deliveries in the recycler view
         * @return number of the deliveries
         */
        int getDeliveriesCount();
    }

    interface Model extends BaseModel {
        /**
         * Returns available delivery schedule.
         * @param offset Offset, from which the returned list should start, needed for pagination.
         *               If null, list will be returned from its beginning.
         * @param limit Maximum amount of items to receive, needed for pagination.
         */
        Single<List<DeliveriesListItem>> getDeliveriesSchedule(@Nullable Integer offset,
                                                               @Nullable Integer limit);

        /**
         * Returns deliveries that are marked as being currently in progress.
         */
        Single<List<DeliveriesListItem>> getInProgressDeliveries();

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
    }

    interface DeliveryView extends BaseView{

        /**
         * Shows the date above the delivery
         * @param date date of the delivery
         */
        void showDateDivider(String date);

        /**
         * Hides the date above the delivery
         */
        void hideDateDivider();

        /**
         * Sets the time of the delivery
         * @param time time of the delivery
         */
        void setTimePeriod(String time);

        /**
         * Sets parcel id of the delivery
         * @param id identifier of the delivery
         */
        void setParcelId(String id);

        /**
         * Sets address of the delivery
         * @param address address of the delivery
         */
        void setAddress(String address);

        /**
         * Sets weight of the delivery
         * @param weight weight of the delivery
         */
        void setWeight(Double weight);

        /**
         * Sets the estimated time of the delivery
         * @param time estimated time of the delvery
         */
        void setEstimatedTime(String time);
    }
}

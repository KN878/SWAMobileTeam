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

    }

    interface Presenter extends BasePresenter<View> {
        DeliveryView getDeliveryViewHolder(android.view.View view);

        void onBindDeliveryGroup(DeliveryView deliveryView, int position);

        int getGroupCount();
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

    interface DeliveryView {
        void showDateDivider(String date);

        void hideDateDivider();

        void setTimePeriod(String time);

        void setParcelId(String id);

        void setAddress(String address);

        void setWeight(Double weight);

        void setEstimatedTime(String time);
    }
}

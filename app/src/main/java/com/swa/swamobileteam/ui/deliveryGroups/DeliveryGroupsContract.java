package com.swa.swamobileteam.ui.deliveryGroups;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

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

    }

    interface Model extends BaseModel {
        /**
         * Marks the desired delivery as being in progress.
         * @param deliveryID identifier of the delivery.
         */
        Completable markDeliveryAsInProgress(@NonNull String deliveryID);

        /**
         * Returns available delivery schedule.
         * @param offset Offset, from which the returned list should start, needed for pagination.
         * @param limit Maximum amount of items to receive, needed for pagination.
         */
        Single<List<DeliveriesListItem>> getDeliveriesSchedule(@Nullable Integer offset,
                                                               @Nullable Integer limit);

        /**
         * Returns deliveries that are marked as being currently in progress.
         */
        Single<List<DeliveriesListItem>> getInProgressDeliveries();
    }
}

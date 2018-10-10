package com.swa.swamobileteam.ui.delivery;

import com.swa.swamobileteam.data.deliveries.DeliveryPeriod;
import com.swa.swamobileteam.ui.base.BaseModel;
import com.swa.swamobileteam.ui.base.BasePresenter;
import com.swa.swamobileteam.ui.base.BaseView;

import io.reactivex.Single;

public interface DeliveryContract {
    interface View extends BaseView {

    }

    interface Presenter extends BasePresenter<View> {

    }

    interface Model extends BaseModel {
        /**
         * Retrieves derailed information about a delivery.
         * @param deliveryID Identifier of the delivery to retrieve info for.
         */
        Single<DeliveryInfo> getDeliveryInfo(String deliveryID);

        /**
         * Calculates how much time is left to finish the delivery in seconds.
         * @param period Delivery period of the delivery.
         */
        Double getRemainingTime(DeliveryPeriod period);
    }
}

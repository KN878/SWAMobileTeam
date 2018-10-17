package com.swa.swamobileteam.ui.delivery;

import com.swa.swamobileteam.data.deliveries.DeliveryPeriod;
import com.swa.swamobileteam.ui.base.BaseModel;
import com.swa.swamobileteam.ui.base.BasePresenter;
import com.swa.swamobileteam.ui.base.BaseView;
import com.swa.swamobileteam.ui.deliveryGroups.DeliveryGroupsContract;

import io.reactivex.Single;

public interface DeliveryContract {
    interface View extends BaseView {

    }

    interface Presenter extends BasePresenter<DeliveryContract.View> {
        void getInfo();
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

    interface DeliveryView extends BaseView{

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

        void setName(String name);

        void setPhone(String phone);

        void setParcelName (String parcelName);

        void setDimensions (String dimensions);
    }
}

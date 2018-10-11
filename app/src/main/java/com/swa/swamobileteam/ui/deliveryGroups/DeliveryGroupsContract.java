package com.swa.swamobileteam.ui.deliveryGroups;

import android.view.View;

import com.swa.swamobileteam.ui.base.BaseModel;
import com.swa.swamobileteam.ui.base.BasePresenter;
import com.swa.swamobileteam.ui.base.BaseView;

public interface DeliveryGroupsContract {

    interface View extends BaseView {

    }

    interface Presenter extends BasePresenter<View> {
        DeliveryView getDeliveryViewHolder(android.view.View view);

        void onBindDeliveryGroup(DeliveryView deliveryView, int position);

        int getGroupCount();
    }

    interface Model extends BaseModel {

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

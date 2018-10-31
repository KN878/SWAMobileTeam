package com.swa.swamobileteam.ui.delivery.finishDelivery;

import com.swa.swamobileteam.ui.base.BaseModel;
import com.swa.swamobileteam.ui.base.BasePresenter;
import com.swa.swamobileteam.ui.base.BaseView;

import io.reactivex.Completable;

public interface FinishDeliveryContract {
    interface View extends BaseView {
        void navigateToDeliveriesList();
    }
    interface Presenter extends BasePresenter<View> {
        void finish();
    }
    interface Model extends BaseModel {
        Completable finishDelivery(String id);
    }
}

package com.swa.swamobileteam.ui.delivery.finishDelivery;

import android.support.annotation.Nullable;

import javax.inject.Inject;

public class FinishDeliveryPresenter implements FinishDeliveryContract.Presenter {

    @Nullable
    FinishDeliveryContract.View view;

    @Inject
    FinishDeliveryPresenter() {}

    @Override
    public void attachView(FinishDeliveryContract.View view, boolean isNew) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void stop() {

    }

    @Override
    public void finish() {
        if (view != null) {
            view.navigateToDeliveriesList();
        }
    }
}

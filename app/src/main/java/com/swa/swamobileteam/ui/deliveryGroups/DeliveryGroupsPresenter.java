package com.swa.swamobileteam.ui.deliveryGroups;

import android.view.View;

import javax.inject.Inject;

public class DeliveryGroupsPresenter implements DeliveryGroupsContract.Presenter {

    private DeliveryGroupsContract.View view;
    private DeliveryGroupsContract.Model model;

    @Inject
    DeliveryGroupsPresenter(DeliveryGroupsContract.Model model){
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

    }

    @Override
    public void onBindDeliveryGroup(DeliveryGroupsContract.DeliveryView deliveryView, int position) {

    }

    @Override
    public int getDeliveriesCount() {
        return 0;
    }
}

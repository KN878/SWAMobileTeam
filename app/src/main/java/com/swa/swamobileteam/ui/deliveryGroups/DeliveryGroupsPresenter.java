package com.swa.swamobileteam.ui.deliveryGroups;

public class DeliveryGroupsPresenter implements DeliveryGroupsContract.Presenter {

    private DeliveryGroupsContract.View view;

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
}

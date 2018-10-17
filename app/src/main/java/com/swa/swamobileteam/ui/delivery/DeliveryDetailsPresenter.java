package com.swa.swamobileteam.ui.delivery;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


public class DeliveryDetailsPresenter implements DeliveryContract.Presenter{

    @Nullable
    private DeliveryContract.View view;
    private DeliveryContract.Model model;
    private CompositeDisposable disposable = new CompositeDisposable();

    @Inject
    DeliveryDetailsPresenter(DeliveryContract.Model model) {
        this.model = model;
    }

    @Override
    public void getInfo(){
        disposable.add(model.getDeliveryInfo(docId))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(document -> {
                    view.setName(deliveryInfo.getName();)
                }
    }

    @Override
    public void attachView(DeliveryContract.View view, boolean isNew) {
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

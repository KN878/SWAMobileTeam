package com.swa.swamobileteam.ui.authorization;

import android.support.annotation.Nullable;

import com.swa.swamobileteam.ui.deliveryGroups.DeliveryGroupsContract;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class AuthorizationPresenter implements AuthorizationContract.Presenter {

    @Nullable
    private AuthorizationContract.View view;
    private AuthorizationContract.Model model;
    private CompositeDisposable disposable = new CompositeDisposable();


    @Inject //important
    AuthorizationPresenter(AuthorizationContract.Model model) {
        this.model = model;
    }

    @Override
    public void login() {
        if (view != null) {
            String login = view.getLogin();
            String password = view.getPassword();
            if (login.isEmpty()) {
                view.showNoLogin();
            } else if (password.isEmpty()) {
                view.showNoPassword();
            } else {
                disposable.add(model.authenticate(login, password)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(()->
                                        view.successLogin(),
                                (error) ->
                                        view.showWrongLogin()
                        ));
            }
        }
    }

    @Override
    public void attachView(AuthorizationContract.View view, boolean isNew) {
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

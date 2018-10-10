package com.swa.swamobileteam.ui.authorization;

import android.support.annotation.Nullable;

import javax.inject.Inject;

public class AuthorizationPresenter implements AuthorizationContract.Presenter {

    @Nullable
    private AuthorizationContract.View view;

    @Inject
    AuthorizationPresenter() {}

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
                view.showWrongLogin();
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

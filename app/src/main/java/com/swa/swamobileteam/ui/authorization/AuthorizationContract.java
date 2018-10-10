package com.swa.swamobileteam.ui.authorization;

import com.swa.swamobileteam.ui.base.BaseModel;
import com.swa.swamobileteam.ui.base.BasePresenter;
import com.swa.swamobileteam.ui.base.BaseView;

public interface AuthorizationContract {
    interface View extends BaseView {
        String getLogin();

        String getPassword();

        void resetPassword();

        void showNoLogin();

        void showNoPassword();

        void showWrongLogin();

        void successLogin();
    }

    interface Presenter extends BasePresenter<AuthorizationContract.View> {
        void login();
    }

    interface Model extends BaseModel {

    }
}

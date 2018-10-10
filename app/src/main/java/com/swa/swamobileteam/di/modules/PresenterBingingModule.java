package com.swa.swamobileteam.di.modules;

import com.swa.swamobileteam.di.ActivityScope;
import com.swa.swamobileteam.ui.authorization.AuthorizationContract;
import com.swa.swamobileteam.ui.authorization.AuthorizationPresenter;
import com.swa.swamobileteam.ui.deliveryGroups.DeliveryGroupsContract;
import com.swa.swamobileteam.ui.deliveryGroups.DeliveryGroupsPresenter;

import dagger.Binds;
import dagger.Module;

@Module
abstract class PresenterBingingModule {

    @Binds
    @ActivityScope
    public abstract AuthorizationContract.Presenter bindAuthorizationPresenter(AuthorizationPresenter presenter);

    @Binds
    @ActivityScope
    public abstract DeliveryGroupsContract.Presenter bindDeliveryGroupsPresenter(
            DeliveryGroupsPresenter presenter
    );

}

package com.swa.swamobileteam.di.modules;

import com.swa.swamobileteam.di.ActivityScope;
import com.swa.swamobileteam.ui.MainActivity;
import com.swa.swamobileteam.ui.authorization.AuthorizationActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityFragmentBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = {PresenterBingingModule.class, ModelBindingModule.class})
    abstract AuthorizationActivity authorizationActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = {PresenterBingingModule.class, ModelBindingModule.class})
    abstract MainActivity mainActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = {PresenterBingingModule.class, ModelBindingModule.class})
    abstract MainActivity mainActivity();

}

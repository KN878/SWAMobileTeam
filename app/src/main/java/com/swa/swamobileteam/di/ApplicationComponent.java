package com.swa.swamobileteam.di;

import com.swa.swamobileteam.AcmeApplication;
import com.swa.swamobileteam.di.modules.ActivityFragmentBindingModule;
import com.swa.swamobileteam.di.modules.ApplicationModule;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@AppScope
@Component(modules = {ApplicationModule.class, ApplicationModule.Declarations.class, ActivityFragmentBindingModule.class, AndroidSupportInjectionModule.class})
public interface ApplicationComponent extends AndroidInjector<AcmeApplication> {
    /**
     * Дает синтаксический сахар. Теперь можно с помощью
     * DaggerApplicationComponent.builder().application(this).build().inject(this);
     * никогда не создавать модули явно или указывать в какой модуль мы передаем application.
     * Application уже будет содержаться в нашем графе зависимостей.
     */
    @Component.Builder
    interface Builder {

        @BindsInstance
        ApplicationComponent.Builder application(AcmeApplication application);

        ApplicationComponent build();
    }
}

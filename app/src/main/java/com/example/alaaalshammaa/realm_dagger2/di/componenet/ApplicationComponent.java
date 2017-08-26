package com.example.alaaalshammaa.realm_dagger2.di.componenet;

import android.content.Context;

import com.example.alaaalshammaa.realm_dagger2.RealmDaggerApplication;
import com.example.alaaalshammaa.realm_dagger2.data.DbHelper;
import com.example.alaaalshammaa.realm_dagger2.data.SharedPrefsHelper;
import com.example.alaaalshammaa.realm_dagger2.di.ApplicationContext;
import com.example.alaaalshammaa.realm_dagger2.di.module.ActivityModule;
import com.example.alaaalshammaa.realm_dagger2.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;
import io.realm.Realm;

/**
 * Created by alaaalshammaa on 26/08/2017.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(RealmDaggerApplication realmDaggerApplication);

    @ApplicationContext
    Context context();

    DbHelper dbHelper();

    SharedPrefsHelper sharedPrefsHelper();

    Realm realm();
}

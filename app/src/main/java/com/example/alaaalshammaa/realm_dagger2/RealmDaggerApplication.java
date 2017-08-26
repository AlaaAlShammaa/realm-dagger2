package com.example.alaaalshammaa.realm_dagger2;

import android.app.Application;
import android.content.Context;

import com.example.alaaalshammaa.realm_dagger2.data.DataManager;
import com.example.alaaalshammaa.realm_dagger2.di.componenet.ApplicationComponent;
import com.example.alaaalshammaa.realm_dagger2.di.componenet.DaggerApplicationComponent;
import com.example.alaaalshammaa.realm_dagger2.di.module.ApplicationModule;


import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by alaaalshammaa on 26/08/2017.
 */

public class RealmDaggerApplication extends Application {

    ApplicationComponent applicationComponent;

    @Inject
    DataManager dataManager;



    public RealmDaggerApplication() {
    }

    public static RealmDaggerApplication get(Context context) {
        return (RealmDaggerApplication) context.getApplicationContext();
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        initRealmConfiguration();
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this, Realm.getDefaultInstance()))
                .build();
        applicationComponent.inject(this);
    }

    private void initRealmConfiguration() {
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }
}

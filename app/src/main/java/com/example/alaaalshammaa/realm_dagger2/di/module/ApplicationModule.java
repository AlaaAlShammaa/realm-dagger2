package com.example.alaaalshammaa.realm_dagger2.di.module;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.alaaalshammaa.realm_dagger2.data.DbHelper;
import com.example.alaaalshammaa.realm_dagger2.data.SharedPrefsHelper;
import com.example.alaaalshammaa.realm_dagger2.di.ApplicationContext;
import com.example.alaaalshammaa.realm_dagger2.di.DatabaseInfo;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by alaaalshammaa on 26/08/2017.
 */

@Module
public class ApplicationModule {
    Context context;
    Realm realm;

    public ApplicationModule(Context context,Realm realm) {
        this.context = context;
        this.realm = realm;
    }

    @ApplicationContext
    @Provides
    Context providesContext() {
        return context;
    }

    @Provides
    DbHelper providesDbHelper() {
        return new DbHelper(realm);
    }
    
    @Provides
    SharedPreferences providesSharedPrefsHelper() {
        return context.getSharedPreferences("realm-android-prefs", Context.MODE_PRIVATE);
    }

    @DatabaseInfo
    @Provides
    String providesDbName() {
        return "realm-android";
    }

    @DatabaseInfo
    @Provides
    Integer providesDbVersion() {
        return 1;
    }

    @Provides
    Realm providesRealm() {
        return Realm.getDefaultInstance();
    }

}

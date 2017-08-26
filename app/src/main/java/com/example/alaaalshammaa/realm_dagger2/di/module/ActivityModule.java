package com.example.alaaalshammaa.realm_dagger2.di.module;

import android.app.Activity;
import android.content.Context;

import com.example.alaaalshammaa.realm_dagger2.di.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by alaaalshammaa on 26/08/2017.
 */

@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context providesContext() {
        return activity;
    }

    @Provides
    Activity providesActivity() {
        return activity;
    }
}

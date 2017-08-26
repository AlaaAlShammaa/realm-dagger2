package com.example.alaaalshammaa.realm_dagger2.di.componenet;

import com.example.alaaalshammaa.realm_dagger2.MainActivity;
import com.example.alaaalshammaa.realm_dagger2.di.PerActivity;
import com.example.alaaalshammaa.realm_dagger2.di.module.ActivityModule;

import dagger.Component;

/**
 * Created by alaaalshammaa on 26/08/2017.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
}

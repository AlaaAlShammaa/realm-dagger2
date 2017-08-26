package com.example.alaaalshammaa.realm_dagger2.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.alaaalshammaa.realm_dagger2.data.model.User;
import com.example.alaaalshammaa.realm_dagger2.di.ApplicationContext;

import javax.inject.Inject;

/**
 * Created by alaaalshammaa on 26/08/2017.
 */

public class DataManager {
    private Context context;
    private DbHelper dbHelper;
    private SharedPrefsHelper sharedPrefsHelper;

    @Inject
    public DataManager(@ApplicationContext Context context, DbHelper dbHelper, SharedPrefsHelper sharedPrefsHelper) {
        this.context = context;
        this.dbHelper = dbHelper;
        this.sharedPrefsHelper = sharedPrefsHelper;
    }

    public void saveAccessToken(String accessToken) {
        sharedPrefsHelper.put(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, accessToken);
    }

    public String getAccessToken() {
        return sharedPrefsHelper.get(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, null);
    }

    public void createUser(User user) {
        dbHelper.createUser(user);
    }

    public User getUser(String id) {
        return dbHelper.getUser(id);
    }
}

package com.example.alaaalshammaa.realm_dagger2.data;

import android.content.Context;

import com.example.alaaalshammaa.realm_dagger2.data.model.User;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.realm.Realm;
import io.realm.RealmQuery;

/**
 * Created by alaaalshammaa on 26/08/2017.
 */

@Singleton
public class DbHelper {

    Realm realm;

    public DbHelper(Realm realm) {
        this.realm = realm;
    }

    void createUser(User user) {
        realm.beginTransaction();
        realm.copyToRealm(user);
        realm.commitTransaction();
    }

    User getUser(String id) {
        RealmQuery<User> query = realm.where(User.class);
        query.equalTo("id", id);
        return query.findFirst();
    }

}

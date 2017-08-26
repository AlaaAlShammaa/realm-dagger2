package com.example.alaaalshammaa.realm_dagger2;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.alaaalshammaa.realm_dagger2.data.DataManager;
import com.example.alaaalshammaa.realm_dagger2.data.model.User;
import com.example.alaaalshammaa.realm_dagger2.di.componenet.ActivityComponent;
import com.example.alaaalshammaa.realm_dagger2.di.componenet.DaggerActivityComponent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.userField)
    TextView userField;

    @Inject
    DataManager dataManager;
    @BindView(R.id.userToken)
    TextView userToken;

    private ActivityComponent activityComponent;

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .applicationComponent(RealmDaggerApplication.get(this).getComponent())
                    .build();
        }
        return activityComponent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getActivityComponent().inject(this);
        if (dataManager.getUser("1234") == null)
            dataManager.createUser(new User("1234", "Alaa", "Syria", "26 Aug 2017", "26 Aug 2017"));
        dataManager.saveAccessToken("ASDR12443JFDJF43543J543H3K543");
        User user = dataManager.getUser("1234");
        userField.setText(user.toString());
        userToken.setText(dataManager.getAccessToken());
    }

}

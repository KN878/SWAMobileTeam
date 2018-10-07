package com.swa.swamobileteam.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.swa.swamobileteam.R;
import com.swa.swamobileteam.ui.deliveryGroups.DeliveryGroupsContract;

public class MainActivity extends AppCompatActivity implements DeliveryGroupsContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

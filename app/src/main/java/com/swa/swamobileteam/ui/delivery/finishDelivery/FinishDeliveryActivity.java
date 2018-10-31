package com.swa.swamobileteam.ui.delivery.finishDelivery;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.swa.swamobileteam.R;
import com.swa.swamobileteam.ui.MainActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;

public class FinishDeliveryActivity extends AppCompatActivity implements FinishDeliveryContract.View {

    @Inject
    FinishDeliveryContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_delivery);
        ButterKnife.bind(this);
        AndroidInjection.inject(this);

        presenter.attachView(this, true);
    }

    @Override
    public void navigateToDeliveriesList() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }

    @OnClick(R.id.button_finish_delivery)
    public void onFinish() {
        presenter.finish();
    }
}

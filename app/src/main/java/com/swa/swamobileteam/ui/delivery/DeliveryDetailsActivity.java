package com.swa.swamobileteam.ui.delivery;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.swa.swamobileteam.R;
import com.swa.swamobileteam.ui.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import butterknife.OnTouch;
import dagger.android.AndroidInjection;


public class DeliveryDetailsActivity extends AppCompatActivity implements DeliveryContract.DeliveryView{
    @BindView(R.id.timeTextView)
    TextView time;
    @BindView(R.id.nameTextView)
    TextView name;
    @BindView(R.id.phoneTextView)
    TextView phone;
    @BindView(R.id.addressTextView)
    TextView address;
    @BindView(R.id.parcelNameTextView)
    TextView parcelName;
    @BindView(R.id.weightTextView)
    TextView weight;
    @BindView(R.id.dimensionsTextView)
    TextView dimensions;
    @BindView(R.id.parcelIDTextView)
    TextView deliveryID;

    @Inject
    DeliveryContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_details);
        ButterKnife.bind(this);
        AndroidInjection.inject(this);
        presenter.attachView((DeliveryContract.View) this, true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
        presenter.stop();
    }


    @Override
    public void setTimePeriod(String time) {
        this.time.setText(time);
    }

    @Override
    public void setParcelId(String id) {
        deliveryID.setText(id);
    }

    @Override
    public void setAddress(String address) {
        this.address.setText(address);
    }

    @Override
    public void setWeight(Double weight) {
        this.weight.setText(String.valueOf(weight));
    }

    @Override
    public void setEstimatedTime(String time) {
        this.time.setText(time);
    }

    @Override
    public void setName(String name) {
        this.name.setText(name);
    }

    @Override
    public void setPhone(String phone) {
        this.phone.setText(phone);
    }

    @Override
    public void setParcelName(String parcelName) {
        this.parcelName.setText(parcelName);
    }

    @Override
    public void setDimensions(String dimensions) {
        this.dimensions.setText(dimensions);
    }


}

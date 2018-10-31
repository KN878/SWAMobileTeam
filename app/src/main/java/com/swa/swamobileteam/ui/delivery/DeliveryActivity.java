package com.swa.swamobileteam.ui.delivery;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.swa.swamobileteam.R;
import com.swa.swamobileteam.ui.delivery.finishDelivery.FinishDeliveryActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;


public class DeliveryActivity extends AppCompatActivity implements DeliveryContract.View {
    private final static String DELIVERY_ID = "delivery_id";

    @BindView(R.id.toolbar_delivery)
    Toolbar toolbar;
    @BindView(R.id.timeTextView)
    TextView time;
    @BindView(R.id.text_time_remaining)
    TextView timeRemaining;
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

    public static Intent newInstance(Context context, String deliveryId) {
        Intent intent = new Intent(context, DeliveryActivity.class);
        intent.putExtra(DELIVERY_ID, deliveryId);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_details);
        ButterKnife.bind(this);
        AndroidInjection.inject(this);
        setToolbar();
        presenter.attachView(this, true);
        presenter.getInfo();
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
    public void setDimensions(Double x, Double y, Double z) {
        this.dimensions.setText(getString(R.string.text_dimensions, x, y, z));
    }

    @Override
    public void setTimeRemaining(long time) {
        this.timeRemaining.setText(getString(R.string.text_time_remaining, time));
    }

    @Override
    public void navigateToMap(Uri coordsUri) {
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, coordsUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    @Override
    public void callPhone(String phone) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
        startActivity(intent);
    }

    @OnClick(R.id.image_button_call)
    public void callClient() {
        presenter.callClient();
    }

    @OnClick(R.id.button_to_map)
    public void openMap() {
        presenter.openMap();
    }

    @OnClick(R.id.button_contact_operator)
    public void callOperator() {
        presenter.callOperator();
    }

    @OnClick(R.id.FinishButton)
    public void onFinish() {
        Intent intent = new Intent(this, FinishDeliveryActivity.class);
        startActivity(intent);
    }

    private void setToolbar() {
        toolbar.setTitle("Parcel #" + getIntent().getStringExtra(DELIVERY_ID));
        toolbar.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.navigation_back));
        toolbar.setNavigationOnClickListener((v) -> onBackPressed());
    }
}

package com.swa.swamobileteam.ui.deliveryGroups.view;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.swa.swamobileteam.R;
import com.swa.swamobileteam.ui.deliveryGroups.DeliveryGroupsContract;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DeliveryViewHolder extends RecyclerView.ViewHolder implements DeliveryGroupsContract.DeliveryView{

    private Resources resources;

    @BindView(R.id.text_date_divider)
    TextView dateDivider;
    @BindView(R.id.text_delivery_time)
    TextView deliveryPeriod;
    @BindView(R.id.text_parcel_id)
    TextView parcelId;
    @BindView(R.id.text_parcel_address)
    TextView parcelAddress;
    @BindView(R.id.text_delivery_weight)
    TextView parcelWeight;
    @BindView(R.id.text_estimated_time)
    TextView estimatedTime;

    public DeliveryViewHolder(@NonNull View itemView){
        super(itemView);
        ButterKnife.bind(this, itemView);
        resources = itemView.getResources();
    }

    @Override
    public void showDateDivider(String date) {
        dateDivider.setVisibility(View.VISIBLE);
        dateDivider.setText(date);
    }

    @Override
    public void hideDateDivider() {
        dateDivider.setVisibility(View.GONE);
    }

    @Override
    public void setTimePeriod(String time) {
        deliveryPeriod.setText(time);
    }

    @Override
    public void setParcelId(String id) {
        parcelId.setText(resources.getString(R.string.text_parcel_id, id));
    }

    @Override
    public void setAddress(String address) {
        parcelAddress.setText(address);
    }

    @Override
    public void setWeight(Double weight) {
        if (weight < 1) {
            parcelWeight.setText(resources.getString(R.string.text_delivery_small, String.valueOf(weight)));
        } else {
            parcelWeight.setText(resources.getString(R.string.text_delivery_large, String.valueOf(weight)));
        }
    }

    @Override
    public void setEstimatedTime(String time) {
        estimatedTime.setText(resources.getString(R.string.text_estimated_time, time));
    }
}

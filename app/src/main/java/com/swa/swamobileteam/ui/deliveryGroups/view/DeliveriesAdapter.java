package com.swa.swamobileteam.ui.deliveryGroups.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.swa.swamobileteam.R;
import com.swa.swamobileteam.ui.deliveryGroups.DeliveryGroupsContract;

public class DeliveriesAdapter extends RecyclerView.Adapter<ViewHolder>{

    private DeliveryGroupsContract.Presenter presenter;

    public DeliveriesAdapter(DeliveryGroupsContract.Presenter presenter){
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_delivery, viewGroup, false);
        return new DeliveryViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        presenter.onBindDeliveryGroup((DeliveryGroupsContract.DeliveryView) viewHolder, i);
    }

    @Override
    public int getItemCount() {
        return presenter.getGroupCount();
    }
}

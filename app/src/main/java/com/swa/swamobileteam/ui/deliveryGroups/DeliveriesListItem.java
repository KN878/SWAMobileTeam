package com.swa.swamobileteam.ui.deliveryGroups;

import com.swa.swamobileteam.data.deliveries.Address;
import com.swa.swamobileteam.data.deliveries.DeliveryPeriod;

public class DeliveriesListItem {
    private String id;
    private Address address;
    private DeliveryPeriod deliveryPeriod;
    private Boolean isInProgress;

    public DeliveriesListItem(String id, Address address, DeliveryPeriod deliveryPeriod, Boolean isInProgress) {
        this.id = id;
        this.address = address;
        this.deliveryPeriod = deliveryPeriod;
        this.isInProgress = isInProgress;
    }

    public String getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public DeliveryPeriod getDeliveryPeriod() {
        return deliveryPeriod;
    }

    public Boolean getInProgress() {
        return isInProgress;
    }

    public void setInProgress(Boolean inProgress) {
        isInProgress = inProgress;
    }
}

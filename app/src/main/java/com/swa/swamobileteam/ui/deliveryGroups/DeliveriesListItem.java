package com.swa.swamobileteam.ui.deliveryGroups;

import com.swa.swamobileteam.data.deliveries.Address;
import com.swa.swamobileteam.data.deliveries.DeliveryPeriod;

/**
 * A single item in the delivery schedule list.
 */
public class DeliveriesListItem {
    /**
     * Unique identification number string of the parcel to deliver.
     */
    private String id;

    /**
     * Address where the parcel is mean to be delivered.
     */
    private Address address;

    /**
     * A date period, during which the parcel should be delivered to its destination.
     */
    private DeliveryPeriod deliveryPeriod;

    /**
     * A flag indicating whether the delivery is marked as in progress.
     */
    private Boolean isInProgress;

    /**
     * Weight in kg of the parcel to deliver.
     */
    private Double weight;

    public DeliveriesListItem(String id, Address address, DeliveryPeriod deliveryPeriod, Boolean isInProgress, Double weight) {
        this.id = id;
        this.address = address;
        this.deliveryPeriod = deliveryPeriod;
        this.isInProgress = isInProgress;
        this.weight = weight;
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

    public Double getWeight() {
        return weight;
    }

    public Boolean getInProgress() {
        return isInProgress;
    }

    public void setInProgress(Boolean inProgress) {
        isInProgress = inProgress;
    }
}

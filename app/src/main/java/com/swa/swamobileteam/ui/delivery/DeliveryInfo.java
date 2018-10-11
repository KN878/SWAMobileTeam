package com.swa.swamobileteam.ui.delivery;

import com.swa.swamobileteam.data.deliveries.Address;
import com.swa.swamobileteam.data.deliveries.ClientInfo;
import com.swa.swamobileteam.data.deliveries.DeliveryPeriod;
import com.swa.swamobileteam.data.deliveries.ParcelInfo;

public class DeliveryInfo {
    private String id;
    private ParcelInfo parcelInfo;
    private ClientInfo clientInfo;
    private Address address;
    private DeliveryPeriod deliveryPeriod;
    private Boolean isInProcess;

    public DeliveryInfo(String id, ParcelInfo parcelInfo, ClientInfo clientInfo, Address address, DeliveryPeriod deliveryPeriod, Boolean isInProcess) {
        this.id = id;
        this.parcelInfo = parcelInfo;
        this.clientInfo = clientInfo;
        this.address = address;
        this.deliveryPeriod = deliveryPeriod;
        this.isInProcess = isInProcess;
    }

    public String getId() {
        return id;
    }

    public ParcelInfo getParcelInfo() {
        return parcelInfo;
    }

    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public Address getAddress() {
        return address;
    }

    public DeliveryPeriod getDeliveryPeriod() {
        return deliveryPeriod;
    }

    public Boolean getInProcess() {
        return isInProcess;
    }

    public void setInProcess(Boolean inProcess) {
        isInProcess = inProcess;
    }
}

package com.swa.swamobileteam.data.deliveries;

public class DeliveryOrderModel {
    private HumanContacts customerInfo;
    private Status status;
    private String description;
    private Address address;
    private int priority;
    private String id;
    private DeliveryPeriod deliveryPeriod;

    public DeliveryPeriod getDeliveryPeriod() {
        return deliveryPeriod;
    }

    public void setDeliveryPeriod(DeliveryPeriod deliveryPeriod) {
        this.deliveryPeriod = deliveryPeriod;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public HumanContacts getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(HumanContacts customerInfo) {
        this.customerInfo = customerInfo;
    }

    public enum Status { in_process, pending, finished }
}

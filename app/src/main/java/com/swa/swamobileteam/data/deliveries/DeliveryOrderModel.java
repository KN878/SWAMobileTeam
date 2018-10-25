package com.swa.swamobileteam.data.deliveries;

/**
 * Model which describes while order
 */
public class DeliveryOrderModel {
    /**
     * Customer first and last name, phone number
     */
    private HumanContacts customerInfo;
    /**
     * Status of the order
     */
    private Status status;
    /**
     * Description of the order - additional info
     */
    private String description;
    /**
     * Address in standard format: String representation and Location
     */
    private Address address;
    /**
     * Priority of the order
     */
    private int priority;
    /**
     * If of the order
     */
    private String id;
    /**
     * Delivery period: start and end
     */
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

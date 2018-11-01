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

    public int getPriority() {
        return priority;
    }

    public Address getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public HumanContacts getCustomerInfo() {
        return customerInfo;
    }

    public enum Status { in_process, pending, finished }
}

package com.swa.swamobileteam.data.deliveries;

public class ControlOperator {

    /**
     * ControlOperator id
     */
    private String id;

    /**
     * Control Operator contacts (name, phone number )
     */
    private HumanContacts contacts;

    /**
     * Getters and setters
     */
    public HumanContacts getContacts() {
        return contacts;
    }

    public String getId() {
        return id;
    }
}

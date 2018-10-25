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

    public void setContacts(HumanContacts contacts) {
        this.contacts = contacts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

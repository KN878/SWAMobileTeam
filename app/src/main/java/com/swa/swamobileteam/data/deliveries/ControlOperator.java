package com.swa.swamobileteam.data.deliveries;

public class ControlOperator {
    private String id;
    private HumanContacts contacts;

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

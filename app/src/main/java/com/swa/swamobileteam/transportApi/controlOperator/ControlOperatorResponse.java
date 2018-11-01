package com.swa.swamobileteam.transportApi.controlOperator;

import com.swa.swamobileteam.data.deliveries.HumanContacts;

public class ControlOperatorResponse {

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

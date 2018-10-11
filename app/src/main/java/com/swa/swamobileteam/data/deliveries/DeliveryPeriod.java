package com.swa.swamobileteam.data.deliveries;

import java.util.Date;

public class DeliveryPeriod {

    public DeliveryPeriod(Date start, Date end) {
        this.start = start;
        this.end = end;
    }
    /**
     * The date period starts with.
     */
    private Date start;

    /**
     * The date period ends with.
     */
    private Date end;
}

package com.swa.swamobileteam.data.deliveries;

import com.swa.swamobileteam.ui.deliveryGroups.DeliveriesListItem;

import java.util.List;

public class DeliveryScheduleModel {
    /**
     * Delivery schedules
     */
    private List<List<DeliveriesListItem>> results;
    private int totalCount;

    public int getTotalCount() {
        return totalCount;
    }

    public List<List<DeliveriesListItem>> getResults() {
        return results;
    }
}

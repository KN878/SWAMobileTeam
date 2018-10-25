package com.swa.swamobileteam.data.deliveries;

import com.swa.swamobileteam.ui.deliveryGroups.DeliveriesListItem;

import java.util.List;

public class DeliveryScheduleModel {
    private List<List<DeliveriesListItem>> results;
    private int totalCount;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<List<DeliveriesListItem>> getResults() {
        return results;
    }

    public void setResults(List<List<DeliveriesListItem>> results) {
        this.results = results;
    }
}

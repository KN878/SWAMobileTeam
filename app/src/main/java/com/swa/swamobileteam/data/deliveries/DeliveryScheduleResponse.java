package com.swa.swamobileteam.data.deliveries;

/**
 * Delivery schedule wrapper for server response
 */
public class DeliveryScheduleResponse {
    /**
     * Delivery schedule model which describes it
     */
     private  DeliveryScheduleModel deliveryScheduleResponse;

    public DeliveryScheduleModel getDeliveryScheduleResponse() {
        return deliveryScheduleResponse;
    }

    public void setDeliveryScheduleResponse(DeliveryScheduleModel deliveryScheduleResponse) {
        this.deliveryScheduleResponse = deliveryScheduleResponse;
    }
}

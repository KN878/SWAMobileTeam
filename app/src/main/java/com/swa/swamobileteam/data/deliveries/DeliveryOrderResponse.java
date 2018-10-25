package com.swa.swamobileteam.data.deliveries;

/**
 * Wrapper for the delivery order from server
 */
public class DeliveryOrderResponse {
    /**
     * Delivery order model which describes it
     */
    private DeliveryOrderModel deliveryOrderresponse;

    public DeliveryOrderModel getDeliveryOrderresponse() {
        return deliveryOrderresponse;
    }

    public void setDeliveryOrderresponse(DeliveryOrderModel deliveryOrderresponse) {
        this.deliveryOrderresponse = deliveryOrderresponse;
    }
}

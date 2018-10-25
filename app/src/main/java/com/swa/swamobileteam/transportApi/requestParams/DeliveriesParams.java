package com.swa.swamobileteam.transportApi.requestParams;

import com.swa.swamobileteam.utils.DeliveryType;

public class DeliveriesParams {
    private DeliveryType type;
    private int limit;
    private int offset;

    private DeliveriesParams(Builder builder) {
        this.type = builder.type;
        this.limit = builder.limit;
        this.offset = builder.offset;
    }

    public DeliveryType getType() {
        return type;
    }

    public int getLimit() {
        return limit;
    }

    public int getOffset() {
        return offset;
    }

    public static class Builder {
        private DeliveryType type;
        private int limit;
        private int offset;

        public Builder(){
            this.limit = 0;
            this.offset = 0;
            this.type = DeliveryType.New;
        }

        public Builder type(DeliveryType type) {
            this.type = type;
            return this;
        }

        public Builder limit(int limit) {
            this.limit = limit;
            return this;
        }

        public Builder offset(int offset) {
            this.offset = offset;
            return this;
        }

        public DeliveriesParams create() {
            return new DeliveriesParams(this);
        }
    }
}

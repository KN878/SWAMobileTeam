package com.swa.swamobileteam.transportApi.deliveries;

public class DeliveriesParams {
    private int limit;
    private int offset;

    private DeliveriesParams(Builder builder) {
        this.limit = builder.limit;
        this.offset = builder.offset;
    }

    public int getLimit() {
        return limit;
    }

    public int getOffset() {
        return offset;
    }

    public static class Builder {
        private int limit;
        private int offset;

        public Builder(){
            this.limit = 0;
            this.offset = 0;
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

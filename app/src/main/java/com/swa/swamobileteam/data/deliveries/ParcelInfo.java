package com.swa.swamobileteam.data.deliveries;

public class ParcelInfo {
    /**
     * Information about parcel's size in meters.
     */
    public class Dimensions {
        private Double x;
        private Double y;
        private Double z;

        public Dimensions(Double x, Double y, Double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public Double getX() {
            return x;
        }

        public Double getY() {
            return y;
        }

        public Double getZ() {
            return z;
        }
    }

    private Double weight;
    private Dimensions dimensions;

    public ParcelInfo(Double weight, Dimensions dimensions) {
        this.weight = weight;
        this.dimensions = dimensions;
    }

    public Double getWeight() {
        return weight;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }
}

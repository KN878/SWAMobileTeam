package com.swa.swamobileteam.data.deliveries;

public class Address {
    /**
     * Address of some destination
     */
    private String address;

    /**
     * Location in standard format (longitude, latitude)
     */
    private Location location;

    public Address(String address, Location location) {
        this.address = address;
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public Location getLocation() {
        return location;
    }
}

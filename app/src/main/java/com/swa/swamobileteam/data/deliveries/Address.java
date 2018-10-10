package com.swa.swamobileteam.data.deliveries;

public class Address {
    private String address;
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

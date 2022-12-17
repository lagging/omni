package com.creditsaison.omni.enums;

public enum FacilityType {

    PUSH_CARD("Push cart"),
    TRUCK("Truck");

    String type;

    FacilityType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

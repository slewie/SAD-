package com.slewie.recommender.map;

public enum PlaceType {

    RESTAURANT(true),
    THEATRE(false),
    MUSEUM(false),
    CINEMA(false),
    CAFE(true),
    BAR(true);

    private final boolean isFoodType;

    PlaceType(boolean isFoodType) {this.isFoodType = isFoodType;}

    public boolean isFoodType() {
        return isFoodType;
    }
}

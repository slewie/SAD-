package com.slewie.recommender.map;

import java.util.Set;

public record PlaceInfo(
        String name,
        PlaceRating rating,
        PlaceType placeType,
        Set<FoodType> foodTypes
) {}

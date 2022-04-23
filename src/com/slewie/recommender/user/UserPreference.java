package com.slewie.recommender.user;

import com.slewie.recommender.map.FoodType;
import com.slewie.recommender.map.PlaceRating;
import com.slewie.recommender.map.PlaceType;
import java.util.Set;

public record UserPreference(
        Set<PlaceType> placeTypes,
        Set<FoodType> foodTypes,
        Set<PlaceRating> ratings
) {}

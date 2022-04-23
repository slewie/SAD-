package com.slewie.recommender.service;

import com.slewie.recommender.map.PlaceInfo;
import com.slewie.recommender.user.UserPreference;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SimpleMapDataFilterer implements MapDataFilterer {

    @Override
    public Set<PlaceInfo> filterBy(
            Set<PlaceInfo> places, UserPreference preference
    ) {
        var placeSatisfiesPredicate = getPlaceSatisfiesPredicate(preference);
        return places.stream()
                     .filter(placeSatisfiesPredicate)
                     .collect(Collectors.toSet());
    }

    private Predicate<PlaceInfo> getPlaceSatisfiesPredicate(UserPreference preference) {
        return place -> preference.ratings().contains(place.rating())
                        && preference.placeTypes().contains(place.placeType())
                        && (
                                !place.placeType().isFoodType()
                                || preference.foodTypes().stream().anyMatch(
                                        foodType -> place.foodTypes().contains(foodType)
                                )
                        );
    }

}
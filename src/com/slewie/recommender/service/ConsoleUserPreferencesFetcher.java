package com.slewie.recommender.service;

import com.slewie.recommender.map.FoodType;
import com.slewie.recommender.map.PlaceRating;
import com.slewie.recommender.map.PlaceType;
import com.slewie.recommender.user.UserPreference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import static java.util.stream.Collectors.joining;

public class ConsoleUserPreferencesFetcher implements UserPreferencesFetcher {

    @Override
    public UserPreference fetchUserPreference() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please write down the list of preferred place types delimited with ',':");
        System.out.println("Available types are:" +
                           Arrays.stream(PlaceType.values()).map(Enum::toString)
                                 .collect(joining(", ")) + "."
        );

        String[] placeTypes = scanner.nextLine().split(",");

        System.out.println("Please write down the list of preferred food types delimited with ',':");
        System.out.println("Available types are:" +
                           Arrays.stream(FoodType.values()).map(Enum::toString)
                                 .collect(joining(", ")) + "."
        );

        String[] foodTypes = scanner.nextLine().split(",");

        System.out.println(
                "Please write down the list of preferred ratings (1 to 5) delimited with ',':");
        String[] ratings = scanner.nextLine().split(",");

        Set<PlaceType> placeTypeSet = new HashSet<>();
        Set<FoodType> foodTypeSet = new HashSet<>();
        Set<PlaceRating> ratingSet = new HashSet<>();

        for (var placeType : placeTypes) {
            placeTypeSet.add(PlaceType.valueOf(placeType.toUpperCase().strip()));
        }

        for (var foodType : foodTypes) {
            foodTypeSet.add(FoodType.valueOf(foodType.toUpperCase().strip()));
        }

        for (var rating : ratings) {
            ratingSet.add(PlaceRating.ofStars(Integer.parseInt(rating.strip())));
        }

        return new UserPreference(
                placeTypeSet, foodTypeSet, ratingSet
        );
    }

}

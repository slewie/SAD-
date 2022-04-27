package com.slewie.recommender.service;

import com.slewie.recommender.map.PlaceInfo;
import java.util.Set;
import static java.util.stream.Collectors.joining;

public class ConsoleMapDisplayService extends MapDataHandler implements MapDisplayService {

    @Override
    public Set<PlaceInfo> handle(Set<PlaceInfo> places) {
        displayData(places);
        return callNext(places);
    }

    @Override
    public void displayData(Set<PlaceInfo> map) {
        System.out.println("These are all available places for you:");
        map.forEach(el -> System.out.printf(
                "%s %s [%s] %s %n",
                el.placeType().toString(), el.name(),
                "★".repeat(el.rating().getStars()),
                el.foodTypes().isEmpty()
                ? ""
                : "serving " + el.foodTypes().stream()
                                 .map(Enum::toString).collect(joining(", "))
        ));
    }

}

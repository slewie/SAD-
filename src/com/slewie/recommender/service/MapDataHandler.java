package com.slewie.recommender.service;

import com.slewie.recommender.map.PlaceInfo;
import java.util.Set;

public class MapDataHandler {

    protected MapDataHandler next;

    public Set<PlaceInfo> handle(Set<PlaceInfo> places) {
        return callNext(places);
    }

    public void setNext(MapDataHandler handler) {
        this.next = handler;
    }

    protected Set<PlaceInfo> callNext(Set<PlaceInfo> places) {
        if (next != null) {
            return next.handle(places);
        }

        return places;
    }

}

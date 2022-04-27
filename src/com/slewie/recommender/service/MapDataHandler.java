package com.slewie.recommender.service;

import com.slewie.recommender.map.PlaceInfo;
import java.util.Set;

public class MapDataHandler {

    protected MapDataHandler next;

    /**
     * Runs the chain till the end.
     * @return The result of last call in the chain.
     */
    public Set<PlaceInfo> handle(Set<PlaceInfo> places) {
        return callNext(places);
    }

    /**
     * Replaces next handler in the chain.
     */
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

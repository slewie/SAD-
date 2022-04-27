package com.slewie.recommender.service;

import com.slewie.recommender.map.PlaceInfo;
import java.util.Set;

public interface MapDataFetcher {

    /**
     * Throws {@link com.slewie.recommender.exception.MapDataFetchingException} if something goes wrong.
     * @return Set of {@link PlaceInfo}
     */
    Set<PlaceInfo> fetchPlaces();

}

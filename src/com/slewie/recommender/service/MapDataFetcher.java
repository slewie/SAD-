package com.slewie.recommender.service;

import com.slewie.recommender.map.PlaceInfo;
import java.util.Set;

public interface MapDataFetcher {

    Set<PlaceInfo> fetchPlaces();

}

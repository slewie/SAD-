package com.slewie.recommender.service;

import com.slewie.recommender.map.PlaceInfo;
import java.util.Set;

public interface MapDataFilterer {

    Set<PlaceInfo> filter(Set<PlaceInfo> places);

}

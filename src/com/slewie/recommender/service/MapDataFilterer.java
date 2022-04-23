package com.slewie.recommender.service;

import com.slewie.recommender.map.PlaceInfo;
import com.slewie.recommender.user.UserPreference;
import java.util.Set;

public interface MapDataFilterer {

    Set<PlaceInfo> filterBy(Set<PlaceInfo> places, UserPreference userPreference);

}

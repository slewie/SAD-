package com.slewie.recommender.service;

import java.util.HashSet;

public class ApplicationFacade {

    private final UserPreferencesFetcher userPreferencesFetcher;
    private final String filename;

    public ApplicationFacade(String filename) {
        this.filename = filename;
        this.userPreferencesFetcher = new ConsoleUserPreferencesFetcher();
    }

    public void doRun() {
        try {
            var preferences = userPreferencesFetcher.fetchUserPreference();

            var mapDataHandler = new MapDataHandler();
            var mapDataFetcher = new CsvMapDataFetcher(filename);
            var dataFilterer = new SimpleMapDataFilterer(preferences);
            var mapDisplayService = new ConsoleMapDisplayService();

            mapDataHandler.setNext(mapDataFetcher);
            mapDataFetcher.setNext(dataFilterer);
            dataFilterer.setNext(mapDisplayService);

            mapDataHandler.handle(new HashSet<>());
        } catch (Exception e) {
            System.err.println(
                    "Error during program execution. Error message is: " + e.getMessage()
            );
            e.printStackTrace();
        }
    }

}

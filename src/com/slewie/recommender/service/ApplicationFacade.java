package com.slewie.recommender.service;

public class ApplicationFacade {

    private final MapDataFetcher mapDataFetcher;
    private final MapDataFilterer dataFilterer;
    private final MapDisplayService mapDisplayService;

    private final UserPreferencesFetcher userPreferencesFetcher;

    public ApplicationFacade(String filename) {
        this.mapDataFetcher = new CsvMapDataFetcher(filename);
        this.dataFilterer = new SimpleMapDataFilterer();
        this.mapDisplayService = new ConsoleMapDisplayService();
        this.userPreferencesFetcher = new ConsoleUserPreferencesFetcher();
    }

    public void doRun() {
        try {
            var mapData = mapDataFetcher.fetchPlaces();
            var preferences = userPreferencesFetcher.fetchUserPreference();
            var filteredMapData = dataFilterer.filterBy(mapData, preferences);

            mapDisplayService.displayData(filteredMapData);
        } catch (Exception e) {
            System.err.println(
                    "Error during program execution. Error message is: " + e.getMessage()
            );
            e.printStackTrace();
        }
    }

}

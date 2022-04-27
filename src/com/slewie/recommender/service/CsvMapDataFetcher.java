package com.slewie.recommender.service;

import com.slewie.recommender.exception.CsvParsingException;
import com.slewie.recommender.map.FoodType;
import com.slewie.recommender.map.PlaceInfo;
import com.slewie.recommender.map.PlaceRating;
import com.slewie.recommender.map.PlaceType;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import java.util.HashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class CsvMapDataFetcher extends MapDataHandler implements MapDataFetcher {

    private final String filename;
    private final Scanner scanner;
    private int rowNum = 0;

    public CsvMapDataFetcher(String filename) {
        this.filename = filename;
        try {
            scanner = new Scanner(new FileInputStream(filename));
        } catch (FileNotFoundException e) {
            throw new CsvParsingException(
                    format("File %s not found.", filename)
            );
        }
    }

    @Override
    public Set<PlaceInfo> handle(Set<PlaceInfo> places) {
        return callNext(fetchPlaces());
    }

    @Override
    public Set<PlaceInfo> fetchPlaces() {
        var result = new HashSet<PlaceInfo>();

        while (true) {
            var place = fetchRow();
            if (place.isPresent()) {
                result.add(place.get());
            } else {
                break;
            }
        }

        return result;
    }

    private Optional<PlaceInfo> fetchRow() {
        if (!scanner.hasNextLine()) {
            return Optional.empty();
        }

        ++rowNum;
        String[] currentRow = scanner.nextLine().split(",");

        int colNum = 0;
        var name = currentRow[colNum++].strip();

        try {
            var rating = PlaceRating.ofStars(
                    parseInt(currentRow[colNum++].strip())
            );

            var placeType = PlaceType.valueOf(
                    currentRow[colNum++].toUpperCase().strip()
            );

            var foodTypes = new HashSet<FoodType>();
            while (colNum < currentRow.length) {
                foodTypes.add(
                        FoodType.valueOf(
                                currentRow[colNum].toUpperCase().strip()
                        )
                );
                colNum++;
            }

            return Optional.of(
                    new PlaceInfo(name, rating, placeType, foodTypes)
            );

        } catch (IllegalArgumentException illegalArgumentException) {
            throw new CsvParsingException(
                    filename,
                    rowNum,
                    colNum,
                    illegalArgumentException.getMessage()
            );
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw new CsvParsingException(
                    filename,
                    rowNum,
                    colNum,
                    "Row finished unexpectedly. Expected to see at least 3 columns."
            );
        }

    }
}

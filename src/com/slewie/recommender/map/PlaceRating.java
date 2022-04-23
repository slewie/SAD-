package com.slewie.recommender.map;

import static java.lang.String.format;

public enum PlaceRating {

    EXCELLENT(5),
    VERY_GOOD(4),
    SATISFYING(3),
    SUFFICIENT(2),
    UNSATISFACTORY(1);

    private final int stars;

    PlaceRating(int starsCount) {this.stars = starsCount;}

    public static PlaceRating ofStars(int stars) {
        return switch (stars) {
            case 1 -> UNSATISFACTORY;
            case 2 -> SUFFICIENT;
            case 3 -> SATISFYING;
            case 4 -> VERY_GOOD;
            case 5 -> EXCELLENT;
            default -> throw new IllegalArgumentException(
                    format("Expected stars to be in range [1;5], but got %d", stars)
            );
        };
    }

    public int getStars() {
        return stars;
    }

}

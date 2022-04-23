package com.slewie.recommender.exception;

import static java.lang.String.format;

public class CsvParsingException extends RuntimeException {

    private final String message;

    public CsvParsingException(String message) {
        super(message);
        this.message = message;
    }

    public CsvParsingException(
            String filename,
            int row,
            int column,
            String message
    ) {
        super(
                format(
                        "Exception parsing %s at (%d, %d). Message is: %s.",
                        filename,
                        row,
                        column,
                        message
                )
        );
        this.message = message;
    }

}

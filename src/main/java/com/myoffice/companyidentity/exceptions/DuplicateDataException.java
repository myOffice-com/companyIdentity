package com.myoffice.companyidentity.exceptions;

import java.io.Serial;

public class DuplicateDataException extends RuntimeException {

    /**
     * Exception to be thrown when duplicate data is found in the system.
     * This exception is used to indicate that an operation cannot be completed
     * due to the presence of duplicate data that violates unique constraints.
     */
    @Serial
    private static final long serialVersionUID = 1577561110380371166L;


    public DuplicateDataException(String message) {
        super(message);
    }

}

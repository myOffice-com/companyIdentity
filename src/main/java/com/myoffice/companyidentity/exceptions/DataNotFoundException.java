package com.myoffice.companyidentity.exceptions;

import java.io.Serial;

public class DataNotFoundException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 6277833385707712286L;

    public DataNotFoundException (String message) {
        super(message);
    }

}

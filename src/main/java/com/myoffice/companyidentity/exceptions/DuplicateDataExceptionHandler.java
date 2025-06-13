package com.myoffice.companyidentity.exceptions;

import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DuplicateDataExceptionHandler {

    @ExceptionHandler(DuplicateDataException.class)
    public ProblemDetail duplicateDataExceptionHandler(DuplicateDataException duplicateDataException) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(409);
        problemDetail.setTitle("Duplicate Data");
        problemDetail.setProperty("message", duplicateDataException.getMessage());
        return problemDetail;
    }

}

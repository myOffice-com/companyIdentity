package com.myoffice.companyidentity.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DataNotFoundExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ProblemDetail dataNotFoundExceptionHandler(DataNotFoundException dataNotFoundException) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatusCode.valueOf(404));
        problemDetail.setTitle("Data Not Found");
        problemDetail.setProperty("message", dataNotFoundException.getMessage());
        return problemDetail;
    }


}

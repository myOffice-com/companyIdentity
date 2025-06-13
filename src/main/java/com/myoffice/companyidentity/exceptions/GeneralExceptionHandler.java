package com.myoffice.companyidentity.exceptions;

import org.slf4j.Logger;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(GeneralExceptionHandler.class);

    /**
     * Exception to be thrown for general errors that do not fit into specific categories.
     * This exception is used to indicate that an operation cannot be completed due to
     * an unexpected error or a condition that does not match any other defined exceptions.
     */
    @ExceptionHandler(Exception.class)
    public ProblemDetail generalExceptionHandler(Exception exception) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatusCode.valueOf(500));
        problemDetail.setTitle("Internal Server Error");
        problemDetail.setProperty("message", "Something went wrong. Please try again later.");
        logger.error("An unexpected error occurred: {}", exception.getMessage(), exception);
        return problemDetail;
    }


}

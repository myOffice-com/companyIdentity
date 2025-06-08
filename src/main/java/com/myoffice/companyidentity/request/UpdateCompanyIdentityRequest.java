package com.myoffice.companyidentity.request;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;


/**
 * Request object for updating company identity information.
 * This class is used to encapsulate the data required to update a company's identity.
 */
public record UpdateCompanyIdentityRequest(


    /**
     * Name of the company.
     */
    @NotNull(message = "Company name cannot be null")
    @Size(min = 1, max = 100, message = "Company name must be between 1 and 100 characters")
    String companyName,

    /**
     * Address of the company.
     */
    @NotNull(message = "Address cannot be null")
    @Size(min = 1, max = 255, message = "Address must be between 1 and 255 characters")
    String address,

    /**
     * CGI (Corporate Group Identifier) number of the company.
     */
    @NotNull(message = "CGI number cannot be null")
    String cgiNumber,

    /**
     * Identifier for the company administrator.
     */
    @NotNull(message = "Company admin ID cannot be null")
    @Size(min = 1, max = 10, message = "Company admin ID must be between 1 and 10 characters")
    String companyAdminId,

    /**
     * Password associated with the company account.
     */
    @NotNull(message = "Password cannot be null")
    @Size(min = 8, max = 50, message = "Password must be between 8 and 50 characters")
    String password,

    /**
     * Start date of the company's operations.
     */
    @NotNull(message = "Start date cannot be null")
    LocalDate startDate,

    /**
     * Start time of the company's operations.
     */
    @NotNull(message = "Start time cannot be null")
    String startTime,

    /**
     * End date of the company's operations.
     */
    @NotNull(message = "End date cannot be null")
    LocalDate endDate,

    /**
     * End time of the company's operations.
     */
    @NotNull(message = "End time cannot be null")
    String endTime
) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1480119316683378949L;
}
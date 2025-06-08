package com.myoffice.companyidentity.dto;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Data Transfer Object (DTO) for retrieving company identity information.
 * This record is used to transfer company identity data between layers of the application.
 */
public record GetCompanyIdentityDTO(

    /**
     * Unique identifier for the company.
     */
    String companyId,

    /**
     * Name of the company.
     */
    String companyName,

    /**
     * Address of the company.
     */
    String address,

    /**
     * CGI (Corporate Group Identifier) number of the company.
     */
    String cgiNumber,

    /**
     * Identifier for the company administrator.
     */
    String companyAdminId,

    /**
     * Password associated with the company account.
     */
    String password,

    /**
     * Start date of the company's operations.
     */
    LocalDate startDate,

    /**
     * Start time of the company's operations.
     */
    String startTime,

    /**
     * End date of the company's operations.
     */
    LocalDate endDate,

    /**
     * End time of the company's operations.
     */
     String endTime) implements Serializable {
    @Serial
    private static final long serialVersionUID = 492789791913183401L;
    }

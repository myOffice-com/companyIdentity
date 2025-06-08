package com.myoffice.companyidentity.response;

import java.io.Serial;
import java.time.LocalDate;


/**
 * Response object for creating a company identity.
 * This class encapsulates the details of a newly created company identity.
 */
public record CreateCompanyIdentityResponse(

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
    String endTime

) implements java.io.Serializable {
    @Serial
    private static final long serialVersionUID = 4241011408955376889L;
}
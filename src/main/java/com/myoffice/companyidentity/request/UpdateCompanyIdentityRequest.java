package com.myoffice.companyidentity.request;


import com.myoffice.companyidentity.util.FieldErrorConstants;
import jakarta.validation.constraints.NotBlank;
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
    @NotNull(message = FieldErrorConstants.COMPANY_NAME_CANNOT_BE_NULL)
    @Size(min = 1, max = 100, message = "Company name must be between 1 and 100 characters")
    @NotBlank(message = "Company name cannot be blank")
    String companyName,

    /**
     * Address of the company.
     */
    @NotNull(message = FieldErrorConstants.ADDRESS_CANNOT_BE_NULL)
    @Size(min = 1, max = 255, message = FieldErrorConstants.ADDRESS_MUST_BE_BETWEEN_1_AND_255_CHARACTERS)
    String address,

    /**
     * CGI (Corporate Group Identifier) number of the company.
     */
    @NotNull(message = FieldErrorConstants.CGI_NUMBER_CANNOT_BE_NULL)
    @NotBlank(message = "CGI number cannot be blank")
    String cgiNumber,

    /**
     * Identifier for the company administrator.
     */
    @NotNull(message = FieldErrorConstants.COMPANY_ADMIN_ID_CANNOT_BE_NULL)
    @Size(min = 1, max = 10, message = FieldErrorConstants.COMPANY_ID_MUST_BE_EXACTLY_10_CHARACTERS_LONG)
    @NotBlank(message = "Company admin ID cannot be blank")
    String companyAdminId,

    /**
     * Password associated with the company account.
     */
    @NotNull(message = FieldErrorConstants.PASSWORD_CANNOT_BE_NULL)
    @Size(min = 8, max = 50, message = FieldErrorConstants.PASSWORD_MUST_BE_BETWEEN_8_AND_50_CHARACTERS)
    @NotBlank(message = "Password cannot be blank")
    String password,

    /**
     * Start date of the company's operations.
     */
    @NotNull(message = FieldErrorConstants.START_DATE_CANNOT_BE_NULL)
    LocalDate startDate,

    /**
     * Start time of the company's operations.
     */
    @NotNull(message = FieldErrorConstants.START_TIME_CANNOT_BE_NULL)
    String startTime,

    /**
     * End date of the company's operations.
     */
    @NotNull(message = FieldErrorConstants.END_DATE_CANNOT_BE_NULL)
    LocalDate endDate,

    /**
     * End time of the company's operations.
     */
    @NotNull(message = FieldErrorConstants.END_TIME_CANNOT_BE_NULL)
    String endTime,

    boolean isExpired

) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1480119316683378949L;
}
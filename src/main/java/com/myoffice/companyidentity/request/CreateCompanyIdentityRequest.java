package com.myoffice.companyidentity.request;

import com.myoffice.companyidentity.util.FieldErrorConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;



/**
 * Request object for creating a company identity.
 */
public record CreateCompanyIdentityRequest(

    /**
     * Name of the company.
     */
    @NotNull(message = FieldErrorConstants.COMPANY_NAME_CANNOT_BE_NULL)
    @Size(min = 1, max = 100, message = FieldErrorConstants.COMPANY_NAME_MUST_BE_BETWEEN_1_AND_100_CHARACTERS)
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
    @NotNull(message = "CGI number cannot be null")
    @NotBlank(message = "CGI number cannot be blank")
    String cgiNumber,

    /**
     * Identifier for the company administrator.
     */
    @NotNull(message = FieldErrorConstants.COMPANY_ADMIN_ID_CANNOT_BE_NULL)
    @Size(min = 1, max = 10, message = FieldErrorConstants.COMPANY_ADMIN_ID_MUST_BE_BETWEEN_1_AND_10_CHARACTERS)
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
    private static final long serialVersionUID = 1961706458556934210L;
}

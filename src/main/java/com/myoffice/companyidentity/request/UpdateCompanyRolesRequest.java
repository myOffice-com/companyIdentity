package com.myoffice.companyidentity.request;

import com.myoffice.companyidentity.util.FieldErrorConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public record UpdateCompanyRolesRequest (

        /**
         * Identifier for the company whose roles are to be updated.
         */
        @NotNull(message = FieldErrorConstants.COMPANY_ID_CANNOT_BE_NULL)
        @Size(min = 10, max = 10, message = FieldErrorConstants.COMPANY_ID_MUST_BE_EXACTLY_10_CHARACTERS_LONG)
        @NotBlank(message = "Company ID cannot be blank")
        String companyId,

        /**
         * List of roles to be updated for the company.
         */
        @NotNull(message = FieldErrorConstants.ROLES_CANNOT_BE_NULL)
        List<String> roles

) implements Serializable{
    @Serial
    private static final long serialVersionUID = 1003221257541325980L;
}

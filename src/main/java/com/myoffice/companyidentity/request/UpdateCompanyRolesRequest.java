package com.myoffice.companyidentity.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public record UpdateCompanyRolesRequest (

        /**
         * Identifier for the company whose roles are to be updated.
         */
        @NotNull(message = "Company ID cannot be null")
        @Size(min = 10, max = 10, message = "Company ID must be exactly 10 characters long")
        String companyId,

        /**
         * List of roles to be updated for the company.
         */
        @NotNull(message = "Roles cannot be null")
        List<String> roles

) implements Serializable{
    @Serial
    private static final long serialVersionUID = 1003221257541325980L;
}

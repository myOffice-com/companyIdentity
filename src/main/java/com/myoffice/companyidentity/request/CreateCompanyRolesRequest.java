package com.myoffice.companyidentity.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public record CreateCompanyRolesRequest(

        /**
         * Identifier for the company to which the role belongs.
         */
        @NotNull(message = "Company ID cannot be null")
        @Size(min = 10, max = 10, message = "Company ID must be exactly 10 characters long")
        String companyId,

        /**
         * List of roles to be created for the company.
         */
        @NotNull(message = "Roles cannot be null")
        List<String> roles

) implements Serializable {
    @Serial
    private static final long serialVersionUID = -8143995058169392304L;
}

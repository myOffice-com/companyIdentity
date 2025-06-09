package com.myoffice.companyidentity.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public record GetCompanyRolesDTO(

        /**
         * Identifier for the company whose roles are retrieved.
         */
        String companyId,

        /**
         * List of roles associated with the company.
         */
        List<String> roles

) implements Serializable {

    @Serial
    private static final long serialVersionUID = 6946446825447238975L;

}

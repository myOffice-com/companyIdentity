package com.myoffice.companyidentity.dto;


import java.io.Serial;
import java.io.Serializable;

/**
 * Data Transfer Object (DTO) for retrieving company identities.
 * This record is used to transfer company identity data between layers of the application.
 */
public record GetCompanyIdentitiesDTO(String companyId, String companyName) implements Serializable {

    @Serial
    private static final long serialVersionUID = -3997006367202826784L;

}

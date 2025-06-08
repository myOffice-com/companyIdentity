package com.myoffice.companyidentity.service;

import com.myoffice.companyidentity.dto.GetCompanyIdentityDTO;

public interface GetCompanyIdentityService {

    /**
     * Retrieves the company identity based on the provided company ID.
     *
     * @param companyId the ID of the company whose identity is to be retrieved
     * @return GetCompanyIdentityDTO containing the company identity details
     */
    GetCompanyIdentityDTO getCompanyIdentity(String companyId);

}

package com.myoffice.companyidentity.service.companyidentity;

import com.myoffice.companyidentity.dto.GetCompanyIdentitiesDTO;

import java.util.List;

public interface GetAllCompanyIdentitiesService {
    /**
     * Retrieves all company identities.
     *
     * @return a list of all company identities
     */
    List<GetCompanyIdentitiesDTO> getAllCompanyIdentities(String filterKey);
}

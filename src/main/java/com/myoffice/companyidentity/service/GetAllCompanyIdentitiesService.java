package com.myoffice.companyidentity.service;

import com.myoffice.companyidentity.dto.GetCompanyIdentitiesList;

import java.util.List;

public interface GetAllCompanyIdentitiesService {
    /**
     * Retrieves all company identities.
     *
     * @return a list of all company identities
     */
    List<GetCompanyIdentitiesList> getAllCompanyIdentities();
}

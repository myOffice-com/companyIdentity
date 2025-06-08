package com.myoffice.companyidentity.service;

import com.myoffice.companyidentity.request.UpdateCompanyIdentityRequest;

public interface UpdateCompanyIdentityService {

    /**
     * Updates the company identity based on the provided request.
     *
     * @param request the request containing the details to update the company identity
     * @return a response indicating the result of the update operation
     */
    void updateCompanyIdentity(String companyId,UpdateCompanyIdentityRequest request);

}

package com.myoffice.companyidentity.validators;

import com.myoffice.companyidentity.request.UpdateCompanyIdentityRequest;

public interface UpdateCompanyIdentityValidator {

    void validateCompanyIdentity(UpdateCompanyIdentityRequest request, String companyId);

}

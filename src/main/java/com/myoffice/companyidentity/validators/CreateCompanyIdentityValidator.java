package com.myoffice.companyidentity.validators;

import com.myoffice.companyidentity.request.CreateCompanyIdentityRequest;

public interface CreateCompanyIdentityValidator {

    void validateCompanyIdentity(CreateCompanyIdentityRequest createCompanyIdentityRequest);

}

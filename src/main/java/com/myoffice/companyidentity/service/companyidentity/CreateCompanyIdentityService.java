package com.myoffice.companyidentity.service.companyidentity;

import com.myoffice.companyidentity.request.CreateCompanyIdentityRequest;
import com.myoffice.companyidentity.response.CreateCompanyIdentityResponse;

public interface CreateCompanyIdentityService {

    CreateCompanyIdentityResponse createCompanyIdentity(CreateCompanyIdentityRequest request);

}

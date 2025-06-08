package com.myoffice.companyidentity.mappers;

import com.myoffice.companyidentity.entity.CompanyIdentity;
import com.myoffice.companyidentity.request.CreateCompanyIdentityRequest;
import com.myoffice.companyidentity.response.CreateCompanyIdentityResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateCompanyIdentityMapper {
    CompanyIdentity createCompanyIdentityRequestToEntity(CreateCompanyIdentityRequest request);
    CreateCompanyIdentityResponse companyIdentityToCreateCompanyIdentityResponse(CompanyIdentity companyIdentity);
}

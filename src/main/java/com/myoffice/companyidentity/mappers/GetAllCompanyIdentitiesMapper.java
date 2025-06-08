package com.myoffice.companyidentity.mappers;

import com.myoffice.companyidentity.dto.GetCompanyIdentitiesList;
import com.myoffice.companyidentity.entity.CompanyIdentity;

import java.util.List;

public interface GetAllCompanyIdentitiesMapper {
    List<GetCompanyIdentitiesList> companyIdentitiesToGetCompanyIdentitiesList(List<CompanyIdentity> companyIdentities);
}

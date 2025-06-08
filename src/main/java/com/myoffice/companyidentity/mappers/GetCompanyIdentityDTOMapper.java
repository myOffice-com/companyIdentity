package com.myoffice.companyidentity.mappers;

import com.myoffice.companyidentity.dto.GetCompanyIdentityDTO;
import com.myoffice.companyidentity.entity.CompanyIdentity;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface GetCompanyIdentityDTOMapper {

    GetCompanyIdentityDTO getCompanyIdentity(CompanyIdentity companyIdentity);
}

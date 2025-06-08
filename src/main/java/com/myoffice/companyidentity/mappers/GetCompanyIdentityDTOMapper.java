package com.myoffice.companyidentity.mappers;

import com.myoffice.companyidentity.dto.GetCompanyIdentityDTO;
import com.myoffice.companyidentity.entity.CompanyIdentity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GetCompanyIdentityDTOMapper {

    GetCompanyIdentityDTOMapper Instance = Mappers.getMapper(GetCompanyIdentityDTOMapper.class);

    GetCompanyIdentityDTO getCompanyIdentity(CompanyIdentity companyIdentity);
}

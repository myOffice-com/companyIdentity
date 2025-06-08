package com.myoffice.companyidentity.mappers;

import com.myoffice.companyidentity.dto.GetCompanyIdentitiesDTO;
import com.myoffice.companyidentity.entity.CompanyIdentity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface GetAllCompanyIdentitiesMapper {

    GetAllCompanyIdentitiesMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(GetAllCompanyIdentitiesMapper.class);

    // Mapping method for a single object
    GetCompanyIdentitiesDTO companyIdentityToGetCompanyIdentitiesDTO(CompanyIdentity companyIdentity);

    // Mapping method for a list of objects
    List<GetCompanyIdentitiesDTO> companyIdentitiesToGetCompanyIdentitiesDTOList(List<CompanyIdentity> companyIdentities);
}
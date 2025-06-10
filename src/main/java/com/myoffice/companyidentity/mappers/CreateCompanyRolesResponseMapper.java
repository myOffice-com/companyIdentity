package com.myoffice.companyidentity.mappers;

import com.myoffice.companyidentity.entity.CompanyRoles;
import com.myoffice.companyidentity.response.CreateCompanyRolesResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel ="spring")
public interface CreateCompanyRolesResponseMapper {
     CreateCompanyRolesResponse companyRolestoCreateCompanyRolesResponse(CompanyRoles companyRoles);
}

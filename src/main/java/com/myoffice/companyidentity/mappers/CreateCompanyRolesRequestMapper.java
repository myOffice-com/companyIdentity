package com.myoffice.companyidentity.mappers;

import ch.qos.logback.core.model.ComponentModel;
import com.myoffice.companyidentity.entity.CompanyRoles;
import com.myoffice.companyidentity.request.CreateCompanyRolesRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface CreateCompanyRolesRequestMapper {
    CompanyRoles companyRoles(CreateCompanyRolesRequest createCompanyRolesRequest);

}

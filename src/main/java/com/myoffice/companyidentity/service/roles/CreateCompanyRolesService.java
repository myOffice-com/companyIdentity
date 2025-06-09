package com.myoffice.companyidentity.service.roles;

import com.myoffice.companyidentity.request.CreateCompanyRolesRequest;

public interface CreateCompanyRolesService {

    /**
     * Creates roles for a company based on the provided request.
     *
     * @param request the request containing the details for creating company roles
     */
    void createCompanyRoles(CreateCompanyRolesRequest request );

}

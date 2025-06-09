package com.myoffice.companyidentity.service.roles;

import com.myoffice.companyidentity.request.UpdateCompanyRolesRequest;

public interface UpdateCompanyRolesService {

    /**
     * Updates the roles for a company based on the provided request.
     *
     * @param request the request containing the details for updating company roles
     */
    void updateCompanyRoles( UpdateCompanyRolesRequest request );

}

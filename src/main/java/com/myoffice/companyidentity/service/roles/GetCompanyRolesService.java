package com.myoffice.companyidentity.service.roles;

import com.myoffice.companyidentity.dto.GetCompanyRolesDTO;

public interface GetCompanyRolesService {
     /**
      * Retrieves the roles associated with a company based on the provided company ID.
      *
      * @param companyId the ID of the company whose roles are to be retrieved
      * @return GetCompanyRolesDTO containing the roles of the company
      */
    GetCompanyRolesDTO getCompanyRoles(String companyId);

}

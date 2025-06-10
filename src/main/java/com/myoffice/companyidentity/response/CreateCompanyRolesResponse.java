package com.myoffice.companyidentity.response;

import java.util.List;

public record CreateCompanyRolesResponse(
        long roleId,
        String companyId,
        List<String> roles

) {



}

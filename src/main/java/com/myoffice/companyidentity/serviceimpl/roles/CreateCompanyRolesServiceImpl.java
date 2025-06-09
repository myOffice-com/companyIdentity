package com.myoffice.companyidentity.serviceimpl.roles;

import com.myoffice.companyidentity.request.CreateCompanyRolesRequest;
import com.myoffice.companyidentity.service.roles.CreateCompanyRolesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyRolesServiceImpl implements CreateCompanyRolesService {


    private static final Logger logger = LoggerFactory.getLogger(CreateCompanyRolesServiceImpl.class);


    /**
     * Creates roles for a company based on the provided request.
     *
     * @param request the request containing the details for creating company roles
     */
    @Override
    public void createCompanyRoles(CreateCompanyRolesRequest request) {

    }



}

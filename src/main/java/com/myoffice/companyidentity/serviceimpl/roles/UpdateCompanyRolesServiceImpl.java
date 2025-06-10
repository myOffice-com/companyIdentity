package com.myoffice.companyidentity.serviceimpl.roles;

import com.myoffice.companyidentity.entity.CompanyRoles;
import com.myoffice.companyidentity.repository.CompanyRolesRepository;
import com.myoffice.companyidentity.request.UpdateCompanyRolesRequest;
import com.myoffice.companyidentity.service.roles.UpdateCompanyRolesService;
import com.myoffice.companyidentity.util.IdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Service implementation for updating company roles.*/
@Service
public class UpdateCompanyRolesServiceImpl implements UpdateCompanyRolesService {

    private static final Logger logger = LoggerFactory.getLogger(UpdateCompanyRolesServiceImpl.class);


    private final CompanyRolesRepository companyRolesRepository;

    private final IdGenerator idGenerator;

    public UpdateCompanyRolesServiceImpl(CompanyRolesRepository companyRolesRepository, IdGenerator idGenerator) {
        this.companyRolesRepository = companyRolesRepository;
        this.idGenerator = idGenerator;
    }


    /**
     * Update the roles for a company identified by roleId and request data.
     *
     * @param roleId the ID of a role to verify existence before update
     * @param request contains companyId and new list of role names to update
     */
    @Transactional
    @Override
    public void updateCompanyRoles(Long roleId, UpdateCompanyRolesRequest request) {
        logger.info("update company roles method started");
        getCompanyRoles(roleId);
        companyRolesRepository.deleteByCompanyId(request.companyId());
        List<CompanyRoles> newRoles = new ArrayList<>();
        request.roles().forEach(roleName -> {
            CompanyRoles role = new CompanyRoles();
            role.setRoleId(Long.parseLong(idGenerator.generateId(10)));// Optional if @GeneratedValue used
            role.setCompanyId(request.companyId());
            role.setRoleName(roleName);
            newRoles.add(role);
        });

        companyRolesRepository.saveAll(newRoles);
    }

    /**
     * Retrieves a CompanyRoles entity by roleId.
     * Throws IllegalArgumentException if role not found.
     *
     * @param roleId the role ID to find
     * @return the CompanyRoles entity if found
     */
    private CompanyRoles getCompanyRoles(Long roleId) {
        logger.info("role id not found");
        return companyRolesRepository.findById(roleId)
                .orElseThrow(()->new IllegalArgumentException("role id not found"));
    }

}

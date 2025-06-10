package com.myoffice.companyidentity.serviceimpl.roles;

import com.myoffice.companyidentity.entity.CompanyRoles;
import com.myoffice.companyidentity.mappers.CreateCompanyRolesRequestMapper;
import com.myoffice.companyidentity.repository.CompanyRolesRepository;
import com.myoffice.companyidentity.request.CreateCompanyRolesRequest;
import com.myoffice.companyidentity.service.roles.CreateCompanyRolesService;
import com.myoffice.companyidentity.util.IdGenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Service implementation responsible for creating or updating company roles.
 */
@Service
public class CreateCompanyRolesServiceImpl implements CreateCompanyRolesService {


    private static final Logger logger = LoggerFactory.getLogger(CreateCompanyRolesServiceImpl.class);

    private final CompanyRolesRepository companyRolesRepository;
    private final CreateCompanyRolesRequestMapper createCompanyRolesRequestMapper;
    private final IdGenerator idGenerator;

    /**
     * Constructor for dependency injection.
     *
     * @param companyRolesRepository Repository to manage CompanyRoles persistence.
     * @param createCompanyRolesRequestMapper Mapper to convert request DTOs to entities.
     * @param idGenerator Utility to generate unique IDs for roles (if not using @GeneratedValue).
     */
    public CreateCompanyRolesServiceImpl(CompanyRolesRepository companyRolesRepository, CreateCompanyRolesRequestMapper createCompanyRolesRequestMapper, IdGenerator idGenerator) {
        this.companyRolesRepository = companyRolesRepository;
        this.createCompanyRolesRequestMapper = createCompanyRolesRequestMapper;
        this.idGenerator = idGenerator;
    }


    /**
     * Creates roles for a company based on the provided request.
     *
     * @param request the request containing the details for creating company roles
     */
    @Transactional
    @Override
    public void createCompanyRoles(CreateCompanyRolesRequest request) {
        CompanyRoles companyRoles = createCompanyRolesRequestMapper.companyRoles(request);
        // Delete existing roles for the company
        companyRolesRepository.deleteByCompanyId(companyRoles.getCompanyId());

        // Prepare new roles
        List<CompanyRoles> newRoles = new ArrayList<>();
        request.roles().forEach(roleName -> {
            CompanyRoles role = new CompanyRoles();

            // Optional: Only use this if you're not using @GeneratedValue in the entity
            role.setRoleId(Long.parseLong(idGenerator.generateId(10)));

            role.setCompanyId(request.companyId());
            role.setRoleName(roleName);
            newRoles.add(role);
        });

        // Save all roles in one go
        companyRolesRepository.saveAll(newRoles);

        logger.info("Saved {} roles for companyId={}", newRoles.size(), request.companyId());
    }




}

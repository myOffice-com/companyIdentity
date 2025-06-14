package com.myoffice.companyidentity.serviceimpl.roles;

import com.myoffice.companyidentity.entity.CompanyRoles;
import com.myoffice.companyidentity.exceptions.DataNotFoundException;
import com.myoffice.companyidentity.exceptions.DuplicateDataException;
import com.myoffice.companyidentity.exceptions.ResponseCodes;
import com.myoffice.companyidentity.repository.CompanyIdentityRepository;
import com.myoffice.companyidentity.repository.CompanyRolesRepository;
import com.myoffice.companyidentity.request.CreateCompanyRolesRequest;
import com.myoffice.companyidentity.service.roles.CreateCompanyRolesService;
import com.myoffice.companyidentity.util.IdGenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
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
    private final MessageSource messageSource;
    private final CompanyIdentityRepository companyIdentityRepository;

    /**
     * Constructor for dependency injection.
     *
     * @param companyRolesRepository Repository to manage CompanyRoles persistence.
     */
    public CreateCompanyRolesServiceImpl(CompanyRolesRepository companyRolesRepository, MessageSource messageSource, CompanyIdentityRepository companyIdentityRepository) {
        this.companyRolesRepository = companyRolesRepository;
        this.messageSource = messageSource;
        this.companyIdentityRepository = companyIdentityRepository;
    }


    /**
     * Creates roles for a company based on the provided request.
     *
     * @param request the request containing the details for creating company roles
     */
    @Transactional
    @Override
    public void createCompanyRoles(CreateCompanyRolesRequest request) {
        validateCompanyId(request.companyId());
        deleteExistingRoles(request.companyId());
        logger.info("Creating roles for companyId={}", request.companyId());
        List<CompanyRoles> newRoles = new ArrayList<>();
        request.roles().forEach(roleName -> {
            CompanyRoles role = new CompanyRoles();
            role.setCompanyId(request.companyId());
            role.setRoleName(roleName);
            newRoles.add(role);
        });
        companyRolesRepository.saveAll(newRoles);
        logger.info("Saved {} roles for companyId={}", newRoles.size(), request.companyId());
    }

    private void deleteExistingRoles(String companyId) {
        logger.info("Deleting existing roles for companyId={}", companyId);
        companyRolesRepository.deleteByCompanyId(companyId);
    }


    private void validateCompanyId(String companyId){
        companyIdentityRepository.findByCompanyId(companyId)
                .orElseThrow(() -> new DataNotFoundException(messageSource.getMessage(ResponseCodes.COMPANY_ID_NOT_FOUND,null, LocaleContextHolder.getLocale())));
    }




}

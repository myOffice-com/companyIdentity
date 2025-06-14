package com.myoffice.companyidentity.serviceimpl.roles;

import com.myoffice.companyidentity.dto.GetCompanyRolesDTO;
import com.myoffice.companyidentity.entity.CompanyRoles;
import com.myoffice.companyidentity.exceptions.DataNotFoundException;
import com.myoffice.companyidentity.exceptions.ResponseCodes;
import com.myoffice.companyidentity.repository.CompanyIdentityRepository;
import com.myoffice.companyidentity.repository.CompanyRolesRepository;
import com.myoffice.companyidentity.service.roles.GetCompanyRolesService;
import org.slf4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of the GetCompanyRolesService interface to retrieve roles associated with a company.
 */
@Service
public class GetCompanyRolesServiceImpl implements GetCompanyRolesService {


    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(GetCompanyRolesServiceImpl.class);

    private final CompanyIdentityRepository companyIdentityRepository;
    private final CompanyRolesRepository companyRolesRepository;
    private final MessageSource messageSource;

    public GetCompanyRolesServiceImpl(CompanyIdentityRepository companyIdentityRepository, CompanyRolesRepository companyRolesRepository, MessageSource messageSource) {
        this.companyIdentityRepository = companyIdentityRepository;
        this.companyRolesRepository = companyRolesRepository;
        this.messageSource = messageSource;
    }


    /**
     * Retrieves the roles associated with a company based on the provided company ID.
     *
     * @param companyId the ID of the company whose roles are to be retrieved
     * @return GetCompanyRolesDTO containing the roles of the company
     */
    @Transactional(readOnly = true)
    @Override
    public GetCompanyRolesDTO getCompanyRoles(String companyId) {
        validateCompanyId(companyId);
        logger.info("Retrieving roles for company with ID: {}", companyId);
        List<CompanyRoles> companyRoles = companyRolesRepository.findAllByCompanyId(companyId);
        if (companyRoles.isEmpty()) {
            logger.warn("No roles found for company with ID: {}", companyId);
            return new GetCompanyRolesDTO(companyId, List.of());
        }
        return mapToGetCompanyRolesDTO(companyRoles, companyId);
    }

    /**
     * Validates the existence of a company by its ID.
     *
     * @param companyId the ID of the company to validate
     * @throws IllegalArgumentException if the company does not exist
     */
    private void validateCompanyId(String companyId) {
        logger.info("Validating company ID: {}", companyId);
        companyIdentityRepository.findByCompanyId(companyId)
                .orElseThrow(() -> new DataNotFoundException(messageSource.getMessage(ResponseCodes.COMPANY_ID_NOT_FOUND,null, LocaleContextHolder.getLocale())));
    }

    /**
     * Maps a list of CompanyRoles to a GetCompanyRolesDTO.
     *
     * @param companyRoles the list of CompanyRoles to map
     * @param companyId    the ID of the company
     * @return GetCompanyRolesDTO containing the company ID and its roles
     */
    private GetCompanyRolesDTO mapToGetCompanyRolesDTO(List<CompanyRoles> companyRoles, String companyId) {
        return new GetCompanyRolesDTO(companyId, companyRoles.stream().map(CompanyRoles::getRoleName).toList());
    }





}

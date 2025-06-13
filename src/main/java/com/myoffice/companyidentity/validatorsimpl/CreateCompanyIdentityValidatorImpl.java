package com.myoffice.companyidentity.validatorsimpl;

import com.myoffice.companyidentity.exceptions.DuplicateDataException;
import com.myoffice.companyidentity.repository.CompanyIdentityRepository;
import com.myoffice.companyidentity.request.CreateCompanyIdentityRequest;
import com.myoffice.companyidentity.validators.CreateCompanyIdentityValidator;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class CreateCompanyIdentityValidatorImpl implements CreateCompanyIdentityValidator {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(CreateCompanyIdentityValidatorImpl.class);

    private final CompanyIdentityRepository companyIdentityRepository;

    public CreateCompanyIdentityValidatorImpl(CompanyIdentityRepository companyIdentityRepository) {
        this.companyIdentityRepository = companyIdentityRepository;
    }


    /**
     * @param createCompanyIdentityRequest
     */
    @Override
    public void validateCompanyIdentity(CreateCompanyIdentityRequest createCompanyIdentityRequest) {
        validateCompanyName(createCompanyIdentityRequest.companyName());
        validateCGINumber(createCompanyIdentityRequest.cgiNumber());
        validateAdminId(createCompanyIdentityRequest.companyAdminId());
    }


    private void validateCompanyName(String companyName){

        if (companyIdentityRepository.existsByCompanyName(companyName)) {
            logger.error("Company name already exists: {}", companyName);
            throw new DuplicateDataException("Company name already exists: " + companyName);
        }

    }

    private void validateCGINumber(String cgiNumber) {

        if (companyIdentityRepository.existsByCgiNumber(cgiNumber)) {
            logger.error("CGI number already exists: {}", cgiNumber);
            throw new DuplicateDataException("CGI number already exists: " + cgiNumber);
        }

    }


    private void validateAdminId(String adminId) {

        if( companyIdentityRepository.existsByCompanyAdminId(adminId)) {
            logger.error("Admin ID already exists: {}", adminId);
            throw new DuplicateDataException("Admin ID already exists: " + adminId);
        }

    }





}

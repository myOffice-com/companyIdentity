package com.myoffice.companyidentity.validatorsimpl;

import com.myoffice.companyidentity.exceptions.DuplicateDataException;
import com.myoffice.companyidentity.exceptions.ResponseCodes;
import com.myoffice.companyidentity.repository.CompanyIdentityRepository;
import com.myoffice.companyidentity.request.CreateCompanyIdentityRequest;
import com.myoffice.companyidentity.validators.CreateCompanyIdentityValidator;
import org.slf4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class CreateCompanyIdentityValidatorImpl implements CreateCompanyIdentityValidator {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(CreateCompanyIdentityValidatorImpl.class);

    private final CompanyIdentityRepository companyIdentityRepository;

    private final MessageSource messageSource;

    public CreateCompanyIdentityValidatorImpl(CompanyIdentityRepository companyIdentityRepository, MessageSource messageSource) {
        this.companyIdentityRepository = companyIdentityRepository;
        this.messageSource = messageSource;
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
            throw new DuplicateDataException(messageSource.getMessage(ResponseCodes.COMPANY_NAME_ALREADY_EXIST,null, LocaleContextHolder.getLocale()));
        }

    }

    private void validateCGINumber(String cgiNumber) {

        if (companyIdentityRepository.existsByCgiNumber(cgiNumber)) {
            logger.error("CGI number already exists: {}", cgiNumber);
            throw new DuplicateDataException(messageSource.getMessage(ResponseCodes.CGI_NUMBER_ALREADY_EXIST,null,LocaleContextHolder.getLocale()));
        }

    }


    private void validateAdminId(String adminId) {

        if( companyIdentityRepository.existsByCompanyAdminId(adminId)) {
            logger.error("Admin ID already exists: {}", adminId);
            throw new DuplicateDataException(messageSource.getMessage(ResponseCodes.ADMIN_ID_ALREADY_EXIST,null,LocaleContextHolder.getLocale()));
        }

    }





}

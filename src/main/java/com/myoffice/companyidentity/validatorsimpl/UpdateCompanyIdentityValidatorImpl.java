package com.myoffice.companyidentity.validatorsimpl;

import com.myoffice.companyidentity.entity.CompanyIdentity;
import com.myoffice.companyidentity.exceptions.DuplicateDataException;
import com.myoffice.companyidentity.exceptions.ResponseCodes;
import com.myoffice.companyidentity.repository.CompanyIdentityRepository;
import com.myoffice.companyidentity.request.UpdateCompanyIdentityRequest;
import com.myoffice.companyidentity.validators.UpdateCompanyIdentityValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UpdateCompanyIdentityValidatorImpl implements UpdateCompanyIdentityValidator {


    private static final Logger logger = LoggerFactory.getLogger(UpdateCompanyIdentityValidatorImpl.class);

    private final CompanyIdentityRepository companyIdentityRepository;
    private final MessageSource messageSource;

    public UpdateCompanyIdentityValidatorImpl(CompanyIdentityRepository companyIdentityRepository, MessageSource messageSource) {
        this.companyIdentityRepository = companyIdentityRepository;
        this.messageSource = messageSource;
    }

    @Override
    public void validateCompanyIdentity(UpdateCompanyIdentityRequest request, String companyId) {
        validateCompanyName(request.companyName(), companyId);
        validateCGINumber(request.cgiNumber(), companyId);
        validateAdminId(request.companyAdminId(), companyId);
    }

    private void validateCompanyName(String newCompanyName, String companyId) {
        Optional<CompanyIdentity> existing = companyIdentityRepository.findByCompanyName(newCompanyName);

        if (existing.isPresent() && !existing.get().getCompanyId().equals(companyId)) {
            logger.error("Company name already exists: {}", newCompanyName);
            throw new DuplicateDataException(messageSource.getMessage(ResponseCodes.COMPANY_NAME_ALREADY_EXIST,null,LocaleContextHolder.getLocale()));
        }
    }

    private void validateCGINumber(String newCgiNumber, String companyId) {
        Optional<CompanyIdentity> existing = companyIdentityRepository.findByCgiNumber(newCgiNumber);

        if (existing.isPresent() && !existing.get().getCompanyId().equals(companyId)) {
            logger.error("CGI number already exists: {}", newCgiNumber);
            throw new DuplicateDataException(messageSource.getMessage(ResponseCodes.CGI_NUMBER_ALREADY_EXIST,null,LocaleContextHolder.getLocale()));
        }
    }

    private void validateAdminId(String newAdminId, String companyId) {
        Optional<CompanyIdentity> existing = companyIdentityRepository.findByCompanyAdminId(newAdminId);

        if (existing.isPresent() && !existing.get().getCompanyId().equals(companyId)) {
            logger.error("Admin ID already exists: {}", newAdminId);
            throw new DuplicateDataException(messageSource.getMessage(ResponseCodes.ADMIN_ID_ALREADY_EXIST,null, LocaleContextHolder.getLocale()));
        }
    }
}

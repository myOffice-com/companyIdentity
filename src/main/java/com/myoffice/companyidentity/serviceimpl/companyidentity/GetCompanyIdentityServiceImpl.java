package com.myoffice.companyidentity.serviceimpl.companyidentity;

import com.myoffice.companyidentity.dto.GetCompanyIdentityDTO;
import com.myoffice.companyidentity.entity.CompanyIdentity;
import com.myoffice.companyidentity.exceptions.DataNotFoundException;
import com.myoffice.companyidentity.exceptions.ResponseCodes;
import com.myoffice.companyidentity.mappers.GetCompanyIdentityDTOMapper;
import com.myoffice.companyidentity.repository.CompanyIdentityRepository;
import com.myoffice.companyidentity.service.companyidentity.GetCompanyIdentityService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GetCompanyIdentityServiceImpl implements GetCompanyIdentityService {


    private final CompanyIdentityRepository companyIdentityRepository;
    private final MessageSource messageSource;

    public GetCompanyIdentityServiceImpl(CompanyIdentityRepository companyIdentityRepository, MessageSource messageSource) {
        this.companyIdentityRepository = companyIdentityRepository;
        this.messageSource = messageSource;
    }


    /**
     * Retrieves the company identity based on the provided company ID.
     *
     * @param companyId the ID of the company whose identity is to be retrieved
     * @return GetCompanyIdentityDTO containing the company identity details
     */
    @Transactional(readOnly = true)
    @Override
    public GetCompanyIdentityDTO getCompanyIdentity(String companyId) {
        return GetCompanyIdentityDTOMapper.Instance.getCompanyIdentity(validateCompanyIdentity(companyId));
    }


    private CompanyIdentity validateCompanyIdentity(String companyId){
        return companyIdentityRepository.findByCompanyId(companyId)
                .orElseThrow(() -> new DataNotFoundException(messageSource.getMessage(ResponseCodes.COMPANY_ID_NOT_FOUND,null, LocaleContextHolder.getLocale())));
    }



}

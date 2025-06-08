package com.myoffice.companyidentity.service;

import com.myoffice.companyidentity.dto.GetCompanyIdentityDTO;
import com.myoffice.companyidentity.entity.CompanyIdentity;
import com.myoffice.companyidentity.mappers.GetCompanyIdentityDTOMapper;
import com.myoffice.companyidentity.repository.CompanyIdentityRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;

public class CreateCompanyIdentityServiceImpl implements GetCompanyIdentityService{


    private final CompanyIdentityRepository companyIdentityRepository;
    private final GetCompanyIdentityDTOMapper getCompanyIdentityDTOMapper;

    public CreateCompanyIdentityServiceImpl(CompanyIdentityRepository companyIdentityRepository, GetCompanyIdentityDTOMapper getCompanyIdentityDTOMapper) {
        this.companyIdentityRepository = companyIdentityRepository;
        this.getCompanyIdentityDTOMapper = getCompanyIdentityDTOMapper;
    }

    @Transactional
    @Override
    public GetCompanyIdentityDTO getCompanyIdentity(String companyId) {
        CompanyIdentity companyIdentity = companyIdentityRepository.findById(companyId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Company identity not found for ID: " + companyId));


       return getCompanyIdentityDTOMapper.getCompanyIdentity(companyIdentity) ;
    }
}

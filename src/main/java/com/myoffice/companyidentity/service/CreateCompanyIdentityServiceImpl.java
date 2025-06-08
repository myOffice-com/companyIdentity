package com.myoffice.companyidentity.service;

import com.myoffice.companyidentity.dto.GetCompanyIdentityDTO;
import com.myoffice.companyidentity.entity.CompanyIdentity;
import com.myoffice.companyidentity.mappers.GetCompanyIdentityDTOMapper;
import com.myoffice.companyidentity.repository.CompanyIdentityRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateCompanyIdentityServiceImpl implements GetCompanyIdentityService{

    private final CompanyIdentityRepository companyIdentityRepository;
    private final GetCompanyIdentityDTOMapper getCompanyIdentityDTOMapper;

    public CreateCompanyIdentityServiceImpl(CompanyIdentityRepository companyIdentityRepository, GetCompanyIdentityDTOMapper getCompanyIdentityDTOMapper) {
        this.companyIdentityRepository = companyIdentityRepository;
        this.getCompanyIdentityDTOMapper = getCompanyIdentityDTOMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public GetCompanyIdentityDTO getCompanyIdentity(String companyId) {
        CompanyIdentity companyIdentity = getIdentity(companyId);
        return getCompanyIdentityDTOMapper.getCompanyIdentity(companyIdentity);
    }

    private CompanyIdentity getIdentity(String companyId) {
        return companyIdentityRepository.findById(companyId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Company identity not found for ID: " + companyId));
    }


}

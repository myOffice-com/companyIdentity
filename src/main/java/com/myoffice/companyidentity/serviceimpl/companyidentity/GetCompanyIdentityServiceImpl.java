package com.myoffice.companyidentity.serviceimpl.companyidentity;

import com.myoffice.companyidentity.dto.GetCompanyIdentityDTO;
import com.myoffice.companyidentity.entity.CompanyIdentity;
import com.myoffice.companyidentity.mappers.GetCompanyIdentityDTOMapper;
import com.myoffice.companyidentity.repository.CompanyIdentityRepository;
import com.myoffice.companyidentity.service.companyidentity.GetCompanyIdentityService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GetCompanyIdentityServiceImpl implements GetCompanyIdentityService {


    private final CompanyIdentityRepository companyIdentityRepository;

    public GetCompanyIdentityServiceImpl(CompanyIdentityRepository companyIdentityRepository) {
        this.companyIdentityRepository = companyIdentityRepository;
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
                .orElseThrow(() -> new EntityNotFoundException("Company identity not found for company ID: " + companyId));
    }



}

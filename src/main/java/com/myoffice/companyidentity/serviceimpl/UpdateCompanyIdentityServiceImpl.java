package com.myoffice.companyidentity.serviceimpl;


import com.myoffice.companyidentity.entity.CompanyIdentity;
import com.myoffice.companyidentity.repository.CompanyIdentityRepository;
import com.myoffice.companyidentity.request.UpdateCompanyIdentityRequest;
import com.myoffice.companyidentity.service.UpdateCompanyIdentityService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateCompanyIdentityServiceImpl implements UpdateCompanyIdentityService {

  private final CompanyIdentityRepository companyIdentityRepository;
    public UpdateCompanyIdentityServiceImpl(CompanyIdentityRepository companyIdentityRepository) {
        this.companyIdentityRepository = companyIdentityRepository;
    }
    @Transactional
    @Override
    public void updateCompanyIdentity(UpdateCompanyIdentityRequest request) {
        CompanyIdentity companyIdentity = getCompanyIdentity(request);
        mergeCompanyIdentity(companyIdentity, request);
        companyIdentityRepository.save(companyIdentity);
    }

    private CompanyIdentity getCompanyIdentity(UpdateCompanyIdentityRequest request) {
        return companyIdentityRepository.findById(request.getCompanyId())
                .orElseThrow(() ->
                        new EntityNotFoundException("Company identity not found for ID: " + request.getCompanyId())
                );
    }

    private void mergeCompanyIdentity(CompanyIdentity companyIdentity,
                                      UpdateCompanyIdentityRequest request) {
        companyIdentity.setCompanyName(request.getCompanyName());
        companyIdentity.setAddress(request.getAddress());
        companyIdentity.setCgiNumber(request.getCgiNumber());
        companyIdentity.setCompanyAdminId(request.getCompanyAdminId());
        companyIdentity.setPassword(request.getPassword());
        companyIdentity.setStartDate(request.getStartDate());
        companyIdentity.setStartTime(request.getStartTime());
        companyIdentity.setEndDate(request.getEndDate());
        companyIdentity.setEndTime(request.getEndTime());
    }

}

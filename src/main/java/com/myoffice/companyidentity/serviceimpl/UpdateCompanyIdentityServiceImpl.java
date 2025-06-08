package com.myoffice.companyidentity.serviceimpl;


import com.myoffice.companyidentity.entity.CompanyIdentity;
import com.myoffice.companyidentity.repository.CompanyIdentityRepository;
import com.myoffice.companyidentity.request.UpdateCompanyIdentityRequest;
import com.myoffice.companyidentity.service.UpdateCompanyIdentityService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


 /* Service implementation for updating and retrieving CompanyIdentity entities.**/
@Service
public class UpdateCompanyIdentityServiceImpl implements UpdateCompanyIdentityService {

  private final CompanyIdentityRepository companyIdentityRepository;
    public UpdateCompanyIdentityServiceImpl(CompanyIdentityRepository companyIdentityRepository) {
        this.companyIdentityRepository = companyIdentityRepository;
    }


     /**
      * Updates an existing CompanyIdentity entity using data from the update request.
      * <p>
      * This method loads the current entity, merges new values, and persists the changes
      * within a transactional context. Any runtime exceptions will trigger a rollback.
      * </p>
      *
      * @param request a DTO containing the updated fields and target companyId
      * @throws EntityNotFoundException if no CompanyIdentity is found for the provided ID
      */
    @Transactional
    @Override
    public void updateCompanyIdentity(UpdateCompanyIdentityRequest request) {
        CompanyIdentity companyIdentity = getCompanyIdentity(request);
        mergeCompanyIdentity(companyIdentity, request);
        companyIdentityRepository.save(companyIdentity);
    }

     /**
      * Retrieves the existing CompanyIdentity entity for the given update request.
      *
      * @param request the update request containing the companyId
      * @return the managed CompanyIdentity entity
      * @throws EntityNotFoundException if the entity does not exist in the repository
      */
    private CompanyIdentity getCompanyIdentity(UpdateCompanyIdentityRequest request) {
        return companyIdentityRepository.findById(request.getCompanyId())
                .orElseThrow(() ->
                        new EntityNotFoundException("Company identity not found for ID: " + request.getCompanyId())
                );
    }

     /**
      * Merges the fields from the update request into the existing CompanyIdentity entity.
      * <p>
      * Note: This overwrites all provided fields in the entity with values from the request.
      * Ensure the request contains all necessary data or adjust logic for partial updates.
      * </p>
      *
      * @param companyIdentity the persistent entity to be updated
      * @param request the DTO containing new field values
      */
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

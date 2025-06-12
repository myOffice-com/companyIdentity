package com.myoffice.companyidentity.serviceimpl.companyidentity;


import com.myoffice.companyidentity.entity.CompanyIdentity;
import com.myoffice.companyidentity.repository.CompanyIdentityRepository;
import com.myoffice.companyidentity.request.UpdateCompanyIdentityRequest;
import com.myoffice.companyidentity.service.companyidentity.UpdateCompanyIdentityService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/* Service implementation for updating and retrieving CompanyIdentity entities.**/
@Service
public class UpdateCompanyIdentityServiceImpl implements UpdateCompanyIdentityService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UpdateCompanyIdentityServiceImpl.class);

    private final CompanyIdentityRepository companyIdentityRepository;

    public UpdateCompanyIdentityServiceImpl(CompanyIdentityRepository companyIdentityRepository) {
        this.companyIdentityRepository = companyIdentityRepository;
    }


    /**
     * Updates an existing CompanyIdentity entity using data from the update request.
     * This method loads the current entity, merges new values, and persists the changes
     * within a transactional context. Any runtime exceptions will trigger a rollback.
     *
     * @param request a DTO containing the updated fields and target companyId
     * @throws EntityNotFoundException if no CompanyIdentity is found for the provided ID
     */
    @Transactional
    @Override
    public void updateCompanyIdentity(String companyId,UpdateCompanyIdentityRequest request) {
        CompanyIdentity companyIdentity = getCompanyIdentity(companyId);
        mergeCompanyIdentity(companyIdentity, request);
        companyIdentityRepository.save(companyIdentity);
        logger.info("Company identity updated successfully for ID: {}{}", companyId,request);
    }

    /**
     * Retrieves the existing CompanyIdentity entity for the given update request.
     *
     * @param companyId the update request containing the companyId
     * @return the managed CompanyIdentity entity
     * @throws EntityNotFoundException if the entity does not exist in the repository
     */
    private CompanyIdentity getCompanyIdentity(String companyId) {
        return companyIdentityRepository.findById(companyId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Company identity not found for ID: " + companyId)
                );
    }

    /**
     * Merges the fields from the update request into the existing CompanyIdentity entity.
     * Note: This overwrites all provided fields in the entity with values from the request.
     * Ensure the request contains all necessary data or adjust logic for partial updates.
     *
     * @param companyIdentity the persistent entity to be updated
     * @param request         the DTO containing new field values
     */
    private void mergeCompanyIdentity(CompanyIdentity companyIdentity,
                                      UpdateCompanyIdentityRequest request) {
        companyIdentity.setCompanyName(request.companyName());
        companyIdentity.setAddress(request.address());
        companyIdentity.setCgiNumber(request.cgiNumber());
        companyIdentity.setCompanyAdminId(request.companyAdminId());
        companyIdentity.setPassword(request.password());
        companyIdentity.setStartDate(request.startDate());
        companyIdentity.setStartTime(request.startTime());
        companyIdentity.setEndDate(request.endDate());
        companyIdentity.setEndTime(request.endTime());
        companyIdentity.setExpired(request.isExpired());
    }

}

package com.myoffice.companyidentity.serviceimpl;

import com.myoffice.companyidentity.entity.CompanyIdentity;
import com.myoffice.companyidentity.mappers.CreateCompanyIdentityMapper;
import com.myoffice.companyidentity.repository.CompanyIdentityRepository;
import com.myoffice.companyidentity.request.CreateCompanyIdentityRequest;
import com.myoffice.companyidentity.response.CreateCompanyIdentityResponse;
import com.myoffice.companyidentity.service.CreateCompanyIdentityService;
import com.myoffice.companyidentity.util.IdGenerator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateCompanyIdentityServiceImpl implements CreateCompanyIdentityService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CreateCompanyIdentityServiceImpl.class);

    private final CompanyIdentityRepository companyIdentityRepository;
    private final CreateCompanyIdentityMapper createCompanyIdentityMapper;
    private final IdGenerator idGenerator;

    public CreateCompanyIdentityServiceImpl(CompanyIdentityRepository companyIdentityRepository, CreateCompanyIdentityMapper createCompanyIdentityMapper, IdGenerator idGenerator) {
        this.companyIdentityRepository = companyIdentityRepository;
        this.createCompanyIdentityMapper = createCompanyIdentityMapper;
        this.idGenerator = idGenerator;
    }

    /**
     * This method is used to create a company identity.
     * It takes a CreateCompanyIdentityRequest object as input and returns a CreateCompanyIdentityResponse object.
     * Currently, it returns null as the implementation is not provided.
     *
     * @param request The request object containing the details for creating a company identity.
     * @return A response object indicating the result of the creation operation.
     */
    @Transactional
    @Override
    public CreateCompanyIdentityResponse createCompanyIdentity(CreateCompanyIdentityRequest request) {
        logger.info("Creating company identity with request: {}", request);
        CompanyIdentity companyIdentity = createCompanyIdentityMapper.createCompanyIdentityRequestToEntity(request);
        companyIdentity.setCompanyId(idGenerator.generateId(10));
        return createCompanyIdentityMapper.companyIdentityToCreateCompanyIdentityResponse(companyIdentityRepository.save(companyIdentity));
    }



}

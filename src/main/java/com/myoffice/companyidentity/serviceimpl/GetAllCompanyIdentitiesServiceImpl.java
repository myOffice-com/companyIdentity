package com.myoffice.companyidentity.serviceimpl;

import com.myoffice.companyidentity.dto.GetCompanyIdentitiesList;
import com.myoffice.companyidentity.entity.CompanyIdentity;
import com.myoffice.companyidentity.mappers.GetAllCompanyIdentitiesMapper;
import com.myoffice.companyidentity.repository.CompanyIdentityRepository;
import com.myoffice.companyidentity.service.GetAllCompanyIdentitiesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllCompanyIdentitiesServiceImpl implements GetAllCompanyIdentitiesService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(GetAllCompanyIdentitiesServiceImpl.class);

    private static final String ALL_COMPANY_IDENTITIES = "all";

    private static final String ALL_ACTIVE_COMPANY_IDENTITIES = "active";

    private static final String ALL_INACTIVE_COMPANY_IDENTITIES = "inactive";

    private final CompanyIdentityRepository companyIdentityRepository;
    private final GetAllCompanyIdentitiesMapper getAllCompanyIdentitiesMapper;

    public GetAllCompanyIdentitiesServiceImpl(CompanyIdentityRepository companyIdentityRepository, GetAllCompanyIdentitiesMapper getAllCompanyIdentitiesMapper) {
        this.companyIdentityRepository = companyIdentityRepository;
        this.getAllCompanyIdentitiesMapper = getAllCompanyIdentitiesMapper;
    }

    /**
     * This method is used to get all company identities.
     * Currently, it returns null as the implementation is not provided.
     *
     * @return A response object containing all company identities.
     */
    @Transactional(readOnly = true)
    @Override
    public List<GetCompanyIdentitiesList> getAllCompanyIdentities(String filterKey) {
        logger.info("Fetching company identities with filter: {}", filterKey);

        List<CompanyIdentity> companyIdentities = switch (filterKey.toLowerCase()) {
            case ALL_COMPANY_IDENTITIES -> companyIdentityRepository.findAll();
            case ALL_ACTIVE_COMPANY_IDENTITIES -> companyIdentityRepository.findByIsExpired(false);
            case ALL_INACTIVE_COMPANY_IDENTITIES -> companyIdentityRepository.findByIsExpired(true);
            default -> {
                logger.error("Invalid filter key provided: {}", filterKey);
                throw new IllegalArgumentException("Invalid filter key provided: " + filterKey);
            }
        };

        if (companyIdentities.isEmpty()) {
            logger.info("No company identities found for filter: {}", filterKey);
            return new ArrayList<>();
        }

        return getAllCompanyIdentitiesMapper.companyIdentitiesToGetCompanyIdentitiesList(companyIdentities);
    }

}

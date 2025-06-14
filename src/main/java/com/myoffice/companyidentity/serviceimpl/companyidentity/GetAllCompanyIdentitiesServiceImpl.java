package com.myoffice.companyidentity.serviceimpl.companyidentity;

import com.myoffice.companyidentity.dto.GetCompanyIdentitiesDTO;
import com.myoffice.companyidentity.entity.CompanyIdentity;
import com.myoffice.companyidentity.exceptions.DuplicateDataException;
import com.myoffice.companyidentity.exceptions.ResponseCodes;
import com.myoffice.companyidentity.mappers.GetAllCompanyIdentitiesMapper;
import com.myoffice.companyidentity.repository.CompanyIdentityRepository;
import com.myoffice.companyidentity.service.companyidentity.GetAllCompanyIdentitiesService;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllCompanyIdentitiesServiceImpl implements GetAllCompanyIdentitiesService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(GetAllCompanyIdentitiesServiceImpl.class);

    private final MessageSource messageSource;

    private static final String ALL_COMPANY_IDENTITIES = "all";

    private static final String ALL_ACTIVE_COMPANY_IDENTITIES = "active";

    private static final String ALL_INACTIVE_COMPANY_IDENTITIES = "inactive";

    private final CompanyIdentityRepository companyIdentityRepository;

    public GetAllCompanyIdentitiesServiceImpl(MessageSource messageSource, CompanyIdentityRepository companyIdentityRepository) {
        this.messageSource = messageSource;
        this.companyIdentityRepository = companyIdentityRepository;
    }

    /**
     * This method is used to get all company identities.
     * Currently, it returns null as the implementation is not provided.
     *
     * @return A response object containing all company identities.
     */
    @Transactional(readOnly = true)
    @Override
    public List<GetCompanyIdentitiesDTO> getAllCompanyIdentities(String filterKey) {
        logger.info("Fetching company identities with filter: {}", filterKey);

        List<CompanyIdentity> companyIdentities = switch (filterKey.toLowerCase()) {
            case ALL_COMPANY_IDENTITIES -> companyIdentityRepository.findAll();
            case ALL_ACTIVE_COMPANY_IDENTITIES -> companyIdentityRepository.findByIsExpired(false);
            case ALL_INACTIVE_COMPANY_IDENTITIES -> companyIdentityRepository.findByIsExpired(true);
            default -> {
                logger.error("Invalid filter key provided: {}", filterKey);
                throw new DuplicateDataException(messageSource.getMessage(ResponseCodes.INVALID_FILTER_KEY_PROVIDED,null, LocaleContextHolder.getLocale()));
            }
        };

        if (companyIdentities.isEmpty()) {
            logger.info("No company identities found for filter: {}", filterKey);
            return new ArrayList<>();
        }

        return GetAllCompanyIdentitiesMapper.INSTANCE.companyIdentitiesToGetCompanyIdentitiesDTOList(companyIdentities);
    }

}

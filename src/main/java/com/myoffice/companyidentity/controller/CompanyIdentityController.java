package com.myoffice.companyidentity.controller;

    import com.myoffice.companyidentity.dto.GetCompanyIdentitiesDTO;
    import com.myoffice.companyidentity.dto.GetCompanyIdentityDTO;
    import com.myoffice.companyidentity.request.CreateCompanyIdentityRequest;
    import com.myoffice.companyidentity.request.UpdateCompanyIdentityRequest;
    import com.myoffice.companyidentity.response.CreateCompanyIdentityResponse;
    import com.myoffice.companyidentity.service.companyidentity.CreateCompanyIdentityService;
    import com.myoffice.companyidentity.service.companyidentity.GetAllCompanyIdentitiesService;
    import com.myoffice.companyidentity.service.companyidentity.GetCompanyIdentityService;
    import com.myoffice.companyidentity.service.companyidentity.UpdateCompanyIdentityService;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.HttpStatusCode;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    /**
     * REST controller for managing company identities.
     * Provides endpoints for creating, updating, and retrieving company identity data.
     */
    @RestController
    @RequestMapping("/api/v1/company-identity")
    public class CompanyIdentityController {

        private static final Logger logger = LoggerFactory.getLogger(CompanyIdentityController.class);

        private final CreateCompanyIdentityService createCompanyIdentityService;
        private final GetAllCompanyIdentitiesService getAllCompanyIdentitiesService;
        private final GetCompanyIdentityService getCompanyIdentityService;
        private final UpdateCompanyIdentityService updateCompanyIdentityService;

        /**
         * Constructor for injecting required services.
         *
         * @param createCompanyIdentityService Service for creating company identities.
         * @param getAllCompanyIdentitiesService Service for retrieving all company identities.
         * @param getCompanyIdentityService Service for retrieving a specific company identity.
         * @param updateCompanyIdentityService Service for updating company identities.
         */
        public CompanyIdentityController(CreateCompanyIdentityService createCompanyIdentityService,
                                         GetAllCompanyIdentitiesService getAllCompanyIdentitiesService,
                                         GetCompanyIdentityService getCompanyIdentityService,
                                         UpdateCompanyIdentityService updateCompanyIdentityService) {
            this.createCompanyIdentityService = createCompanyIdentityService;
            this.getAllCompanyIdentitiesService = getAllCompanyIdentitiesService;
            this.getCompanyIdentityService = getCompanyIdentityService;
            this.updateCompanyIdentityService = updateCompanyIdentityService;
        }

        /**
         * Endpoint to create a new company identity.
         *
         * @param request The request containing company identity details.
         * @return ResponseEntity with the created company identity and HTTP status.
         */
        @PostMapping("/create")
        public ResponseEntity<CreateCompanyIdentityResponse> createCompanyIdentity(@RequestBody CreateCompanyIdentityRequest request) {
            logger.info("Received request to create company identity: {}", request);
            CreateCompanyIdentityResponse response = createCompanyIdentityService.createCompanyIdentity(request);
            logger.info("Successfully created company identity with ID: {}", response.companyId());
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }

        /**
         * Endpoint to update an existing company identity.
         *
         * @param request The request containing updated company identity details.
         * @return ResponseEntity with HTTP status.
         */
        @PatchMapping("/update/{companyId}")
        public ResponseEntity<Object> updateCompanyIdentity(@PathVariable String companyId,
                                                            @RequestBody UpdateCompanyIdentityRequest request) {
            logger.info("Received request to update company identity with ID: {}", companyId);
            updateCompanyIdentityService.updateCompanyIdentity(companyId,request);
            logger.info("Successfully updated company identity with ID: {}", companyId);
            return new ResponseEntity<>(HttpStatusCode.valueOf(204));
        }

        /**
         * Endpoint to retrieve a list of company identities based on a filter key.
         *
         * @param filterKey The filter key to search for company identities.
         * @return ResponseEntity with the list of company identities and HTTP status.
         */
        @GetMapping("/{filterKey}")
        public ResponseEntity<List<GetCompanyIdentitiesDTO>> getCompanyIdentities(@PathVariable String filterKey) {
            logger.info("Received request to retrieve company identities with filter key: {}", filterKey);
            List<GetCompanyIdentitiesDTO> companyIdentities = getAllCompanyIdentitiesService.getAllCompanyIdentities(filterKey);
            logger.info("Successfully retrieved {} company identities for filter key: {}", companyIdentities.size(), filterKey);
            return ResponseEntity.ok(companyIdentities);
        }

        /**
         * Endpoint to retrieve a specific company identity by its ID.
         *
         * @param companyId The ID of the company identity to retrieve.
         * @return ResponseEntity with the company identity details and HTTP status.
         */
        @GetMapping("/{companyId}")
        public ResponseEntity<GetCompanyIdentityDTO> getCompanyIdentity(@PathVariable String companyId) {
            logger.info("Received request to retrieve company identity with ID: {}", companyId);
            GetCompanyIdentityDTO companyIdentity = getCompanyIdentityService.getCompanyIdentity(companyId);
            logger.info("Successfully retrieved company identity with ID: {}", companyId);
            return ResponseEntity.ok(companyIdentity);
        }
    }
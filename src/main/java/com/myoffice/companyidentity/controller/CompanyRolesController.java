package com.myoffice.companyidentity.controller;

import com.myoffice.companyidentity.dto.GetCompanyRolesDTO;
import com.myoffice.companyidentity.request.CreateCompanyRolesRequest;
import com.myoffice.companyidentity.response.CreateCompanyRolesResponse;
import com.myoffice.companyidentity.service.roles.CreateCompanyRolesService;
import com.myoffice.companyidentity.service.roles.GetCompanyRolesService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/company-roles")
public class CompanyRolesController {


    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(CompanyRolesController.class);


    private final CreateCompanyRolesService createCompanyRolesService;
    private final GetCompanyRolesService getCompanyRolesService;


    public CompanyRolesController(CreateCompanyRolesService createCompanyRolesService, GetCompanyRolesService getCompanyRolesService) {
        this.createCompanyRolesService = createCompanyRolesService;
        this.getCompanyRolesService = getCompanyRolesService;
    }

    /**
     * Endpoint to create roles for a company.
     *
     * @param createCompanyRolesRequest the request containing the details for creating company roles
     * @return ResponseEntity with status CREATED
     */
    @PostMapping("/company-roles")
    public ResponseEntity<CreateCompanyRolesResponse> createCompanyRoles(@Valid @RequestBody CreateCompanyRolesRequest createCompanyRolesRequest){
        logger.info("Received request to create company roles for companyId={}", createCompanyRolesRequest);
        createCompanyRolesService.createCompanyRoles(createCompanyRolesRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Endpoint to retrieve roles for a company.
     *
     * @param companyId the ID of the company whose roles are to be retrieved
     * @return ResponseEntity with GetCompanyRolesDTO containing the roles of the company
     */
    @GetMapping("/company-roles")
    public ResponseEntity<GetCompanyRolesDTO> getCompanyRoles(@RequestParam String companyId){
        logger.info("Received request to get company roles for companyId={}", companyId);
        GetCompanyRolesDTO companyRoles = getCompanyRolesService.getCompanyRoles(companyId);
        return new ResponseEntity<>(companyRoles, HttpStatus.OK);
    }

}

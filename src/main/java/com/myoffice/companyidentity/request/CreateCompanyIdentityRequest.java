package com.myoffice.companyidentity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCompanyIdentityRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1961706458556934210L;

    /**
     * Name of the company.
     */
    private String companyName;

    /**
     * Address of the company.
     */
    private String address;

    /**
     * CGI (Corporate Group Identifier) number of the company.
     */
    private String cgiNumber;

    /**
     * Identifier for the company administrator.
     */
    private String companyAdminId;

    /**
     * Password associated with the company account.
     */
    private String password;

    /**
     * Start date of the company's operations.
     */
    private LocalDate startDate;

    /**
     * Start time of the company's operations.
     */
    private String startTime;

    /**
     * End date of the company's operations.
     */
    private LocalDate endDate;

    /**
     * End time of the company's operations.
     */
    private String endTime;

}

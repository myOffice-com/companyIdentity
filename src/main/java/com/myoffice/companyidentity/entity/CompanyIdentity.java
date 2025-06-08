package com.myoffice.companyidentity.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Entity class representing the `company_identity` table in the database.
 * This class is used to store and retrieve company identity information.
 */
@Data
@Entity
@Table(name = "company_identity")
public class CompanyIdentity implements Serializable {

    @Serial
    private static final long serialVersionUID = -3363652379348521539L;

    /**
     * Unique identifier for the company.
     */
    @Id
    @Column(name = "company_id")
    private String companyId;

    /**
     * Name of the company.
     */
    @Column(name = "company_name", nullable = false, unique = true)
    private String companyName;

    /**
     * Address of the company.
     */
    @Column(name = "address", nullable = false)
    private String address;

    /**
     * CGI (Corporate Group Identifier) number of the company.
     */
    @Column(name = "cgi_number", nullable = false, unique = true)
    private String cgiNumber;

    /**
     * Identifier for the company administrator.
     */
    @Column(name = "company_admin_id", nullable = false, unique = true)
    private String companyAdminId;

    /**
     * Password associated with the company account.
     */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * Start date of the company's operations.
     */
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    /**
     * Start time of the company's operations.
     */
    @Column(name = "start_time", nullable = false)
    private String startTime;

    /**
     * End date of the company's operations.
     */
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    /**
     * End time of the company's operations.
     */
    @Column(name = "end_time", nullable = false)
    private String endTime;

    /**
     * Indicates whether the company identity is expired.
     */
    @Column(name = "is_expired", nullable = false)
    private boolean isExpired;
}
package com.myoffice.companyidentity.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;


/*
 * Entity class representing the `company_roles` table in the database.
 * This class is used to store and retrieve company roles information.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company_roles")
public class CompanyRoles implements Serializable {

    @Serial
    private static final long serialVersionUID = 1537872061852527184L;

    /**
     * Unique identifier for the role.
     */
    @Id
    @Column(name = "role_id")
    private long roleId;

    /**
     * Identifier for the company to which the role belongs.
     */
    @Column(name = "company_id", nullable = false)
    private String companyId;

    /**
     * Name of the role.
     */
    @Column(name = "role_name", nullable = false)
    private String roleName;
}

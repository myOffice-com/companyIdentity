package com.myoffice.companyidentity.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;


/*
 * Entity class representing the `company_roles` table in the database.
 * This class is used to store and retrieve company roles information.
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuppressWarnings("LombokGetterMayBeUsed,LombokSetterMayBeUsed")
@Table(name = "company_roles")
public class CompanyRoles implements Serializable {

    @Serial
    private static final long serialVersionUID = 1537872061852527184L;

    /**
     * Unique identifier for the role.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

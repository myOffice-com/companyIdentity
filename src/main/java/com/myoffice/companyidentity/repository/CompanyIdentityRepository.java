package com.myoffice.companyidentity.repository;

import com.myoffice.companyidentity.entity.CompanyIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyIdentityRepository extends JpaRepository<CompanyIdentity, String> {

    /**
     * Finds a CompanyIdentity by its company ID.
     *
     * @param companyId the ID of the company
     * @return the CompanyIdentity associated with the given company ID, or null if not found
     */
    Optional<CompanyIdentity> findByCompanyId(String companyId);


    List<CompanyIdentity> findByIsExpired(boolean b);
}

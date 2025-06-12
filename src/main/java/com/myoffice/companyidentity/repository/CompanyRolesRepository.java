package com.myoffice.companyidentity.repository;

import com.myoffice.companyidentity.entity.CompanyRoles;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRolesRepository extends JpaRepository<CompanyRoles,Long> {
 
    void deleteByCompanyId(String companyId);

    List<CompanyRoles> findAllByCompanyId(String companyId);


}

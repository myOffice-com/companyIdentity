package com.myoffice.companyidentity.repository;

import com.myoffice.companyidentity.entity.CompanyRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRolesRepository extends JpaRepository<CompanyRoles,Long> {

    List<CompanyRoles> findAllByCompanyId(String companyId);

}

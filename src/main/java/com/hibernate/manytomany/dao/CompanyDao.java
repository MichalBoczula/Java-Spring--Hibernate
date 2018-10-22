package com.hibernate.manytomany.dao;

import com.hibernate.manytomany.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Long> {

    @Query(nativeQuery = true)
    List<Company> retrieveCompanyNameWithFirstThreeCharacters(@Param("COMPANY_NAME") String companyName);
}

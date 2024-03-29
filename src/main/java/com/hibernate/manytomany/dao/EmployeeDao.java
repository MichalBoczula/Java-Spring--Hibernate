package com.hibernate.manytomany.dao;

import com.hibernate.manytomany.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface EmployeeDao extends CrudRepository<Employee, Long> {

    @Query
    List<Employee> retrieveEmployeeWithThisLastName(@Param("LAST_NAME") String lastName);
}

package com.hibernate.manytomany.dao.facade;

import com.hibernate.manytomany.Company;
import com.hibernate.manytomany.Employee;
import com.hibernate.manytomany.dao.CompanyDao;
import com.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoFacade {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> findByEmployeeLastName(String lastName){
        return employeeDao.retrieveEmployeeWithThisLastName(lastName);
    }

    public List<Company> findByCompanyShortName(String companyName){
        return companyDao.retrieveCompanyNameWithFirstThreeCharacters(companyName);
    }

}

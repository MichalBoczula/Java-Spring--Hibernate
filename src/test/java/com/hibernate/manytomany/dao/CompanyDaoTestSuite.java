package com.hibernate.manytomany.dao;

import com.hibernate.manytomany.Company;
import com.hibernate.manytomany.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        long softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        long dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        long greyMatterId = greyMatter.getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaestersId);
        assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.delete(softwareMachineId);
            companyDao.delete(dataMaestersId);
            companyDao.delete(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testRetrieveEmployeeWithThisLastName(){
        //Given
        final Employee employee1 = new Employee("Adam", "Nowak");
        final Employee employee2 = new Employee("Antoni", "Nowak");
        final Employee employee3 = new Employee("Piotr", "Kowalski");
        final Employee employee4 = new Employee("Mariusz", "Kowal");
        employeeDao.save(employee1);
        employeeDao.save(employee2);
        employeeDao.save(employee3);
        employeeDao.save(employee4);

        //When
        final List<Employee> testList = employeeDao.retrieveEmployeeWithThisLastName("Nowak");

        //Then
        assertEquals(2, testList.size());

        //CleanUp
        employeeDao.delete(employee1.getId());
        employeeDao.delete(employee2.getId());
        employeeDao.delete(employee3.getId());
        employeeDao.delete(employee4.getId());
    }

    @Test
    public void testRetrieveCompanyNameWithFirstThreeCharacters(){
        //Given
        final Company softwareMachine = new Company("Software Machine");
        final Company dataMasters = new Company("Data Masters");
        final Company greyMatter = new Company("Grey Matter");
        final Company softwareDataHouse = new Company("Software Data House");

        companyDao.save(softwareMachine);
        companyDao.save(dataMasters);
        companyDao.save(greyMatter);
        companyDao.save(softwareDataHouse);

        //When
        final List<Company> testList = companyDao.retrieveCompanyNameWithFirstThreeCharacters("sof");

        //Then
        assertEquals(2, testList.size());
        assertEquals(4, companyDao.count());

        //CleanUp
        companyDao.delete(softwareDataHouse.getId());
        companyDao.delete(softwareMachine.getId());
        companyDao.delete(greyMatter.getId());
        companyDao.delete(dataMasters.getId());

    }
}

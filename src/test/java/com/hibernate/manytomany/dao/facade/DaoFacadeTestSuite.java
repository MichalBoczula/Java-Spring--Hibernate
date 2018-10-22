package com.hibernate.manytomany.dao.facade;

import com.hibernate.manytomany.Company;
import com.hibernate.manytomany.Employee;
import com.hibernate.manytomany.dao.CompanyDao;
import com.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DaoFacadeTestSuite {
    @Autowired
    private DaoFacade daoFacade;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private CompanyDao companyDao;

    @Test
    public void findByEmployeeLastName() {
        //given
        final Employee adamKowalski = new Employee("Adam", "Kowalski");
        final Employee piotrNowak = new Employee("piotr", "Nowak");
        final Employee adamNowak = new Employee("adam", "Nowak");
        List<Employee> employeeArrayTest = new ArrayList<>();
        employeeArrayTest.add(piotrNowak);
        employeeArrayTest.add(adamNowak);
        employeeDao.save(adamKowalski);
        employeeDao.save(piotrNowak);
        employeeDao.save(adamNowak);
        //when
        final List<Employee> employeeListFirst = daoFacade.findByEmployeeLastName("Nowak");
        final List<Employee> employeeListSecond = daoFacade.findByEmployeeLastName("Kowalski");
        //then
        assertEquals(2, employeeListFirst.size());
        assertEquals(1, employeeListSecond.size());
        //cleanUp
        employeeDao.delete(adamKowalski.getId());
        employeeDao.delete(piotrNowak.getId());
        employeeDao.delete(adamNowak.getId());
    }

    @Test
    public void findByCompanyName() {
        //given
        final Company mazBud = new Company("MazBud");
        final Company crystalia = new Company("Crystalia");
        companyDao.save(mazBud);
        companyDao.save(crystalia);
        //when
        final List<Company> companyListFirst = daoFacade.findByCompanyShortName("Maz");
        final List<Company> companyListSecond = daoFacade.findByCompanyShortName("Cry");
        //then
        assertEquals(1, companyListFirst.size());
        assertEquals(1, companyListSecond.size());
        assertEquals(mazBud.getId(), companyListFirst.get(0).getId());
        assertEquals(crystalia.getId(), companyListSecond.get(0).getId());
        //cleanUp
        companyDao.delete(mazBud.getId());
        companyDao.delete(crystalia.getId());
    }
}
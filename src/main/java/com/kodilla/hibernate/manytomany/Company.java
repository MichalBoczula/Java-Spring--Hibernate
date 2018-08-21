package com.kodilla.hibernate.manytomany;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedQuery(
        name = "Company.retrieve",
        query = "FROM Company WHERE company_name = :COMPANY_NAME"
)

@NamedNativeQuery(
        name = "Company.retrieveNative",
        query = "SELECT * FROM companies WHERE company_name = :COMPANY_NAME",
        resultClass = Company.class
)

//@NamedNativeQuery(
//        name = "Company.retrieveTasksWithThisDuration",
//        query = "SELECT * FROM companies WHERE SUBSTRING (description, 1, 3) = :"
//)

@Entity
@Table(name = "companies")
public class Company {
    private int id;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "company_id", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "company_name")
    public String getName() {
        return name;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    public List<Employee> getEmployees() {
        return employees;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
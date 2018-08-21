package com.kodilla.hibernate.manytomany;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedNativeQuery(
        name = "Company.retrieveCompanyNameWithFirstThreeCharacters",
        query = "SELECT * FROM companies WHERE LEFT (company_name, 3) = :COMPANY_NAME",
        resultClass = Company.class
)

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "company_id", unique = true)
    private long id;

    @NotNull
    @Column(name = "company_name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    private List<Employee> employees = new ArrayList<>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
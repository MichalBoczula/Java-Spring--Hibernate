//package com.kodilla.hibernate.manytomany;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name = "employees")
//public class Employee {
//    private int id;
//    private String firstName;
//    private String lastName;
//    private List<Company> companies = new ArrayList<>();
//
//    public Employee() {
//    }
//
//    public Employee(String firstName, String lastName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }
//
//    @Id
//    @GeneratedValue
//    @NotNull
//    @Column(name = "employee_id", unique = true)
//    public int getId() {
//        return id;
//    }
//
//    @NotNull
//    @Column(name = "first_name")
//    public String getFirstName() {
//        return firstName;
//    }
//
//    @NotNull
//    @Column(name = "last_name")
//    public String getLastName() {
//        return lastName;
//    }
//
////    @ManyToMany(cascade = CascadeType.ALL)
////    @JoinTable(
////            name = "join_company_employee",
////            joinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "employee_id")},
////            inverseJoinColumns = {@JoinColumn(name = "company_id", referencedColumnName = "company_id")}
////    )
////    public List<Company> getCompanies() {
////        return companies;
////    }
//
//    private void setId(int id) {
//        this.id = id;
//    }
//
//    private void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    private void setCompanies(List<Company> companies) {
//        this.companies = companies;
//    }
//
//    private void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//}

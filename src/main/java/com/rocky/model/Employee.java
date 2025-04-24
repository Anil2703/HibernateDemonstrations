package com.rocky.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private double salary;

    @Column(name = "phoneNum")
    private String phoneNum;

    @Column(name = "dateOfBirth")
    private Date dateOfBirth;


    //To save Address directly into as Columns of Employee Class, use @Embedded here on field and use @Embeddable on top of Class Address
    //Initialize this field, Add getters, setters and use it

    //******************* If we want to use Address as PrimaryKey in class Employee, then use @EmbeddedId on top of field in class Employee and
    //@Embeddable on class Address as usual*******************
    //Addition:: @AttributeOverrides can be used for PrimaryKeys also if required in different classes.

    //@Embedded
    //private Address address;

    //Below implementation for using address as both homeAddress and officeAddress
    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "streetName", column = @Column(name = "home_Streetname")),
                        @AttributeOverride(name = "landMark", column = @Column(name = "home_landMark")),
                        @AttributeOverride(name = "cityName", column = @Column(name = "home_cityName")),
                        @AttributeOverride(name = "state", column = @Column(name = "home_state")),
                        @AttributeOverride(name = "pinCode", column = @Column(name = "home_pinCode"))})
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "streetName", column = @Column(name = "office_Streetname")),
            @AttributeOverride(name = "landMark", column = @Column(name = "office_landMark")),
            @AttributeOverride(name = "cityName", column = @Column(name = "office_cityName")),
            @AttributeOverride(name = "state", column = @Column(name = "office_state")),
            @AttributeOverride(name = "pinCode", column = @Column(name = "office_pinCode"))})
    private Address officeAddress;


    public Employee(String name, double salary, String phoneNum, Date dateOfBirth) {
        this.name = name;
        this.salary = salary;
        this.phoneNum = phoneNum;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
    }
}
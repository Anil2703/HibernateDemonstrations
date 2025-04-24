package com.rocky.model;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

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

    //Use below to save a listofaddresses as collection inside Employee class,
    //The way it would be saved is it creates a seperate Table for Employee and an other table Employee_listOfAddresses
    //it uses PK of class Employee and maps it as FK in Employee_listOfAddresses, which creates the Relation b/w these two tables.
    //No need to use Entity on Top of Class Address
    //******** TO Add more Tweaks like naming the above table Employee_listOfAddresses, Use @JoinTable Annotation alongside @ElementCollection
    // and configure its Table Name as per you.
    //@JoinTable(name = "TableName", joinColumns=@JoinColumn(name = ""))  , @JoinColumn for FK


    //Use below to generate a PK inside the Table Employee_listOfAddresses or our JoinTable
    //@GenericGenerator(name = "hilo-gen", strategy = "hilo")
    //@CollectionId(columns = {@Column(name = "addressId")}, generator = "hilo-gen", type = @Type(type = "long"))


    //@ElementCollection
    //private Set<Address> listOfAddresses;

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
package com.rocky.model;

import javax.persistence.*;

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

    public Employee() {}

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getters and Setters
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return this. id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this. name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return this. salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
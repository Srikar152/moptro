package com.example.myapplication;

import java.util.Date;

public class Employee {
private String id;
private String name;
private String dob;
private String role;
public Employee(String id,String name,String dob,String role){
    this.id=id;
    this.name=name;
    this.dob=dob;
    this.role=role;
}
    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String dob() {
        return dob;
    }

    public String Role() {
        return role;
    }
}


package com.yadu.example.demo.entity;

import java.util.Date;

public class Employee {
    private String employeecode;

    private String email;

    private String phone;

    private String name;

    private String addresss;

    private Date birthday;

    public Employee(String employeecode, String email, String phone, String name, String addresss, Date birthday) {
        this.employeecode = employeecode;
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.addresss = addresss;
        this.birthday = birthday;
    }

    public Employee() {
        super();
    }

    public String getEmployeecode() {
        return employeecode;
    }

    public void setEmployeecode(String employeecode) {
        this.employeecode = employeecode == null ? null : employeecode.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddresss() {
        return addresss;
    }

    public void setAddresss(String addresss) {
        this.addresss = addresss == null ? null : addresss.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
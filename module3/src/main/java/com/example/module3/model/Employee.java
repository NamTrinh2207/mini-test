package com.example.module3.model;

public class Employee {
    private int id;
    private String name;
    private String address;
    private String phone;
    private long salary;
    private Department department;

    public Employee() {
    }

    public Employee(int id, String name, String address, String phone, long salary, Department department) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.salary = salary;
        this.department = department;
    }

    public Employee(String name, String address, String phone, long salary, Department department) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.salary = salary;
        this.department = department;
    }

    public Employee(int id, String name, String address, String phone, long salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.salary = salary;
    }

    public Employee(String name, String address, String phone, long salary) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.salary = salary;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

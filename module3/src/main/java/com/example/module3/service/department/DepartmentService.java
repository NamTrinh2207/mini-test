package com.example.module3.service.department;

import com.example.module3.model.Department;

import java.util.List;

public interface DepartmentService {


    List<Department> findAll();

    Department findById(int id);

}
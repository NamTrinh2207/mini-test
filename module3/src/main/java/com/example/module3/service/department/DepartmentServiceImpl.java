package com.example.module3.service.department;

import com.example.module3.connection.CreateDatabase;
import com.example.module3.model.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    private static final String SELECT_ALL = "select * from department;";
    private static final String SELECT_DEPARTMENT = "select * from department where id = ?;";
    private static final Connection connection;

    static {
        try {
            connection = CreateDatabase.getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Department> findAll() {
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
                List<Department> departmentList = new ArrayList<>();
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String departmentName = rs.getString("department");
                    Department department = new Department(id, departmentName);
                    departmentList.add(department);
                }
                return departmentList;
            } catch (SQLException e) {
                System.out.println("Query Error");
            }
        }
        return null;
    }

    @Override
    public Department findById(int id) {
        if (connection != null) {
            try {
                PreparedStatement p = connection.prepareStatement(SELECT_DEPARTMENT);
                p.setInt(1, id);
                ResultSet rs = p.executeQuery();
                if (rs.next()) {
                    String department = rs.getString("department");
                    return new Department(id, department);
                }
            } catch (SQLException e) {
                System.out.println("Query Error");
            }
        }
        return null;
    }
}
package com.example.module3.service.employee;

import com.example.module3.connection.CreateDatabase;
import com.example.module3.model.Department;
import com.example.module3.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService implements IEmployeeService {
    private final Connection connection;

    {
        try {
            connection = CreateDatabase.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static final String INSERT_EMPLOYEE = "INSERT INTO employee (name,address,phone, salary) VALUES (?,?,?,?);";
    private static final String SELECT_EMPLOYEE_BY_ID = "select * from employee where id =?";
    private static final String SELECT_ALL_EMPLOYEES = "select * from employee";
    private static final String DELETE_EMPLOYEE = "delete from employee where id = ?;";
    private static final String UPDATE_EMPLOYEE = "update employee set name = ?,address = ?,phone = ?, salary = ? where id = ?;";

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String address = resultSet.getString("address");
                    String phone = resultSet.getString("phone");
                    long salary = resultSet.getLong("salary");
                    int id_department = resultSet.getInt("id");
                    String department = resultSet.getString("department");
                    Department department1 = new Department(id_department, department);
                    employees.add(new Employee(id, name, address, phone, salary, department1));
                }
                return employees;
            } catch (Exception e) {
                System.out.println("Query error");
            }
        }
        return null;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = null;
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String address = resultSet.getString("address");
                    String phone = resultSet.getString("phone");
                    long salary = resultSet.getLong("salary");
                    employee = new Employee(id, name, address, phone, salary);
                }
                return employee;
            } catch (SQLException e) {
                System.out.println("Query error");
            }
        }
        return null;
    }

    @Override
    public void update(int id, Employee employee) throws SQLException {
        if (connection != null) {
            try {
                PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE);
                statement.setString(1, employee.getName());
                statement.setString(2, employee.getAddress());
                statement.setString(3, employee.getPhone());
                statement.setLong(4, employee.getSalary());
                statement.setInt(5, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Query error");
            }
        }
    }

    @Override
    public void delete(int id) {
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
                preparedStatement.setLong(1, id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Query error");
            }
        }
    }

    @Override
    public void save(Employee employee) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getAddress());
            preparedStatement.setString(3, employee.getPhone());
            preparedStatement.setLong(4, employee.getSalary());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Query error");
        }
    }
}
package com.example.module3.service.employee;

import com.example.module3.connection.CreateDatabase;
import com.example.module3.model.Department;
import com.example.module3.model.Employee;
import com.example.module3.service.department.DepartmentServiceImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService implements IEmployeeService {
    private final Connection connection;
    private final DepartmentServiceImpl departmentService = new DepartmentServiceImpl();

    {
        try {
            connection = CreateDatabase.getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static final String INSERT_EMPLOYEE = "insert into employee(name, address, phone, salary, id_department) values (?,?,?,?,?);";
    private static final String SELECT_EMPLOYEE_BY_ID = "select * from employee where id =?";
    private static final String SELECT_ALL_EMPLOYEES = "select * from employee join department d on d.id = employee.id_department;";
    private static final String DELETE_EMPLOYEE = "delete from employee where id = ?;";
    private static final String UPDATE_EMPLOYEE = "UPDATE employee, department SET name = ?, address = ?, phone = ? , salary = ? , department = ? where employee.id_department = ?;";

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
                    String department = resultSet.getString("department");
                    Department department1 = new Department(department);
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
                statement.setString(5, employee.getDepartment().getDepartment());
                statement.setObject(6, id);
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
            preparedStatement.setObject(5, employee.getDepartment().getDepartment());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Query error");
        }
    }
}
package com.example.module3.controller;

import com.example.module3.model.Employee;
import com.example.module3.service.employee.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/employees")
public class EmployeeServlet extends HttpServlet {
    EmployeeService iEcommerce;

    @Override
    public void init() {
        iEcommerce = new EmployeeService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createForm(request, response);
                break;
            case "edit":
                editForm(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
            case "view":
                view(request, response);
                break;
            default:
                listEmployee(request, response);
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Employee> employees = iEcommerce.findAll();
            request.setAttribute("employees", employees);
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void view(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Employee employee = iEcommerce.findById(id);
            request.setAttribute("employee", employee);
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee/views.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Employee employee = iEcommerce.findById(id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee/update.jsp");
            request.setAttribute("employee", employee);
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    createEmployee(request, response);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "edit":
                try {
                    editEmployee(request, response);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                break;
            default:
                listEmployee(request, response);
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            iEcommerce.delete(id);
            response.sendRedirect("http://localhost:8080/employees");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            long salary = Long.parseLong(request.getParameter("salary"));
            Employee employee = new Employee(id, name, address, phone, salary);
            iEcommerce.update(id, employee);
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee/update.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        try {
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            long salary = Long.parseLong(request.getParameter("salary"));
            Employee employee = new Employee(name, address, phone, salary);
            iEcommerce.save(employee);
            request.getRequestDispatcher("employee/create.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
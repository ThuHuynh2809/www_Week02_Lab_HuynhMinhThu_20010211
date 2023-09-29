package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.frontend.model;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.models.Employee;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.services.EmployeeServices;

import java.time.LocalDate;

public class EmployeeModel {
    public void insertEmp(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        LocalDate dob = LocalDate.parse(req.getParameter("dob"));
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        EmployeeStatus status = EmployeeStatus.valueOf(req.getParameter("status"));
        Employee employee = new Employee(name,dob,email, phone,address,status);
        EmployeeServices services = new EmployeeServices();
        services.insertEmp(employee);
    }
}

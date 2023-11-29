package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.frontend.model;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.models.Employee;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.services.EmployeeServices;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class EmployeeModel {
    private final EmployeeServices services = new EmployeeServices();
    public void insertEmp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        LocalDate dob = LocalDate.parse(req.getParameter("dob"));
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        EmployeeStatus status = EmployeeStatus.valueOf(req.getParameter("status"));
        Employee employee = new Employee(name,dob,email, phone,address,status);
        services.insertEmp(employee);
        resp.sendRedirect("employeeListing.jsp");
    }
    public List<Employee> getAllEmployees(){
        return services.getAll();
    }
}

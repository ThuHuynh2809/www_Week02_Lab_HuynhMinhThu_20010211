package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.frontend.model;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.models.Customer;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.services.CustomerServices;

import java.io.IOException;
import java.util.List;

public class CustomerModel {
    private CustomerServices services = new CustomerServices();
    public void insertCust(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        Customer customer = new Customer(name,email,phone,address);
        services.insertCust(customer);
        resp.sendRedirect("customerListing.jsp");
    }
    public List<Customer> getAllCustomers(){
        return services.getAll();
    }
}

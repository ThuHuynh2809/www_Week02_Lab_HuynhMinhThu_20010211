package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.frontend.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.frontend.model.CustomerModel;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.frontend.model.EmployeeModel;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.frontend.model.ProductModel;

import java.io.IOException;

@WebServlet("/controls")
public class ServielController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Object actionObject = req.getParameter("action");
            if (actionObject != null) {
                String action = actionObject.toString();
                if (action.equals("cust_list")) {
                    resp.sendRedirect("customerListing.jsp");
                } else if (action.equals("delete_product")) {
                    ProductModel pm = new ProductModel();
                    pm.deleteProduct(req, resp);
                } else if (action.equals("emp_list")) {
                    resp.sendRedirect("employeeListing.jsp");
                } else if (action.equals("del_emp")) {
                    EmployeeModel emp = new EmployeeModel();
                    emp.deleteEmployee(req, resp);
                } else if (action.equals("prod_list")) {
                    resp.sendRedirect("product.jsp");
                }
            } else {
                resp.sendRedirect("test.jsp");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Object actionObject = req.getParameter("action");
            if (actionObject != null) {
                String action = actionObject.toString();
                if (action.equals("insertEmp")) {
                    EmployeeModel empModel = new EmployeeModel();
                    empModel.insertEmp(req, resp);
                } else if (action.equals("insertCust")) {
                    CustomerModel customerModel = new CustomerModel();
                    customerModel.insertCust(req, resp);
                } else if (action.equals("insert_products")) {
                    ProductModel pm = new ProductModel();
                    pm.insertProduct(req, resp);
                } else if (action.equals("update_emp")) {
                    EmployeeModel empModel = new EmployeeModel();
                    empModel.updateEmployee(req, resp);
                }

            } else {
                resp.sendRedirect("customerListing.jsp");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

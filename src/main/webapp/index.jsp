<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.repositories.EmployeeRepository" %>
<%@ page import="vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.models.Employee" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.enums.EmployeeStatus" %>
<%@ page import="vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.repositories.ProductRepository" %>
<%@ page import="vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.models.Product" %>
<%@ page import="vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.enums.ProductStatus" %>
<%@ page import="vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.models.ProductImage" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%
    EmployeeRepository repository = new EmployeeRepository();
    Employee employee = new Employee("Thu", LocalDateTime.now(), "thu" + System.currentTimeMillis() + "@mail.com",
            "28092002", "1190 pvd", EmployeeStatus.ACTIVE);
    repository.insertEmployee(employee);
    out.print(employee);

%>
</body>
</html>
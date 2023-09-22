<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="vn.edu.iuh.fit.repositories.EmployeeRepository" %>
<%@ page import="vn.edu.iuh.fit.models.Employee" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="vn.edu.iuh.fit.enums.EmployeeStatus" %>
<%@ page import="vn.edu.iuh.fit.repositories.ProductRepository" %>
<%@ page import="vn.edu.iuh.fit.models.Product" %>
<%@ page import="vn.edu.iuh.fit.enums.ProductStatus" %>
<%@ page import="vn.edu.iuh.fit.models.ProductImage" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%
    EmployeeRepository repository = new EmployeeRepository();
    Employee emp = new Employee("Thu", LocalDateTime.now(), "thu" + System.currentTimeMillis() + "@mail.com",
            "28092002", "1190 pvd", EmployeeStatus.ACTIVE);
    repository.insertEmp(emp);

    out.print(emp);


    out.print("OK");
%>
</body>
</html>
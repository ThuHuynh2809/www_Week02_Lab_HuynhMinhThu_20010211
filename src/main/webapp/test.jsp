<%@ page import="vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.repositories.EmployeeRepository" %>
<%@ page import="vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.models.Employee" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.enums.EmployeeStatus" %>
<%@ page import="vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.repositories.ProductRepository" %>
<%@ page import="vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.models.Product" %>
<%@ page import="vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.models.ProductImage" %>
<%@ page import="vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.enums.ProductStatus" %><%--
  Created by IntelliJ IDEA.
  User: huynh
  Date: 11/30/2023
  Time: 10:26 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<%
  EmployeeRepository repository = new EmployeeRepository();
  Employee emp = new Employee("Thu",LocalDate.now(),"A.@gmail.com","Thu","0377284811",EmployeeStatus.ACTIVE);
  repository.insertEmployee(emp);
  out.print(emp);

  ProductRepository productRepository = new ProductRepository();
  Product product = new Product("Tivi","sieu mong","cai","Sony",ProductStatus.ACTIVE);

  ProductImage productImage = new ProductImage();
  productImage.setPath("/images/Tivi.png");
  productImage.setAlternative("xxx xxx");
  productImage.setProduct(product);
  out.print("OK");
  product.getProductImageList().add(productImage);
  productRepository.add(product);

  out.print("OK");
%>
</body>
</html>
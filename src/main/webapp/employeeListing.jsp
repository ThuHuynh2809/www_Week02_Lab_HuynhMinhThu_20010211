<%@ page import="vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.services.EmployeeServices" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.models.Employee" %><%--
  Created by IntelliJ IDEA.
  User: huynh
  Date: 9/29/2023
  Time: 10:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
<%
    EmployeeServices services = new EmployeeServices();
    List<Employee> lst = services.getAll();
%>
  <table width="80%" align="center">
    <tr>
     <th>Id</th>
      <th>Name</th>
      <th>Dod</th>
      <th>Email</th>
      <th>Phone</th>
      <th>Address</th>
     <th><a href="InsertEmp.jsp">Insert</a></th>
    </tr>
      <%
          for (Employee employee:lst){
      %>
      <tr>
          <td><%=employee.getEmpId()%></td>
          <td><%=employee.getFullName()%></td>
          <td><%=employee.getEmail()%></td>
          <td><%=employee.getPhone()%></td>
          <td><%=employee.getAddress()%></td>
          <td><%=employee.getStatus()%></td>
          <tb>
              <a href="">Update</a>
              <a href="">Delete</a>
          </tb>
      </tr>
      <%}%>
  </table>
</body>
</html>

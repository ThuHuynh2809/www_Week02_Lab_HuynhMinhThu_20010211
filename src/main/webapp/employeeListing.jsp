<%@ page import="vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.services.EmployeeServices" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.models.Employee" %><%--
  Created by IntelliJ IDEA.
  User: huynh
  Date: 9/29/2023
  Time: 10:07 PM
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
      integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
      integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee</title>
</head>
<body>
<%
    EmployeeServices services = new EmployeeServices();
    List<Employee> lst = services.getAll();
%>
<div class="container">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Dob</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Addres</th>
            <th>Status</th>
            <th colspan="2"><a href="insertEmployee.jsp">Insert</a></th>
        </tr>
        </thead>
        <% for (Employee emp : lst) {%>
        <tr>

            <td><%=emp.getId()%>
            </td>
            <td><%=emp.getFullName()%>
            </td>
            <td><%=emp.getAddress()%>
            </td>
            <td><%=emp.getDob()%>
            </td>
            <td><%=emp.getEmail()%>
            </td>
            <td><%=emp.getPhone()%>
            </td>
            <td><%=emp.getStatus()%>
            </td>
            <td><a href="updateEmployee.jsp?id=<%=emp.getId()%>">Update</a></td>
            <td><a href="controls?action=del_emp&id=<%=emp.getId()%>">Delete</a></td>

        </tr>
        <%}%>
    </table>
</div>
</body>
</html>
<%@ page import="vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.services.CustomerServices" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.models.Customer" %><%--
  Created by IntelliJ IDEA.
  User: huynh
  Date: 9/29/2023
  Time: 10:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
    <%
        CustomerServices services = new CustomerServices();
        List<Customer> lst = services.getAll();
    %>
    <table width="80%" align="center">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Address</th>
            <th><a href="InsertCust.jsp">Insert</a></th>
        </tr>
        <%for (Customer customer:lst){%>
        <tr>
            <td><%=customer.getCust_Id()%></td>
            <td><%=customer.getCustName()%></td>
            <td><%=customer.getEmail()%></td>
            <td><%=customer.getPhone()%></td>
            <td><%=customer.getAddress()%></td>
            <tb>
                <a href="">Update</a>
                <a href="">Delete</a>
            </tb>
        </tr>
        <%}%>
    </table>
</body>
</html>
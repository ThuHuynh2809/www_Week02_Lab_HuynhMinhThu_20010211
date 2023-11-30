<%@ page import="vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.services.CustomerServices" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.models.Customer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
</head>
<body>
<%
    CustomerServices services = new CustomerServices();
    List<Customer> lst = services.getAll();
    System.out.println("Number of customers: " + lst.size());
%>

<div class="container">
    <h2>Customer List</h2>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Address</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <% for (Customer customer : lst) { %>
        <tr>
            <td><%= customer.getId() %></td>
            <td><%= customer.getName() %></td>
            <td><%= customer.getAddress() %></td>
            <td><%= customer.getPhone() %></td>
            <td><%= customer.getEmail() %></td>
            <td>
                <a href="updateCustomer.jsp?id=<%= customer.getId() %>">Update</a>
                <a href="controls?action=del_customer&id=<%= customer.getId() %>">Delete</a>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <a href="insertCustomer.jsp" class="btn btn-primary">Insert Customer</a>
</div>

</body>
</html>

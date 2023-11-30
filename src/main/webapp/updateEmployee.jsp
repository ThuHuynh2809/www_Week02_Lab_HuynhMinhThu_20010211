<%--
  Created by IntelliJ IDEA.
  User: huynh
  Date: 11/30/2023
  Time: 10:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Employee</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <h1>UPDATE EMPLOYEE</h1>
    <form action="controls" method="post">
        <input type="hidden" name="action" value="update_emp">
        <input type="hidden" name="id" value="<%= request.getParameter("id") %>">

        <div class="form-group">
            <label for="name">Full Name:</label>
            <input type="text" class="form-control" name="name">
        </div>
        <div class="form-group">
            <label for="dob">Date of birth:</label>
            <input type="text" class="form-control" name="dob">
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" name="email">
        </div>
        <div class="form-group">
            <label for="phone">Phone:</label>
            <input type="text" class="form-control" name="phone">
        </div>
        <div class="form-group">
            <label for="address">Address:</label>
            <textarea class="form-control" name="address" cols="30" rows="3"></textarea>
        </div>
        <div class="form-group">
            <label for="status">Status:</label>
            <select class="form-control" name="status">
                <option value="ACTIVE">Active</option>
                <option value="TERMINATED">Terminated</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Update Employee</button>
        <button type="reset" class="btn btn-secondary">Clear</button>
    </form>
</div>

<!-- Bootstrap JS and jQuery (Make sure to include jQuery before Bootstrap) -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>

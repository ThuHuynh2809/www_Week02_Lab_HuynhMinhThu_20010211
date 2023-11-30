<%--
  Created by IntelliJ IDEA.
  User: huynh
  Date: 9/29/2023
  Time: 7:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h2 class="text-center">Navigation Menu</h2>
    <div class="row">
        <div class="col-md-3">
            <a href="test.jsp" class="btn btn-primary btn-block">Order Listing</a>
        </div>
        <div class="col-md-3">
            <a href="customerListing.jsp" class="btn btn-success btn-block">Customer Listing</a>
        </div>
        <div class="col-md-3">
            <a href="product.jsp" class="btn btn-info btn-block">Product Listing</a>
        </div>
        <div class="col-md-3">
            <a href="controls?action=emp_list" class="btn btn-warning btn-block">Employee Listing</a>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
</body>
</html>


<%--
  Created by IntelliJ IDEA.
  User: huynh
  Date: 9/29/2023
  Time: 4:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert new Customer</title>
</head>
<body>
    <form action="controls?action=insertCust" method="post">
        Name: <input name="name"><br/>
        Email: <input name="email"><br/>
        Phone: <input name="phone"><br/>
        Address: <textarea name="address" cols="30" rows="3"/></textarea><br/>
        <input type="submit" value="Insert new Customer"/>
        <input type="reset" value="Clear"/>
    </form>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: huynh
  Date: 11/30/2023
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>INsert Products</title>
    <form action="controls?action=insert_products" method="post">
        Name: <input name="name"/><br/>
        Description:<input name="desc"/><br/>
        Unit: <input name="unit"/><br/>
        Manufacturer: <input name="menu"/><br/>
        Status:<select name="status">
        <option selected="true" label="ACTIVE">ACTIVE</option>
        <option label="IN_ACTIVE">IN_ACTIVE</option>
        <option label="TERMINATED">TERMINATED</option>
    </select>
        <input type="submit" value="Insert"/>
        <input type="reset" value="Clear"/>
    </form>
</head>
<body>

</body>
</html>
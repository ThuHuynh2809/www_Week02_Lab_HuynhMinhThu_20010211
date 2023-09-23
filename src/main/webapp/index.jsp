<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.repositories.EmployeeRepository" %>
<%@ page import="vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.models.Employee" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.enums.EmployeeStatus" %>
<!DOCTYPE html>
<html>
<head>
    <title>Huynh Minh Thu</title>
</head>
<body>
<%
    EmployeeRepository repository =  new EmployeeRepository();
    Employee employee = new Employee("Thu", LocalDateTime.now(), "thu@gmail.com","093934848","1190 pvd", EmployeeStatus.ACTIVE);
    repository.insertEmployee(employee);
    out.println(employee);
%>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: iXasthur
  Date: 06.12.2020
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%= request.getContextPath() %>" method="post">
    <table>
        <tr>
            <td>First Name</td>
            <td><input type="text" name="firstName" required/></td>
        </tr>
        <tr>
            <td>Middle Name</td>
            <td><input type="text" name="middleName" required/></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><input type="text" name="lastName" required/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="email" name="email" required/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" required/></td>
        </tr>
    </table>
    <input type="submit" value="Submit" />
</form>
</body>
</html>

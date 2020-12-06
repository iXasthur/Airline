<%@ page import="entity.Member" %>
<%@ page import="dao.sql.MemberDAOSQL" %>
<%@ page import="service.UserService" %><%--
  Created by IntelliJ IDEA.
  User: iXasthur
  Date: 25.11.2020
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Member member = (Member)request.getSession().getAttribute("member");
%>
<html>
<head>
    <title>main.jsp</title>
</head>
<body>
    <h1>Airline</h1>
    <%
        if (member == null) {
            out.print("<p>\n" +
                    "        <a href=\"signin\">Sign In</a>\n" +
                    "    </p>\n" +
                    "    <p>\n" +
                    "        <a href=\"signup\">Sign Up</a>\n" +
                    "    </p>");
        } else {
            out.print("<p>" + member.email + "</p>");
        }
    %>

    <h1>Flights</h1>
</body>
</html>

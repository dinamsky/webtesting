<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Игорь
  Date: 13.04.2019
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User list</title>
</head>
<body>
<h1>User list</h1>
<%
    List<String> names = (List<String>) request.getAttribute("userNames");

    if (names != null && !names.isEmpty()) {
        out.println("<ui>");
        for (String s : names) {
            out.println("<li>" + s + "</li>");
        }
        out.println("</ui>");
    } else out.println("<p>There are no users yet!</p>");
%>
</body>
</html>

<%@ page import="model.entity.Luggage" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; utf-8"> <title>Insert title here</title>
</head>
<body>
<%
    ArrayList<Luggage> posts=(ArrayList<Luggage>) request.getAttribute("luggages");
    for (Luggage luggage: posts) {
%>
<tr>
    <td><%=luggage.getId()%></td>
    <td><%=luggage.getType()%></td>
    <td><%=luggage.getWeight()%></td>
    <td><%=luggage.getPrice()%></td>
</tr>
<%}%>
</body>
</html>
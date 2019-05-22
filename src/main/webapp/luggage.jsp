<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; utf-8"> <title>Insert title here</title>
</head>
<body>
<table>
    <c:forEach items="${requestScope.luggages}" var="luggage">
        <tr>
            <td><c:out value="${luggage.getId()}"/></td>
            <td><c:out value="${luggage.getType()}"/></td>
            <td><c:out value="${luggage.getWeight()}"/></td>
            <td><c:out value="${luggage.getPrice()}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

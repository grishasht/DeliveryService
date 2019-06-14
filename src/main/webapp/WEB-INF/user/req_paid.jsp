<%--
  Created by IntelliJ IDEA.
  User: hs
  Date: 6/14/19
  Time: 2:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.curLang}"/>
<fmt:setBundle basename="lang"/>
<jsp:useBean id="accService" scope="request" class="model.service.AccountService"/>

<html>
<head>
    <title><fmt:message key="req.paid.title"/></title>
    <link href="${pageContext.request.contextPath}/css/reg_required.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="error-template">
                <h1><fmt:message key="success.success"/></h1>
                <h2><fmt:message key="req.paid.successful"/></h2>
                <c:if test="${sessionScope.account != null}">
                    <h4><fmt:message key="req.paid.amount"/> ${sessionScope.account.getAmount()}$<br>
                        <fmt:message key="req.paid.date"/> ${sessionScope.account.getDate()}</h4>
                </c:if>
                <div class="error-actions">
                    <a href="${pageContext.request.contextPath}/page/?curLang=${sessionScope.curLang}"
                       class="btn btn-primary btn-lg"><span
                            class="glyphicon glyphicon-home"></span>
                        <fmt:message key="error.go.home"/> </a>
                    <a href="${pageContext.request.contextPath}/page/my_requests?curLang=${sessionScope.curLang}"
                       class="btn btn-default btn-lg"><span
                            class="glyphicon glyphicon-envelope"></span><fmt:message key="error.return"/>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

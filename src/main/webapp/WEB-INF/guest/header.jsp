<%--
  Created by IntelliJ IDEA.
  User: hs
  Date: 5/26/19
  Time: 4:54 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>


<fmt:setLocale value="${sessionScope.curLang}"/>
<fmt:setBundle basename="lang"/>
<jsp:useBean id="getParams" scope="page" class="java.lang.String"/>

<script src="${pageContext.request.contextPath}/js/signAjax.js"></script>
<script src="${pageContext.request.contextPath}/js/post.js"></script>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="/page/">YoursDelivery <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/page/">Features</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/page/">Pricing</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="/page/" id="navbarDropdownMenuLink" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Languages
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" onclick="{return renewPage(setGetParam('curLang', 'en'))}"
                       href="#"><fmt:message key="locale.english"/></a>
                    <a class="dropdown-item" onclick="{return renewPage(setGetParam('curLang', 'ru'))}"
                       href="#"><fmt:message key="locale.russian"/></a>
                </div>
            </li>
            <form class="form-inline">
                <input class="form-control mr-sm-2" type="text" placeholder=
                <fmt:message key="header.form.login"/> aria-label="Login">
                <input class="form-control mr-sm-2" type="password" placeholder=
                <fmt:message key="header.form.password"/> aria-label="Password">
                <button class="btn btn-outline-success my-3 my-sm-0" type="submit"><fmt:message
                        key="header.form.signin"/></button>
            </form>
            <form class="form-inline" action="${pageContext.request.contextPath}/page/reg_forward?curLang=${sessionScope.curLang}">
                <button class="btn btn-outline-success my-3 my-sm-0" type="submit">
                    <fmt:message key="header.form.signup"/></button>
            </form>
        </ul>
    </div>
</nav>
<%--
  Created by IntelliJ IDEA.
  User: hs
  Date: 6/6/19
  Time: 9:44 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.curLang}"/>
<fmt:setBundle basename="lang"/>
<jsp:useBean id="addressesService" scope="request" class="model.service.AddressService"/>

<script src="${pageContext.request.contextPath}/js/signAjax.js"></script>
<script src="${pageContext.request.contextPath}/js/post.js"></script>

<div class="wrap">
    <div class="input-group mb-3 country-box">
        <select class="custom-select" id="countrySelect" >
            <option selected>Choose...</option>
            <c:forEach var="country" items="${addressesService.countries}">
                <option value="${country}">${country}</option>
            </c:forEach>
        </select>
        <div class="input-group-append">
            <button class="btn btn-outline-secondary" type="button"
                    >Button</button>
        </div>
    </div>
    <div class="input-group mb-3 city-box">
        <select class="custom-select" id="citySelect" >
            <option selected>Choose...</option>
            <c:forEach var="city" items="${addressesService.cities}">
                <option value="${city}">${city}</option>
            </c:forEach>
        </select>
        <div class="input-group-append">
            <button class="btn btn-outline-secondary" type="button">Button</button>
        </div>
    </div>
    <div class="input-group mb-3 street-box">
        <select class="custom-select" id="streetSelect" >
            <option selected>Choose...</option>
            <c:forEach var="street" items="${addressesService.streets}">
                <option value="${street}">${street}</option>
            </c:forEach>
        </select>
        <div class="input-group-append">
            <button class="btn btn-outline-secondary" type="button">Button</button>
        </div>
    </div>
</div>

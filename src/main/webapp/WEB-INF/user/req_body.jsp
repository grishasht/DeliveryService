<%--
  Created by IntelliJ IDEA.
  User: hs
  Date: 6/13/19
  Time: 2:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.curLang}"/>
<fmt:setBundle basename="lang"/>
<jsp:useBean id="reqService" scope="request" class="model.service.RequestService"/>

<div class="container">
    <c:if test="${reqService.getUserRequests(sessionScope.sessionUser.getId()).size() == 0}">
        <h2 style="margin: 25% 25% 25% 25%"> Requests list is empty... </h2>
    </c:if>
    <c:forEach var="req" items="${reqService.getUserRequests(sessionScope.sessionUser.getId())}">
        <br>
        <hr>
        <form>
            <div class="wrap">
                <div class="req-id">
                    <h6><fmt:message key="req.body.req.id"/> ${req.getId()}</h6>
                    <br>
                    <fmt:message key="calculator.total.price"/>
                        ${req.getTotalPrice()}$<br>
                    <fmt:message key="req.body.send.date"/> ${req.getSendDate()}<br>
                    <fmt:message key="req.body.receive.date"/> ${req.getReceiveDate()}
                </div>
                <div class="req-address">
                    <h4><fmt:message key="calculator.address"/></h4>
                    <hr>
                    <span>${req.getCountry()}, ${req.getCity()}, ${req.getStreet()}
                        <c:if test="${req.getHouseNum() != null}"> ${req.getHouseNum()}</c:if>
                    </span>
                </div>
                <div class="req-lug">
                    <h4><fmt:message key="calculator.luggage"/></h4>
                    <hr>
                    <h7>Type: ${req.getLuggage()}<br>
                        <c:if test="${req.getWeight() != null}"> <fmt:message
                                key="calculator.weight"/>${req.getWeight()} kg <br>
                        </c:if>
                        <c:choose>
                            <c:when test="${req.getLuggage() == 'Letters' ||
                                            req.getLuggage() == 'Huge transport'}">
                                <fmt:message key="calculator.show.price"/>
                            </c:when>
                            <c:otherwise>
                                <fmt:message key="calculator.show.price.kg"/>
                            </c:otherwise>
                        </c:choose>
                            ${req.getPrice()}$
                    </h7>
                </div>
                <div class="buttons">
                    <a class="btn rounded btn btn-primary btn2-pos"
                       href="${pageContext.request.contextPath}/page/my_requests/pay?reqId=${req.getId()}&totPrice=${req.getTotalPrice()}&curLang=${sessionScope.curLang}">
                        <fmt:message key="my.req.pay"/>
                    </a>
                    <br>
                    <a class="btn rounded btn btn-primary btn2-pos"
                       href="${pageContext.request.contextPath}/page/my_requests/remove?reqId=${req.getId()}&curLang=${sessionScope.curLang}">
                        <fmt:message key="my.req.rm"/>
                    </a>
                </div>
            </div>
        </form>
    </c:forEach>
</div>
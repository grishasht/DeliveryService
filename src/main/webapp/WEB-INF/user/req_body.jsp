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

<fmt:setLocale value="${sessionScope.curLang}"/>
<fmt:setBundle basename="lang"/>

<div class="request-box">
    <c:if test="${sessionScope.showReq == true}">
        <form>
            <div class="req-pos">
                <div>
                    <h4><fmt:message key="calculator.address"/></h4>
                    <h7>${sessionScope.country}, ${sessionScope.city}, ${sessionScope.street}
                        <c:if test="${sessionScope.houseNum != null}"> ${sessionScope.houseNum}</c:if>
                    </h7>
                    <br>
                    <h4><fmt:message key="calculator.luggage"/></h4>
                    <h7>Type: ${sessionScope.lugType}<br>
                        <c:if test="${sessionScope.lugWeight != null}"> <fmt:message key="calculator.weight"/>${sessionScope.lugWeight} kg <br>
                        </c:if> <fmt:message key="calculator.total.price"/>
                            ${luggageService.getTotalPrice(luggageService.getLuggagePrice(sessionScope.lugType),
                                    sessionScope.lugWeight,
                                    addressesService.getCoefficient(sessionScope.street))}$
                    </h7>
                    <br>
                </div>
                <div>
                    <button type="submit" class="btn btn-primary float-right"
                            name="curLang" value="${sessionScope.curLang}"
                            formaction="${pageContext.request.contextPath}/page/commit_req">
                        <fmt:message key="calculator.commit"/>
                    </button>
                </div>
            </div>
        </form>
    </c:if>
</div>
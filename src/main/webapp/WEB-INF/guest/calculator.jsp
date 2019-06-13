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
<jsp:useBean id="luggageService" scope="request" class="model.service.LuggageService"/>

<script src="${pageContext.request.contextPath}/js/signAjax.js"></script>
<script src="${pageContext.request.contextPath}/js/post.js"></script>

<div class="wrap container user-container">
    <div class="address-box" id="addressDiv">
        <label class="col-form-label" for="addressDiv"><h3><fmt:message key="calculator.choose.adr"/></h3></label>
        <form method="post">
            <div class="input-group mb-3">
                <select class="custom-select" id="country" name="country" required>
                    <option selected>
                        <c:if test="${sessionScope.country != null}">
                            ${sessionScope.country}
                        </c:if>
                        <c:if test="${sessionScope.country == null}">
                            <fmt:message key="calculator.choose.country"/>
                        </c:if></option>
                    <c:forEach var="country" items="${addressesService.countries}">
                        <option value="${country}">${country}</option>
                    </c:forEach>
                </select>
                <div class="input-group-append">
                    <button class="btn btn-outline-secondary" type="submit"
                            formaction="${pageContext.request.contextPath}/page/service/choose_country"
                            name="curLang" value="${sessionScope.curLang}">
                        <fmt:message key="register.submit"/>
                    </button>
                </div>
            </div>


            <div class="input-group mb-3">
                <select class="custom-select" id="city" name="city" required>
                    <option selected><c:if test="${sessionScope.city != null}">
                        ${sessionScope.city}
                    </c:if>
                        <c:if test="${sessionScope.city == null}">
                            <fmt:message key="calculator.choose.city"/>
                        </c:if>
                    </option>
                    <c:forEach var="city" items="${addressesService.getCities(sessionScope.country)}">
                        <option value="${city}">${city}</option>
                    </c:forEach>
                </select>
                <div class="input-group-append">
                    <button class="btn btn-outline-secondary" type="submit"
                            name="curLang" value="${sessionScope.curLang}"
                            formaction="${pageContext.request.contextPath}/page/service/choose_city">
                        <fmt:message key="register.submit"/>
                    </button>
                </div>
            </div>

            <div class="input-group mb-3">
                <select class="custom-select" name="street" id="streetSelect"
                        required>
                    <option selected><c:if test="${sessionScope.street != null}">
                        ${sessionScope.street}
                    </c:if> <c:if test="${sessionScope.street == null}">
                        <fmt:message key="calculator.choose.street"/>
                    </c:if></option>
                    <c:forEach var="street" items="${addressesService.getStreets(sessionScope.city)}">
                        <option value="${street}">${street}</option>
                    </c:forEach>
                </select>
                <div class="input-group-append">
                    <button class="btn btn-outline-secondary" type="submit"
                            name="curLang" value="${sessionScope.curLang}"
                            formaction="${pageContext.request.contextPath}/page/service/choose_street">
                        <fmt:message key="register.submit"/>
                    </button>
                </div>
            </div>
            <div class="input-group mb-3">
                <input type="text" name="houseNum" class="form-control"
                <c:if test="${sessionScope.houseNum == null}">
                       placeholder="<fmt:message key="calculator.choose.house"/>"
                </c:if>
                <c:if test="${sessionScope.houseNum != null}">
                       placeholder="${sessionScope.houseNum}"
                </c:if>
                       aria-label="House number" aria-describedby="button-addon2">
                <div class="input-group-append">
                    <button class="btn btn-outline-secondary" type="submit"
                            name="curLang" value="${sessionScope.curLang}"
                            formaction="${pageContext.request.contextPath}/page/service/choose_house">
                        <fmt:message key="register.submit"/>
                    </button>
                </div>
            </div>
        </form>
    </div>
    <div class="luggage-box" id="luggageDiv">
        <label class="col-form-label" for="luggageDiv"><h3><fmt:message key="calculator.input.lug"/></h3></label>
        <form>
            <div class="input-group mb-3">
                <select class="custom-select" name="lugType" id="luggageSelect"
                        required>
                    <option selected>
                        <c:if test="${sessionScope.lugType != null}">
                            ${sessionScope.lugType}
                        </c:if>
                        <c:if test="${sessionScope.lugType == null}">
                            <fmt:message key="calculator.choose.lug.type"/>
                        </c:if></option>
                    <c:forEach var="lugType" items="${luggageService.luggageType}">
                        <option value="${lugType}">${lugType}</option>
                    </c:forEach>
                </select>
                <div class="input-group-append">
                    <button class="btn btn-outline-secondary" type="submit"
                            name="curLang" value="${sessionScope.curLang}"
                            formaction="${pageContext.request.contextPath}/page/service/choose_lug_type">
                        <fmt:message key="register.submit"/>
                    </button>
                </div>
            </div>
        </form>
        <form>
            <div>
                <c:choose>
                    <c:when test="${sessionScope.lugType.equals('Letters')}">
                        <h5>calculator.input.lug${luggageService.getLuggagePrice(sessionScope.lugType)}$</h5>
                    </c:when>
                    <c:when test="${sessionScope.lugType.equals('Huge Transport')}">
                        <h5><fmt:message key="calculator.show.price"/>${luggageService.getLuggagePrice(sessionScope.lugType)}$</h5>
                    </c:when>
                    <c:otherwise>
                        <h5><fmt:message key="calculator.show.price.kg"/>${luggageService.getLuggagePrice(sessionScope.lugType)}$</h5>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="input-group mb-3">
                <input type="text" name="lugWeight" class="form-control" required
                <c:if test="${sessionScope.lugWeight == null}">
                       placeholder="<fmt:message key="calculator.choose.weight"/>"
                </c:if>
                <c:if test="${sessionScope.lugWeight != null}">
                       placeholder="${sessionScope.lugWeight}"
                </c:if>
                       aria-label="Weight" aria-describedby="button-addon2">
            </div>
            <div class="crt-req-btn">
                <form>
                    <button type="submit" class="btn btn-primary float-right btn-size"
                            name="curLang" value="${sessionScope.curLang}"
                            formaction="${pageContext.request.contextPath}/page/service/create_req">
                        <fmt:message key="calculator.create.req"/>
                    </button>
                    <button type="submit" class="btn btn-primary float-left btn-size"
                            name="curLang" value="${sessionScope.curLang}"
                            formaction="${pageContext.request.contextPath}/page/service/reset">
                        <fmt:message key="calculator.clear"/>
                    </button>
                </form>
            </div>
        </form>
    </div>
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
</div>


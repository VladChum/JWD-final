<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fm" uri="http://provider.com/jsp/tlds/phone" %>

<c:set var="locale" value="${empty cookie['locale'].getValue() ? 'en' : cookie['locale'].getValue() }"/>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="locale" />

<div class="tab-pane fade show active" id="score" role="tabpanel">
    <div class="tariff-item__top">
        <div class="container">
            <div class="row align-items-start">
                <div class="col-2"><h5 class="card-title"><fmt:message key="page.user.account.subscriber"/> : </h5></div>
                <div class="col"><h5>${user.firstName} ${user.lastName}</h5></div>
            </div>
        </div>
        <div class="container">
            <div class="row align-items-start">
                <div class="col-2"><h5 class="card-title"><fmt:message key="page.user.account.login"/> : </h5></div>
                <div class="col"><h5>${account.login}</h5></div>
            </div>
        </div>
        <div class="container">
            <div class="row align-items-start">
                <div class="col-2"><h5 class="card-title"><fmt:message key="page.user.account.status"/> : </h5></div>
                <div id="userStatusLight" class="userStatusLight">
                    <c:if test="${user.status == 'ACTIVATE'}">
                        <img alt="logo" src="../../../resources/user/activeStatus.svg"
                    </c:if>
                    <c:if test="${user.status == 'SUSPENDED'}">
                        <img alt="logo" src="../../../resources/user/suspendedStatus.svg"
                    </c:if>
                    <c:if test="${user.status == 'BANNED'}">
                    <img alt="logo" src="../../../resources/user/blockStatus.svg"
                    </c:if>
                         data-user-status="${user.status}">
                </div>
                <div class="col"><h5>${user.status}</h5></div>
            </div>
        </div>
        <div class="container">
            <div class="row align-items-start">
                <div class="col-2"><h5 class="card-title"><fmt:message key="page.user.account.balance"/> : </h5></div>
                <div class="col"><h5 class="card-title">${user.balance}</h5></div>
            </div>
        </div>
        <br><br><br><br><br><br><br><br><br><br><br><br>
        <div class="container">
            <div class="row align-items-start">
                <div class="col-2"><h5 class="card-title"><fmt:message key="page.user.account.phone"/> : </h5></div>
                <div class="col"><h5><fm:format phone="${user.phone}"/></h5></div>
            </div>
        </div>
        <div class="container">
            <div class="row align-items-start">
                <div class="col-2"><h5 class="card-title">E-mail : </h5></div>
                <div class="col"><h5 class="card-title">${user.email}</h5></div>
            </div>
        </div>
    </div>
</div>
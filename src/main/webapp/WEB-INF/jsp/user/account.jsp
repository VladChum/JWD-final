<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fm" uri="http://provider.com/jsp/tlds/phone" %>

<c:set var="locale" value="${empty cookie['locale'].getValue() ? 'en' : cookie['locale'].getValue() }"/>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="locale"/>

<div class="tab-pane fade show active" id="score" role="tabpanel">
    <div class="tariff-item__top">
        <div class="container">
            <div class="row align-items-start">
                <div class="col-2"><h5 class="card-title"><fmt:message key="form.new_user.name"/> : </h5>
                </div>
                <div class="col"><h5>${user.firstName} </h5></div>
            </div>
        </div>
        <div class="container">
            <div class="row align-items-start">
                <div class="col-2"><h5 class="card-title"><fmt:message key="form.new_user.surname"/> : </h5>
                </div>
                <div class="col"><h5>${user.lastName}</h5></div>
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
        <div class="container">
            <div class="row align-items-start">
                <div class="col-2"><h5 class="card-title"><fmt:message key="page.user.account.active_days"/> : </h5>
                </div>
                <div class="col"><h5 class="card-title">${activeDays} <fmt:message key="page.user.account.days"/></h5>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row align-items-start">
                <div class="col-2"><h5 class="card-title"><fmt:message key="page.user.account.active_tariff"/> : </h5>
                </div>
                <div class="col">
                    <div class="row row-cols-1 row-cols-md-8 g-4">
                        <c:forEach items="${tariffPlans}" var="tariffPlan">
                            <c:if test="${tariffPlan.id == subscription.tariffPlanId}">
                                <div class="col-sm-6">
                                    <div class="card">
                                        <div class="card-body">
                                            <div class="tariff-item">
                                                <div class="tariff-item__top">
                                                    <div class="tariff-item__title">
                                                        <h5 class="card-title">${tariffPlan.name}</h5>
                                                    </div>
                                                    <div class="tariff-item__text">
                                                        <p><fmt:message key="tariff.card.text1"/></p>
                                                        <p><fmt:message key="tariff.card.text2"/>
                                                                ${tariffPlan.speed}
                                                            <fmt:message key="tariff.card.text3"/></p>
                                                        <p><fmt:message key="tariff.card.text4"/></p>
                                                    </div>
                                                </div>
                                                <div class="tariff-item__body">
                                                    <div class="tariff-item__price">
                                                    <span>
                                                        <b>${tariffPlan.price}</b>
                                                        <fmt:message key="tariff.card.amount"/>
                                                    </span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
        <br><br>
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
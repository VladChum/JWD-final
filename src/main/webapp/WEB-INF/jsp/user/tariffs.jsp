<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="locale" value="${empty cookie['locale'].getValue() ? 'en' : cookie['locale'].getValue() }"/>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="locale" />

<div class="tariff-item__top">
    <div class="row row-cols-1 row-cols-md-3 g-4">
        <c:forEach items="${tariffPlans}" var="tariffPlan">
            <c:if test="${tariffPlan.active == 'true' || tariffPlan.id == subscription.tariffPlanId}">
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
                                    <c:if test="${tariffPlan.id != subscription.tariffPlanId}">
                                        <div class="tariff-item__btns">
                                            <button name="chengTariffButton"
                                                    class="chengTariffButton btn button-tariff"
                                                    data-tariff-id="${tariffPlan.id}"
                                                    type="button"><fmt:message
                                                    key="tariff.card.link"/>
                                            </button>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
        </c:forEach>
    </div>
</div>
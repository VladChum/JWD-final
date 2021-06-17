<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="locale" value="${empty cookie['locale'].getValue() ? 'en' : cookie['locale'].getValue() }"/>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="locale" />

<div class="tab-pane fade show active" role="tabpanel">
    <div class="tariff-item__top">
        <div class="row row-cols-1 row-cols-md-3 g-4">
            <c:forEach items="${discounts}" var="discount">
                <c:if test="${discount.endDate >= dateNow && discount.startDate <= dateNow}">
                    <div class="col-sm-6">
                        <div class="card">
                            <div class="card-body">
                                <div class="tariff-item">
                                    <div class="tariff-item__top">
                                        <div class="tariff-item__title">
                                            <h5 class="card-title">
                                                <fmt:message key="form.discount.title"/>
                                            </h5>
                                        </div>
                                        <div class="tariff-item__text">
                                            <p><fmt:message
                                                    key="form.discount.start_date"/>: ${discount.startDate} </p>
                                            <p></p>
                                            <p><fmt:message
                                                    key="form.discount.end_date"/>: ${discount.endDate} </p>
                                        </div>
                                    </div>
                                    <div class="tariff-item__body">
                                        <div class="tariff-item__price">
                                            <span><b>${discount.size}</b>%</span>
                                            <b class="tariffActive"><fmt:message key="form.discount.status.active"/></b>
                                        </div>
                                        <c:forEach var="tariff" items="${tariffPlans}">
                                            <c:if test="${discount.id == tariff.discountId}">
                                                <p class="discountTariff">
                                                    <b>${tariff.name}<s>${tariff.price}</s>
                                                        <fmt:formatNumber type="number" maxFractionDigits="2">
                                                            ${tariff.price * (100 - discount.size) / 100}
                                                        </fmt:formatNumber>
                                                    </b>
                                                </p>
                                            </c:if>
                                        </c:forEach>
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

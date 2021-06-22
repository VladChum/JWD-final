<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="locale" value="${empty cookie['locale'].getValue() ? 'en' : cookie['locale'].getValue() }"/>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="locale"/>


<div class="row">
    <div class="col-4">
        <center><fmt:message key="page.admin.list.button.users"/></center>
        <canvas id="myChart" data-active="${param.activeUsers}" data-baned="${param.banedUsers}" data-suspended="${param.suspendedUsers}"></canvas>
    </div>
    <div class="col-4">
        <center><fmt:message key="page.admin.list.button.stock"/></center>
        <canvas id="discountsChart" data-active="${activeDiscounts}}" data-baned="${archiveDiscounts}" data-planed="${planedDiscounts}"></canvas>
    </div>
    <div class="col-4">
        <center><fmt:message key="page.admin.list.button.tariffs"/></center>
        <canvas id="tariffsChart" data-active="${activeTariffs}" data-suspended="${archiveTariffs}"></canvas>
    </div>
</div>


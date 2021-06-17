<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="locale" value="${empty cookie['locale'].getValue() ? 'en' : cookie['locale'].getValue() }"/>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="locale"/>

<div class="nav" id="v-pills-tab" role="tablist" aria-orientation="vertical">
    <button type="button"
            class="nav-link active btn-user btn-outline-primary tarrifs-filter__item admin-filter__item--user ng-star-inserted"
            id="users-tab" data-bs-toggle="pill"
            data-bs-target="#users" role="tab" aria-controls="users"
            aria-selected="true">
        <fmt:message key="page.admin.list.button.users"/>
    </button>
    <button type="button"
            class="nav-link btn-user btn-outline-primary tarrifs-filter__item admin-filter__item--statistics ng-star-inserted"
            id="statistics-tab" data-bs-toggle="pill"
            data-bs-target="#statistics" role="tab" aria-controls="statistics"
            aria-selected="false">
        <fmt:message key="page.admin.list.button.statistics"/>
    </button>
    <button type="button"
            class="nav-link btn-user btn-outline-primary tarrifs-filter__item tarrifs-filter__item--bundle ng-star-inserted"
            id="tariffs-tab" data-bs-toggle="pill"
            data-bs-target="#tariffs" role="tab" aria-controls="tariffs"
            aria-selected="false">
        <fmt:message key="page.admin.list.button.tariffs"/>
    </button>
    <button type="button"
            class="nav-link btn-user btn-outline-primary tarrifs-filter__item tarrifs-filter__item--sails ng-star-inserted"
            id="stock-tab" data-bs-toggle="pill"
            data-bs-target="#stock" role="tab" aria-controls="stock"
            aria-selected="false">
        <fmt:message key="page.admin.list.button.stock"/>
    </button>
    <button type="button"
            class="nav-link btn-user btn-outline-primary tarrifs-filter__item tarrifs-filter__item--sating ng-star-inserted"
            id="settings-tab" data-bs-toggle="pill"
            data-bs-target="#settings" role="tab" aria-controls="settings"
            aria-selected="false">
        <fmt:message key="page.admin.list.button.settings"/>
    </button>
</div>

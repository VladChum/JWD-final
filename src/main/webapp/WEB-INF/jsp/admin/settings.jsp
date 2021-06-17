<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="locale" value="${empty cookie['locale'].getValue() ? 'en' : cookie['locale'].getValue() }"/>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="locale"/>

<br>
<div class="row align-items-start">
    <div class="col-4">
        <h5 class="card-title"><fmt:message key="page.user.settings.change_password.old"/> : </h5>
    </div>
    <div class="col">
        <input type="password" id="oldPassword" class="oldPassword form-control">
    </div>
    <div class="col"></div>
</div>
<div class="row align-items-start">
    <div class="col-4">
        <h5 class="card-title"><fmt:message key="page.user.settings.change_password.new"/> : </h5>
    </div>
    <div class="col">
        <input type="password" id="newPassword" class="newPassword form-control">
    </div>
    <div class="col"></div>
</div>
<div class="row align-items-start">
    <div class="col-4">
        <h5 class="card-title"><fmt:message key="page.user.settings.change_password.second_new"/> : </h5>
    </div>
    <div class="col">
        <input type="password" id="secondNewPassword" class="secondNewPassword form-control">
    </div>
    <div class="col"></div>
</div>
<div id="errorUpdatePassword" class="errorMassage"></div>
<button type="button" id="chengPasswordButton" class="btn btn-primary" data-account-id="${account.id}">
    <fmt:message key="page.user.settings.button.update"/>
</button>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="locale" value="${empty cookie['locale'].getValue() ? 'en' : cookie['locale'].getValue() }"/>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="locale" />

<div class="tariff-item__top">
    <div class="container">
        <div class="row align-items-start">
            <div class="col-2"><h5 class="card-title"><fmt:message key="page.user.account.subscriber"/> : </h5></div>
            <div class="col"><h5>${user.firstName} ${user.lastName}</h5></div>
        </div>
    </div>
    <div class="container">
        <div class="row align-items-start">
            <div class="col-2"><h5 class="card-title"><fmt:message key="page.user.account.status"/> : </h5></div>
            <div class="col"><h5>${user.status}</h5></div>
        </div>
    </div>
    <div class="container">
        <div class="row align-items-start">
            <div class="col-8"><h5 class="card-title"><fmt:message key="page.user.settings.change_status"/>: </h5></div>
            <div class="col">
                <c:if test="${user.status == 'ACTIVATE'}">
                    <button id="chengStatus" class="btn btn-warning" type="button"
                            data-user-status="${user.status}" data-user-id="${user.id}"
                            data-balance="${user.balance}">
                        <fmt:message key="page.user.settings.change_status.stop"/>
                    </button>
                </c:if>
                <c:if test="${user.status != 'ACTIVATE'}">
                    <button id="chengStatus" class="btn btn-success" type="button"
                            data-user-status="${user.status}" data-user-id="${user.id}"
                            data-balance="${user.balance}">
                        <fmt:message key="page.user.settings.change_status.activate"/>
                    </button>
                </c:if>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row align-items-start">
            <div class="col" id="errorActivateStatus"><fmt:message key="page.user.settings.change_status.warning"/>
            </div>
        </div>
    </div>
</div>
<br>
<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
    <li class="nav-item" role="presentation">
        <button class="nav-link active" id="pills-contact-tab" data-bs-toggle="pill"
                data-bs-target="#pills-contact" type="button" role="tab"
                aria-controls="pills-contact" aria-selected="true"><fmt:message
                key="page.user.settings.button.contact"/>
        </button>
    </li>
    <li class="nav-item" role="presentation">
        <button class="nav-link" id="pills-phone-tab" data-bs-toggle="pill"
                data-bs-target="#pills-phone" type="button" role="tab"
                aria-controls="pills-phone" aria-selected="false">
            <fmt:message key="page.user.settings.button.phone"/>
        </button>
    </li>
    <li class="nav-item" role="presentation">
        <button class="nav-link" id="pills-password-tab" data-bs-toggle="pill"
                data-bs-target="#pills-password" type="button" role="tab"
                aria-controls="pills-password" aria-selected="false">
            <fmt:message key="page.user.settings.button.change_password"/>
        </button>
    </li>
</ul>

<div class="tab-content" id="pills-tabContent">
    <%-- contact data--%>
    <div class="tab-pane fade show active" id="pills-contact" role="tabpanel"
         aria-labelledby="pills-contact-tab">
        <br>
        <div class="row align-items-start">
            <div class="col-2">
                <h5 class="card-title">Email : </h5>
            </div>
            <div class="col">
                <input id="newEmail" class="chengEmail form-control"
                       placeholder="${user.email}">
            </div>
            <div class="col">
            </div>
        </div>
        <div id="errorNewEmail" class="errorMassage"></div>
        <button type="button" id="chengEmailButton" class="btn btn-primary"
                data-email="${user.email}" data-user-id="${user.id}">
            <fmt:message key="page.user.settings.button.update"/>
        </button>
    </div>
    <%-- phone--%>
    <div class="tab-pane fade" id="pills-phone" role="tabpanel"
         aria-labelledby="pills-phone-tab">
        <br>
        <div class="row align-items-start">
            <div class="col-2"><h5 class="card-title">Phone : </h5></div>
            <div class="col">
                <input id="newPhone" class="chengPhone form-control"
                       placeholder="${user.phone}">
            </div>
            <div class="col"></div>
        </div>
        <div id="errorNewPhone" class="errorMassage"></div>
        <button type="button" id="chengPhoneButton" class="btn btn-primary"
                data-phone="${user.phone}" data-user-id="${user.id}">
            <fmt:message key="page.user.settings.button.update"/>
        </button>
    </div>
    <%-- change password--%>
    <div class="tab-pane fade" id="pills-password" role="tabpanel"
         aria-labelledby="pills-password-tab">
        <br>
        <div class="row align-items-start">
            <div class="col-4">
                <h5 class="card-title"><fmt:message key="page.user.settings.change_password.old"/> : </h5>
            </div>
            <div class="col">
                <input type="password" id="oldPassword"
                       class="oldPassword form-control">
            </div>
            <div class="col">
            </div>
        </div>
        <div class="row align-items-start">
            <div class="col-4">
                <h5 class="card-title"><fmt:message key="page.user.settings.change_password.new"/> : </h5>
            </div>
            <div class="col">
                <input type="password" id="newPassword"
                       class="newPassword form-control">
            </div>
            <div class="col">
            </div>
        </div>
        <div class="row align-items-start">
            <div class="col-4">
                <h5 class="card-title"><fmt:message key="page.user.settings.change_password.second_new"/> : </h5>
            </div>
            <div class="col">
                <input type="password" id="secondNewPassword"
                       class="secondNewPassword form-control">
            </div>
            <div class="col">
            </div>
        </div>
        <div id="errorUpdatePassword" class="errorMassage"></div>
        <button type="button" id="chengPasswordButton" class="btn btn-primary"
                data-account-id="${account.id}">
            <fmt:message key="page.user.settings.button.update"/>
        </button>
    </div>
</div>

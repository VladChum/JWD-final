<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fm" uri="http://provider.com/jsp/tlds/phone" %>

<c:set var="locale" value="${empty cookie['locale'].getValue() ? 'en' : cookie['locale'].getValue() }"/>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="locale" />
<!doctype html>
<html lang="${locale}">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="stylesheet" href="../../resources/css/style.css">

    <title>user</title>
</head>
<body class="d-flex flex-column min-vh-100">
<div class="intro">
    <header class="header p-3 text-white">
        <div class="container">
            <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                <div class="header-logo">
                    <img alt="logo" src="../../resources/logo2.png">
                </div>
                <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <li><a href="Controller?command=homePage" class="nav-link px-2 text-white me-3"><fmt:message
                            key="page.home.navbar.link.home"/></a></li>
                    <li><a href="Controller?command=tariffPage" class="nav-link px-2 text-white me-3"><fmt:message
                            key="page.home.navbar.link.tariffs"/></a></li>
                    <li><a href="Controller?command=aboutPage" class="nav-link px-2 text-white me-3"><fmt:message
                            key="page.home.navbar.link.about"/></a></li>
                </ul>
                <div class="dropdown">
                    <button class="btn btn-outline-light dropdown-toggle me-3" type="button" id="languageMenu"
                            data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        ${locale.toUpperCase()}
                    </button>
                    <div class="dropdown-menu" aria-labelledby="languageMenu">
                        <button class="dropdown-item locale" data-locale="ru" type="button">RU</button>
                        <button class="dropdown-item locale" data-locale="pl" type="button">PL</button>
                        <button class="dropdown-item locale" data-locale="en" type="button">EN</button>
                    </div>
                </div>
                <c:if test="${account.login == null}">
                    <a href="Controller?command=loginPage">
                        <button type="button" class="btn btn-primary"><fmt:message
                                key="page.home.navbar.button.login"/></button>
                    </a>
                </c:if>
                <c:if test="${account.login != null}">
                    <div class="dropdown text-end">
                        <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle show"
                           id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="true">
                            <img src="../resources/user/account.svg" alt="mdo"
                                 class="account-button rounded-circle">
                        </a>
                        <ul class="account-menu dropdown-menu text-small">
                            <li><a class="dropdown-item" href="Controller?command=personalAccount"><fmt:message
                                    key="page.home.navbar.button.personalaccount"/></a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="Controller?command=signOut"><fmt:message
                                    key="page.home.navbar.button.signout"/></a></li>
                        </ul>
                    </div>
                </c:if>
            </div>
        </div>
    </header>
</div>
<c:set value="${user}" var="user"/>
<c:set value="${account}" var="account"/>
<div id="content" class="container">
    <br>
    <br>
    <div class="row row-cols-1">
        <div class="col-sm-3">
            <div class="card-user">
                <div class="card-body">
                    <div class="tariff-item">
                        <div class="tariff-item__top">
                            <div class="tariff-item__title">
                                <h5 class="card-title">
                                    ${user.firstName}
                                    ${user.lastName}
                                </h5>
                            </div>
                            <div class="tariff-item__text">
                                <b><p>${account.login}</p></b>
                            </div>
                        </div>
                        <div class="tariff-item__body">
                            <div>
                                <div class="tariff-item__price">
                                    <div class="balance-user">
                                        <fmt:message key="page.user.account.balance"/> : <b>
                                        ${user.balance}
                                    </b> <fmt:message key="page.user.account.byn"/>
                                    </div>
                                </div>
                                <hr class="featurette-divider">
                            </div>
                            <div class="nav" id="v-pills-tab" role="tablist"
                                 aria-orientation="vertical">
                                <button type="button"
                                        class="nav-link active btn-user btn-outline-primary tarrifs-filter__item tarrifs-filter__item--user ng-star-inserted"
                                        id="score-tab" data-bs-toggle="pill"
                                        data-bs-target="#score" role="tab" aria-controls="score"
                                        aria-selected="true">
                                    <fmt:message key="page.user.list.button.account"/>
                                </button>
                                <button type="button"
                                        class="nav-link btn-user btn-outline-primary tarrifs-filter__item tarrifs-filter__item--bundle ng-star-inserted"
                                        id="tariffs-tab" data-bs-toggle="pill"
                                        data-bs-target="#tariffs" role="tab" aria-controls="tariffs"
                                        aria-selected="false">
                                    <fmt:message key="page.user.list.button.tariffs"/>
                                </button>
                                <button type="button"
                                        class="nav-link btn-user btn-outline-primary tarrifs-filter__item tarrifs-filter__item--wallet ng-star-inserted"
                                        id="payment-tab" data-bs-toggle="pill"
                                        data-bs-target="#payment" role="tab" aria-controls="payment"
                                        aria-selected="false">
                                    <fmt:message key="page.user.list.button.payment"/>
                                </button>
                                <button type="button"
                                        class="nav-link btn-user btn-outline-primary tarrifs-filter__item tarrifs-filter__item--sails ng-star-inserted"
                                        id="stock-tab" data-bs-toggle="pill"
                                        data-bs-target="#stock" role="tab" aria-controls="payment"
                                        aria-selected="false">
                                    <fmt:message key="page.user.list.button.stock"/>
                                </button>
                                <button type="button"
                                        class="nav-link btn-user btn-outline-primary tarrifs-filter__item tarrifs-filter__item--help ng-star-inserted"
                                        id="help-tab" data-bs-toggle="pill"
                                        data-bs-target="#help" role="tab" aria-controls="help"
                                        aria-selected="false">
                                    <fmt:message key="page.user.list.button.help"/>
                                </button>
                                <button type="button"
                                        class="nav-link btn-user btn-outline-primary tarrifs-filter__item tarrifs-filter__item--sating ng-star-inserted"
                                        id="settings-tab" data-bs-toggle="pill"
                                        data-bs-target="#settings" role="tab" aria-controls="settings"
                                        aria-selected="false">
                                    <fmt:message key="page.user.list.button.settings"/>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-9">
            <div class="card-user">
                <div class="card-body">
                    <div class="tariff-item">
                        <div class="tab-content" id="v-pills-tabContent">
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
                                                    <img alt="logo" src="../../resources/user/activeStatus.svg"
                                                </c:if>
                                                <c:if test="${user.status == 'SUSPENDED'}">
                                                    <img alt="logo" src="../../resources/user/suspendedStatus.svg"
                                                </c:if>
                                                <c:if test="${user.status == 'BANNED'}">
                                                <img alt="logo" src="../../resources/user/blockStatus.svg"
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
                            <div class="tab-pane fade show" id="tariffs" role="tabpanel">
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
                                                                        <h5 class="card-title">
                                                                                ${tariffPlan.name}
                                                                        </h5>
                                                                    </div>
                                                                    <div class="tariff-item__text">
                                                                        <p><fmt:message key="tariff.card.text1"/></p>
                                                                        <p><fmt:message key="tariff.card.text2"/>
                                                                                ${tariffPlan.speed}
                                                                            <fmt:message key="tariff.card.text3"/> </p>
                                                                        <p><fmt:message key="tariff.card.text4"/> </p>
                                                                    </div>
                                                                </div>
                                                                <div class="tariff-item__body">
                                                                    <div class="tariff-item__price">
                                                                    <span>
                                                                        <b>
                                                                                ${tariffPlan.price}
                                                                        </b>
                                                                        <fmt:message key="tariff.card.amount"/>
                                                                    </span>
                                                                    </div>
                                                                    <c:if test="${tariffPlan.id != subscription.tariffPlanId}">
                                                                        <div class="tariff-item__btns">
                                                                            <button name="chengTariffButton"
                                                                                    class="chengTariffButton btn button-tariff"
                                                                                    data-tariff-id="${tariffPlan.id}"
                                                                                    type="button"><fmt:message key="tariff.card.link"/>
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
                            </div>
                            <%--                            payment--%>
                            <div class="tab-pane fade show" id="payment" role="tabpanel">
                                <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                                    <button class="btn replenish-button me-3" type="button"
                                            id="cardReplenishButton"
                                            data-bs-toggle="modal" data-bs-target="#cardForm"
                                            aria-expanded="false">
                                        +
                                    </button>
                                </div>
                                <center>
                                    <h4><fmt:message key="page.user.payment.replenish.title"/></h4>
                                </center>
                                <table>
                                    <tbody>
                                    <tr>
                                        <td align="right">
                                            <b><fmt:message key="page.user.payment.replenish.amount"/>:<b></b></b></td>
                                        <td>
                                            <input type="text" id="replenishAmount" class="form form-control">
                                            <fmt:message key="page.user.payment.replenish.max_amount"/>.
                                            <div id="errorReplenishAmount" class="errorMassage"></div>
                                        </td>
                                        <td>
                                            <button class="ReplenishButton btn btn-primary"
                                                    data-user-id="${user.id}">
                                                <fmt:message key="page.user.payment.replenish.button"/>
                                            </button>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                                <div id="errorReplenish" class="errorMassage"></div>
                                <br>
                                <br>
                                <center>
                                    <h5><fmt:message key="page.user.payment.payment"/></h5>
                                </center>
                                <div class="paymentTable">
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th scope="col"><fmt:message key="page.user.payment.table.data"/></th>
                                            <th scope="col"><fmt:message key="page.user.payment.table.amount"/></th>
                                            <th scope="col"><fmt:message key="page.user.payment.table.payment_type"/></th>
                                        </tr>
                                        </thead>
                                        <tbody class="table">
                                        <c:forEach items="${userPayments}" var="userPayment">
                                            <tr>
                                                <td>${userPayment.date}</td>
                                                <td>${userPayment.amount}</td>
                                                <td>${userPayment.paymentType}</td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="modal fade" id="cardForm" data-bs-backdrop="static"
                                 data-bs-keyboard="false" tabindex="-1"
                                 aria-hidden="true">
                                <div class="modal-dialog modal-lg">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="card">card</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                    aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <br>
                                            <div class="row gy-3">
                                                <div class="col-md-6">
                                                    <label for="cc-name" class="form-label">Name on card</label>
                                                    <input type="text" class="form-control" id="cc-name" placeholder=""
                                                           required="">
                                                    <small class="text-muted">Full name as displayed on card</small>
                                                    <div class="invalid-feedback">
                                                        Name on card is required
                                                    </div>
                                                </div>

                                                <div class="col-md-6">
                                                    <label for="cc-number" class="form-label">Credit card number</label>
                                                    <input type="text" class="form-control" id="cc-number"
                                                           placeholder="" required="">
                                                    <div class="invalid-feedback">
                                                        Credit card number is required
                                                    </div>
                                                </div>

                                                <div class="col-md-3">
                                                    <label for="cc-expiration" class="form-label">Expiration</label>
                                                    <input type="text" class="form-control" id="cc-expiration">
                                                    <div class="invalid-feedback">
                                                        Expiration date required
                                                    </div>
                                                </div>

                                                <div class="col-md-3">
                                                    <label for="cc-cvv" class="form-label">CVV</label>
                                                    <input type="text" class="form-control" id="cc-cvv">
                                                    <div class="invalid-feedback">
                                                        Security code required
                                                    </div>
                                                </div>
                                            </div>
                                            <br>
                                            <h6>Amount</h6>
                                            <div class="col-md-3">
                                                <input type="text" class="cardAmount form-control">
                                                <div id="errorAmount" class="errorMassage"></div>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="closeCardForm"
                                                    class="btn btn-secondary" data-bs-dismiss="modal">
                                                <fmt:message key="form.card.button.cancel"/>
                                            </button>
                                            <button type="button" id="replenishButton"
                                                    data-user-id="${user.id}"
                                                    class="btn btn-primary">
                                                <fmt:message key="form.card.button.replenish"/>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%--                            discount--%>
                            <div class="tab-pane fade show" id="stock" role="tabpanel">
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
                                                                            <p><fmt:message key="form.discount.start_date"/>: ${discount.startDate} </p>
                                                                            <p></p>
                                                                            <p><fmt:message key="form.discount.end_date"/>: ${discount.endDate} </p>
                                                                        </div>
                                                                    </div>
                                                                    <div class="tariff-item__body">
                                                                        <div class="tariff-item__price">
                                                                                <span>
                                                                                    <b>
                                                                                            ${discount.size}
                                                                                    </b>
                                                                                    %
                                                                                </span>
                                                                            <b class="tariffActive">
                                                                                <fmt:message key="form.discount.status.active"/>
                                                                            </b>
                                                                        </div>
                                                                        <c:forEach var="tariff" items="${tariffPlans}">
                                                                            <c:if test="${discount.id == tariff.discountId}">
                                                                                <p class="discountTariff">
                                                                                    <b>
                                                                                            ${tariff.name}
                                                                                        <s>
                                                                                                ${tariff.price}
                                                                                        </s>
                                                                                        <fmt:formatNumber type="number"
                                                                                                          maxFractionDigits="2">
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
                            </div>

                            <div class="tab-pane fade show" id="help" role="tabpanel">
                            </div>

                            <div class="tab-pane fade show" id="settings" role="tabpanel">
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
                                                aria-controls="pills-contact" aria-selected="true"><fmt:message key="page.user.settings.button.contact"/>
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
                                    <%-- cheng password--%>
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
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<footer class="bg-dark text-center text-white mt-auto">
    <div class="container p-4 pb-0">
        <section class="d-flex justify-content-center footer-items mb-4">
            <!-- Facebook -->
            <a class="m-1 footer-item" href="#" role="button">
                <img class="mx-auto" alt="footer-facebook" src="../../resources/social/facebook.svg">
            </a>
            <!-- Twitter -->
            <a class="m-1 footer-item" href="#" role="button" 0>
                <img alt="footer-twitter" src="../../resources/social/twitter.svg">
            </a>
            <!-- Google -->
            <a class="m-1 footer-item" href="#" role="button">
                <img alt="footer-google" src="../../resources/social/google.svg">
            </a>
            <!-- Instagram -->
            <a class="m-1 footer-item" href="#" role="button">
                <img alt="footer-google" src="../../resources/social/instagram.svg">
            </a>
        </section>
    </div>
    <div class="text-center p-3 bg-dark">
        © 2021 Internet:
        <a class="text-white"></a>
    </div>
</footer>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
        crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/script.js"></script>
</body>
</html>

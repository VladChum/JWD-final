<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="locale" value="${empty cookie['locale'].getValue() ? 'en' : cookie['locale'].getValue() }"/>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="locale" />
<!doctype html>
<html lang="${locale}">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="stylesheet" href="../../resources/css/style.css">

    <title>Tariff</title>
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
                        <button class="dropdown-item locale" data-locale="be" type="button">BE</button>
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
                            <li><a class="dropdown-item" href="Controller?command=personalAccount">
                                <fmt:message key="page.home.navbar.button.personalaccount"/></a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="Controller?command=signOut">
                                <fmt:message key="page.home.navbar.button.signout"/></a></li>
                        </ul>
                    </div>
                </c:if>
            </div>
        </div>
    </header>
</div>

<div id="content" class="container">
    <div class="tariff-title">
        <h1><fmt:message key="page.tariff.title"/></h1>
    </div>
    <div class="row row-cols-1 row-cols-md-3 g-4">
        <c:forEach items="${tariffPlans}" var="tariffPlan">
            <c:if test="${tariffPlan.active == 'true'}">
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
                                <span><b>
                                        ${tariffPlan.price}
                                </b> <fmt:message key="tariff.card.amount"/></span>
                                </div>
                                <div class="tariff-item__btns">
                                    <a class="button-tariff js-open-popup" href="Controller?command=tariffPageButton"
                                       data-title="подключение"><fmt:message key="tariff.card.link"/></a>
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
<br><br>
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
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script src="../../resources/js/script.js"></script>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
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
                    <li><a href="Controller?command=homePage" class="nav-link px-2 text-white me-3">Home</a></li>
                    <li><a href="Controller?command=tariffPage" class="nav-link px-2 text-white me-3">Tariff</a></li>
                    <li><a href="Controller?command=aboutPage" class="nav-link px-2 text-white me-3">About</a></li>
                </ul>
                <div class="dropdown">
                    <button class="btn btn-outline-light dropdown-toggle me-3" type="button" id="languageMenu"
                            data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        RU
                    </button>
                    <div class="dropdown-menu" aria-labelledby="languageMenu">
                        <button class="dropdown-item" type="button">RU</button>
                        <button class="dropdown-item" type="button">BE</button>
                        <button class="dropdown-item" type="button">EN</button>
                    </div>
                </div>
                <a href="Controller?command=loginPage">
                    <button type="button" class="btn btn-primary">Login</button>
                </a>
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
                                <b>
                                    <p>
                                        ${account.login}
                                    </p>
                                </b>
                            </div>
                        </div>
                        <div class="tariff-item__body">
                            <div>
                                <div class="tariff-item__price">
                                    <div class="balance-user">
                                        Баланс : <b>
                                        ${user.balance}
                                    </b> руб
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
                                    Cчёт
                                </button>
                                <button type="button"
                                        class="nav-link btn-user btn-outline-primary tarrifs-filter__item tarrifs-filter__item--bundle ng-star-inserted"
                                        id="tariffs-tab" data-bs-toggle="pill"
                                        data-bs-target="#tariffs" role="tab" aria-controls="tariffs"
                                        aria-selected="false">
                                    Тарифы
                                </button>
                                <button type="button"
                                        class="nav-link btn-user btn-outline-primary tarrifs-filter__item tarrifs-filter__item--wallet ng-star-inserted"
                                        id="payment-tab" data-bs-toggle="pill"
                                        data-bs-target="#payment" role="tab" aria-controls="payment"
                                        aria-selected="false">
                                    Платежи
                                </button>
                                <button type="button"
                                        class="nav-link btn-user btn-outline-primary tarrifs-filter__item tarrifs-filter__item--sails ng-star-inserted"
                                        id="stock-tab" data-bs-toggle="pill"
                                        data-bs-target="#stock" role="tab" aria-controls="payment"
                                        aria-selected="false">
                                    Акции
                                </button>
                                <button type="button"
                                        class="nav-link btn-user btn-outline-primary tarrifs-filter__item tarrifs-filter__item--help ng-star-inserted"
                                        id="help-tab" data-bs-toggle="pill"
                                        data-bs-target="#help" role="tab" aria-controls="help"
                                        aria-selected="false">
                                    Помощь
                                </button>
                                <button type="button"
                                        class="nav-link btn-user btn-outline-primary tarrifs-filter__item tarrifs-filter__item--sating ng-star-inserted"
                                        id="settings-tab" data-bs-toggle="pill"
                                        data-bs-target="#settings" role="tab" aria-controls="settings"
                                        aria-selected="false">
                                    Настройки
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
                                    <div class="tariff-item__title">
                                        <h5 class="card-title">Абонент : Чумачёв Владислав Константинович</h5>
                                    </div>
                                    <div class="tariff-item__title">
                                        <h5 class="card-title">Логин : 1561001453502</h5>
                                    </div>
                                    <div class="tariff-item__title">
                                        <h5 class="card-title">Статус : не блокирован</h5>
                                    </div>
                                    <div class="tariff-item__title">
                                        <c:set var="subscription" value="${subscription}"/>
                                        <h5 class="card-title">
                                            ${subscription.startDate}
                                        </h5>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane fade show" id="tariffs" role="tabpanel">
                                <div class="tariff-item__top">
                                    <div class="row row-cols-1 row-cols-md-3 g-4">
                                        <c:forEach items="${tariffPlans}" var="tariffPlan">
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
                                                                    <p>Проводное подключение по Ethernet </p>
                                                                    <p>Безлимит
                                                                            ${tariffPlan.speed}
                                                                        Мбит/с </p>
                                                                    <p>Keenetic Speedster 2.4 + 5 ГГц </p>
                                                                </div>
                                                            </div>
                                                            <div class="tariff-item__body">
                                                                <div class="tariff-item__price">
                                                                    <span>
                                                                        <b>
                                                                                ${tariffPlan.price}
                                                                        </b>
                                                                        руб/мес
                                                                    </span>
                                                                </div>
                                                                <c:if test="${tariffPlan.id != subscription.tariffPlanId}">
                                                                    <div class="tariff-item__btns">
                                                                        <a href="Controller?command=updateTariff"
                                                                           class="button-tariff js-open-popup"
                                                                           data-id="single"
                                                                           data-title="подключение">Подключить</a>
                                                                    </div>
                                                                </c:if>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>

                            <div class="tab-pane fade show" id="payment" role="tabpanel">
                                <div class="tariff-item__top">
                                    <div class="tariff-item__title">
                                        <h5 class="card-title">Абонент : Чумачёв Владислав Константинович</h5>
                                    </div>
                                    <div class="tariff-item__title">
                                        <h5 class="card-title">Логин : 1561001453502</h5>
                                    </div>
                                    <div class="tariff-item__title">
                                        <h5 class="card-title">Статус : не блокирован</h5>
                                    </div>
                                    <div class="tariff-item__title">
                                        <h5 class="card-title">Дата активации : 11.03.2021 02:37:21</h5>
                                    </div>
                                </div>
                            </div>

                            <div class="tab-pane fade show" id="stock" role="tabpanel">
                                <div class="tariff-item__top">
                                    <div class="tariff-item__title">
                                        <h5 class="card-title">Абонент : Чумачёв Владислав Константинович</h5>
                                    </div>
                                    <div class="tariff-item__title">
                                        <h5 class="card-title">Логин : 1561001453502</h5>
                                    </div>
                                    <div class="tariff-item__title">
                                        <h5 class="card-title">Статус : не блокирован</h5>
                                    </div>
                                    <div class="tariff-item__title">
                                        <h5 class="card-title">Дата активации : 11.03.2021 02:37:21</h5>
                                    </div>
                                </div>
                            </div>

                            <div class="tab-pane fade show" id="help" role="tabpanel">
                                <div class="tariff-item__top">
                                    <div class="tariff-item__title">
                                        <h5 class="card-title">Абонент : Чумачёв Владислав Константинович</h5>
                                    </div>
                                    <div class="tariff-item__title">
                                        <h5 class="card-title">Логин : 1561001453502</h5>
                                    </div>
                                    <div class="tariff-item__title">
                                        <h5 class="card-title">Статус : не блокирован</h5>
                                    </div>
                                    <div class="tariff-item__title">
                                        <h5 class="card-title">Дата активации : 11.03.2021 02:37:21</h5>
                                    </div>
                                </div>
                            </div>

                            <div class="tab-pane fade show" id="settings" role="tabpanel">
                                <div class="tariff-item__top">
                                    <div class="tariff-item__title">
                                        <h5 class="card-title">Абонент : Чумачёв Владислав Константинович</h5>
                                    </div>
                                    <div class="tariff-item__title">
                                        <h5 class="card-title">Логин : 1561001453502</h5>
                                    </div>
                                    <div class="tariff-item__title">
                                        <h5 class="card-title">Статус : не блокирован</h5>
                                    </div>
                                    <div class="tariff-item__title">
                                        <h5 class="card-title">Дата активации : 11.03.2021 02:37:21</h5>
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
</body>
</html>

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
    <title>admin</title>
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

<div id="content" class="container">
    <br>
    <br>
    <div class="row row-cols-1">
        <div class="col-sm-3">
            <div class="card-user">
                <div class="card-body">
                    <div class="tariff-item">
                        <div class="tariff-item__body">
                            <img src="../../resources/admin.jpg" class="card-img-top" alt="...">
                            <hr class="featurette-divider">
                            <div class="nav" id="v-pills-tab" role="tablist"
                                 aria-orientation="vertical">
                                <button type="button"
                                        class="nav-link active btn-user btn-outline-primary tarrifs-filter__item admin-filter__item--user ng-star-inserted"
                                        id="users-tab" data-bs-toggle="pill"
                                        data-bs-target="#users" role="tab" aria-controls="users"
                                        aria-selected="true">
                                    Пользователи
                                </button>
                                <button type="button"
                                        class="nav-link btn-user btn-outline-primary tarrifs-filter__item admin-filter__item--statistics ng-star-inserted"
                                        id="statistics-tab" data-bs-toggle="pill"
                                        data-bs-target="#statistics" role="tab" aria-controls="statistics"
                                        aria-selected="false">
                                    Статистика
                                </button>
                                <button type="button"
                                        class="nav-link btn-user btn-outline-primary tarrifs-filter__item tarrifs-filter__item--bundle ng-star-inserted"
                                        id="tariffs-tab" data-bs-toggle="pill"
                                        data-bs-target="#tariffs" role="tab" aria-controls="tariffs"
                                        aria-selected="false">
                                    Тарифы
                                </button>
                                <button type="button"
                                        class="nav-link btn-user btn-outline-primary tarrifs-filter__item tarrifs-filter__item--sails ng-star-inserted"
                                        id="stock-tab" data-bs-toggle="pill"
                                        data-bs-target="#stock" role="tab" aria-controls="stock"
                                        aria-selected="false">
                                    Акции
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
                            <div class="tab-pane fade show active" id="users" role="tabpanel">
                                <%--                               tariff button--%>
                                <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
                                    <li class="nav-item" role="presentation">
                                        <button class="nav-link active" id="pills-home-tab" data-bs-toggle="pill"
                                                data-bs-target="#pills-home" type="button" role="tab"
                                                aria-controls="pills-home" aria-selected="true">пользователи
                                        </button>
                                    </li>
                                    <li class="nav-item" role="presentation">
                                        <button class="nav-link" id="pills-profile-tab" data-bs-toggle="pill"
                                                data-bs-target="#pills-profile" type="button" role="tab"
                                                aria-controls="pills-profile" aria-selected="false">админы
                                        </button>
                                    </li>
                                    <li class="nav-item" role="presentation">
                                        <button class="nav-link" id="pills-contact-tab" data-bs-toggle="pill"
                                                data-bs-target="#pills-contact" type="button" role="tab"
                                                aria-controls="pills-contact" aria-selected="false">заблокированные
                                        </button>
                                    </li>
                                </ul>
                                <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                                    <div class="dropdown">
                                        <button class="btn add-button me-3" type="button"
                                                id="add"
                                                data-bs-toggle="dropdown" aria-haspopup="true"
                                                aria-expanded="false">
                                            +
                                        </button>
                                        <div class="dropdown-menu" aria-labelledby="add">
                                            <button class="dropdown-item " type="button"
                                                    data-bs-toggle="modal" data-bs-target="#newUserForm">добавить
                                                пользователя
                                            </button>
                                            <button class="dropdown-item" type="button" data-bs-toggle="modal"
                                                    data-bs-target="#newAdminForm">добавить админа
                                            </button>
                                        </div>
                                    </div>
                                </div>
                                <%--                                    modal add user--%>
                                <div class="modal fade" id="newUserForm" data-bs-backdrop="static"
                                     data-bs-keyboard="false" tabindex="-1"
                                     aria-hidden="true">
                                    <div class="modal-dialog modal-lg">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="newUser">add User</h5>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                        aria-label="Close"></button>
                                            </div>
                                            <div class="modal-body">
                                                <br>
                                                <h6>login</h6>
                                                <input id="newUserCreateLogin" name="login" class="form-control"
                                                       placeholder="login">
                                                <div id="errorLoginUser" class="errorMassage"></div>
                                                <br>
                                                <h6>password</h6>
                                                <input type="password" name="password" class="form-control"
                                                       id="newUserCreatePassword"
                                                       placeholder="password">
                                                <div id="errorPasswordUser" class="errorMassage"></div>
                                                <br>
                                                <h6>имя</h6>
                                                <input name="firstName" class="form-control"
                                                       id="newUserFirstName"
                                                       placeholder="first name">
                                                <div id="errorFirstNameUser" class="errorMassage"></div>
                                                <br>
                                                <h6>Фамилия</h6>
                                                <input class="form-control"
                                                       id="newUserLastName"
                                                       placeholder="last name">
                                                <div class="errorMassage" id="errorLastNameUser"></div>
                                                <br>
                                                <h6>мобильный номер</h6>
                                                <input class="form-control"
                                                       id="newUserPhone"
                                                       placeholder="phone">
                                                <div id="errorPhoneUser" class="errorMassage"></div>
                                                <br>
                                                <h6>e-mail</h6>
                                                <input class="form-control"
                                                       id="newUserEmail"
                                                       placeholder="e-mail">
                                                <div id="errorEmailUser" class="errorMassage"></div>
                                                <br>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" id="closeCreateUserModal"
                                                        class="btn btn-secondary" data-bs-dismiss="modal">
                                                    отмена
                                                </button>
                                                <button type="button" id="createUserButton" class="btn btn-primary">
                                                    добавить пользователя
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <%--                                    new admin form--%>
                                <div class="modal fade" id="newAdminForm" data-bs-backdrop="static"
                                     data-bs-keyboard="false" tabindex="-1"
                                     aria-hidden="true">
                                    <div class="modal-dialog modal-lg">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="newAdmin">new Admin</h5>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                        aria-label="Close"></button>
                                            </div>
                                            <div class="modal-body">
                                                <br>
                                                <h6>login</h6>
                                                <input id="newAdminCreateLogin" name="login" class="form-control"
                                                       placeholder="login">
                                                <div id="errorLoginAdmin" class="errorMassage"></div>
                                                <br>
                                                <h6>password</h6>
                                                <input type="password" name="password" class="form-control"
                                                       id="newAdminCreatePassword"
                                                       placeholder="password">
                                                <div id="errorPasswordAdmin" class="errorMassage"></div>
                                                <br>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" id="closeCreateAdminModal"
                                                        class="btn btn-secondary" data-bs-dismiss="modal">
                                                    отмена
                                                </button>
                                                <button type="button" id="createAdminButton" class="btn btn-primary">
                                                    добавить админа
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <%--                                    --%>
                                <div class="tab-content" id="pills-tabContent">
                                    <%--                                    user table--%>
                                    <div class="tab-pane fade show active" id="pills-home" role="tabpanel"
                                         aria-labelledby="pills-home-tab">
                                        <table class="table table-striped table-hover">
                                            <thead>
                                            <tr>
                                                <th scope="col">имя</th>
                                                <th scope="col">фамилия</th>
                                                <th scope="col">статус</th>
                                                <th scope="col">баланс</th>
                                            </tr>
                                            <tbody>
                                            <c:forEach items="${users}" var="user">
                                                <tr>
                                                    <td>${user.firstName}</td>
                                                    <td>${user.lastName}</td>
                                                    <td>${user.status}</td>
                                                    <td>${user.balance}</td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                            </thead>
                                        </table>
                                    </div>
                                    <%--                                    admin table--%>
                                    <div class="tab-pane fade" id="pills-profile" role="tabpanel"
                                         aria-labelledby="pills-profile-tab">
                                        <table class="table table-striped table-hover">
                                            <thead>
                                            <tr>
                                                <th scope="col">account id</th>
                                                <th scope="col">login</th>
                                                <th></th>
                                            </tr>
                                            <tbody>
                                            <c:forEach items="${admins}" var="admin">
                                                <tr>
                                                    <td>${admin.id}</td>
                                                    <td>${admin.login}</td>
                                                    <td>
                                                        <button>
                                                            удалить
                                                        </button>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                            </thead>
                                        </table>
                                    </div>
                                    <%--                                    baned users--%>
                                    <div class="tab-pane fade" id="pills-contact" role="tabpanel"
                                         aria-labelledby="pills-contact-tab">
                                        <table class="table table-striped">
                                            <thead>
                                            <tr>
                                                <th scope="col">имя</th>
                                                <th scope="col">фамилия</th>
                                                <th scope="col">статус</th>
                                                <th scope="col">баланс</th>
                                                <th></th>
                                                <th></th>
                                            </tr>
                                            <tbody class="table-danger">
                                            <c:forEach items="${users}" var="user">
                                                <c:if test="${user.status == \"BANNED\"}">
                                                    <tr>
                                                        <td>${user.firstName}</td>
                                                        <td>${user.lastName}</td>
                                                        <td class="color: #D90707">${user.status}</td>
                                                        <td>${user.balance}</td>
                                                        <td>
                                                            <button>
                                                                разблокировать
                                                            </button>
                                                        </td>
                                                        <td>
                                                            <button>
                                                                удалить
                                                            </button>
                                                        </td>
                                                    </tr>
                                                </c:if>
                                            </c:forEach>
                                            </tbody>
                                            </thead>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane fade show" id="statistics" role="tabpanel">
                                <div class="tariff-item__title">
                                    <h5 class="card-title">Абонент : Чумачёв Владислав Константинович</h5>
                                </div>
                                <div class="tariff-item__title">
                                    <h5 class="card-title">Логин : 1561001453502</h5>
                                </div>
                                <div class="tariff-item__title">
                                    <h5 class="card-title">Статус :</h5>
                                </div>
                                <div class="tariff-item__title">
                                    <h5 class="card-title">Дата активации : 11.03.2021 02:37:21</h5>
                                </div>
                            </div>
                            <%--                            tariffs--%>
                            <div class="tab-pane fade show" id="tariffs" role="tabpanel">
                                <ul class="nav nav-pills mb-3" id="tariff-tab" role="tablist">
                                    <li class="nav-item" role="presentation">
                                        <button class="nav-link active" id="active-tab" data-bs-toggle="pill"
                                                data-bs-target="#active-tariffs" type="button" role="tab"
                                                aria-selected="false">активные тарифы
                                        </button>
                                    </li>
                                    <li class="nav-item" role="presentation">
                                        <button class="nav-link" id="archive-tab" data-bs-toggle="pill"
                                                data-bs-target="#archive-tariffs" type="button" role="tab"
                                                aria-selected="false">архив
                                        </button>
                                    </li>
                                </ul>
                                <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                                    <button class="btn add-tariff-button me-3" type="button"
                                            id="addTariff"
                                            aria-expanded="false">
                                        +
                                    </button>
                                </div>
                                <%--                                tariff cards--%>
                                <div class="tab-content" id="pills-tariffs">
                                    <div class="tab-pane fade show active" id="active-tariffs" role="tabpanel">
                                        <div class="tariff-item__top">
                                            <div class="row row-cols-1 row-cols-md-3 g-4">
                                                <c:forEach items="${tariffs}" var="tariff">
                                                    <c:if test="${tariff.active == 'true'}">
                                                        <div class="col-sm-6">
                                                            <div class="card">
                                                                <div class="card-body">
                                                                    <div class="tariff-item">
                                                                        <div class="tariff-item__top">
                                                                            <div class="tariff-item__title">
                                                                                <h5 class="card-title">
                                                                                        ${tariff.name}
                                                                                </h5>
                                                                            </div>
                                                                            <div class="tariff-item__text">
                                                                                <p>Проводное подключение по
                                                                                    Ethernet </p>
                                                                                <p>Безлимит
                                                                                        ${tariff.speed}
                                                                                    Мбит/с </p>
                                                                                <p>Keenetic Speedster 2.4 + 5 ГГц </p>
                                                                            </div>
                                                                        </div>
                                                                        <div class="tariff-item__body">
                                                                            <div class="tariff-item__price">
                                                                    <span>
                                                                        <b>
                                                                                ${tariff.price}
                                                                        </b>
                                                                        руб/мес
                                                                    </span>
                                                                            </div>
                                                                            <div class="dropdown">
                                                                                <button class="btn button-tariff  me-3"
                                                                                        type="button" id="tariffMenu"
                                                                                        data-bs-toggle="dropdown"
                                                                                        aria-haspopup="true"
                                                                                        aria-expanded="false">
                                                                                    изменить
                                                                                </button>
                                                                                <div class="dropdown-menu">
                                                                                    <button class="dropdown-item"
                                                                                            type="button">
                                                                                        изменить
                                                                                    </button>
                                                                                    <button class="dropdown-item"
                                                                                            type="button">
                                                                                        удалить
                                                                                    </button>
                                                                                </div>
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
                                    <div class="tab-pane fade" id="archive-tariffs" role="tabpanel">
                                        <div class="tariff-item__top">
                                            <div class="row row-cols-1 row-cols-md-3 g-4">
                                                <c:forEach items="${tariffs}" var="tariff">
                                                    <c:if test="${tariff.active == 'false'}">
                                                        <div class="col-sm-6">
                                                            <div class="card">
                                                                <div class="card-body">
                                                                    <div class="tariff-item">
                                                                        <div class="tariff-item__top">
                                                                            <div class="tariff-item__title">
                                                                                <h5 class="card-title">
                                                                                        ${tariff.name}
                                                                                </h5>
                                                                            </div>
                                                                            <div class="tariff-item__text">
                                                                                <p>Проводное подключение по
                                                                                    Ethernet </p>
                                                                                <p>Безлимит
                                                                                        ${tariff.speed}
                                                                                    Мбит/с </p>
                                                                                <p>Keenetic Speedster 2.4 + 5 ГГц </p>
                                                                            </div>
                                                                        </div>
                                                                        <div class="tariff-item__body">
                                                                            <div class="tariff-item__price">
                                                                                <span>
                                                                                    <b>
                                                                                            ${tariff.price}
                                                                                    </b>
                                                                                    руб/мес
                                                                                </span>
                                                                            </div>
                                                                            <div class="dropdown">
                                                                                <button class="btn button-tariff  me-3"
                                                                                        type="button" id="archiveTariffMenu"
                                                                                        data-bs-toggle="dropdown"
                                                                                        aria-haspopup="true"
                                                                                        aria-expanded="false">
                                                                                    изменить
                                                                                </button>
                                                                                <div class="dropdown-menu">
                                                                                    <button class="dropdown-item"
                                                                                            type="button">
                                                                                        изменить
                                                                                    </button>
                                                                                    <button class="dropdown-item"
                                                                                            type="button">
                                                                                        активировать
                                                                                    </button>
                                                                                </div>
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
                            </div>
                            <div class="tab-pane fade show" id="stock" role="tabpanel">
                                <div class="tariff-item__title">
                                    <h5 class="card-title">Абонент : Чумачёв Константинович</h5>
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
                            <div class="tab-pane fade show" id="settings" role="tabpanel">
                                <div class="tariff-item__title">
                                    <h5 class="card-title">Абонент : Владислав Константинович</h5>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/script.js"></script>
</body>
</html>

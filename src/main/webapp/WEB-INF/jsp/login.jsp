<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="../../resources/css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">


    <title>login</title>
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
                <c:if test="${account.login == null}">
                    <a href="Controller?command=loginPage">
                        <button type="button" class="btn btn-primary">Login</button>
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
                            <li><a class="dropdown-item" href="Controller?command=personalAccount">личный кабинет</a>
                            </li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li><a class="dropdown-item" href="Controller?command=signOut">Sign out</a></li>
                        </ul>
                    </div>
                </c:if>
            </div>
        </div>
    </header>
</div>
<div class="login-color">
    <div class="position-signIn">
        <div class="row row-cols-1 row-cols-md-12 g-10">
            <div class="col-sm-7">
                <div class="card">
                    <main class="form-signin">
                        <form id="loginPage" method="post" action="/Controller?command=signIn">
                            <h1 class="h3 mb-3 fw-normal ">Sign in</h1>
                            <div class="form-floating">
                                <input type="login" name="login" class="form-control" id="login"
                                       placeholder="name@example.com">
                                <label for="login">Login</label>
                            </div>
                            <br>
                            <div class="form-floating">
                                <input type="password" name="password" class="form-control" id="floatingPassword"
                                       placeholder="Password">
                                <label for="floatingPassword">Password</label>
                            </div>
                            <br>
                            <span id="msg"></span>
                            <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
                            <hr class="my-4">
                            <small class="text-muted"><a id="registerNewAccount" data-bs-toggle="modal" type="button"
                                                         data-bs-target="#registerNewUser">Register new
                                account</a></small>
                        </form>
                    </main>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="registerNewUser" data-bs-backdrop="static"
     data-bs-keyboard="false" tabindex="-1"
     aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="newUser">Register new User</h5>
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
                <button type="button" id="closeRegisterUser"
                        class="btn btn-secondary" data-bs-dismiss="modal">
                    отмена
                </button>
                <button type="button" id="registerNewUserAccount" class="btn btn-primary">
                    зарегистрироваться
                </button>
            </div>
        </div>
    </div>
</div>
<footer class="bg-dark text-center text-white mt-auto">
    <div class="container p-4 pb-0">
        <section class="d-flex justify-content-center footer-items mb-4">
            <!-- Facebook -->
            <a class="m-1 footer-item" href="#" role="button">
                <img class="mx-auto" alt="footer-facebook" src="../resources/social/facebook.svg">
            </a>
            <!-- Twitter -->
            <a class="m-1 footer-item" href="#" role="button" 0>
                <img alt="footer-twitter" src="../resources/social/twitter.svg">
            </a>
            <!-- Google -->
            <a class="m-1 footer-item" href="#" role="button">
                <img alt="footer-google" src="../resources/social/google.svg">
            </a>
            <!-- Instagram -->
            <a class="m-1 footer-item" href="#" role="button">
                <img alt="footer-google" src="../resources/social/instagram.svg">
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

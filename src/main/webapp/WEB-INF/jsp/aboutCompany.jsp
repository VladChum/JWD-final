<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
    <title>AboutCompany</title>
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
                    <li><a href="Controller?command=homePage" class="nav-link px-2 text-white me-3">
                        <fmt:message key="page.home.navbar.link.home"/></a></li>
                    <li><a href="Controller?command=tariffPage" class="nav-link px-2 text-white me-3">
                        <fmt:message key="page.home.navbar.link.tariffs"/></a></li>
                    <li><a href="Controller?command=aboutPage" class="nav-link px-2 text-white me-3">
                        <fmt:message key="page.home.navbar.link.about"/></a></li>
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
                        <button type="button" class="btn btn-primary">
                            <fmt:message key="page.home.navbar.button.login"/></button>
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
<section class="about-page__first">
    <div class="container">
        <img alt="logo" src="../../resources/logo2.png">
        <div class="about-page__content"><p><fmt:message key="page.about.title"/></p></div>
    </div>
</section>
<section class="advantages-section">
    <div class="container">
        <div class="h2"><fmt:message key="page.about.card1.title"/></div>
        <div class="row">
            <div class="col-6 col-lg-4">
                <div class="advantage-item">
                    <div class="advantage-item__img"><img alt="icon" src="../../resources/p1.svg"></div>
                    <div class="advantage-item__title"><fmt:message key="page.about.card1.text1"/></div>
                    <div class="advantage-item__text"><p><fmt:message key="page.about.card1.text2"/></p></div>
                </div>
            </div>
            <div class="col-6 col-lg-4">
                <div class="advantage-item">
                    <div class="advantage-item__img"><img alt="icon" src="../../resources/p2.svg"></div>
                    <div class="advantage-item__title"><fmt:message key="page.about.card2.text1"/></div>
                    <div class="advantage-item__text"><p><fmt:message key="page.about.card2.text2" /></p></div>
                </div>
            </div>
            <div class="col-6 col-lg-4">
                <div class="advantage-item">
                    <div class="advantage-item__img"><img alt="icon" src="../../resources/p3.svg"></div>
                    <div class="advantage-item__title"><fmt:message key="page.about.card3.text1"/></div>
                    <div class="advantage-item__text"><p><fmt:message key="page.about.card3.text2"/></p></div>
                </div>
            </div>
        </div>
        <div class="h2"><fmt:message key="page.about.contacts.title"/></div>
        <div class="b-contact-info__item">
            <div class="b-contact-info__item-col">
                <div class="b-contact-info__title"><fmt:message key="page.about.phone_info"/></div>
            </div>
            <div class="b-contact-info__item-col">
                <div class="b-contact-info__phone">
                    <div class="b-contact-info__phone-item b-contact-info__phone-number">0890</div>
                    <div class="b-contact-info__phone-item b-contact-info__phone-code">7777</div>
                </div>
            </div>
            <div class="b-contact-info__item-col">
                <div class="b-contact-info__phone-item b-contact-info__phone-number">
                    <a>8 017 237-98-98</a>
                </div>
                <div class="b-contact-info__helper"><fmt:message key="page.about.contact_info1"/></div>
            </div>
        </div>
        <div class="b-contact-info__item">
            <div class="b-contact-info__item-col">
                <div class="b-contact-info__title"><fmt:message key="page.about.contact_info2"/></div>
            </div>
            <div class="b-contact-info__item-col">
                <div class="b-contact-info__phone">
                    <div class="b-contact-info__phone-item b-contact-info__phone-number">0990</div>
                    <div class="b-contact-info__phone-item b-contact-info__phone-code">8888</div>
                </div>
            </div>
            <div class="b-contact-info__item-col">
                <div class="b-contact-info__phone-item b-contact-info__phone-number">
                    <a>8 017 237-98-91</a>
                </div>
                <div class="b-contact-info__helper"><fmt:message key="page.about.contact_info1"/></div>
            </div>
        </div>
    </div>
</section>
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

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
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
                            <img src="../resources/user/account.svg" alt="mdo" width="32" height="32"
                                 class="rounded-circle">
                        </a>
                        <ul class="account-menu dropdown-menu text-small">
                            <li><a class="dropdown-item" href="Controller?command=personalAccount">личный кабинет</a></li>
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
<section class="about-page__first">
    <div class="container">
        <img alt="logo" src="../../resources/logo2.png">
        <div class="about-page__content">
            <p>Мы — группа интернет-провайдеров, объединённых в общее информационное пространство. Целью создания NAME
                является обеспечение пользователей интернета разнообразными и удобными сервисами,
                преимущественно требующими больших объемов трафика.</p>
        </div>
    </div>
</section>
<section class="advantages-section">
    <div class="container">
        <div class="h2">Наши преимущества</div>
        <div class="row">
            <div class="col-6 col-lg-4">
                <div class="advantage-item">
                    <div class="advantage-item__img"><img alt="icon" src="../../resources/p1.svg"></div>
                    <div class="advantage-item__title">Большой выбор тарифов от 30 до 300 Мбит/с</div>
                    <div class="advantage-item__text"><p>Мы придумали оптимальный набор тарифов для любого пользователя
                        по цене и скорости. Всё включённое в тарифы проводного интернета оборудование выдаётся бесплатно
                        на время действия договора. На тарифах беспроводного интернета оборудование можно взять в аренду
                        или приобрести.</p></div>
                </div>
            </div>
            <div class="col-6 col-lg-4">
                <div class="advantage-item">
                    <div class="advantage-item__img"><img alt="icon" src="../../resources/p2.svg"></div>
                    <div class="advantage-item__title">Равная входящая и исходящая скорости</div>
                    <div class="advantage-item__text"><p>Мы предоставляем одинаковую скорость в обоих направлениях, не
                        ограничивая исходящую скорость по сравнению с входящей, как часто делают другие провайдеры. Это
                        позволяет быстрее не только скачивать файлы, но и загружать.</p></div>
                </div>
            </div>
            <div class="col-6 col-lg-4">
                <div class="advantage-item">
                    <div class="advantage-item__img"><img alt="icon" src="../../resources/p3.svg"></div>
                    <div class="advantage-item__title">Безлимитный трафик на всех тарифах
                    </div>
                    <div class="advantage-item__text"><p>На наших тарифных планах нет ограничений по трафику. Скачивайте
                        и загружайте сколько угодно!</p></div>
                </div>
            </div>
        </div>
        <div class="h2">Контакты</div>
        <div class="b-contact-info__item">
            <div class="b-contact-info__item-col">
                <div class="b-contact-info__title">Услуги домашнего интернета</div>
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
                <div class="b-contact-info__helper">Круглосуточно</div>
            </div>
        </div>
        <div class="b-contact-info__item">
            <div class="b-contact-info__item-col">
                <div class="b-contact-info__title">Услуги подключения</div>
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
                <div class="b-contact-info__helper">Круглосуточно</div>
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
</body>
</html>

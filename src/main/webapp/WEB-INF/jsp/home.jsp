<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

    <title>Home</title>
</head>
<body class="d-flex flex-column min-vh-100">
<div9 class="intro">
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
</div9>

<div class="text-white">
    <img src="../../resources/1.png" class="card-img" alt="...">
    <div class="img-text">
        <h1 class="card-title"><fmt:message key="page.home.text.title"/></h1>
        <div class="banner-item__text"><p><fmt:message key="page.home.text.title2"/></p>
            <p><fmt:message key="page.home.text.title3"/></p>
            <p><fmt:message key="page.home.text.title4"/></p></div>
        <div class="banner-item__btn">
            <a class="button primary" href="Controller?command=tariffPage">
                <fmt:message key="page.home.button.tariffs"/></a>
        </div>
    </div>
</div>

<div id="content" class="container">
    <!--    <div class="container bg-light ">-->
    <br>
    <br>
    <div class="card border-dark mb-12">
        <div class="card-header">
            <h2><fmt:message key="page.home.card1.title"/></h2>
        </div>
        <div class="card-body text-dark">
            <p><fmt:message key="page.home.card1.text1"/></p>
            <p><fmt:message key="page.home.card1.text2"/></p>
        </div>
    </div>
    <br>
    <div class="row row-cols-1 row-cols-md-3 g-4">
        <div class="col">
            <div class="card">
                <img src="../../resources/card1.png" class="card-img-top" alt="...">
                <div class="card-body">
                    <h2><fmt:message key="page.home.card2.title"/></h2>
                    <p><fmt:message key="page.home.card2.text1"/></p>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card">
                <img src="../../resources/card2.png" class="card-img-top" alt="...">
                <div class="card-body">
                    <h2><fmt:message key="page.home.card3.title"/></h2>
                    <p>
                        <br>
                    <p><fmt:message key="page.home.card3.text1"/></p>
                    <fmt:message key="page.home.card3.text2"/>
                    </p>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card">
                <img src="../../resources/card3.png" class="card-img-top" alt="...">
                <div class="card-body">
                    <h2><fmt:message key="page.home.card4.title"/></h2>
                    <p><fmt:message key="page.home.card4.text1"/></p>
                    <br>
                </div>
            </div>
        </div>
    </div>
    <br>
    <hr class="featurette-divider">
    <div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
        <h1 class="display-4"><fmt:message key="page.home.map"/></h1>
    </div>
    <div id="map"></div>
    <br>

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


<script>
    function initMap() {
        const uluru = {lat: 53.90203168912083, lng: 27.58330502875899};
        const map = new google.maps.Map(document.getElementById("map"), {
            zoom: 11,
            center: uluru,
        });
        const marker = new google.maps.Marker({
            position: uluru,
            map: map,

        });
        const marker2 = new google.maps.Marker({
            position: {lat: 53.920316891201, lng: 27.583300287581},
            map: map,

        });
        const DrozdyHospital = new google.maps.Marker({
            position: {lat: 53.96113485787171, lng: 27.43468433329121},
            map: map,
        });
        const house1 = new google.maps.Marker({
            position: {lat: 53.910457018131254, lng: 27.517141323598583},
            map: map,
        });
        const house2 = new google.maps.Marker({
            position: {lat: 53.912058588685355, lng: 27.540242686908496},
            map: map,
        });
        const KoronaShop = new google.maps.Marker({
            position: {lat: 53.907852042181695, lng: 27.5272375742927},
            map: map,
        });
        const house3 = new google.maps.Marker({
            position: {lat: 53.8812826767093, lng: 27.425758327403926},
            map: map,
        });
        const house4 = new google.maps.Marker({
            position: {lat: 53.87917628977942, lng: 27.45542301962639},
            map: map,
        });
        const Galleria = new google.maps.Marker({
            position: {lat: 53.90895471259554, lng: 27.54917532900177},
            map: map,
        });
        const A1Office = new google.maps.Marker({
            position: {lat: 53.90396482108508, lng: 27.562208790111242},
            map: map,
        });
        const BSU = new google.maps.Marker({
            position: {lat: 53.89217231734216, lng: 27.54863991510809},
            map: map,
        });
        const house5 = new google.maps.Marker({
            position: {lat: 53.88392891858225, lng: 27.538723633776957},
            map: map,
        });
        const house6 = new google.maps.Marker({
            position: {lat: 53.88151342623953, lng: 27.537383882520775},
            map: map,
        });
        const house7 = new google.maps.Marker({
            position: {lat: 53.881367259006986, lng: 27.569582360540252},
            map: map,
        });
        const house8 = new google.maps.Marker({
            position: {lat: 53.85051921503822, lng: 27.527957330938992},
            map: map,
        });
        const house9 = new google.maps.Marker({
            position: {lat: 53.86054104269932, lng: 27.57420611294813},
            map: map,
        });
        const house10 = new google.maps.Marker({
            position: {lat: 53.84453008968254, lng: 27.63843907935474},
            map: map,
        });
        const BSUIR4 = new google.maps.Marker({
            position: {lat: 53.911934110034366, lng: 27.594906271897365},
            map: map,
        });
        const house11 = new google.maps.Marker({
            position: {lat: 53.90821995721282, lng: 27.62662945744871},
            map: map,
        });
        const house12 = new google.maps.Marker({
            position: {lat: 53.88979453828756, lng: 27.68443173416516},
            map: map,
        });
        const EPAMOffice = new google.maps.Marker({
            position: {lat: 53.92841255293204, lng: 27.68516680881007},
            map: map,
        });
        const house13 = new google.maps.Marker({
            position: {lat: 53.950790478505006, lng: 27.62222606006937},
            map: map,
        });
        const house14 = new google.maps.Marker({
            position: {lat: 53.96966804382403, lng: 27.584905561045794},
            map: map,
        });
        const house15 = new google.maps.Marker({
            position: {lat: 53.83741156643649, lng: 27.625530364014462},
            map: map,
        });
        const PalaceIndependence = new google.maps.Marker({
            position: {lat: 53.926965239647785, lng: 27.525277262468258},
            map: map,
        });
        const SupremeCourt = new google.maps.Marker({
            position: {lat: 53.93068861765062, lng: 27.524024785612454},
            map: map,
        });
        const house16 = new google.maps.Marker({
            position: {lat: 53.943600278980256, lng: 27.473199348789333},
            map: map,
        });
        const house17 = new google.maps.Marker({
            position: {lat: 53.943257516543696, lng: 27.477908797304472},
            map: map,
        });
        const house18 = new google.maps.Marker({
            position: {lat: 53.94523953864442, lng: 27.474136174569225},
            map: map,
        });
        const house19 = new google.maps.Marker({
            position: {lat: 53.94230372798484, lng: 27.48547936239065},
            map: map,
        });
        const PresidentHouse = new google.maps.Marker({
            position: {lat: 53.9825504665657, lng: 27.437897097604008},
            map: map,
        });
    }
</script>
<script
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBzDByA8tEm9xpakXNp6DqGlt1HiWYqfHc&callback=initMap&libraries=&v=weekly"
        async
></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
        crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script src="../../resources/js/script.js"></script>
</body>
</html>

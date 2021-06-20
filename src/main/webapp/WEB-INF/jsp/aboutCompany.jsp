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

<jsp:include page="general/navbar.jsp">
    <jsp:param name="locale" value="${locale}"/>
</jsp:include>

<section class="about-page__first">
    <div class="container">
        <img alt="logo" src="../../resources/general/logo2.png">
        <div class="about-page__content"><p><fmt:message key="page.about.title"/></p></div>
    </div>
</section>
<section class="advantages-section">
    <div class="container">
        <div class="h2"><fmt:message key="page.about.card1.title"/></div>
        <div class="row">
            <div class="col-6 col-lg-4">
                <div class="advantage-item">
                    <div class="advantage-item__img"><img alt="icon" src="../../resources/general/p1.svg"></div>
                    <div class="advantage-item__title"><fmt:message key="page.about.card1.text1"/></div>
                    <div class="advantage-item__text"><p><fmt:message key="page.about.card1.text2"/></p></div>
                </div>
            </div>
            <div class="col-6 col-lg-4">
                <div class="advantage-item">
                    <div class="advantage-item__img"><img alt="icon" src="../../resources/general/p2.svg"></div>
                    <div class="advantage-item__title"><fmt:message key="page.about.card2.text1"/></div>
                    <div class="advantage-item__text"><p><fmt:message key="page.about.card2.text2" /></p></div>
                </div>
            </div>
            <div class="col-6 col-lg-4">
                <div class="advantage-item">
                    <div class="advantage-item__img"><img alt="icon" src="../../resources/general/p3.svg"></div>
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
<jsp:include page="general/footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
        crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script src="../../resources/js/script.js"></script>
</body>
</html>

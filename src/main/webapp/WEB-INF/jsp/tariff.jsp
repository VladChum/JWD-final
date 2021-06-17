<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="locale" value="${empty cookie['locale'].getValue() ? 'en' : cookie['locale'].getValue() }"/>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="locale"/>
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

<jsp:include page="general/navbar.jsp">
    <jsp:param name="locale" value="${locale}"/>
</jsp:include>

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
                                            <fmt:message key="tariff.card.text3"/></p>
                                        <p><fmt:message key="tariff.card.text4"/></p>
                                    </div>
                                </div>
                                <div class="tariff-item__body">
                                    <div class="tariff-item__price">
                                <span><b>
                                        ${tariffPlan.price}
                                </b> <fmt:message key="tariff.card.amount"/></span>
                                    </div>
                                    <div class="tariff-item__btns">
                                        <a class="button-tariff js-open-popup"
                                           href="Controller?command=tariffPageButton"
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
<jsp:include page="general/footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
        crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script src="../../resources/js/script.js"></script>
</body>
</html>

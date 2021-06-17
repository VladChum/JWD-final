<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fm" uri="http://provider.com/jsp/tlds/phone" %>

<c:set var="locale" value="${empty cookie['locale'].getValue() ? 'en' : cookie['locale'].getValue() }"/>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="locale"/>
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
<jsp:include page="general/navbar.jsp">
    <jsp:param name="locale" value="${locale}"/>
</jsp:include>

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
                            <jsp:include page="user/menu.jsp"/>
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
                            <jsp:include page="user/account.jsp">
                                <jsp:param name="user" value="${user}"/>
                                <jsp:param name="account" value="${account}"/>
                            </jsp:include>
                            <div class="tab-pane fade show" id="tariffs" role="tabpanel">
                                <jsp:include page="user/tariffs.jsp">
                                    <jsp:param name="tariffPlans" value="${tariffPlans}"/>
                                    <jsp:param name="subscription" value="${subscription}"/>
                                </jsp:include>
                            </div>
                            <%--                            payment--%>
                            <jsp:include page="user/payment.jsp">
                                <jsp:param name="userPayments" value="${userPayments}"/>
                            </jsp:include>

                            <jsp:include page="user/cardForm.jsp"/>
                            <%--                            discount--%>
                            <div class="tab-pane fade show" id="stock" role="tabpanel">
                                <jsp:include page="user/discount.jsp">
                                    <jsp:param name="tariffPlans" value="${tariffPlans}"/>
                                    <jsp:param name="discounts" value="${discounts}"/>
                                    <jsp:param name="dateNow" value="${dateNow}"/>
                                </jsp:include>
                            </div>
                            <div class="tab-pane fade show" id="help" role="tabpanel">

                            </div>
                            <div class="tab-pane fade show" id="settings" role="tabpanel">
                                <jsp:include page="user/settings.jsp"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="general/footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
        crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/script.js"></script>
</body>
</html>

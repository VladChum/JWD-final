<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
    <title>admin</title>
</head>

<body class="d-flex flex-column min-vh-100">

<jsp:include page="general/navbar.jsp">
    <jsp:param name="locale" value="${locale}"/>
</jsp:include>

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
                            <jsp:include page="admin/menu.jsp"/>
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
                                <jsp:include page="admin/users.jsp">
                                    <jsp:param name="users" value="${users}"/>
                                    <jsp:param name="admins" value="${admins}"/>
                                </jsp:include>
                            </div>
                            <div class="tab-pane fade show" id="statistics" role="tabpanel">

                            </div>
                            <div class="tab-pane fade show" id="tariffs" role="tabpanel">
                                <jsp:include page="admin/tariffs.jsp">
                                    <jsp:param name="tariffs" value="${tariffs}"/>
                                </jsp:include>
                            </div>
                            <div class="tab-pane fade show" id="stock" role="tabpanel">
                                <jsp:include page="admin/discounts.jsp">
                                    <jsp:param name="discounts" value="${discounts}"/>
                                    <jsp:param name="dateNow" value="${dateNow}"/>
                                </jsp:include>
                            </div>
                            <jsp:include page="admin/updateDiscountForms.jsp">
                                <jsp:param name="tariffs" value="${tariffs}"/>
                            </jsp:include>
                            <div class="tab-pane fade show" id="settings" role="tabpanel">
                                <jsp:include page="admin/settings.jsp"/>
                            </div>
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

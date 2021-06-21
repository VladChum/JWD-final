<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="locale" value="${empty cookie['locale'].getValue() ? 'en' : cookie['locale'].getValue() }"/>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="locale"/>
<!doctype html>
<html lang="${locale}">
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
<jsp:include page="general/navbar.jsp">
    <jsp:param name="locale" value="${locale}"/>
</jsp:include>

<div class="login-color">
    <div class="position-signIn">
        <div class="row row-cols-1 row-cols-md-12 g-10">
            <div class="col-sm-7">
                <div class="card">
                    <main class="form-signin">
                        <h1 class="h3 mb-3 fw-normal "><fmt:message key="page.login.sign_in"/></h1>
                        <div class="form-floating">
                            <input type="login" name="login" class="form-control" id="loginLoginPage"
                                   placeholder="Login">
                            <label for="loginLoginPage"><fmt:message key="page.login.label.login"/></label>
                        </div>
                        <br>
                        <div class="form-floating">
                            <input type="password" name="password" class="form-control" id="floatingPassword"
                                   placeholder="Password">
                            <label for="floatingPassword"><fmt:message key="page.login.label.password"/></label>
                        </div>
                        <br>
                        <div id="errorLoginOrPassword" class="errorMassage"></div>
                        <span id="msg"></span>
                        <button class="w-100 btn btn-lg btn-primary" id="loginButton">
                            <fmt:message key="page.login.sign_in"/>
                        </button>
                        <hr class="my-4">
                        <small class="text-muted">
                            <a id="registerNewAccount" data-bs-toggle="modal" type="button"
                               data-bs-target="#registerNewUser">
                                <fmt:message key="page.login.link.register_new_account"/>
                            </a>
                        </small>
                    </main>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="registerNewUser" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="newUser"><fmt:message key="form.new_user.title"/></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <br>
                <h6><fmt:message key="form.new_user.login"/></h6>
                <input id="newUserCreateLogin" name="login" class="form-control" placeholder="login">
                <div id="errorLoginUser" class="errorMassage"></div>
                <br>
                <h6><fmt:message key="form.new_user.password"/></h6>
                <input type="password" name="password" class="form-control"
                       id="newUserCreatePassword"
                       placeholder="password">
                <div id="errorPasswordUser" class="errorMassage"></div>
                <br>
                <h6><fmt:message key="form.new_user.name"/></h6>
                <input name="firstName" class="form-control"
                       id="newUserFirstName"
                       placeholder="first name">
                <div id="errorFirstNameUser" class="errorMassage"></div>
                <br>
                <h6><fmt:message key="form.new_user.surname"/></h6>
                <input class="form-control"
                       id="newUserLastName"
                       placeholder="last name">
                <div class="errorMassage" id="errorLastNameUser"></div>
                <br>
                <h6><fmt:message key="form.new_user.phone"/></h6>
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
                    <fmt:message key="form.new_user.button.cancel"/>
                </button>
                <button type="button" id="registerNewUserAccount" class="btn btn-primary">
                    <fmt:message key="form.new_user.button.register"/>
                </button>
            </div>
        </div>
    </div>
</div>
<jsp:include page="general/footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
        crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script src="../../resources/js/script.js"></script>
</body>
</html>

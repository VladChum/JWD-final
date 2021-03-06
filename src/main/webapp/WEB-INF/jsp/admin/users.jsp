<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="locale" value="${empty cookie['locale'].getValue() ? 'en' : cookie['locale'].getValue() }"/>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="locale"/>

<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
    <li class="nav-item" role="presentation">
        <button class="nav-link active" id="pills-home-tab" data-bs-toggle="pill"
                data-bs-target="#pills-home" type="button" role="tab"
                aria-controls="pills-home" aria-selected="true">
            <fmt:message key="page.admin.users.navbar.users"/>
        </button>
    </li>
    <li class="nav-item" role="presentation">
        <button class="nav-link" id="pills-profile-tab" data-bs-toggle="pill"
                data-bs-target="#pills-profile" type="button" role="tab"
                aria-controls="pills-profile" aria-selected="false">
            <fmt:message key="page.admin.users.navbar.admins"/>
        </button>
    </li>
    <li class="nav-item" role="presentation">
        <button class="nav-link" id="pills-contact-tab" data-bs-toggle="pill"
                data-bs-target="#pills-contact" type="button" role="tab"
                aria-controls="pills-contact" aria-selected="false">
            <fmt:message key="page.admin.users.navbar.pills"/>
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
                    data-bs-toggle="modal" data-bs-target="#newUserForm">
                <fmt:message key="page.admin.users.navbar.button.new_user"/>
            </button>
            <button class="dropdown-item" type="button" data-bs-toggle="modal"
                    data-bs-target="#newAdminForm">
                <fmt:message key="page.admin.users.navbar.button.new_admin"/>
            </button>
        </div>
    </div>
</div>
<div class="accordion" id="accordionExample">
    <div class="accordion-item">
        <h2 class="accordion-header" id="headingOne">
            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                    data-bs-target="#panelsStayOpen-collapseTwo" aria-expanded="false"
                    aria-controls="panelsStayOpen-collapseTwo">
                <fmt:message key="page.user.list.button.find"/>
            </button>
        </h2>
        <div id="panelsStayOpen-collapseTwo" class="accordion-collapse collapse"
             aria-labelledby="panelsStayOpen-headingTwo">
            <div class="accordion-body">
                <center>
                    <h5><fmt:message key="page.admin.users.navbar.button.findCategories"/></h5>
                </center>
                <div class="container">
                    <div class="row align-items-start">
                        <div class="col-3">
                            <label for="find-login" class="form-label"><fmt:message
                                    key="page.user.account.login"/></label>
                            <input type="text" class="form-control" id="find-login" placeholder="" required="">
                        </div>
                        <div class="col-3">
                            <label for="findFirstName" class="form-label"><fmt:message
                                    key="form.new_user.name"/></label>
                            <input type="text" class="form-control" id="findFirstName" placeholder="" required="">
                        </div>
                        <div class="col-3">
                            <label for="findLastName" class="form-label"><fmt:message
                                    key="form.new_user.surname"/></label>
                            <input type="text" class="form-control" id="findLastName" placeholder="" required="">
                        </div>
                        <div class="col-3">
                            <button type="button"
                                    class="btn-user btn-outline-primary findUsers-filter findUsers_button"
                                    id="findUsersButton" data-bs-toggle="pill"
                                    data-massage="<fmt:message key="page.admin.users.table.button.delete"/>">
                                <fmt:message key="page.user.list.button.find"/>
                            </button>
                        </div>
                    </div>
                </div>
                <div class="container">
                    <div class="row align-items-start">
                        <div class="col-3">
                            <div class="col-md-12">
                                <label for="findStatus" class="form-label"><fmt:message
                                        key="page.user.account.status"/></label>
                                <select id="findStatus" class="userStatusFind form-select"
                                        data-user-id="">
                                    <option class="status" value=""></option>
                                    <option class="status" value="1">ACTIVATE</option>
                                    <option class="status" value="2">BANNED</option>
                                    <option class="status" value="3">SUSPENDED</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-3">
                            <label for="findPhone" class="form-label"><fmt:message
                                    key="page.user.account.phone"/></label>
                            <input type="text" class="form-control" id="findPhone" placeholder="" required="">
                        </div>
                        <div class="col-3">
                            <label for="findEmail" class="form-label">E-mail</label>
                            <input type="text" class="form-control" id="findEmail" placeholder="" required="">
                        </div>
                        <div class="col-3">
                            <button type="button"
                                    class="btn-user btn-outline-primary findUsers-filter cancelUsers_button"
                                    id="cancelUserFindSettings" data-bs-toggle="pill"
                                    data-massage="<fmt:message key="page.admin.users.table.button.delete"/>">
                                <fmt:message key="page.admin.users.table.button.cancel"/>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<br>
<%--                                    modal add user--%>
<div class="modal fade" id="newUserForm" data-bs-backdrop="static"
     data-bs-keyboard="false" tabindex="-1"
     aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="newUser"><fmt:message key="form.add_user.title"/></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <br>
                <h6><fmt:message key="form.new_user.login"/></h6>
                <input id="newUserCreateLogin" name="login" class="form-control"
                       placeholder="login">
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
                <button type="button" id="closeCreateUserModal"
                        class="btn btn-secondary" data-bs-dismiss="modal">
                    <fmt:message key="form.new_user.button.cancel"/>
                </button>
                <button type="button" id="createUserButton" class="btn btn-primary">
                    <fmt:message key="form.add_user.button.add"/>
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
                <h5 class="modal-title" id="newAdmin"><fmt:message key="form.admin.title"/></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <br>
                <h6><fmt:message key="form.new_user.login"/></h6>
                <input id="newAdminCreateLogin" name="login" class="form-control" placeholder="login">
                <div id="errorLoginAdmin" class="errorMassage"></div>
                <br>
                <h6><fmt:message key="form.new_user.password"/></h6>
                <input type="password" name="password" class="form-control"
                       id="newAdminCreatePassword" placeholder="password">
                <div id="errorPasswordAdmin" class="errorMassage"></div>
                <br>
            </div>
            <div class="modal-footer">
                <button type="button" id="closeCreateAdminModal"
                        class="btn btn-secondary" data-bs-dismiss="modal">
                    <fmt:message key="form.new_user.button.cancel"/>
                </button>
                <button type="button" id="createAdminButton" class="btn btn-primary">
                    <fmt:message key="form.admin.button.add"/>
                </button>
            </div>
        </div>
    </div>
</div>
<%--                                    user info form--%>
<div class="modal fade" id="userInfoForm" data-bs-backdrop="static"
     data-bs-keyboard="false" tabindex="-1"
     aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="userInfoBody">
            </div>
        </div>
    </div>
</div>
<%--                                    --%>
<div class="tab-content" id="pills-tabContent">
    <%--                                    user table--%>
    <div class="tab-pane fade show active userTable" id="pills-home" role="tabpanel"
         aria-labelledby="pills-home-tab">
        <jsp:include page="userTable.jsp">
            <jsp:param name="users" value="${users}"/>
        </jsp:include>
        <br>
        <div class="col-md-3 ms-auto" id="switchButtons" role="group">
            <button type="button" class="pageButton btn btn-primary" data-page-number="1"
                    data-massage="<fmt:message key="page.admin.users.table.button.delete"/>">1
            </button>
            <button type="button" class="pageButton btn btn-primary" data-page-number="2"
                    data-massage="<fmt:message key="page.admin.users.table.button.delete"/>">2
            </button>
            <button type="button" class="pageButton btn btn-primary" data-page-number="3"
                    data-massage="<fmt:message key="page.admin.users.table.button.delete"/>">...
            </button>
            ...
            <button type="button" class="pageButton btn btn-primary" data-page-number="4"
                    data-massage="<fmt:message key="page.admin.users.table.button.delete"/>">4
            </button>
        </div>
    </div>

    <%--                                    admin table--%>
    <div class="tab-pane fade userTable" id="pills-profile" role="tabpanel"
         aria-labelledby="pills-profile-tab">
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th scope="col"><fmt:message
                        key="page.admin.users.table.account_id"/></th>
                <th scope="col"><fmt:message key="page.admin.users.table.login"/></th>
                <th></th>
            </tr>
            <tbody>
            <c:forEach items="${admins}" var="admin">
                <tr>
                    <td>${admin.id}</td>
                    <td>${admin.login}</td>
                    <td>
                        <c:if test="${account.id != admin.id}">
                            <button class="deleteAdmin btn btn-outline-danger"
                                    data-admin-id="${admin.id}">
                                <fmt:message key="page.admin.users.table.button.delete"/>
                            </button>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
            </thead>
        </table>
    </div>
    <%--                                    baned users--%>
    <div class="tab-pane fade userTable" id="pills-contact" role="tabpanel"
         aria-labelledby="pills-contact-tab">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col"><fmt:message key="page.admin.users.table.name"/></th>
                <th scope="col"><fmt:message key="page.admin.users.table.surname"/></th>
                <th scope="col"><fmt:message key="page.admin.users.table.status"/></th>
                <th scope="col"><fmt:message key="page.admin.users.table.balance"/></th>
                <th></th>
                <th></th>
            </tr>
            <tbody class="table-danger">
            <c:forEach items="${users}" var="user">
                <c:if test="${user.status == \"BANNED\"}">
                    <tr class="activeUserTable" data-user-id="${user.id}">
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td class="color: #D90707">${user.status}</td>
                        <td>${user.balance}</td>
                        <td>
                            <button class="unblockUser btn btn-outline-secondary"
                                    data-user-id="${user.id}">
                                <fmt:message
                                        key="page.admin.users.table.button.activate"/>
                            </button>
                        </td>
                        <td>
                            <button class="deleteUser btn btn-outline-danger"
                                    data-user-id="${user.id}">
                                <fmt:message
                                        key="page.admin.users.table.button.delete"/>
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


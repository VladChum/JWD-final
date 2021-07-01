<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="locale" value="${empty cookie['locale'].getValue() ? 'en' : cookie['locale'].getValue() }"/>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="locale"/>

<table class="table table-striped table-hover" id="userTable">
    <thead>
    <tr>
        <th scope="col"><fmt:message key="page.admin.users.table.name"/></th>
        <th scope="col"><fmt:message key="page.admin.users.table.surname"/></th>
        <th scope="col"><fmt:message key="page.admin.users.table.status"/></th>
        <th scope="col"><fmt:message key="page.admin.users.table.balance"/></th>
        <th></th>
    </tr>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr class="tableLine" data-status="${user.status}">
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>
                <div class="col-md-10">
                    <select id="inputState" class="userStatus form-select"
                            data-user-id="${user.id}">
                        <option class="status" selected>${user.status}</option>
                        <option class="status" value="1">ACTIVATE</option>
                        <option class="status" value="2">BANNED</option>
                        <option class="status" value="3">SUSPENDED</option>
                    </select>
                </div>
            </td>
            <td>${user.balance}</td>
            <td>
                <button class="deleteUser btn btn-outline-danger"
                        data-user-id="${user.id}">
                    <fmt:message key="page.admin.users.table.button.delete"/>
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
    </thead>
</table>

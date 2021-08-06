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
    </tbody>
    </thead>
</table>

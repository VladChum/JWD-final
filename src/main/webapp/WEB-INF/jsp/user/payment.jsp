<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="locale" value="${empty cookie['locale'].getValue() ? 'en' : cookie['locale'].getValue() }"/>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="locale" />

<div class="tab-pane fade show" id="payment" role="tabpanel">
    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <button class="btn replenish-button me-3" type="button"
                id="cardReplenishButton"
                data-bs-toggle="modal" data-bs-target="#cardForm"
                aria-expanded="false">
            +
        </button>
    </div>
    <center>
        <h4><fmt:message key="page.user.payment.replenish.title"/></h4>
    </center>
    <table>
        <tbody>
        <tr>
            <td align="right">
                <b><fmt:message key="page.user.payment.replenish.amount"/>:<b></b></b></td>
            <td>
                <input type="text" id="replenishAmount" class="form form-control">
                <fmt:message key="page.user.payment.replenish.max_amount"/>.
                <div id="errorReplenishAmount" class="errorMassage"></div>
            </td>
            <td>
                <button class="ReplenishButton btn btn-primary"
                        data-user-id="${user.id}">
                    <fmt:message key="page.user.payment.replenish.button"/>
                </button>
            </td>
        </tr>
        </tbody>
    </table>
    <div id="errorReplenish" class="errorMassage"></div>
    <br>
    <br>
    <center>
        <h5><fmt:message key="page.user.payment.payment"/></h5>
    </center>
    <div class="paymentTable">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th scope="col"><fmt:message key="page.user.payment.table.data"/></th>
                <th scope="col"><fmt:message key="page.user.payment.table.amount"/></th>
                <th scope="col"><fmt:message key="page.user.payment.table.payment_type"/></th>
            </tr>
            </thead>
            <tbody class="table">
            <c:forEach items="${userPayments}" var="userPayment">
                <tr>
                    <td>${userPayment.date}</td>
                    <td>${userPayment.amount}</td>
                    <td>${userPayment.paymentType}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
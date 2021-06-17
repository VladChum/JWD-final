<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="locale" value="${empty cookie['locale'].getValue() ? 'en' : cookie['locale'].getValue() }"/>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="locale"/>

<%--                            update discount --%>
<div class="modal fade" id="updateDiscountForm" data-bs-backdrop="static"
     data-bs-keyboard="false" tabindex="-1"
     aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="updateDiscount"><fmt:message key="form.update_discount.title"/></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <br>
                <h6><fmt:message key="form.new_discount.size"/></h6>
                <input id="updateDiscountSize" name="discountSize" class="form-control" placeholder="discountSize">
                <div id="errorUpdateDiscountSize" class="errorMassage"></div>
                <br>
                <h6><fmt:message key="form.discount.start_date"/></h6>
                <input name="startDate" class="form-control" id="updateStartDateDiscount" placeholder="price">
                <div id="errorUpdateStartDateDiscount" class="errorMassage"></div>
                <br>
                <h6><fmt:message key="form.discount.end_date"/></h6>
                <input name="endDate" class="form-control" id="updateEndDateDiscount" placeholder="price">
                <div id="errorUpdateEndDateDiscount" class="errorMassage"></div>
                <br>
            </div>
            <div class="modal-footer">
                <button type="button" id="closeUpdateDiscount" class="btn btn-secondary" data-bs-dismiss="modal">
                    <fmt:message key="form.new_user.button.cancel"/>
                </button>
                <button type="button" id="updateDiscountButton" class="btn btn-primary">
                    <fmt:message key="form.update_discount.button"/>
                </button>
            </div>
        </div>
    </div>
</div>
<%--                            add tariff for discount--%>
<div class="modal fade" id="addTariffsForDiscountForm" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addTariffsForDiscount"><fmt:message key="form.add_tariffs_discount.title"/></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <br>
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th scope="col"><fmt:message key="form.new_tariff.name"/></th>
                        <th scope="col"><fmt:message key="form.new_tariff.price"/></th>
                        <th scope="col"><fmt:message key="form.new_tariff.speed"/></th>
                        <th scope="col"><fmt:message key="form.add_tariffs_discount.discount_id"/></th>
                        <th></th>
                    </tr>
                    <tbody>
                    <c:forEach items="${tariffs}" var="tariff">
                        <tr>
                            <td>${tariff.name}</td>
                            <td>${tariff.price}</td>
                            <td>${tariff.speed}</td>
                            <td>${tariff.discountId}</td>
                            <td>
                                <button class="addTariff btn btn-primary" data-tariff-id="${tariff.id}"
                                        data-discount-id="${tariff.discountId}">
                                    <fmt:message key="form.add_tariffs_discount.button.add"/>
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                    </thead>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" id="closeAddTariffsForDiscount" class="btn btn-secondary" data-bs-dismiss="modal">
                    <fmt:message key="form.card.button.cancel"/>
                </button>
                <button type="button" id="addTariffsForDiscountButton" class="btn btn-primary">
                    <fmt:message key="form.add_tariffs_discount.button.add"/>
                </button>
            </div>
        </div>
    </div>
</div>
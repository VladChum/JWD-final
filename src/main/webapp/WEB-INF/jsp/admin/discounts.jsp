<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="locale" value="${empty cookie['locale'].getValue() ? 'en' : cookie['locale'].getValue() }"/>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="locale"/>

<ul class="nav nav-pills mb-3" id="discount-tab" role="tablist">
    <li class="nav-item" role="presentation">
        <button class="nav-link active" id="activeDiscount-tab" data-bs-toggle="pill"
                data-bs-target="#active-discount" type="button" role="tab"
                aria-selected="false"><fmt:message key="page.admin.discount.navbar.button.active"/>
        </button>
    </li>
    <li class="nav-item" role="presentation">
        <button class="nav-link" id="archiveDiscount-tab" data-bs-toggle="pill"
                data-bs-target="#archive-discount" type="button" role="tab"
                aria-selected="false"><fmt:message key="page.admin.discount.navbar.button.archive"/>
        </button>
    </li>
</ul>
<div class="d-grid gap-2 d-md-flex justify-content-md-end">
    <button class="btn add-tariff-button me-3" type="button" id="newDiscountButton"
            data-bs-toggle="modal" data-bs-target="#newDiscountForm" aria-expanded="false">
        +
    </button>
</div>
<div class="modal fade" id="newDiscountForm" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="newDiscount"><fmt:message key="form.new_discount.title"/></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <br>
                <h6><fmt:message key="form.new_discount.size"/></h6>
                <input id="newDiscountSize" name="discountSize" class="form-control" placeholder="discountSize">
                <div id="errorDiscountSize" class="errorMassage"></div>
                <br>
                <h6><fmt:message key="form.discount.start_date"/></h6>
                <input name="startDate" class="form-control" id="newStartDateDiscount" placeholder="price">
                <div id="errorStartDateDiscount" class="errorMassage"></div>
                <br>
                <h6><fmt:message key="form.discount.end_date"/></h6>
                <input name="endDate" class="form-control" id="newEndDateDiscount" placeholder="price">
                <div id="errorEndDateDiscount" class="errorMassage"></div>
                <br>
            </div>
            <div class="modal-footer">
                <button type="button" id="closeCreateDiscount" class="btn btn-secondary" data-bs-dismiss="modal">
                    <fmt:message key="form.new_user.button.cancel"/>
                </button>
                <button type="button" id="createDiscount" class="btn btn-primary">
                    <fmt:message key="form.new_discount.button.add"/>
                </button>
            </div>
        </div>
    </div>
</div>
<%--                                discount cards--%>
<div class="tab-content" id="pills-tariffs">
    <div class="tab-pane fade show active" id="active-discount" role="tabpanel">
        <div class="tariff-item__top">
            <div class="row row-cols-1 row-cols-md-3 g-4">
                <c:forEach items="${discounts}" var="discount">
                    <c:if test="${discount.endDate >= dateNow && discount.startDate <= dateNow}">
                        <div class="col-sm-6">
                            <div class="card">
                                <div class="card-body">
                                    <div class="tariff-item">
                                        <div class="tariff-item__top">
                                            <div class="tariff-item__title">
                                                <h5 class="card-title"><fmt:message key="discount.card.title"/></h5>
                                            </div>
                                            <div class="tariff-item__text">
                                                <p><fmt:message key="form.discount.start_date"/>: ${discount.startDate} </p>
                                                <p></p>
                                                <p><fmt:message key="form.discount.end_date"/>: ${discount.endDate} </p>
                                            </div>
                                        </div>
                                        <div class="tariff-item__body">
                                            <div class="tariff-item__price">
                                                <span>
                                                    <b>${discount.size}</b>%
                                                </span>
                                                <b class="tariffActive">
                                                    <fmt:message key="form.discount.status.active"/>
                                                </b>
                                            </div>
                                            <div class="dropdown">
                                                <button class="btn button-tariff  me-3" type="button"
                                                        id="discountMenu" data-bs-toggle="dropdown"
                                                        aria-haspopup="true" aria-expanded="false">
                                                    <fmt:message key="page.admin.tariffs.button.change"/>
                                                </button>
                                                <div class=" dropdown-menu">
                                                    <button class="updateDiscountButton dropdown-item"
                                                            data-discount-id="${discount.id}"
                                                            data-discount-size="${discount.size}"
                                                            date-discount-start="${discount.startDate}"
                                                            data-discount-end="${discount.endDate}"
                                                            data-bs-toggle="modal" data-bs-target="#updateDiscountForm"
                                                            aria-expanded="false" type="button">
                                                        <fmt:message key="page.admin.tariffs.button.change"/>
                                                    </button>
                                                    <button class="addTariffsForDiscountButton dropdown-item"
                                                            data-discount-id="${discount.id}"
                                                            data-discount-size="${discount.size}"
                                                            data-bs-toggle="modal"
                                                            data-bs-target="#addTariffsForDiscountForm"
                                                            aria-expanded="false" type="button">
                                                        <fmt:message key="discount.card.button.tariffs"/>
                                                    </button>
                                                    <button class="archiveDiscountButton dropdown-item"
                                                            name="archiveDiscountButton"
                                                            data-tariff-id="${discount.id}" type="button">
                                                        <fmt:message key="page.user.settings.change_status.stop"/>
                                                    </button>
                                                </div>
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
    </div>
    <div class="tab-pane fade" id="archive-discount" role="tabpanel">
        <div class="tariff-item__top">
            <div class="row row-cols-1 row-cols-md-3 g-4">
                <c:forEach items="${discounts}" var="discount">
                    <c:if test="${dateNow > discount.endDate || dateNow < discount.startDate}">
                        <div class="col-sm-6">
                            <div class="card">
                                <div class="card-body">
                                    <div class="tariff-item">
                                        <div class="tariff-item__top">
                                            <div class="tariff-item__title">
                                                <h5 class="card-title"><fmt:message key="discount.card.title"/></h5>
                                            </div>
                                            <div class="tariff-item__text">
                                                <p><fmt:message key="form.discount.start_date"/>: ${discount.startDate} </p>
                                                <p></p>
                                                <p><fmt:message key="form.discount.end_date"/>: ${discount.endDate} </p>
                                            </div>
                                        </div>
                                        <div class="tariff-item__body">
                                            <div class="tariff-item__price">
                                                <span>
                                                    <b>${discount.size}</b>%
                                                </span>
                                                <c:if test="${discount.startDate > dateNow}">
                                                    <b class="planed">
                                                        <fmt:message key="discount.card.status.planed"/>
                                                    </b>
                                                </c:if>
                                                <c:if test="${discount.startDate < dateNow}">
                                                    <b class="ended">
                                                        <fmt:message key="discount.card.status.ended"/>
                                                    </b>
                                                </c:if>
                                            </div>
                                            <button class="updateDiscountButton btn button-tariff  me-3"
                                                    name="updateDiscountButton" data-bs-toggle="modal"
                                                    data-bs-target="#updateDiscountForm" aria-expanded="false"
                                                    data-discount-id="${discount.id}"
                                                    data-discount-size="${discount.size}"
                                                    date-discount-start="${discount.startDate}"
                                                    data-discount-end="${discount.endDate}"
                                                    type="button">
                                                <fmt:message key="page.user.settings.button.update"/>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

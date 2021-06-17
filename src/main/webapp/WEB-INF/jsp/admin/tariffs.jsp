<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="locale" value="${empty cookie['locale'].getValue() ? 'en' : cookie['locale'].getValue() }"/>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="locale"/>

<ul class="nav nav-pills mb-3" id="tariff-tab" role="tablist">
    <li class="nav-item" role="presentation">
        <button class="nav-link active" id="active-tab" data-bs-toggle="pill" data-bs-target="#active-tariffs"
                type="button" role="tab" aria-selected="false">
            <fmt:message key="page.admin.tariffs.navbar.active"/>
        </button>
    </li>
    <li class="nav-item" role="presentation">
        <button class="nav-link" id="archive-tab" data-bs-toggle="pill" data-bs-target="#archive-tariffs"
                type="button" role="tab" aria-selected="false">
            <fmt:message key="page.admin.tariffs.navbar.archive"/>
        </button>
    </li>
</ul>
<div class="d-grid gap-2 d-md-flex justify-content-md-end">
    <button class="btn add-tariff-button me-3" type="button" id="newTariffButton"
            data-bs-toggle="modal" data-bs-target="#newTariffForm" aria-expanded="false">
        +
    </button>
</div>
<div class="modal fade" id="newTariffForm" data-bs-backdrop="static"
     data-bs-keyboard="false" tabindex="-1"
     aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="newATariff"><fmt:message key="form.new_tariff.title"/></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <br>
                <h6><fmt:message key="form.new_tariff.name"/></h6>
                <input id="newTariffName" name="name" class="form-control" placeholder="name">
                <div id="errorNameTariff" class="errorMassage"></div>
                <br>
                <h6><fmt:message key="form.new_tariff.price"/></h6>
                <input name="price" class="form-control" id="newTariffPrice" placeholder="price">
                <div id="errorPriceTariff" class="errorMassage"></div>
                <br>
                <h6><fmt:message key="form.new_tariff.speed"/></h6>
                <input name="speed" class="form-control" id="newTariffSpeed" placeholder="price">
                <div id="errorSpeedTariff" class="errorMassage"></div>
                <br>
            </div>
            <div class="modal-footer">
                <button type="button" id="closeCreateTariff" class="btn btn-secondary" data-bs-dismiss="modal">
                    <fmt:message key="form.card.button.cancel"/>
                </button>
                <button type="button" id="createTariff" class="btn btn-primary">
                    <fmt:message key="form.new_tariff.button.add"/>
                </button>
            </div>
        </div>
    </div>
</div>
<%--                                tariff cards--%>
<div class="tab-content" id="pills-tariffs">
    <div class="tab-pane fade show active" id="active-tariffs" role="tabpanel">
        <div class="tariff-item__top">
            <div class="row row-cols-1 row-cols-md-3 g-4">
                <c:forEach items="${tariffs}" var="tariff">
                    <c:if test="${tariff.active == 'true'}">
                        <div class="col-sm-6">
                            <div class="card">
                                <div class="card-body">
                                    <div class="tariff-item">
                                        <div class="tariff-item__top">
                                            <div class="tariff-item__title">
                                                <h5 class="card-title">${tariff.name}</h5>
                                            </div>
                                            <div class="tariff-item__text">
                                                <p><fmt:message key="tariff.card.text1"/></p>
                                                <p><fmt:message key="tariff.card.text2"/>
                                                        ${tariff.speed}
                                                    <fmt:message key="tariff.card.text3"/></p>
                                                <p><fmt:message key="tariff.card.text4"/></p>
                                            </div>
                                        </div>
                                        <div class="tariff-item__body">
                                            <div class="tariff-item__price">
                                                <span>
                                                    <b>${tariff.price}</b>
                                                    <fmt:message key="tariff.card.amount"/>
                                                </span>
                                            </div>
                                            <div class="dropdown">
                                                <button class="btn button-tariff  me-3" type="button" id="tariffMenu"
                                                        data-bs-toggle="dropdown" aria-haspopup="true"
                                                        aria-expanded="false">
                                                    <fmt:message key="page.admin.tariffs.button.change"/>
                                                </button>
                                                <div class="dropdown-menu">
                                                    <button class="updateTariffButton dropdown-item"
                                                            data-tariff-id="${tariff.id}"
                                                            data-tariff-price="${tariff.price}"
                                                            data-tariff-speed="${tariff.speed}"
                                                            data-tariff-name="${tariff.name}"
                                                            type="button"
                                                            data-bs-toggle="modal"
                                                            data-bs-target="#updateTariffForm">
                                                        <fmt:message key="page.admin.tariffs.button.change"/>
                                                    </button>
                                                    <button class="archiveTariffButton dropdown-item"
                                                            name="archiveTariffButton"
                                                            data-tariff-id="${tariff.id}"
                                                            type="button">
                                                        <fmt:message key="page.admin.users.table.button.delete"/>
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

    <div class="modal fade" id="updateTariffForm" data-bs-backdrop="static"
         data-bs-keyboard="false" tabindex="-1"
         aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="updateATariff"><fmt:message key="form.update_tariff.title"/></h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <br>
                    <h6><fmt:message key="form.new_tariff.name"/></h6>
                    <input id="updateTariffName" name="name" class="form-control" placeholder="name">
                    <div id="errorUpdateNameTariff" class="errorMassage"></div>
                    <br>
                    <h6><fmt:message key="form.new_tariff.price"/></h6>
                    <input name="price" class="form-control" id="updateTariffPrice" placeholder="price">
                    <div id="errorUpdatePriceTariff" class="errorMassage"></div>
                    <br>
                    <h6><fmt:message key="form.new_tariff.speed"/></h6>
                    <input name="speed" class="form-control" id="updateTariffSpeed" placeholder="price">
                    <div id="errorUpdateSpeedTariff" class="errorMassage"></div>
                    <br>
                </div>
                <div class="modal-footer">
                    <button type="button" id="closeUpdateTariff" class="btn btn-secondary" data-bs-dismiss="modal">
                        <fmt:message key="form.new_user.button.cancel"/>
                    </button>
                    <button type="button" id="updateTariffButton" class="btn btn-primary">
                        <fmt:message key="page.user.settings.button.update"/>
                    </button>
                </div>
            </div>
        </div>
    </div>

    <div class="tab-pane fade" id="archive-tariffs" role="tabpanel">
        <div class="tariff-item__top">
            <div class="row row-cols-1 row-cols-md-3 g-4">
                <c:forEach items="${tariffs}" var="tariff">
                    <c:if test="${tariff.active == 'false'}">
                        <div class="col-sm-6">
                            <div class="card">
                                <div class="card-body">
                                    <div class="tariff-item">
                                        <div class="tariff-item__top">
                                            <div class="tariff-item__title">
                                                <h5 class="card-title">${tariff.name}</h5>
                                            </div>
                                            <div class="tariff-item__text">
                                                <p><fmt:message key="tariff.card.text1"/></p>
                                                <p><fmt:message key="tariff.card.text2"/>
                                                        ${tariff.speed}
                                                    <fmt:message key="tariff.card.text3"/></p>
                                                <p><fmt:message key="tariff.card.text4"/></p>
                                            </div>
                                        </div>
                                        <div class="tariff-item__body">
                                            <div class="tariff-item__price">
                                                <span>
                                                    <b>${tariff.price}</b>
                                                    <fmt:message key="tariff.card.amount"/>
                                                </span>
                                            </div>
                                            <div class="dropdown">
                                                <button class="btn button-tariff  me-3" type="button"
                                                        id="archiveTariffMenu"
                                                        data-bs-toggle="dropdown"
                                                        aria-haspopup="true"
                                                        aria-expanded="false">
                                                    <fmt:message key="page.admin.tariffs.button.change"/>
                                                </button>
                                                <div class="dropdown-menu">
                                                    <button class="updateTariffButton dropdown-item" type="button"
                                                            data-tariff-id="${tariff.id}"
                                                            data-tariff-price="${tariff.price}"
                                                            data-tariff-speed="${tariff.speed}"
                                                            data-tariff-name="${tariff.name}"
                                                            data-bs-toggle="modal"
                                                            data-bs-target="#updateTariffForm">
                                                        <fmt:message key="page.admin.tariffs.button.change"/>
                                                    </button>
                                                    <button class="activateTariffButton dropdown-item"
                                                            name="activateTariffButton"
                                                            data-tariff-Id="${tariff.id}"
                                                            type="button">
                                                        <fmt:message key="tariff.card.button.activate"/>
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
</div>

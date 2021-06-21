<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="locale" value="${empty cookie['locale'].getValue() ? 'en' : cookie['locale'].getValue() }"/>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="locale" />

<div class="modal fade" id="cardForm" data-bs-backdrop="static"
     data-bs-keyboard="false" tabindex="-1"
     aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="card">card</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"
                        aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <br>
                <div class="row gy-3">
                    <div class="col-md-6">
                        <label for="cc-name" class="form-label">Name on card</label>
                        <input type="text" class="form-control" id="cc-name" placeholder=""
                               required="">
                        <small class="text-muted">Full name as displayed on card</small>
                        <div class="invalid-feedback">
                            Name on card is required
                        </div>
                        <div id="errorNameOfCard" class="errorMassage"></div>
                    </div>

                    <div class="col-md-6">
                        <label for="cc-number" class="form-label">Credit card number</label>
                        <input type="text" class="form-control" id="cc-number"
                               placeholder="" required="">
                        <div class="invalid-feedback">
                            Credit card number is required
                        </div>
                        <div id="errorCardNumber" class="errorMassage"></div>
                    </div>

                    <div class="col-md-3">
                        <label for="cc-expiration" class="form-label">Expiration</label>
                        <input type="text" class="form-control" id="cc-expiration">
                        <div class="invalid-feedback">
                            Expiration date required
                        </div>
                        <div id="errorExpiration" class="errorMassage"></div>
                    </div>

                    <div class="col-md-3">
                        <label for="cc-cvv" class="form-label">CVV</label>
                        <input type="text" class="form-control" id="cc-cvv">
                        <div class="invalid-feedback">
                            Security code required
                        </div>
                        <div id="errorCVV" class="errorMassage"></div>
                    </div>
                </div>
                <br>
                <h6>Amount</h6>
                <div class="col-md-3">
                    <input type="text" class="cardAmount form-control">
                    <div id="errorAmount" class="errorMassage"></div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" id="closeCardForm"
                        class="btn btn-secondary" data-bs-dismiss="modal">
                    <fmt:message key="form.card.button.cancel"/>
                </button>
                <button type="button" id="replenishButton"
                        data-user-id="${user.id}"
                        class="btn btn-primary">
                    <fmt:message key="form.card.button.replenish"/>
                </button>
            </div>
        </div>
    </div>
</div>
$("document").ready(function () {
    const DEFAULT_LANGUAGE = 'en';

    function validateEmail(email) {
        const re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return re.test(email);
    }

    function validatePassword(password) {
        const pattern = /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,30}$/;
        return pattern.test(password);
    }

    function validatePhone(phone) {
        const phoneno = /^\+?([0-9]{3})\)?[-. ]?([0-9]{5})[-. ]?([0-9]{4})$/;
        return phoneno.test(phone);
    }

    function validateSpeed(speed) {
        const pattern = /^[0-9]+$/;
        return pattern.test(speed);
    }

    function validatePrice(price) {
        const pattern = /^\d*\.?\d*$/;
        return pattern.test(price);
    }

    function validateDate(date) {
        const pattern = /^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;
        if (pattern.test(date)) {
            let parts = date.split("-");
            let day = parseInt(parts[2], 10);
            let month = parseInt(parts[1], 10);
            let year = parseInt(parts[0], 10);

            if (year < 1000 || year > 3000 || month === 0 || month > 12) {
                return false;
            }
            let monthLength = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

            if (year % 400 === 0 || (year % 100 !== 0 && year % 4 === 0)) {
                monthLength[1] = 29;
            }
            return day > 0 && day <= monthLength[month - 1];
        } else {
            return false;
        }
    }

    function validateRegisterDataUser(password, login, firstName, lastName, email, phone) {
        let valid = 0;
        if (password.length < 8 || password.length > 30) {
            $('#errorPasswordUser').html("Wrong input: password must be 8 to 30 characters long");
        } else {
            $('#errorPasswordUser').html("");
            valid++;
        }
        if (login.length < 5 || login.length > 30) {
            $('#errorLoginUser').html("Wrong input: login must be 5 to 30 characters long");
        } else {
            $('#errorLoginUser').html("");
            valid++;
        }
        if (firstName.length <= 1) {
            $('#errorFirstNameUser').html("Wrong input: invalid first name!");
        } else {
            $('#errorFirstNameUser').html("");
            valid++;
        }
        if (lastName.length <= 1) {
            $('#errorLastNameUser').html("Wrong input: invalid last name!");
        } else {
            $('#errorLastNameUser').html("");
            valid++;
        }
        if (validateEmail(email) || email.length === 0) {
            $('#errorEmailUser').html("");
            valid++;
        } else {
            $('#errorEmailUser').html("Wrong input: invalid email!");
        }
        if (phone.length === 0 || validatePhone(phone)) {
            $('#errorPhoneUser').html("");
            valid++;
        } else {
            $('#errorPhoneUser').html("Wrong input: invalid phone!");
        }
        return valid;
    }

    function tariffsButtonsOnDiscount() {
        $('.addTariff').each(function () {
            if ($(this).attr('data-discount-id') === discountIdForTariffs) {
                $(this).prop('disabled', true);
            } else {
                $(this).prop('disabled', false);
            }
        });
    }

    function cardDataValidation(name, cardNumber, cvv, expiration) {
        const cardNumberPattern = /^(?:4[0-9]{12}(?:[0-9]{3})?|[25][1-7][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\d{3})\d{11})$/;
        const expirationPattern = /^(0[1-9]|1[0-2])\/(0[1-9]|[1-9][0-9])$/;
        let valid = 0;
        if (name.length <= 0) {
            $('#errorNameOfCard').html("Wrong input");
        } else {
            $('#errorNameOfCard').html("");
            valid++;
        }
        if (!cardNumberPattern.test(cardNumber)) {
            $('#errorCardNumber').html("Wrong input: incorrect card number");
        } else {
            $('#errorCardNumber').html("");
            valid++;
        }
        if (!validateSpeed(cvv) || parseInt(cvv) > 999 || parseInt(cvv) < 100) {
            $('#errorCVV').html("Wrong input: incorrect CVV");
        } else {
            $('#errorCVV').html("");
            valid++;
        }
        if (!expirationPattern.test(expiration)) {
            $('#errorExpiration').html("Wrong input: incorrect expiration (10/20)");
        } else {
            $('#errorExpiration').html("");
            valid++;
        }
        return valid === 4;
    }

    $('.chengTariffButton').on('click', function () {
        let id = $(this).attr('data-tariff-id');
        let url = "Controller?command=updateUserTariff";
        let data = {tariffId: id};
        $.post(url, data, function (data, status) {
            location.reload();
        });
    });

    $('#newUserCreateLogin').on('keyup', function () {
        let login = $('#newUserCreateLogin').val();
        if (login.length < 5 || login.length > 30) {
            $('#errorLoginUser').html("Wrong input: login must be 5 to 30 characters long");
        } else {
            $('#errorLoginUser').html("");

        }
    });

    $('#newUserCreatePassword').on('keyup', function () {
        let password = $('#newUserCreatePassword').val();
        if (password.length < 8 || password.length > 30) {
            $('#errorPasswordUser').html("Wrong input: password must be 8 to 30 characters long");
        } else {
            $('#errorPasswordUser').html("");
        }
    });

    $('#createUserButton').on('click', function () {
        let login = $('#newUserCreateLogin').val();
        let password = $('#newUserCreatePassword').val();
        let firstName = $('#newUserFirstName').val();
        let lastName = $('#newUserLastName').val();
        let phone = $('#newUserPhone').val();
        let email = $('#newUserEmail').val();
        let valid = validateRegisterDataUser(password, login, firstName, lastName, email, phone);

        if (valid >= 6) {
            let data = {
                login: login,
                password: password,
                firstName: firstName,
                lastName: lastName,
                phone: phone,
                email: email
            }
            let url = "Controller?command=createUser";
            $.post(url, data, function (data, status) {
                if (data === "false") {
                    $('#errorLoginUser').html("error: user with this login already exists!");
                } else {
                    location.reload();
                }
            });
        }
    });

    $('#closeCreateUserModal').on('click', function () {
        $('#newUserCreateLogin').val("");
        $('#newUserCreatePassword').val("");
        $('#newUserFirstName').val("");
        $('#newUserLastName').val("");
        $('#newUserEmail').val("");
        $('#newUserPhone').val("");
        $('#errorLastNameUser').html("");
        $('#errorLoginUser').html("");
        $('#errorPasswordUser').html("");
        $('#errorFirstNameUser').html("");
        $('#errorEmailUser').html("");
        $('#errorPhoneUser').html("");
    });

    $('#newAdminCreateLogin').on('keyup', function () {
        let login = $('#newAdminCreateLogin').val();
        if (login.length < 5 || login.length > 30) {
            $('#errorLoginAdmin').html("Wrong input: login must be 5 to 30 characters long");
        } else {
            $('#errorLoginAdmin').html("");
        }
    });

    $('#newAdminCreatePassword').on('keyup', function () {
        let password = $('#newAdminCreatePassword').val();
        if (password.length < 8 || password.length > 30) {
            $('#errorPasswordAdmin').html("Wrong input: password must be 8 to 30 characters long");
        } else {
            $('#errorPasswordAdmin').html("");
        }
    });

    $('#createAdminButton').on('click', function () {
        let login = $('#newAdminCreateLogin').val();
        let password = $('#newAdminCreatePassword').val();
        let valid = 0;

        if (password.length >= 8 || password.length <= 30) {
            valid++;
        }
        if (login.length >= 5 || login.length <= 30) {
            valid++;
        }

        if (valid === 2) {
            let data = {
                login: login,
                password: password,
            }
            let url = "Controller?command=createAdmin";
            $.post(url, data, function (data, status) {
                if (data !== "") {
                    $('#errorLoginAdmin').html(data);
                } else {
                    location.reload();
                }
            });
        }
    });

    $('#closeCreateAdminModal').on('click', function () {
        $('#newAdminCreatePassword').val("");
        $('#newAdminCreateLogin').val("");
        $('#errorPasswordAdmin').html("");
        $('#errorLoginAdmin').html("");
    });

    $('#newTariffName').on('keyup', function () {
        let name = $('#newTariffName').val();
        if (name.length < 2 && name.length !== 0) {
            $('#errorNameTariff').html("Wrong input: name too short");
        } else {
            $('#errorNameTariff').html("");
        }
    });

    $('#newTariffSpeed').on('keyup', function () {
        let speed = $('#newTariffSpeed').val();
        if (!validateSpeed(speed) || speed === "0" || speed > 999999) {
            $('#errorSpeedTariff').html("Wrong input: speed > 0 and speed < 100000000");
        } else {
            $('#errorSpeedTariff').html("");
        }
    });

    $('#newTariffPrice').on('keyup', function () {
        let price = $('#newTariffPrice').val();
        if (!validatePrice(price) || price === "0" || parseFloat(price) >= 100000) {
            $('#errorPriceTariff').html("Wrong input: price >= 0 and price < 100000000");
        } else {
            $('#errorPriceTariff').html("");
        }
    });

    $('#closeCreateTariff').on('click', function () {
        $('#newTariffPrice').val("");
        $('#newTariffSpeed').val("");
        $('#newTariffName').val("");
        $('#errorPriceTariff').html("");
        $('#errorSpeedTariff').html("");
        $('#errorNameTariff').html("");
    });

    $('#createTariff').on('click', function () {
        let name = $('#newTariffName').val();
        let price = $('#newTariffPrice').val();
        let speed = $('#newTariffSpeed').val();
        let valid = 0;

        if (name.length < 2 && name.length !== 0) {
            $('#errorNameTariff').html("Wrong input: name too short");
        } else {
            $('#errorNameTariff').html("");
            valid++;
        }
        if (!validateSpeed(speed) || speed === "0" || speed >= 999999 || speed === "") {
            $('#errorSpeedTariff').html("Wrong input: speed > 0 and speed < 100000000");
        } else {
            $('#errorSpeedTariff').html("");
            valid++;
        }
        if (!validatePrice(price) || price === "0" || parseFloat(price) >= 100000 || speed === "") {
            $('#errorPriceTariff').html("Wrong input: price >= 0 and price < 100000000");
        } else {
            $('#errorPriceTariff').html("");
            valid++;
        }

        if (valid === 3) {
            let data = {
                name: name,
                price: price,
                speed: speed
            }
            let url = "Controller?command=createTariff";
            $.post(url, data, function (data, status) {
                if (data !== "") {
                    $('#errorNameTariff').html(data);
                } else {
                    location.reload();
                }
            });
        }
    });

    $('.archiveTariffButton').on('click', function () {
        let tariffId = $(this).attr('data-tariff-id');
        let data = {
            tariffId: tariffId
        }
        let url = "Controller?command=deleteTariff";
        $.post(url, data, function (data, status) {
            location.reload();
        });
    });

    $('.activateTariffButton').on('click', function () {
        let tariffId = $(this).attr('data-tariff-id');
        let data = {
            tariffId: tariffId
        }
        let url = "Controller?command=activateTariff";
        $.post(url, data, function (data, status) {
            location.reload();
        });
    });

    $('#newDiscountSize').on('keyup', function () {
        let size = $('#newDiscountSize').val();
        if (parseFloat(size) > 0 && parseFloat(size) < 100 && validatePrice(size)) {
            $('#errorDiscountSize').html("");
        } else {
            $('#errorDiscountSize').html("Wrong input: 0 < discount size < 100");
        }
    });

    $('#newStartDateDiscount').on('keyup', function () {
        let startDate = $('#newStartDateDiscount').val();
        if (!validateDate(startDate)) {
            $('#errorStartDateDiscount').html("Wrong input: date example 2020-03-03");
        } else {
            $('#errorStartDateDiscount').html("");
        }
    });

    $('#newEndDateDiscount').on('keyup', function () {
        let endDate = $('#newEndDateDiscount').val();
        if (!validateDate(endDate)) {
            $('#errorEndDateDiscount').html("Wrong input: date example 2020-03-04");
        } else {
            $('#errorEndDateDiscount').html("");
        }
    });

    $('#createDiscount').on('click', function () {
        let size = $('#newDiscountSize').val();
        let startDate = $('#newStartDateDiscount').val();
        let endDate = $('#newEndDateDiscount').val();
        let valid = 0;

        if (startDate > endDate) {
            $('#errorEndDateDiscount').html("Wrong input: date example 2020-03-04");
            $('#errorStartDateDiscount').html("Wrong input: date example 2020-03-04");
        } else {
            if (parseFloat(size) > 0 && parseFloat(size) < 100 && validatePrice(size)) {
                $('#errorDiscountSize').html("");
                valid++;
            } else {
                $('#errorDiscountSize').html("Wrong input:  0 < discount size < 100");
            }
            if (!validateDate(endDate)) {
                $('#errorEndDateDiscount').html("Wrong input: date example 2020-03-04");
            } else {
                $('#errorEndDateDiscount').html("");
                valid++;
            }
            if (!validateDate(startDate)) {
                $('#errorStartDateDiscount').html("Wrong input: date example 2020-03-04");
            } else {
                $('#errorStartDateDiscount').html("");
                valid++;
            }
        }

        if (valid === 3) {
            let data = {
                size: size,
                startDate: startDate,
                endDate: endDate
            }
            let url = "Controller?command=createDiscount";
            $.post(url, data, function (data, status) {
                location.reload();
            });
        }
    });

    $('.archiveDiscountButton').on('click', function () {
        let discountId = $(this).attr('data-tariff-id');
        let data = {
            discountId: discountId
        }
        let url = "Controller?command=stopDiscount";
        $.post(url, data, function (data, status) {
            location.reload();
        });
    });

    var discountIdForUpdate;

    $('.updateDiscountButton').on('click', function () {
        let size = $(this).attr('data-discount-size');
        let startDate = $(this).attr('date-discount-start');
        let endDate = $(this).attr('data-discount-end');
        discountIdForUpdate = $(this).attr('data-discount-id');

        document.getElementById('updateDiscountSize').value = size;
        document.getElementById('updateEndDateDiscount').value = endDate;
        document.getElementById('updateStartDateDiscount').value = startDate;
    });

    $('#updateDiscountSize').on('keyup', function () {
        let size = $('#updateDiscountSize').val();
        if (parseFloat(size) > 0 && parseFloat(size) < 100 && validatePrice(size)) {
            $('#errorUpdateDiscountSize').html("");
        } else {
            $('#errorUpdateDiscountSize').html("Wrong input: 0 < discount size < 100");
        }
    });

    $('#updateStartDateDiscount').on('keyup', function () {
        let startDate = $('#updateStartDateDiscount').val();
        if (!validateDate(startDate)) {
            $('#errorUpdateStartDateDiscount').html("Wrong input: date example 2020-03-03");
        } else {
            $('#errorUpdateStartDateDiscount').html("");
        }
    });

    $('#updateEndDateDiscount').on('keyup', function () {
        let endDate = $('#updateEndDateDiscount').val();
        if (!validateDate(endDate)) {
            $('#errorUpdateEndDateDiscount').html("Wrong input: date example 2020-03-04");
        } else {
            $('#errorUpdateEndDateDiscount').html("");
        }
    });

    $('#updateDiscountButton').on('click', function () {
        let size = $('#updateDiscountSize').val();
        let startDate = $('#updateStartDateDiscount').val();
        let endDate = $('#updateEndDateDiscount').val();
        let valid = 0;

        if (startDate > endDate) {
            $('#errorUpdateStartDateDiscount').html("Wrong input: date example 2020-03-03");
            $('#errorUpdateEndDateDiscount').html("Wrong input: date example 2020-03-04");
        } else {
            if (parseFloat(size) > 0 && parseFloat(size) < 100 && validatePrice(size)) {
                $('#errorUpdateDiscountSize').html("");
                valid++;
            } else {
                $('#errorUpdateDiscountSize').html("Wrong input: 0 < discount size < 100");
            }
            if (!validateDate(startDate)) {
                $('#errorUpdateStartDateDiscount').html("Wrong input: date example 2020-03-03");
            } else {
                $('#errorUpdateStartDateDiscount').html("");
                valid++;
            }
            if (!validateDate(endDate)) {
                $('#errorUpdateEndDateDiscount').html("Wrong input: date example 2020-03-04");
            } else {
                $('#errorUpdateEndDateDiscount').html("");
                valid++;
            }
        }

        if (valid === 3) {
            let data = {
                discountId: discountIdForUpdate,
                discountSize: size,
                startDate: startDate,
                endDate: endDate
            }
            let url = "Controller?command=updateDiscount";
            $.post(url, data, function (data, status) {
                if (data !== "") {
                    $('#errorUpdateDiscountSize').html(data);
                } else {
                    location.reload();
                }
            });
        }
    });

    $('#closeUpdateDiscount').on('click', function () {
        $('#updateDiscountSize').val("");
        $('#updateStartDateDiscount').val("");
        $('#updateEndDateDiscount').val("");
        $('#errorUpdateEndDateDiscount').html("");
        $('#errorUpdateStartDateDiscount').html("");
        $('#errorUpdateDiscountSize').html("");
    });

    var discountIdForTariffs;

    $('.addTariffsForDiscountButton').on('click', function () {
        discountIdForTariffs = $(this).attr('data-discount-id');
        tariffsButtonsOnDiscount();
    });

    var tariffs = [];

    $('.addTariff').on('click', function () {
        let tariffDiscountId = $(this).attr('data-tariff-id');
        $(this).prop('disabled', true);
        tariffs.push(tariffDiscountId);
    });

    $('#closeAddTariffsForDiscount').click(function () {
        tariffs = [];
    });

    $('#addTariffsForDiscountButton').on('click', function () {
        let data = {
            discountId: discountIdForTariffs,
            tariffs: tariffs.toString()
        }
        tariffs.splice(0, tariffs.length);
        let url = "Controller?command=addTariffsToDiscount";
        $.post(url, data, function (data, status) {
            location.reload();
        });
    });

    $('.deleteAdmin').on('click', function () {
        let adminId = $(this).attr('data-admin-id');
        let data = {
            adminId: adminId
        }
        let url = "Controller?command=deleteAdmin";
        $.post(url, data, function (data, status) {
            location.reload();
        });
    });

    $('.deleteUser').on('click', function () {
        let userId = $(this).attr('data-user-id');
        let data = {
            userId: userId
        }
        let url = "Controller?command=deleteUser";
        $.post(url, data, function (data, status) {
            location.reload();
        });
    });

    $('.userStatus').on('click', function () {
        let userIdForStatus = $(this).attr('data-user-id');
        let statusId = $('option:selected', this).attr('value');

        let data = {
            userId: userIdForStatus,
            statusId: statusId
        }
        let url = "Controller?command=chengUserStatus";
        $.post(url, data, function (data, status) {
            location.reload();
        });
    });

    $('.cardAmount').on('keyup', function () {
        let amount = $('.cardAmount').val();
        if (parseFloat(amount) > 0 && parseFloat(amount) <= 1000 && validatePrice(amount)) {
            $('#errorAmount').html("");
        } else {
            $('#errorAmount').html("Wrong input: 0 < amount <= 1000");
        }
    });

    $('#replenishButton').on('click', function () {
        let amount = $('.cardAmount').val();
        let userId = $(this).attr('data-user-id');
        let paymentType = 2;
        let cvv = $('#cc-cvv').val();
        let name = $('#cc-name').val();
        let cardNumber = $('#cc-number').val();
        let expiration = $('#cc-expiration').val();

        if (parseFloat(amount) > 0 && parseFloat(amount) <= 1000 && validatePrice(amount)
            && cardDataValidation(name, cardNumber, cvv, expiration)) {
            let data = {
                userId: userId,
                amount: amount,
                paymentType: paymentType
            }
            let url = "Controller?command=userPayment";
            $.post(url, data, function (data, status) {
                location.reload();
            });
        } else {
            $('#errorAmount').html("Wrong input: 0 < amount <= 1000");
        }
    });

    $('#closeCardForm').on('click', function () {

    });

    $('#replenishAmount').on('keyup', function () {
        let amount = $('#replenishAmount').val();
        if (parseFloat(amount) > 0 && parseFloat(amount) <= 15 && validatePrice(amount)) {
            $('#errorReplenishAmount').html("");
        } else {
            $('#errorReplenishAmount').html("Wrong input: 0 < amount <= 15");
        }
    });

    $('.ReplenishButton').on('click', function () {
        let userId = $(this).attr('data-user-id');
        let paymentType = 3;
        let amount = $('#replenishAmount').val();
        if (parseFloat(amount) > 0 && parseFloat(amount) <= 15 && validatePrice(amount)) {
            let data = {
                userId: userId,
                amount: amount,
                paymentType: paymentType
            }
            let url = "Controller?command=userPayment";
            $.post(url, data, function (data, status) {
                if (data !== "") {
                    $('#errorReplenishAmount').html(data);
                } else {
                    location.reload();
                }
            });
        } else {
            $('#errorReplenishAmount').html("Wrong input: 0 < amount <= 15");
        }
    });

    $('#chengEmailButton').on('click', function () {
        let oldEmail = $(this).attr('data-email');
        let userId = $(this).attr('data-user-id');
        let newEmail = $('#newEmail').val();

        if (oldEmail !== newEmail && newEmail.length !== 0 && validateEmail(newEmail)) {
            let data = {
                userId: userId,
                newEmail: newEmail
            }
            let url = "Controller?command=updateUserEmail";
            $.post(url, data, function (data, status) {
                if (data !== "") {
                    $('#errorNewEmail').html(data);
                } else {
                    location.reload();
                }
            });
        } else {
            $('#errorNewEmail').html("*Email is not valid");
        }
    });

    $('#chengPhoneButton').on('click', function () {
        let oldPhone = $(this).attr('data-phone');
        let userId = $(this).attr('data-user-id');
        let newPhone = $('#newPhone').val();
        let phoneno = /^\+?([0-9]{3})\)?[-. ]?([0-9]{5})[-. ]?([0-9]{4})$/;

        if (oldPhone !== newPhone && newPhone.length !== 0 && phoneno.test(newPhone)) {
            let data = {
                userId: userId,
                newPhone: newPhone
            }
            let url = "Controller?command=updateUserPhone";
            $.post(url, data, function (data, status) {
                if (data !== "") {
                    $('#errorNewPhone').html(data);
                } else {
                    location.reload();
                }
            });
        } else {
            $('#errorNewPhone').html("Wrong input!");
        }
    });

    $('#chengPasswordButton').on('click', function () {
        let accountId = $(this).attr('data-account-id');
        let password = $('#oldPassword').val();
        let newPassword = $('#newPassword').val();
        let secondNewPassword = $('#secondNewPassword').val();

        if (newPassword === secondNewPassword && validatePassword(newPassword)) {
            let data = {
                accountId: accountId,
                password: password,
                newPassword: newPassword
            }
            let url = "Controller?command=updatePassword";
            $.post(url, data, function (data, status) {
                if (data !== "") {
                    $('#errorUpdatePassword').html(data);
                } else {
                    location.reload();
                }
            });
        } else {
            $('#errorUpdatePassword').html("Wrong input!" +
                "<p>*should contain at least one digit</p>" +
                "<p>*should contain at least one lower case</p>" +
                "<p>*should contain at least one upper case\n</p>" +
                "*should contain at least 8 from the mentioned characters");
        }
    });

    $('#registerNewUserAccount').on('click', function () {
        let login = $('#newUserCreateLogin').val();
        let password = $('#newUserCreatePassword').val();
        let firstName = $('#newUserFirstName').val();
        let lastName = $('#newUserLastName').val();
        let phone = $('#newUserPhone').val();
        let email = $('#newUserEmail').val();
        let valid = validateRegisterDataUser(password, login, firstName, lastName, email, phone);

        if (valid >= 6) {
            let data = {
                login: login,
                password: password,
                firstName: firstName,
                lastName: lastName,
                phone: phone,
                email: email
            }
            let url = "Controller?command=registerUser";
            $.post(url, data, function (data, status) {
                console.log(data);
                if (data === "false") {
                    $('#errorLoginUser').html("error: user with this login already exists!");
                } else {
                    location.reload();
                }
            });
        }
    });

    $('#closeRegisterUser').on('click', function () {
        $('#newUserCreateLogin').val("");
        $('#newUserCreatePassword').val("");
        $('#newUserFirstName').val("");
        $('#newUserLastName').val("");
        $('#newUserEmail').val("");
        $('#newUserPhone').val("");
        $('#errorLastNameUser').html("");
        $('#errorLoginUser').html("");
        $('#errorPasswordUser').html("");
        $('#errorFirstNameUser').html("");
        $('#errorEmailUser').html("");
        $('#errorPhoneUser').html("");
    });

    let tariffIdForUpdate;

    $('.updateTariffButton').on('click', function () {
        tariffIdForUpdate = $(this).attr('data-tariff-id');
        $('#updateTariffName').val($(this).attr('data-tariff-name'));
        $('#updateTariffPrice').val($(this).attr('data-tariff-price'));
        $('#updateTariffSpeed').val($(this).attr('data-tariff-speed'));
    });

    $('#updateTariffButton').on('click', function () {
        let name = $('#updateTariffName').val();
        let price = $('#updateTariffPrice').val();
        let speed = $('#updateTariffSpeed').val();
        let valid = 0;

        if (name.length < 2 && name.length !== 0) {
            $('#errorUpdateNameTariff').html("Wrong input: name too short");
        } else {
            $('#errorUpdateNameTariff').html("");
            valid++;
        }
        if (!validateSpeed(speed) || speed === "0" || speed > 999999 || speed === "") {
            $('#errorUpdateSpeedTariff').html("Wrong input: speed > 0 and speed < 100000");
        } else {
            $('#errorUpdateSpeedTariff').html("");
            valid++;
        }
        if (!validatePrice(price) || price === "0" || parseFloat(price) >= 100000 || price === "") {
            $('#errorUpdatePriceTariff').html("Wrong input: price >= 0 and price < 100000");
        } else {
            $('#errorUpdatePriceTariff').html("");
            valid++;
        }

        if (valid === 3) {
            let data = {
                tariffId: tariffIdForUpdate,
                name: name,
                price: price,
                speed: speed
            }
            let url = "Controller?command=updateTariff";
            $.post(url, data, function (data, status) {
                if (data !== "") {
                    $('#errorUpdateNameTariff').html(data);
                } else {
                    location.reload();
                }
            });
        }
    });

    $('.unblockUser').on('click', function () {
        let userId = $(this).attr('data-user-id');
        let data = {
            userId: userId
        }
        let url = "Controller?command=unblockUser";
        $.post(url, data, function (data, status) {
            location.reload();
        });
    });

    $('#chengStatus').on('click', function () {
        let userId = $(this).attr('data-user-id');
        let status = $(this).attr('data-user-status');
        let balance = parseFloat($(this).attr('data-balance'));
        let result = false;

        if (status === "ACTIVATE" && balance >= 0) {
            status = 3;
            result = true;
        } else if (status === "SUSPENDED" && balance >= 0) {
            status = 1;
            result = true;
        } else if (status === "BANNED" && balance >= 0) {
            status = 1;
            result = true;
        } else {
            $('#errorActivateStatus').html('error: you are blocked');
        }

        if (result === true) {
            let data = {
                userId: userId,
                statusId: status,
            }
            let url = "Controller?command=chengUserStatus";
            $.post(url, data, function (data, status) {
                location.reload();
            });
        }
    });

    $('.locale').on('click', function () {
        let locale = $(this).attr('data-locale');
        let data = {
            locale: locale
        }
        let url = "Controller?command=changLanguage";
        $.post(url, data, function (data, status) {
            if (data === "update") {
                location.reload();
            }
        });
    });

    $('#loginButton').on('click', function () {
        let login = $('#loginLoginPage').val();
        let password = $('#floatingPassword').val();
        console.log(login.length + " " + password.length);
        if (login.length !== 0 && password.length !== 0) {
            let data = {
                login: login,
                password: password
            }
            let url = "Controller?command=signIn";
            $.post(url, data, function (data, status) {
                console.log(data);
                if (data === "false") {
                    console.log(data);
                    $('#errorLoginOrPassword').html("error: Incorrect login or password");
                } else {
                    location.reload();
                }
            });
        } else {
            $('#errorLoginOrPassword').html("error: empty login or password");
        }
    });


})
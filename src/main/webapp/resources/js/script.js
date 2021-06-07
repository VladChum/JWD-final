$("document").ready(function () {
    $('.chengTariffButton').on('click', function () {
        var id = $(this).attr('data-tariff-id');
        var url = "Controller?command=updateUserTariff";
        var data = {tariffId: id};
        $.post(url, data, function (data, status) {
            location.reload();
        });
    });

    $('#newUserCreateLogin').on('keyup', function () {
        var login = $('#newUserCreateLogin').val();
        if (login.length < 5 || login.length > 30) {
            $('#errorLoginUser').html("Wrong input: login must be 5 to 30 characters long");
        } else {
            $('#errorLoginUser').html("");

        }
    });

    $('#newUserCreatePassword').on('keyup', function () {
        var password = $('#newUserCreatePassword').val();
        if (password.length < 8 || password.length > 30) {
            $('#errorPasswordUser').html("Wrong input: password must be 8 to 30 characters long");
        } else {
            $('#errorPasswordUser').html("");
        }
    });

    $('#createUserButton').on('click', function () {
        var login = $('#newUserCreateLogin').val();
        var password = $('#newUserCreatePassword').val();
        var firstName = $('#newUserFirstName').val();
        var lastName = $('#newUserLastName').val();
        var phone = $('#newUserPhone').val();
        var email = $('#newUserEmail').val();
        var valid = 0;

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

        if (valid >= 4) {
            var data = {
                login: login,
                password: password,
                firstName: firstName,
                lastName: lastName,
                phone: phone,
                email: email
            }
            var url = "Controller?command=createUser";
            $.post(url, data, function (data, status) {
                location.reload();
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
        var login = $('#newAdminCreateLogin').val();
        if (login.length < 5 || login.length > 30) {
            $('#errorLoginAdmin').html("Wrong input: login must be 5 to 30 characters long");
        } else {
            $('#errorLoginAdmin').html("");
        }
    });

    $('#newAdminCreatePassword').on('keyup', function () {
        var password = $('#newAdminCreatePassword').val();
        if (password.length < 8 || password.length > 30) {
            $('#errorPasswordAdmin').html("Wrong input: password must be 8 to 30 characters long");
        } else {
            $('#errorPasswordAdmin').html("");
        }
    });

    $('#createAdminButton').on('click', function () {
        var login = $('#newAdminCreateLogin').val();
        var password = $('#newAdminCreatePassword').val();
        var valid = 0;

        if (password.length >= 8 || password.length <= 30) {
            valid++;
        }
        if (login.length >= 5 || login.length <= 30) {
            valid++;
        }

        if (valid == 2) {
            var data = {
                login: login,
                password: password,
            }
            var url = "Controller?command=createAdmin";
            $.post(url, data, function (data, status) {
                location.reload();
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
        var name = $('#newTariffName').val();
        if (name.length < 2 && name.length !== 0) {
            $('#errorNameTariff').html("Wrong input: name too short");
        } else {
            $('#errorNameTariff').html("");
        }
    });

    $('#newTariffSpeed').on('keyup', function () {
        var speed = parseInt($('#newTariffSpeed').val());
        if (speed <= 0 || speed > 100000000) {
            $('#errorSpeedTariff').html("Wrong input: speed > 0 and speed < 100000000");
        } else {
            $('#errorSpeedTariff').html("");
        }
    });

    $('#newTariffPrice').on('keyup', function () {
        var price = parseFloat($('#newTariffPrice').val());
        if (price < 0 || price > 100000000) {
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
        var name = $('#newTariffName').val();
        var price = parseFloat($('#newTariffPrice').val());
        var speed = parseInt($('#newTariffSpeed').val());
        var valid = 0;

        if (name.length < 2 && name.length !== 0) {
            $('#errorNameTariff').html("Wrong input: name too short");
        } else {
            $('#errorNameTariff').html("");
            valid++;
        }
        if (speed <= 0 || speed > 100000000) {
            $('#errorSpeedTariff').html("Wrong input: speed > 0 and speed < 100000000");
        } else {
            $('#errorSpeedTariff').html("");
            valid++;
        }
        if (price < 0 || price > 100000000) {
            $('#errorPriceTariff').html("Wrong input: price >= 0 and price < 100000000");
        } else {
            $('#errorPriceTariff').html("");
            valid++;
        }

        if (valid === 3) {
            var data = {
                name: name,
                price: price,
                speed: speed
            }
            var url = "Controller?command=createTariff";
            $.post(url, data, function (data, status) {
                location.reload();
            });
        }
    });

    $('.archiveTariffButton').on('click', function () {
        var tariffId = $(this).attr('data-tariff-id');
        var data = {
            tariffId: tariffId
        }
        var url = "Controller?command=deleteTariff";
        $.post(url, data, function (data, status) {
            location.reload();
        });
    });

    $('.activateTariffButton').on('click', function () {
        var tariffId = $(this).attr('data-tariff-id');
        var data = {
            tariffId: tariffId
        }
        var url = "Controller?command=activateTariff";
        $.post(url, data, function (data, status) {
            location.reload();
        });
    });

    $('#newDiscountSize').on('keyup', function () {
        let size = parseFloat($('#newDiscountSize').val());
        if (size > 0 && size <= 100 || $('#newDiscountSize').val().length === 0) {
            $('#errorDiscountSize').html("");
        } else {
            $('#errorDiscountSize').html("Wrong input: 0 < discount size < 100");
        }
    });

    $('#newStartDateDiscount').on('keyup', function () {
        var startDate = $('#newStartDateDiscount').val();
        if (startDate.length != 10) {
            $('#errorStartDateDiscount').html("Wrong input: date example 2020-03-03");
        } else {
            $('#errorStartDateDiscount').html("");
        }
    });

    $('#newEndDateDiscount').on('keyup', function () {
        var endDate = $('#newEndDateDiscount').val();
        if (endDate.length != 10) {
            $('#errorEndDateDiscount').html("Wrong input: date example 2020-03-04");
        } else {
            $('#errorEndDateDiscount').html("");
        }
    });
    // доделать нормальную проверку даты

    $('#createDiscount').on('click', function () {
        var size = parseFloat($('#newDiscountSize').val());
        var startDate = $('#newStartDateDiscount').val();
        var endDate = $('#newEndDateDiscount').val();
        var valid = 0;

        var startDateTime = new Date(startDate);
        var endDateTime = new Date(endDate);

        if (startDate > endDate) {
            $('#errorEndDateDiscount').html("Wrong input: date example 2020-03-04");
            $('#errorStartDateDiscount').html("Wrong input: date example 2020-03-04");
        } else {
            if (size > 0 && size <= 100 && $('#newDiscountSize').val().length != 0) {
                $('#errorDiscountSize').html("");
                valid++;
            } else {
                $('#errorDiscountSize').html("Wrong input:  0 < discount size < 100");
            }
            if (endDate.length != 10) {
                $('#errorEndDateDiscount').html("Wrong input: date example 2020-03-04");
            } else {
                $('#errorEndDateDiscount').html("");
                valid++;
            }
            if (startDate.length != 10) {
                $('#errorStartDateDiscount').html("Wrong input: date example 2020-03-04");
            } else {
                $('#errorStartDateDiscount').html("");
                valid++;
            }
        }

        if (valid === 3) {
            var data = {
                size: size,
                startDate: startDate,
                endDate: endDate
            }
            var url = "Controller?command=createDiscount";
            $.post(url, data, function (data, status) {
                location.reload();
            });
        }
    });

    $('.archiveDiscountButton').on('click', function () {
        var discountId = $(this).attr('data-tariff-id');
        var data = {
            discountId: discountId
        }
        var url = "Controller?command=stopDiscount";
        $.post(url, data, function (data, status) {
            location.reload();
        });
    });

    var discountIdForUpdate;

    $('.updateDiscountButton').on('click', function () {
        var size = $(this).attr('data-discount-size');
        var startDate = $(this).attr('date-discount-start');
        var endDate = $(this).attr('data-discount-end');
        discountIdForUpdate = $(this).attr('data-discount-id');

        document.getElementById('updateDiscountSize').value = size;
        document.getElementById('updateEndDateDiscount').value = endDate;
        document.getElementById('updateStartDateDiscount').value = startDate;
    });

    $('#updateDiscountSize').on('keyup', function () {
        var size = parseFloat($('#updateDiscountSize').val());
        if (size > 0 && size <= 100 || $('#updateDiscountSize').val().length === 0) {
            $('#errorUpdateDiscountSize').html("");
        } else {
            $('#errorUpdateDiscountSize').html("Wrong input: 0 < discount size < 100");
        }
    });

    $('#updateStartDateDiscount').on('keyup', function () {
        var startDate = $('#updateStartDateDiscount').val();
        if (startDate.length != 10) {
            $('#errorUpdateStartDateDiscount').html("Wrong input: date example 2020-03-03");
        } else {
            $('#errorUpdateStartDateDiscount').html("");
        }
    });

    $('#updateEndDateDiscount').on('keyup', function () {
        var endDate = $('#updateEndDateDiscount').val();
        if (endDate.length != 10) {
            $('#errorUpdateEndDateDiscount').html("Wrong input: date example 2020-03-04");
        } else {
            $('#errorUpdateEndDateDiscount').html("");
        }
    });

    $('#updateDiscountButton').on('click', function () {
        var size = parseFloat($('#updateDiscountSize').val());
        var startDate = $('#updateStartDateDiscount').val();
        var endDate = $('#updateEndDateDiscount').val();
        var valid = 0;

        var startDateTime = new Date(startDate);
        var endDateTime = new Date(endDate);

        if (startDate > endDate) {
            $('#errorUpdateStartDateDiscount').html("Wrong input: date example 2020-03-03");
            $('#errorUpdateEndDateDiscount').html("Wrong input: date example 2020-03-04");
        } else {
            if (size > 0 && size <= 100 || $('#updateDiscountSize').val().length === 0) {
                $('#errorUpdateDiscountSize').html("");
                valid++;
            } else {
                $('#errorUpdateDiscountSize').html("Wrong input: 0 < discount size < 100");
            }
            if (startDate.length != 10) {
                $('#errorUpdateStartDateDiscount').html("Wrong input: date example 2020-03-03");
            } else {
                $('#errorUpdateStartDateDiscount').html("");
                valid++;
            }
            if (endDate.length != 10) {
                $('#errorUpdateEndDateDiscount').html("Wrong input: date example 2020-03-04");
            } else {
                $('#errorUpdateEndDateDiscount').html("");
                valid++;
            }
        }

        if (valid === 3) {
            var data = {
                discountId: discountIdForUpdate,
                discountSize: size,
                startDate: startDate,
                endDate: endDate
            }
            var url = "Controller?command=updateDiscount";
            $.post(url, data, function (data, status) {
                location.reload();
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
    });

    var tariffs = [];

    $('.addTariff').on('click', function () {
        var tariffDiscountId = $(this).attr('data-tariff-id');
        $(this).prop('disabled', true);
        tariffs.push(tariffDiscountId);
    });

    //ToDo изменить оброботку события при создании
    $('.addTariff').on('mouseenter', function () {
        var tariffDiscountId = $(this).attr('data-discount-id');
        var discountId = discountIdForTariffs;
        if (tariffDiscountId === discountId) {
            $(this).prop('disabled', true);
        }
    });

    $('#addTariffsForDiscountButton').on('click', function () {
        var data = {
            discountId: discountIdForTariffs,
            tariffs: tariffs.toString()
        }
        tariffs.splice(0, tariffs.length);
        var url = "Controller?command=addTariffsToDiscount";
        $.post(url, data, function (data, status) {
            location.reload();
        });
    });

    $('.deleteAdmin').on('click', function () {
        var adminId = $(this).attr('data-admin-id');
        var data = {
            adminId: adminId
        }
        var url = "Controller?command=deleteAdmin";
        $.post(url, data, function (data, status) {
            location.reload();
        });
    });

    $('.deleteUser').on('click', function () {
        var userId = $(this).attr('data-user-id');
        var data = {
            userId: userId
        }
        var url = "Controller?command=deleteUser";
        $.post(url, data, function (data, status) {
            location.reload();
        });
    });

    $('.userStatus').on('click', function () {
        var userIdForStatus = $(this).attr('data-user-id');
        var statusId = $('option:selected', this).attr('value');
        ;
        var data = {
            userId: userIdForStatus,
            statusId: statusId
        }
        var url = "Controller?command=chengUserStatus";
        $.post(url, data, function (data, status) {
            location.reload();
        });
    });

    $('.cardAmount').on('keyup', function () {
        var amount = parseFloat($('.cardAmount').val());
        if ((amount > 1000 || amount <= 0) && $('.cardAmount').val().length !== 0) {
            $('#errorAmount').html("Wrong input: 0 < amount <= 1000");
        } else {
            $('#errorAmount').html("");
        }
    });

    $('#replenishButton').on('click', function () {
        var amount = parseFloat($('.cardAmount').val());
        var userId = $(this).attr('data-user-id');
        var paymentType = 2;
        if ((amount > 1000 || amount <= 0) || $('.cardAmount').val().length === 0) {
            $('#errorAmount').html("Wrong input: 0 < amount <= 1000");
        } else {
            var data = {
                userId: userId,
                amount: amount,
                paymentType: paymentType
            }
            var url = "Controller?command=userPayment";
            $.post(url, data, function (data, status) {
                location.reload();
            });
        }
    });

    $('#closeCardForm').on('click', function () {

    });

    $('#replenishAmount').on('keyup', function () {
        var amount = parseFloat($('#replenishAmount').val());
        if ((amount > 15 || amount <= 0) && $('#replenishAmount').val().length !== 0) {
            $('#errorReplenishAmount').html("Wrong input: 0 < amount <= 15");
        } else {
            $('#errorReplenishAmount').html("");
        }
    });

    $('.ReplenishButton').on('click', function () {
        var userId = $(this).attr('data-user-id');
        var paymentType = 3;
        var amount = parseFloat($('#replenishAmount').val());
        if ((amount > 15 || amount <= 0) || $('#replenishAmount').val().length === 0) {
            $('#errorReplenishAmount').html("Wrong input: 0 < amount <= 15");
        } else {
            var data = {
                userId: userId,
                amount: amount,
                paymentType: paymentType
            }
            var url = "Controller?command=userPayment";
            $.post(url, data, function (data, status) {
                location.reload();
            });
        }
    });

    $('#chengEmailButton').on('click', function () {
        var oldEmail = $(this).attr('data-email');
        var userId = $(this).attr('data-user-id');
        var newEmail = $('#newEmail').val();

        if (oldEmail !== newEmail && newEmail.length !== 0) {
            var data = {
                userId: userId,
                newEmail: newEmail
            }
            var url = "Controller?command=updateUserEmail";
            $.post(url, data, function (data, status) {
                location.reload();
            });
        } else {
            $('#errorNewEmail').html("Wrong input!");
        }
    });

    $('#chengPhoneButton').on('click', function () {
        var oldPhone = $(this).attr('data-phone');
        var userId = $(this).attr('data-user-id');
        var newPhone = $('#newPhone').val();

        if (oldPhone !== newPhone && newPhone.length !== 0) {
            var data = {
                userId: userId,
                newPhone: newPhone
            }
            var url = "Controller?command=updateUserPhone";
            $.post(url, data, function (data, status) {
                location.reload();
            });
        } else {
            $('#errorNewPhone').html("Wrong input!");
        }
    });

    //todo доделать проверку пароля
    $('#chengPasswordButton').on('click', function () {
        var accountId = $(this).attr('data-account-id');
        var password = $('#oldPassword').val();
        var newPassword = $('#newPassword').val();
        var secondNewPassword = $('#secondNewPassword').val();

        if (newPassword === secondNewPassword && newPassword.length !== 0) {
            var data = {
                accountId: accountId,
                password: password,
                newPassword: newPassword
            }
            var url = "Controller?command=updatePassword";
            $.post(url, data, function (data, status) {
                location.reload();
            });
        } else {
            $('#errorUpdatePassword').html("Wrong input!");
        }
    });

    $('#registerNewUserAccount').on('click', function () {
        var login = $('#newUserCreateLogin').val();
        var password = $('#newUserCreatePassword').val();
        var firstName = $('#newUserFirstName').val();
        var lastName = $('#newUserLastName').val();
        var phone = $('#newUserPhone').val();
        var email = $('#newUserEmail').val();
        var valid = 0;

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

        if (valid >= 4) {
            var data = {
                login: login,
                password: password,
                firstName: firstName,
                lastName: lastName,
                phone: phone,
                email: email
            }
            var url = "Controller?command=registerUser";
            $.post(url, data, function (data, status) {
                location.reload();
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

    var tariffIdForUpdate;

    $('.updateTariffButton').on('click', function () {
        tariffIdForUpdate = $(this).attr('data-tariff-id');
        $('#updateTariffName').val($(this).attr('data-tariff-name'));
        $('#updateTariffPrice').val($(this).attr('data-tariff-price'));
        $('#updateTariffSpeed').val($(this).attr('data-tariff-speed'));
    });

    $('#updateTariffButton').on('click', function () {
        var name = $('#updateTariffName').val();
        var price = parseFloat($('#updateTariffPrice').val());
        var speed = parseInt($('#updateTariffSpeed').val());
        var valid = 0;

        if (name.length < 2 && name.length !== 0) {
            $('#errorUpdateNameTariff').html("Wrong input: name too short");
        } else {
            $('#errorUpdateNameTariff').html("");
            valid++;
        }
        if (speed <= 0 || speed > 100000000) {
            $('#errorUpdateSpeedTariff').html("Wrong input: speed > 0 and speed < 100000000");
        } else {
            $('#errorUpdateSpeedTariff').html("");
            valid++;
        }
        if (price < 0 || price > 100000000) {
            $('#errorUpdatePriceTariff').html("Wrong input: price >= 0 and price < 100000000");
        } else {
            $('#errorUpdatePriceTariff').html("");
            valid++;
        }

        if (valid === 3) {
            var data = {
                tariffId: tariffIdForUpdate,
                name: name,
                price: price,
                speed: speed
            }
            var url = "Controller?command=updateTariff";
            $.post(url, data, function (data, status) {
                location.reload();
            });
        }
    });

    $('.unblockUser').on('click', function () {
        var userId = $(this).attr('data-user-id');
        var data = {
            userId: userId
        }
        var url = "Controller?command=unblockUser";
        $.post(url, data, function (data, status) {
            location.reload();
        });
    });

})
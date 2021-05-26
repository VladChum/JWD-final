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

    $('.activateTariffButton').on('click', function() {
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
            $('#errorNameTariff').html("Wrong input: date example 2020-03-04");
        } else {
            $('#errorNameTariff').html("");
        }
    });
    // доделать нормальную проверку даты

    $('#createDiscount').on('click', function () {
        var size = parseFloat($('#newDiscountSize').val());
        var startDate = $('#newStartDateDiscount').val();
        var endDate = $('#newEndDateDiscount').val();
        var valid = 0;

        if (size > 0 && size <= 100 && $('#newDiscountSize').val().length === 0) {
            $('#errorDiscountSize').html("");
            valid++;
        } else {
            $('#errorDiscountSize').html("Wrong input: name too short");
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
})
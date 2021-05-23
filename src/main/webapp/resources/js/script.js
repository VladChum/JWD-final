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

    $('#closeCreateAdminModal').on('click', function (){
        $('#newAdminCreatePassword').val("");
        $('#newAdminCreateLogin').val("");
        $('#errorPasswordAdmin').html("");
        $('#errorLoginAdmin').html("");
    });
})
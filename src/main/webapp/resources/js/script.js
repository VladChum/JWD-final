$("document").ready(function (){
    $('.chengTariffButton').on('click', function (){
        var id = $(this).attr('data-tariff-id');
        var url = "Controller?command=updateUserTariff";
        var data = {tariffId: id};
        $.post(url, data, function (data, status){
            location.reload();
        });
    });
})
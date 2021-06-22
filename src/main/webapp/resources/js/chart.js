$("document").ready(function () {
    const data = {
        labels: [
            'active',
            'baned',
            'suspended'
        ],
        datasets: [{
            label: 'users',
            data: [parseInt($("#myChart").attr('data-active')),
                parseInt($("#myChart").attr('data-baned')),
                parseInt($("#myChart").attr('data-suspended'))],
            backgroundColor: [
                '#00AF41',
                '#f5041f',
                '#FFC843'
            ],
            hoverOffset: 4
        }]
    };

    const config = {
        type: 'doughnut',
        data: data
    };

    let myChart = $('#myChart');
    let usersChart = new Chart(myChart, config);

    const dataTariffs = {
        labels: [
            'active',
            'suspended'
        ],
        datasets: [{
            label: 'users',
            data: [parseInt($("#tariffsChart").attr('data-active')),
                parseInt($("#tariffsChart").attr('data-suspended'))],
            backgroundColor: [
                'rgb(72,9,243)',
                'rgb(118,13,137)'
            ],
            hoverOffset: 4
        }]
    };

    const configTariffs = {
        type: 'doughnut',
        data: dataTariffs
    };

    let tariffChart = $('#tariffsChart');
    let tariff = new Chart(tariffChart, configTariffs);

    const dataDiscounts = {
        labels: [
            'active',
            'archive',
            'planed'
        ],
        datasets: [{
            label: 'users',
            data: [parseInt($("#discountsChart").attr('data-active')),
                parseInt($("#discountsChart").attr('data-baned')),
                parseInt($("#discountsChart").attr('data-planed'))],
            backgroundColor: [
                '#00AF41',
                '#0071CE',
                '#FFC843'
            ],
            hoverOffset: 4
        }]
    };

    const configDiscounts = {
        type: 'doughnut',
        data: dataDiscounts
    };

    let discountChart = $('#discountsChart');
    let discount = new Chart(discountChart, configDiscounts);
})
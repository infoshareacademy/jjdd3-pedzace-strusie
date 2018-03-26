<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Expenses by categories</title>

    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
        google.charts.load('current', {'packages': ['corechart']});
        google.charts.setOnLoadCallback(drawChart);
        function drawChart() {
            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Expenses');
            data.addColumn('number', 'Values');
            data.addRows([
            <#list chartData>
                <#items as map>
                        ['${map.getKey()}', parseFloat("${map.getValue()}".replace(",", "."))]
                </#items>
            </#list>
            ]);
            var options = {
                'title': 'Expenses sorted by categories',
                'width': 600,
                'height': 400,
                is3D: true,
            };
            var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
            chart.draw(data, options);
        }
    </script>
</head>
<body>
<div class="container">
    <div id="chart_div"></div>
</div>
<div class="container">

    <#if errors??>
        <#list errors>
            <ul>
                <#items as error>
                    <li style="...">${error}</li>
                </#items>
            </ul>
        </#list>
    </#if>

    <div class="col-md-8">

        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Category</th>
                <th scope="col">Expenses[PLN]</th>
            </tr>
            </thead>
            <tbody>
            <#list maps>
                <#items as map>
                <tr>
                    <th scope="row">#</th>
                    <td> ${map.getKey()}</td>
                    <td> ${map.getValue()}</td>

                </tr>
                </#items>
            </#list>
            </tbody>
            <tfoot>
            <tr>
                <th scope="col">Total expenses:</th>
                <th scope="col"></th>
                <th scope="col"><strong>${sumExpenses}</strong></th>
            </tr>
            <tr>
                <th scope="col">Total incomes:</th>
                <th scope="col"></th>
                <th scope="col"><strong>${sumIncomes}</strong></th>
            </tr>
            </tfoot>
        </table>

    </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
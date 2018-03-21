<!DOCTYPE html>
<html>
<head>
    <title>Map list</title>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">

        // Load the Visualization API and the corechart package.
        google.charts.load('current', {'packages': ['corechart']});

        // Set a callback to run when the Google Visualization API is loaded.
        google.charts.setOnLoadCallback(drawChart);

        // Callback that creates and populates a data table,
        // instantiates the pie chart, passes in the data and
        // draws it.
        function drawChart() {

            // Create the data table.
            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Expenses');
            data.addColumn('number', 'Values');
            data.addRows([
                <#list chartData?keys as dataKey>
                        ['${dataKey}', ${chartData[dataKey]}],

                </#list>]
            );

            // Set chart options
            var options = {
                'title': 'How Much Pizza I Ate Last Night',
                'width': 700,
                'height': 500
            };

            // Instantiate and draw our chart, passing in some options.
            var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
            chart.draw(data, options);
        }
    </script>
</head>

<body>
<col>
<#list maps>
    <#items as map>
        <div>
            <p>Months: ${map.getKey()}</p>
            <p>Expenses: ${map.getValue()}</p>
        </div>
    </#items>
</#list>

<p>sunExpenses: <strong>${sumExpenses}</strong></p>
<p>sumIncomes: <strong>${sumIncomes}</strong></p>

<div id="chart_div"></div>

<#include "footer.ftlh">
</body>
</html>
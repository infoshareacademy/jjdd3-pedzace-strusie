<html>
<head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
        google.charts.load("current", {packages:["corechart"]});
        google.charts.setOnLoadCallback(drawChart);
        function drawChart() {
            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Expenses');
            data.addColumn('number', 'Values');
            data.addRows([
            <#list chartData>
                <#items as map>
                        ['${map.getKey()}', ${map.getValue()}],
                </#items>
            </#list>
            ]);
            var options = {
                title: 'My Daily Activities',
                is3D: true,
            };

            var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
            chart.draw(data, options);
        }
    </script>
</head>

<body>
<div id="piechart_3d" style="width: 900px; height: 500px;"></div>
</body>
</html>
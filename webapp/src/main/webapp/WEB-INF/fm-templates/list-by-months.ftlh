<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

</head>

<body>
<div class="container">
    <div class="col">
        <div id="chart_div"></div>

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
        <#include "footer.ftlh">
    </div>

</div>

</body>
</html>
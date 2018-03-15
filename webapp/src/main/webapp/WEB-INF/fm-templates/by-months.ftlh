<!DOCTYPE html>
<html>
<head>
    <title>Map list</title>
</head>
<body>
<#list maps>
    <#items as map>
        <div>
            <p>Months: ${map.getKey()}</p>
            <p>Expenses: ${map.getValue()}</p>
        <#sep><p>=======================</p></#sep>
        </div>
    </#items>
</#list>
<p>sunExpenses: <strong>${sumExpenses}</strong></p>
<p>sumIncomes: <strong>${sumIncomes}</strong></p>

<#include "footer.ftlh">
</body>
</html>
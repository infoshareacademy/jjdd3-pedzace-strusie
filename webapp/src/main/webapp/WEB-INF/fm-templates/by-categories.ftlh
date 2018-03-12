<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Map list</title>
</head>
<body>
<#list maps>
    <#items as map>
        <div >
            <p>Category: ${map.getKey()}</p>
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
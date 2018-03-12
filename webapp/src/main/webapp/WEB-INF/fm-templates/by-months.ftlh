<!DOCTYPE html>
<html>
<head>
    <title>Map list</title>
</head>
<body>
<#list maps>
    <#items as map>
        <div style="color: red;">
            <p>Months: ${map.getKey()}</p>
            <p>Expenses: ${map.getValue()}</p>
        <#sep><p>=======================</p></#sep>
        </div>
    </#items>
</#list>
<p>sunExpenses: ${sumExpenses}</p>
<p>sumIncoms: ${sumIncoms}</p>

<#include "footer.ftlh">
</body>
</html>
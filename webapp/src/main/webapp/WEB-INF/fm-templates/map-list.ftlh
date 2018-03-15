<!DOCTYPE html>
<html>
<head>
    <title>Map list</title>
</head>
<body>
<#list users>
    <#items as user>
        <div>
            <p>Key: ${user.getKey()}</p>
            <p>Value: ${user.getValue()}</p>
        <#sep><p>=======================</p></#sep>
        </div>
    </#items>
</#list>
<p>sunEx: ${sumEx}</p>
<p>sumIn: ${sumIn}</p>

<#include "footer.ftlh">
</body>
</html>
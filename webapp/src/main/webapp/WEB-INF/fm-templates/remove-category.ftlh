<!DOCTYPE html>
<html>
<head>
    <title>Remove category template</title>
</head>
<body>
<#if errors??>
    <#list errors>
    <ul>
        <#items as error>
            <li style="color: #ff0000; font-weight: bold; font-size: 14px;">${error}</li>
        </#items>
    </ul>
    </#list>
</#if>
<form method="post" action="/${action!"remove-category"}" enctype="multipart/form-data">
    Category: <input type="text" name="name" value="${(category)!}"/><br/><br/>
    <input type="submit" name="remove" value="remove"/><br/><br/>
</form>
<#include "footer.ftlh">
</body>
</html>
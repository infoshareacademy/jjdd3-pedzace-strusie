<!DOCTYPE html>
<html>
<head>
    <title>Users list</title>
</head>
<body>
<#list users>
    <#items as user>
        <div style="color: red;">
            <p>ID: ${user.id}</p>
            <p>Login: ${user.login}</p>
            <p>Name: ${user.name}</p>
            <p><a href="/edit-user?id=${user.id}">Edit user</a></p>
        <#sep><p>=======================</p></#sep>
        </div>
    </#items>
</#list>
<#include "footer.ftlh">
</body>
</html>
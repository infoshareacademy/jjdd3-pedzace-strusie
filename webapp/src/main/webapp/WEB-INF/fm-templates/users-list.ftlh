<!DOCTYPE html>
<html>
<head>
    <title>Users list</title>
</head>
<body>
<#list users>
    <#items as user>
        <#if user.age <= 20 >
        <div style="color: green;">
        <#elseif (user.age > 20 && user.age < 50) >
        <div style="color: blue;">
        <#else>
        <div style="color: red;">
        </#if>
            <p>ID: ${user.id}</p>
            <p>Login: ${user.login}</p>
            <p>Name: ${user.name}</p>
            <p>Age: ${user.age}</p>
            <p>Gender: ${user.gender}</p>
            <#if (user.imageURL)??>
            <img src="${user.imageURL}" width="200"/>
            </#if>
            <p><a href="/edit-user?id=${user.id}">Edit user</a></p>
        <#sep><p>=======================</p></#sep>
        </div>
    </#items>
</#list>
<#include "footer.ftlh">
</body>
</html>
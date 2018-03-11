<!DOCTYPE html>
<html>
<head>
    <title>Welcome user template</title>
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
<form method="post" action="/${action!"add-user"}" enctype="multipart/form-data">
    ID: <input type="text" name="id" value="${(user.id)!}"/><br/><br/>
    Name: <input type="text" name="name" value="${(user.name)!}"/><br/><br/>
    Login: <input type="text" name="login" value="${(user.login)!}"/><br/><br/>
    Password: <input type="password" name="password"/><br/><br/>
    Age: <input type="text" name="age" value="${(user.age)!}"/><br/><br/>
    Image: <input type="file" name="image"/><br/><br/>
    <input type="submit" name="save" value="save"/><br/><br/>
</form>
</body>
</html>
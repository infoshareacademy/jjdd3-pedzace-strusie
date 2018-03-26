<#--<!DOCTYPE html>-->
<#--<html>-->
<#--<head>-->
    <#--<title>Add category template</title>-->
<#--</head>-->
<#--<body>-->
<#--<#if errors??>-->
    <#--<#list errors>-->
    <#--<ul>-->
        <#--<#items as error>-->
            <#--<li style="color: #ff0000; font-weight: bold; font-size: 14px;">${error}</li>-->
        <#--</#items>-->
    <#--</ul>-->
    <#--</#list>-->
<#--</#if>-->
<#--<form method="post" action="/${action!"budget/add-category"}" enctype="multipart/form-data">-->
    <#--Category: <input type="text" name="name" value="${(category)!}"/><br/><br/>-->
    <#--<input type="submit" name="save" value="save"/><br/><br/>-->
<#--</form>-->
<#--<#include "footer.ftlh">-->
<#--</body>-->
<#--</html>-->


<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Add category template</title>
</head>
<body>

<div class="container">

    <#if errors??>
        <#list errors>
            <ul>
                <#items as error>
                    <li style="...">${error}</li>
                </#items>
            </ul>
        </#list>
    </#if>

    <div class="col-md-8">
        <form name="incomesForm" method="post" action="/${action!"budget/add-category"}">
            <div class="form-group">
                <label>Category name</label>
                <input type="text" class="form-control" placeholder="Please type in category name" name="name"
                       value="${(category)!}">
            </div>
            <input type="submit" class="btn btn-primary" value="Save">
        </form>
    </div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>

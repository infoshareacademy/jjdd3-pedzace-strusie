<#--<!DOCTYPE html>-->
<#--<html>-->
<#--<head>-->
    <#--<title>Categories list</title>-->
<#--</head>-->
<#--<body>-->
<#--<#list categories>-->
  <#--<ol>-->
    <#--<#items as category>-->
        <#--<li> ${category}</li>-->
    <#--</#items>-->
  <#--</ol>-->
<#--<#else>-->
  <#--<p>No categories found-->
<#--</#list>-->
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

    <title>Expense Service</title>
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
        <form name="expenseForm" method="post" action="/${action!"add-expense"}">

            <div class="form-group">
                <label>Categories</label>

                <select class="form-control" name="category">
                    <#list categories>
  <ol>
    <#items as category>
        <option> ${category.category}</option>
    </#items>
  </ol>
                    <#else>
  <p>No categories found
                    </#list>
                </select>
                <small class="form-text text-muted">Please choose category.</small>

                <input type="submit" class="btn btn-primary" value="Save my expense">
            </div>
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
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Period date</title>
</head>
<body>

<div class="container">
    <div class="col-md-8">

    </div>
    <br>

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
        <form name="periodExpensesForm" method="post" action="/${action!"budget/get-expensesbycat"}">
            <div class="form-group">
                <label> Start date</label>
                <input type="date" class="form-control" name="minDatePeriod" value="${(minDatePeriod)!}">
                <small class="form-text text-muted"> Please type in start date</small>
            </div>
            <div class="form-group">
                <label> End date</label>
                <input type="date" class="form-control" name="maxDatePeriod" value="${(maxDatePeriod)!}">
                <small class="form-text text-muted"> Please type in end date</small>
            </div>
            <input type="submit" class="btn btn-primary" value="Ok">
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

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
    <div class="col-md-8">
        <p> We invite you to get great experience with using our application. Please fill each field of
            our form. We kindly thank you for using our application.</p>
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
        <form name="expenseForm" method="post" action="/${action!"add-expense"}">
            <div class="form-group">
                <label> Date of expense</label>
                <input type="date" class="form-control" name="date" value="${(expense.date)!}">
                <small class="form-text text-muted"> Please choose date of your expense</small>
            </div>
            <div class="form-group">
                <label>Category</label>
                <select class="form-control" name="category">
                    <#list categories>
                        <#items as category>
                            <option>${category.category}</option>
                        </#items>
                    <#else>
                        <p>No categories found</p>
                    </#list>
                </select>
                <small class="form-text text-muted">Please choose category of your expense.
                </small>
                <br>
                <div class="form-group">
                    <label>Value of expense</label>
                    <input type="text" class="form-control" placeholder="Please enter value of your expense"
                           name="expense" value="${(expense.expense)!}">
                    <small class="form-text text-muted">Please enter value of your expense. We'll never
                        share this information with anyone else.
                    </small>
                </div>
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
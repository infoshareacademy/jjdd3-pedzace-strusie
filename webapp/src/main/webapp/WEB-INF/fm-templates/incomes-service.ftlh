<title>Expense Service</title>
</head>
<body>

<div class="container">
    <div class="col-md-8">
        <p> We invite you to get great experience with using our application. Please fill each field of
            our form. We kindly thank you for using our application.</p>
    </div>
    <br>
    <div class="col-md-8">
        <form name="incomesForm" method="post" action="IncomeServiceServlet">
            <div class="form-group">
                <label> Date of income</label>
                <input type="date" class="form-control" name="date">
                <small class="form-text text-muted"> Please choose date of your income</small>
            </div>
            <div class="form-group">
                <label>Value of income</label>
                <input type="text" class="form-control" placeholder="Please enter value of your income">
                <small class="form-text text-muted">Please enter value of your income. We'll never
                    share this information with anyone else.
                </small>
            </div>
            <input type="submit" class="btn btn-primary" value="Save my income">
        </form>
    </div>
</div>



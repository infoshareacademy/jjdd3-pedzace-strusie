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
        <form name="expenseForm" method="post" action="ExpenseServiceServlet">
            <div class="form-group">
                <label> Date of expense</label>
                <input type="date" class="form-control" name="date">
                <small class="form-text text-muted"> Please choose date of your expense</small>
            </div>
            <div class="form-group">
                <label>Category</label>
                <select class="form-control" name="category">
                    <option>Plese select your expense</option>
                    <option>accomodation</option>
                    <option>broadband</option>
                    <option>children</option>
                    <option>clothes</option>
                    <option>entertainment</option>
                    <option>food</option>
                    <option>health</option>
                    <option>hygiene</option>
                    <option>loans</option>
                    <option>others</option>
                    <option>savings</option>
                    <option>transportaion</option>
                </select>
                <small class="form-text text-muted">Please choose category of your expense.
                </small>
                <br>
                <div class="form-group">
                    <label>Value of expense</label>
                    <input type="text" class="form-control" placeholder="Please enter value of your expense">
                    <small class="form-text text-muted">Please enter value of your expense. We'll never
                        share this information with anyone else.
                    </small>
                </div>
                <input type="submit" class="btn btn-primary" value="Save my expense">
            </div>
        </form>
    </div>
</div>


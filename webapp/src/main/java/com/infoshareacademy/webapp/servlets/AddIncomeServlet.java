package com.infoshareacademy.webapp.servlets;


//import com.infoshareacademy.webapp.dao.IncomeDaoBean;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/add-income")
public class AddIncomeServlet extends HttpServlet {

   /* private static final Logger logger = Logger.getLogger(getClass().getName());

    private Template template;

    @EJB
    private IncomeDaoBean incomeDaoBean;


    @Override
    public void init() throws ServletException {

        try {
            template = TemplateProvider.createTemplate(getServletContext(), "incomes-service.ftlh");
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Income income = new Income();
        income.setDate(LocalDate.parse(req.getParameter("date")));
        income.setIncome(Double.parseDouble(req.getParameter("income")));

        incomeDaoBean.save(income);

        resp.sendRedirect("/"); //Należy wstawić odnośnik do servletu odpowiedzialnego za wyświetlenie listy
        // dochodów   !!!!!
    }*/
}

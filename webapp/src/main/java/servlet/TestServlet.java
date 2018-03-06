package servlet;

import com.infoshareacademy.baseapp.Income;
import dao.IncomeDao;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(urlPatterns = "/test")
public class TestServlet extends HttpServlet {

    @Inject
    private IncomeDao incomeDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Income i = new Income(LocalDate.now(), 123.30);
        incomeDao.save(i);
        resp.getWriter().print(i.toString());
    }
}

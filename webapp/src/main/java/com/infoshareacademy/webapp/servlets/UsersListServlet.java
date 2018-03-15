package com.infoshareacademy.webapp.servlets;

import com.infoshareacademy.baseapp.Expense;
import com.infoshareacademy.webapp.dao_lockal.UsersRepositoryDao;
import com.infoshareacademy.webapp.freemarker.TemplateProvider;
import com.infoshareacademy.webapp.model.User;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/users-list")
public class UsersListServlet extends HttpServlet {

    @EJB
    UsersRepositoryDao usersRepositoryDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = usersRepositoryDao.getUsersList();

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("users", userList);

        Template template = TemplateProvider.createTemplate(getServletContext(), "users-list.ftlh");

        try {
            template.process(dataModel, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}

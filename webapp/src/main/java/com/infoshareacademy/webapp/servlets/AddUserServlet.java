package com.infoshareacademy.webapp.servlets;

import com.infoshareacademy.webapp.cdi.FileUploadProcessor;
import com.infoshareacademy.webapp.dao.UserDao;
import com.infoshareacademy.webapp.dao.UserDaoBean;
import com.infoshareacademy.webapp.dao_lockal.UsersRepositoryDao;
import com.infoshareacademy.webapp.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import model.Income;
import model.User;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/add-user")
@MultipartConfig
public class AddUserServlet extends HttpServlet {

    Logger logger = Logger.getLogger(getClass().getName());

    File templatesPath;
    Template template;

    @EJB
    UsersRepositoryDao usersRepositoryDao;

    @EJB
    UserDao userDao;

    @Inject
    FileUploadProcessor fileUploadProcessor;

    @Override
    public void init() throws ServletException {
        try {
            template = TemplateProvider.createTemplate(getServletContext(), "add-edit-user.ftlh");
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        Map<String, Object> dataModel = new HashMap<>();

        List<String> errors = (List<String>) req.getSession().getAttribute("errors");
        if (errors != null && !errors.isEmpty()) {
            dataModel.put("errors", errors);
            dataModel.put("user", req.getSession().getAttribute("user"));
            req.getSession().removeAttribute("error");
            req.getSession().removeAttribute("user");
        }

      /*  User user = new User();
        Set<Income> incomes = new HashSet<>(Arrays.asList(new Income(LocalDate.now(), 14d)));
        user.setIncome(incomes);
        user.setIncome(name);
        userDao.save(user);*/

        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setId(Long.parseLong(req.getParameter("id")));
        user.setName(req.getParameter("name"));
        user.setLogin(req.getParameter("login"));
        user.setPassword(req.getParameter("password"));
//        user.setAge(Integer.parseInt(req.getParameter("age")));
/*
        Part filePart = req.getPart("image");
        File file = null;
        try {
            file = fileUploadProcessor.uploadImageFile(filePart);
            user.setImageURL("/images/" + file.getName());
        } catch (UserImageNotFound userImageNotFound) {
            logger.log(Level.SEVERE, userImageNotFound.getMessage());
        }*/

        usersRepositoryDao.addUser(user);

        resp.sendRedirect("/users-list");
    }
}

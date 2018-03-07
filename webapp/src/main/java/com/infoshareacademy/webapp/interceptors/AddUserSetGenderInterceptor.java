package com.infoshareacademy.webapp.interceptors;


import com.infoshareacademy.webapp.domain.User;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

public class AddUserSetGenderInterceptor {

    Logger logger = Logger.getLogger(AddUserSetGenderInterceptor.class.getName());

    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {

        Object[] parameters = context.getParameters();
        for (Object parameter : parameters) {
            User user = (User) parameter;
            if (user.getLogin() == null) {
                if (user.getName().endsWith("a")) {
                    user.setLogin("Login ends on 'a'");
                } else {
                    user.setLogin("Login is diff");
                }
            }
            logger.info("Login interceptor: Login has been set to: " + user.getLogin().toString());
        }
        context.setParameters(parameters);
        return context.proceed();
    }
}

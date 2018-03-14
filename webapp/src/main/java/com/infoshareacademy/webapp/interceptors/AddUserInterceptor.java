package com.infoshareacademy.webapp.interceptors;

import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class AddUserInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AddUserInterceptor.class);

    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {

        StringBuilder parameters = new StringBuilder();
        for (Object parameter : context.getParameters()) {
            parameters.append(((User) parameter).getId());
        }

        logger.info("Add user has been invoked with parameters User.ID " + parameters.toString() + "!");
        return context.proceed();
    }
}

package com.infoshareacademy.webapp.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

public class HelloWorldInterceptor {

    Logger logger = Logger.getLogger(HelloWorldInterceptor.class.getName());

    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {

        logger.info("This is HELLO from interceptor: " + getClass().getName());
        return context.proceed();
    }
}

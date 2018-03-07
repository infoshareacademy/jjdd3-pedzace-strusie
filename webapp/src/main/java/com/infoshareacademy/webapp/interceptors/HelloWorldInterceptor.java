package com.infoshareacademy.webapp.interceptors;

import org.slf4j.LoggerFactory;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class HelloWorldInterceptor {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(HelloWorldInterceptor.class);


    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {

        logger.info(getClass().getName());
        return context.proceed();
    }
}

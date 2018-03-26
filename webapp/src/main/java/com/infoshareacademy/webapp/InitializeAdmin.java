package com.infoshareacademy.webapp;

import com.infoshareacademy.webapp.dao.UserFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
@Singleton
public class InitializeAdmin {

    @Inject
    private UserFactory userFactory;

    @PostConstruct
    void initializeAdmin () {
        userFactory.addAdmin("{\"sub\":\"google-oauth2|102338589831484844486\"}");
    }

}


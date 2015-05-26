package com.ibcs.primax.javaee.service;

import com.ibcs.primax.javaee.model.User;

import javax.servlet.ServletContext;
import java.util.List;

/**
 * Created by instructor on 5/4/2015.
 */
public interface UserService {
    public void saveUser(User user, ServletContext servletContext);

    User getUser(String email, String password, ServletContext servletContext);

    List<User> getUserList(ServletContext servletContext);
}

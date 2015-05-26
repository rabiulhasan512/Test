package com.ibcs.primax.javaee.service;

import com.ibcs.primax.javaee.model.User;
import com.ibcs.primax.javaee.utils.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import java.util.List;

/**
 * Created by instructor on 5/4/2015.
 */
public class UserServiceImpl implements UserService {
    public static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public void saveUser(User user, ServletContext servletContext) {
        List<User> userList = getUsers(servletContext);
        userList.add(user);
    }

    private List<User> getUsers(ServletContext servletContext) {
        return (List<User>) servletContext.getAttribute(Constant.USER_LIST);
    }

    @Override
    public User getUser(String email, String password, ServletContext servletContext) {
        log.info("getUser with email={} and password={}", email, password);

        List<User> userList = getUsers(servletContext);

        log.debug("total user: {}", userList.size());

        for (User user : userList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    }

    @Override
    public List<User> getUserList(ServletContext servletContext) {
        return getUsers(servletContext);
    }
}

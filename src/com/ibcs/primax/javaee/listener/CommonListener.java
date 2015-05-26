package com.ibcs.primax.javaee.listener; /**
 * Created by instructor on 5/4/2015.
 */

import com.ibcs.primax.javaee.model.Message;
import com.ibcs.primax.javaee.model.User;
import com.ibcs.primax.javaee.utils.Constant;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.List;

@WebListener()
public class CommonListener implements ServletContextListener {

    // Public constructor is required by servlet spec
    public CommonListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
        List<User> userList = new ArrayList<User>();
        sce.getServletContext().setAttribute(Constant.USER_LIST, userList);

        List<Message> messageList = new ArrayList<Message>();
        sce.getServletContext().setAttribute(Constant.MESSAGE_LIST, messageList);
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

}

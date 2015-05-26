package com.ibcs.primax.javaee.web;

import com.ibcs.primax.javaee.model.User;
import com.ibcs.primax.javaee.service.UserService;
import com.ibcs.primax.javaee.service.UserServiceImpl;
import com.ibcs.primax.javaee.utils.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    public static final Logger log = LoggerFactory.getLogger(LoginServlet.class);

    UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userService.getUser(email, password, getServletContext());

        if (user == null) {
            request.setAttribute("error", "Username/Password invalid");
            request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
        } else {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute(Constant.USER, user);
            response.sendRedirect("/user/chat");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("GET request at /login");
        request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
    }
}

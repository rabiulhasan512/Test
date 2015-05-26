package com.ibcs.primax.javaee.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Abdullah Al Mamun Oronno
 *         Email: mr.oronno@gmail.com
 */
@WebServlet(name = "TagDemoServlet", urlPatterns = "/tagdemo")
public class TagDemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("mobilePrice", 50000);
        request.getRequestDispatcher("/WEB-INF/view/tagdemo.jsp").forward(request, response);
    }
}

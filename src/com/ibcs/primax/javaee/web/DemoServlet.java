package com.ibcs.primax.javaee.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author Abdullah Al Mamun Oronno
 *         Created on 5/6/15
 */
@WebServlet(name = "DemoServlet", urlPatterns = "/demo")
public class DemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("price", 25000000);
        request.setAttribute("now", new Date());
        request.getRequestDispatcher("/WEB-INF/view/demo.jsp").forward(request, response);
    }
}

package com.ibcs.primax.javaee.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Abdullah Al Mamun Oronno
 *         Created on 5/5/15
 */
@WebServlet(name = "ErrorHandlerServlet", urlPatterns = "/error")
public class ErrorHandlerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        extractParamAndForwardToErrorView(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        extractParamAndForwardToErrorView(request, response);
    }

    private void extractParamAndForwardToErrorView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");

        if (servletName == null) {
            servletName = "Unknown";
        }

        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
        if (requestUri == null) {
            requestUri = "Unknown";
        }

        System.out.println("Error Occur. Servlet: " + servletName + " & requestUri=" + requestUri);

        request.setAttribute("statusCode", statusCode);
        request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
    }
}

package com.ibcs.primax.javaee.filter;

import com.ibcs.primax.javaee.model.User;
import com.ibcs.primax.javaee.utils.Constant;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by instructor on 5/4/2015.
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = "/user/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        User user = (User) httpServletRequest.getSession().getAttribute(Constant.USER);
        if (user == null) {
            HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
            ((HttpServletResponse) resp).sendRedirect("/login");
            return;
        }
        chain.doFilter(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {

    }

}

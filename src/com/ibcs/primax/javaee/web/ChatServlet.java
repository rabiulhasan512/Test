package com.ibcs.primax.javaee.web;

import com.ibcs.primax.javaee.model.Message;
import com.ibcs.primax.javaee.model.User;
import com.ibcs.primax.javaee.service.MessageService;
import com.ibcs.primax.javaee.service.MessageServiceImpl;
import com.ibcs.primax.javaee.service.UserService;
import com.ibcs.primax.javaee.service.UserServiceImpl;
import com.ibcs.primax.javaee.utils.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;


@WebServlet(name = "ChatServlet", urlPatterns = "/user/chat")
public class ChatServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();
    MessageService messageService = new MessageServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String messageText = request.getParameter("message");
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute(Constant.USER);
        Message message = new Message(messageText, user, new Date());

        messageService.addMessage(message, getServletContext());

        response.sendRedirect("/user/chat");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userService.getUserList(getServletContext());
        List<Message> messageList = messageService.getMessageList(getServletContext());

        request.setAttribute("userList", userList);
        request.setAttribute("messageList", messageList);

        request.getRequestDispatcher("/WEB-INF/view/chat.jsp").forward(request, response);
    }
}

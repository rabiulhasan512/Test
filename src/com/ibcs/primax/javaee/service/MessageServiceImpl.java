package com.ibcs.primax.javaee.service;

import com.ibcs.primax.javaee.model.Message;
import com.ibcs.primax.javaee.utils.Constant;

import javax.servlet.ServletContext;
import java.util.List;

/**
 * @author Abdullah Al Mamun Oronno
 *         Created on 5/5/15
 */
public class MessageServiceImpl implements MessageService {
    @Override
    public List<Message> getMessageList(ServletContext servletContext) {
        return (List<Message>) servletContext.getAttribute(Constant.MESSAGE_LIST);
    }

    @Override
    public void addMessage(Message message, ServletContext servletContext) {
        getMessageList(servletContext).add(message);
    }
}

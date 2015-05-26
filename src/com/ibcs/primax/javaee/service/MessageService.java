package com.ibcs.primax.javaee.service;

import com.ibcs.primax.javaee.model.Message;

import javax.servlet.ServletContext;
import java.util.List;

/**
 * @author Abdullah Al Mamun Oronno
 *         Created on 5/5/15
 */
public interface MessageService {
    public List<Message> getMessageList(ServletContext servletContext);

    void addMessage(Message message, ServletContext servletContext);
}

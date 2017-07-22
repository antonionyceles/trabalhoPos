/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.listener;

import com.pos.entity.Usuario;
import com.pos.session.SessionSingleton;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author Antoniony
 */
public class SessaoRedisListener implements HttpSessionListener {

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session =se.getSession();
        Usuario user = (Usuario) session.getAttribute("usuario");
        if (user != null) {
            SessionSingleton.deleteSession(user);
        }

    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Sessao Criada");
    }

    

    
}

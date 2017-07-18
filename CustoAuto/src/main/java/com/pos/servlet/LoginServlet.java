/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.servlet;

import com.pos.bo.UsuarioBO;
import com.pos.entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Antoniony
 */
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        UsuarioBO usuarioBo = new UsuarioBO();
        if (request.getParameter("operacao").equals("1")) {
            Usuario user = new Usuario(request.getParameter("login"),
                    request.getParameter("senha"));
            try {
                usuarioBo.isUser(user);
                HttpSession session = request.getSession();
                session.setAttribute("usuario", user);
                response.sendRedirect("menu.jsp");
            } catch (Exception ex) {
                HttpSession session = request.getSession();
                request.setAttribute("messageType", "danger");
                request.setAttribute("message", ex.getLocalizedMessage());
               
                response.sendRedirect("index.jsp");

            }

        } else if (request.getParameter("operacao").equals("2")) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", null);

        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

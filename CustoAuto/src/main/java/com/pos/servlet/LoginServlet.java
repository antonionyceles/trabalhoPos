/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.servlet;

import com.pos.bo.UsuarioBO;
import com.pos.entity.Usuario;
import com.pos.session.SessionSingleton;
import java.io.IOException;
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
            HttpSession session = request.getSession();
            try {
                
                user = usuarioBo.isUser(user);
                session.setAttribute("usuario", user);
                request.getRequestDispatcher("menu.jsp").forward(request, response);
            } catch (Exception ex) {

                request.setAttribute("messageType", "danger");
                request.setAttribute("message", ex.getLocalizedMessage());
                request.getRequestDispatcher("index.jsp").forward(request, response);

            }

        } else {
            HttpSession session = request.getSession();
            session.invalidate();
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("operacao").equals("2")) {
            request.setAttribute("messageType", "info");
            request.setAttribute("message", "Logout efetuado com sucesso!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            SessionSingleton.deleteSession((Usuario) request.getSession().getAttribute("usuario"));
            request.getSession().invalidate();
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

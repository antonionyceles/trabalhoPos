/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.servlet;

import com.pos.bo.UsuarioBO;
import com.pos.entity.Cliente;
import com.pos.entity.Usuario;
import com.pos.util.DataUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author antoniony.lima
 */
@WebServlet(name = "PreCadastroServlet", urlPatterns = {"/PreCadastroServlet"})
public class PreCadastroServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        UsuarioBO usuarioBO = new UsuarioBO();

        Cliente cliente = new Cliente(request.getParameter("nome"),
                request.getParameter("sobrenome"),
                request.getParameter("email"),
                request.getParameter("celular"),
                request.getParameter("telefone")
        );
        Usuario usuario = new Usuario(request.getParameter("email"),
                request.getParameter("senha"), null, new Date());

        String confirmaSenha = request.getParameter("confirmaSenha");
        try {
           cliente.setDtNascimento(DataUtil.getDataFromString(request.getParameter("dtNascimento")));
            usuarioBO.savePreCadastro(cliente, usuario, confirmaSenha);
            request.setAttribute("messageType", "info");
            request.setAttribute("message", "Usuário cadastrado com sucesso");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception ex) {

            request.setAttribute("cliente", cliente);
            request.setAttribute("usuario", usuario);
            request.setAttribute("messageType", "danger");
            request.setAttribute("message", ex.getLocalizedMessage());
//            request.getRequestDispatcher("").forward(request, response);
            request.getRequestDispatcher("pre-cadastro.jsp").forward(request, response);

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(PreCadastroServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(PreCadastroServlet.class.getName()).log(Level.SEVERE, null, ex);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.servlet;

import com.pos.bo.VeiculoBO;
import com.pos.dao.UsuarioDAO;
import com.pos.dao.VeiculoUsuarioDAO;
import com.pos.entity.TipoVeiculo;
import com.pos.entity.Usuario;

import com.pos.entity.VeiculoUsuario;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
@WebServlet(name = "VeiculoServlet", urlPatterns = {"/VeiculoServlet"})
public class VeiculoServlet extends HttpServlet {

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
        VeiculoBO veiculoBO = new VeiculoBO();
        VeiculoUsuario vc;
        List<VeiculoUsuario> veiculos = new ArrayList<VeiculoUsuario>();
        try {
            switch (request.getParameter("operacao")) {
                case "1":
                    System.out.println("VV");
                    vc = new VeiculoUsuario(BigInteger.ONE,
                            // (Usuario) request.getSession().getAttribute("usuario"),
                            new UsuarioDAO().findById(BigInteger.valueOf(4)),
                            new VeiculoUsuarioDAO().getTipoVeiculo(request.getParameter("tipo")),
                            request.getParameter("descricao"),
                            request.getParameter("placa"),
                            new Date(),
                            null);
                    System.out.println("VV-ADD");
                    veiculoBO.adicionar(vc);
                    request.setAttribute("messageType", "info");
                    request.setAttribute("message", "Veículo adicionado com sucesso!");
                    break;
                case "2":
                    vc = new VeiculoUsuario(new BigInteger(request.getParameter("id")),
                            (Usuario) request.getSession().getAttribute("usuario"),
                            TipoVeiculo.Moto,
                            request.getParameter("descricao"),
                            request.getParameter("placa"),
                            null,
                            new Date());
                    veiculoBO.editar(vc);

                    request.setAttribute("messageType", "info");
                    request.setAttribute("message", "Veículo editado com sucesso!");
                    break;
                case "3":
                    deletarVeiculo(request, request.getSession());
                    break;
                default:
                    response.sendRedirect("menu.jsp");
                    break;
            }
            veiculos = veiculoBO.findByUser( BigInteger.valueOf(4 ) );
        } catch (Exception ex) {
            request.setAttribute("messageType", "error");
            request.setAttribute("message", ex.getLocalizedMessage());
        }
        System.out.println("setar a lista");
        request.setAttribute("listaVeiculos", veiculos);        
        //response.sendRedirect("veiculo/list.jsp");
        request.getRequestDispatcher("veiculo/list.jsp").forward(request, response);

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

    private void deletarVeiculo(HttpServletRequest request, HttpSession session) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

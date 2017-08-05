///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.pos.servlet;
//
//import com.pos.entity.Veiculo;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// *
// * @author Antoniony
// */
//@WebServlet(name = "VeiculoServlet", urlPatterns = {"/VeiculoServlet"})
//public class VeiculoServlet extends HttpServlet {
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        switch (request.getParameter("operacao")) {
//            case "1":
//                inserirVeiculo(request, request.getSession());
//                break;
//            case "2":
//                editarVeiculo(request, request.getSession());
//                break;
//            case "3":
//                deletarVeiculo(request, request.getSession());
//                break;
//            default:
//                response.sendRedirect("menu.jsp");
//                break;
//        }
//        response.sendRedirect("veiculo/list.jsp");
//
//    }
//
//    protected void inserirVeiculo(HttpServletRequest request, HttpSession session) {
//        Map<String, Veiculo> vcMap;
//        if (session.getAttribute("veiculoList") == null) {
//            vcMap = new HashMap<String, Veiculo>();
//
//        } else {
//            vcMap = (Map<String, Veiculo>) session.getAttribute("veiculoList");
//
//        }
//        Veiculo vc = new Veiculo(String.valueOf(Math.random()),
//                request.getParameter("tipo"),
//                request.getParameter("modelo"),
//                Boolean.TRUE);
//        vcMap.put(vc.getId(), vc);
//        session.setAttribute("veiculoList", vcMap);
//
//    }
//
//    protected void editarVeiculo(HttpServletRequest request, HttpSession session) {
//        Map<String, Veiculo> vcMap = (Map<String, Veiculo>) session.getAttribute("veiculoList");
//        String id = request.getParameter("id");
//        Veiculo vcEdit = vcMap.get(id);
//        vcEdit.setTipo(request.getParameter("tipo"));
//        vcEdit.setModelo(request.getParameter("modelo"));
//        vcMap.put(vcEdit.getId(), vcEdit);
//        session.setAttribute("veiculoList", vcMap);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//    private void deletarVeiculo(HttpServletRequest request, HttpSession session) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//}

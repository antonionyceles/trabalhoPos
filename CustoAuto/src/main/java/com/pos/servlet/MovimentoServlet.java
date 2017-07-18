package com.pos.servlet;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.pos.entity.Movimentacao;
import com.pos.entity.Usuario;
import com.pos.entity.Veiculo;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
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
 * @author aluno
 */
@WebServlet(urlPatterns = {"/MovimentoServlet"})
public class MovimentoServlet extends HttpServlet {

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
            switch (request.getParameter("operacao")) {
                case "1":
                    inserirMovimentacao(request, request.getSession());
                    break;
                case "2":
                    editarMovimentacao(request, request.getSession());
                    break;
                case "3":
                    deletarMovimentacao(request, request.getSession());
                    break;
                default:
                    response.sendRedirect("menu.jsp");
                    break;
            }
            response.sendRedirect("movimento/list.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(MovimentoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void inserirMovimentacao(HttpServletRequest request, HttpSession session) throws ParseException {
        Map<String, Movimentacao> movMap;
        if (session.getAttribute("movimentacaoList") == null) {
            movMap = new HashMap<String, Movimentacao>();

        } else {
            movMap = (Map<String, Movimentacao>) session.getAttribute("movimentacaoList");

        }
        String data = (String) request.getParameter("data");
        
        Map vcMap = (Map<String, Veiculo>) session.getAttribute("veiculoList");
        Movimentacao vc = new Movimentacao(String.valueOf(Math.random()),
                (Usuario) session.getAttribute("usuario"),
                (Veiculo) vcMap.get(request.getParameter("veiculo")),
                new SimpleDateFormat("YYYY-MM-dd").parse(data),
                new BigInteger((String) request.getParameter("km")),
                new BigDecimal((String) request.getParameter("valor")));
        movMap.put(vc.getId(), vc);
        session.setAttribute("movimentacaoList", movMap);
    }

    private void editarMovimentacao(HttpServletRequest request, HttpSession session) throws ParseException {
        Map<String, Movimentacao> movMap = (Map<String, Movimentacao>) session.getAttribute("movimentacaoList");
        String id = request.getParameter("id");
        Map vcMap = (Map<String, Veiculo>) session.getAttribute("veiculoList");
        Movimentacao vc = new Movimentacao(id,
                (Usuario) session.getAttribute("usuario"),
                (Veiculo) vcMap.get(request.getParameter("veiculo")),
                new SimpleDateFormat("YYYY-MM-dd").parse((String) request.getParameter("data")),
                new BigInteger((String) request.getParameter("km")),
                new BigDecimal((String) request.getParameter("valor")));
        movMap.put(vc.getId(), vc);
        session.setAttribute("movimentacaoList", movMap);

    }

    private void deletarMovimentacao(HttpServletRequest request, HttpSession session) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

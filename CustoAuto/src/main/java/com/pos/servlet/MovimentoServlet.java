package com.pos.servlet;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.pos.bo.DespesasBO;
import com.pos.bo.VeiculoBO;
import com.pos.entity.DespesaVeiculo;
import com.pos.entity.TipoDespesa;
import com.pos.entity.TipoVeiculo;
import com.pos.entity.Usuario;
import com.pos.entity.VeiculoUsuario;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
@WebServlet(urlPatterns = {"/Movimento"})
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
        DespesasBO despesaBO = new DespesasBO();
        try {
            switch (request.getParameter("operacao")) {
                case "1":
                    DespesaVeiculo dv = new DespesaVeiculo(null,
                            new VeiculoUsuario(new BigInteger(request.getParameter("veiculo"))),
                            new Date(),
                            TipoDespesa.CP,
                            request.getParameter("descricao"),
                            new Integer(request.getParameter("kilometragem")),
                            new Double(request.getParameter("valor")),
                            new Date(),
                            null);
                    despesaBO.lancarValor(dv);
                    break;
                case "2":
//                    editarMovimentacao(request, request.getSession());
                    break;
                case "3":
//                    deletarMovimentacao(request, request.getSession());
                    break;
                default:
                    response.sendRedirect("menu.jsp");
                    break;
            }

        } catch (Exception ex) {
            request.setAttribute("messageType", "danger");
            request.setAttribute("message", ex.getLocalizedMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
            Logger.getLogger(MovimentoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            switch (request.getParameter("operacao")) {
                case "2":
                    DespesasBO despesaBO = new DespesasBO();
                    List<DespesaVeiculo> despesaVeiculoL = null;
                    despesaVeiculoL = despesaBO.listarDespesasByUsuario(usuario);
                    request.setAttribute("despesaVeiculoL", despesaVeiculoL);

                    request.getRequestDispatcher("movimento/list.jsp").forward(request, response);
                    break;
                case "1":
                    VeiculoBO vcBO = new VeiculoBO();
                    List<VeiculoUsuario> veiculoL
                            = vcBO.findByUser(usuario.getId());
                    request.setAttribute("veiculoL", veiculoL);
                    request.getRequestDispatcher("movimento/form.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(MovimentoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.bo;

import com.pos.dao.DespesaVeiculoDAO;
import com.pos.entity.DespesaVeiculo;
import com.pos.entity.Usuario;
import com.pos.entity.VeiculoUsuario;
import com.pos.observer.GastosVeiculo;
import com.pos.observer.GraficoBarraVeiculo;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Antoniony
 */
public class DespesasBO {

    private final GastosVeiculo veiculo = GastosVeiculo.getInstance();
    private final GraficoBarraVeiculo gBv = GraficoBarraVeiculo.getInstance();
    protected DespesaVeiculoDAO despesaDAO = new DespesaVeiculoDAO();

    public void lancarValor(DespesaVeiculo despesaV) {
        try {
            veiculo.adicionaAcoes(despesaV.getVeiculo().getDescricao(),
                    new BigDecimal(despesaV.getValor()));
        } catch (Exception ex) {
            throw ex;
        } finally {

        }
    }

    public List<DespesaVeiculo> listarDespesasByUsuario(Usuario usuario) throws Exception {
        List<DespesaVeiculo> despesaL = null;
        
        try {
            despesaL = despesaDAO.findByUsuario(usuario);
        } catch (Exception ex) {
            throw ex;
        }

        return despesaL;
    }
    public List<DespesaVeiculo> listarDespesasByVeiculo(VeiculoUsuario veiculo) throws Exception {
        List<DespesaVeiculo> despesaL = null;
        try {
            despesaL = despesaDAO.findByVeiculo(veiculo);
        } catch (Exception ex) {
            throw ex;
        }

        return despesaL;
    }

}

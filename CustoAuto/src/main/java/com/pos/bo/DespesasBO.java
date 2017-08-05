/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.bo;

import com.pos.entity.DespesaVeiculo;
import com.pos.observer.GastosVeiculo;
import com.pos.observer.GraficoBarraVeiculo;
import com.pos.observer.Observador;
import java.math.BigDecimal;

/**
 *
 * @author Antoniony
 */
public class DespesasBO {

    private  final GastosVeiculo veiculo = GastosVeiculo.getInstance();
    private final GraficoBarraVeiculo gBv = GraficoBarraVeiculo.getInstance();

  
    
    

    public void lancarValor(DespesaVeiculo despesaV) {
        try {
            veiculo.adicionaAcoes(despesaV.getVeiculo().getDescricao(),
                    new BigDecimal(despesaV.getValor()));
        } catch (Exception ex) {
            throw ex;
        } finally {
           
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.observer;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Antoniony
 */
public class GraficoBarraVeiculo implements Observador {

    private static GraficoBarraVeiculo gBv;

    public static synchronized GraficoBarraVeiculo getInstance() {
        if (gBv == null) {
            gBv = new GraficoBarraVeiculo();
        }

        return gBv;
    }
    private final Map<String, BigDecimal> acoes = new HashMap<>();

    @Override
    public void mudancaValor(String veiculo, BigDecimal valor) {
        if (acoes.containsKey(veiculo)) {
            valor.add(acoes.get(veiculo));
        }
        acoes.put(veiculo, valor);
    }

    public Map<String, BigDecimal> getAcoes() {
        return acoes;
    }

}

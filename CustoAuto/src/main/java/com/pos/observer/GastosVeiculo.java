/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.observer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Antoniony
 */
public class GastosVeiculo {

    private static GastosVeiculo veiculo;
    private static Map<String, BigDecimal> acoes = new HashMap<>();
    private final List<Observador> obs = new ArrayList<>();

    public static synchronized GastosVeiculo getInstance() {
        if (veiculo == null) {
            veiculo = new GastosVeiculo();
        }

        return veiculo;
    }

    public void adicionaAcoes(String acao, BigDecimal valor) {
        if (acoes.containsKey(acao)) {
            valor = valor.add(acoes.get(acao));
        }
        acoes.put(acao, valor);
        notificar(acao, valor);
    }

    private void notificar(String acao, BigDecimal valor) {
        for (Observador o : obs) {
            o.mudancaValor(acao, valor);
        }
    }

    public void addObservador(Observador o) {
        obs.add(o);
    }
}

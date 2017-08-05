/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.observer;

import java.math.BigDecimal;

/**
 *
 * @author Antoniony
 */
public interface Observador {

    void mudancaValor(String mes, BigDecimal valor);
}

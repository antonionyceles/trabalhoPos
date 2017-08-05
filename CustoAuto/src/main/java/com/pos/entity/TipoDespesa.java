/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.entity;

/**
 *
 * @author jony
 */
public enum TipoDespesa {
    CO("CO", "Combustível"), OF("OF", "Oficina"), CP("CP", "Compra de peças"), 
    LA("LA", "Lavagem"), IM("IM", "Impostos"), OT("OT", "Outros");
    
    private final String codigo;
    private final String nome;
    
    TipoDespesa(String codigo, String nome){
        this.codigo = codigo;
        this.nome = nome;
    }
    
    public String codigo() {
        return this.codigo;
    }
    
    public String nome() {
        return this.nome;
    }
    
}

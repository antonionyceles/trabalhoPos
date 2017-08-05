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
public enum TipoVeiculo {
    Carro("1", "Carro"), Pickup("2", "Pickup"), Moto("3", "Moto"), Caminhao("4", "Caminhão"), Outros("5", "Outros");
    
    private final String codigo;
    private final String nome;
    
    TipoVeiculo(String codigo, String nome){
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
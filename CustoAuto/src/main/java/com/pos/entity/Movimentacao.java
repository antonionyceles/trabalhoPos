/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author Antoniony
 */
public class Movimentacao {
    private String id;
    private Usuario usuario;
    private Veiculo veiculo;
    private Date data;
    private BigInteger km;
    private BigDecimal valor;

    public Movimentacao(String id,Usuario usuario, Veiculo veiculo, Date data, BigInteger km, BigDecimal valor) {
        this.id=id;
        this.usuario = usuario;
        this.veiculo = veiculo;
        this.data = data;
        this.km = km;
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigInteger getKm() {
        return km;
    }

    public void setKm(BigInteger km) {
        this.km = km;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.entity;

import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author antoniony.lima
 */
public class VeiculoUsuario {
    
    private BigInteger id;
    private Usuario usuario;
    private TipoVeiculo tipo;
    private String descricao;
    private String placa;
    private Date dataCadastro;
    private Date dataAtualizacao;    

    public VeiculoUsuario(BigInteger id, Usuario usuario, TipoVeiculo tipo, String descricao, String placa, Date dataCadastro, Date dataAtualizacao) {
        this.id = id;
        this.usuario = usuario;
        this.tipo = tipo;
        this.descricao = descricao;
        this.placa = placa;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoVeiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVeiculo tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
    
       
    
    
}

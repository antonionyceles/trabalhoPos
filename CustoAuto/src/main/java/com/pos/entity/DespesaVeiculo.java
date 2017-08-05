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
 * @author jony
 */
public class DespesaVeiculo {
    private BigInteger id;
    private VeiculoUsuario veiculo;
    private Date dataDespesa;
    private TipoDespesa tipo;
    private String descricao;
    private Integer kilometragem;
    private Double valor;
    private Date dataRegistro;
    private Date dataAtualizacao;

    public DespesaVeiculo(BigInteger id, VeiculoUsuario veiculo, Date dataDespesa, TipoDespesa tipo, String descricao, Integer kilometragem, Double valor, Date dataRegistro, Date dataAtualizacao) {
        this.id = id;
        this.veiculo = veiculo;
        this.dataDespesa = dataDespesa;
        this.tipo = tipo;
        this.descricao = descricao;
        this.kilometragem = kilometragem;
        this.valor = valor;
        this.dataRegistro = dataRegistro;
        this.dataAtualizacao = dataAtualizacao;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public VeiculoUsuario getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(VeiculoUsuario veiculo) {
        this.veiculo = veiculo;
    }

    public Date getDataDespesa() {
        return dataDespesa;
    }

    public void setDataDespesa(Date dataDespesa) {
        this.dataDespesa = dataDespesa;
    }

    public TipoDespesa getTipo() {
        return tipo;
    }

    public void setTipo(TipoDespesa tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(Integer kilometragem) {
        this.kilometragem = kilometragem;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }    
    
}

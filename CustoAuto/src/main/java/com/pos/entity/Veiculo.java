package com.pos.entity;

import com.google.gson.annotations.SerializedName;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author aluno
 */
public class Veiculo {

    private String id;
    @SerializedName("TipoVeiculo")
    private String tipo;
    @SerializedName("Modelo")
    private String modelo;
    @SerializedName("Marca")
    private String marca;
    private Boolean ativo;
    @SerializedName("AnoModelo")
    private Integer AnoModelo;

    public Veiculo(String id, String tipo, String modelo, Boolean ativo) {
        this.id = id;
        this.tipo = tipo;
        this.modelo = modelo;
        this.ativo = ativo;
    }

    public Veiculo(String id, String tipo, String modelo, String marca) {
        this.id = id;
        this.tipo = tipo;
        this.modelo = modelo;
        this.marca = marca;
    }

    public Integer getAnoModelo() {
        return AnoModelo;
    }

    public void setAnoModelo(Integer AnoModelo) {
        this.AnoModelo = AnoModelo;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    

}

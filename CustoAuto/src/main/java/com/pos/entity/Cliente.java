/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.entity;

import java.math.BigInteger;

/**
 *
 * @author antoniony.lima
 */
public class Cliente {

    private BigInteger cdCliente;
    private String nmNome;
    private String nmSobrenome;
    private String dsCpf;
    private String dsRg;
    private String dsEmail;
    private String nrCelular;
    private String nrTelefone;

    public Cliente(BigInteger cdCliente, String nmNome, String nmSobrenome, String dsCpf, String dsRg, String dsEmail, String nrCelular, String nrTelefone) {
        this.cdCliente = cdCliente;
        this.nmNome = nmNome;
        this.nmSobrenome = nmSobrenome;
        this.dsCpf = dsCpf;
        this.dsRg = dsRg;
        this.dsEmail = dsEmail;
        this.nrCelular = nrCelular;
        this.nrTelefone = nrTelefone;
    }

    public BigInteger getCdCliente() {
        return cdCliente;
    }

    public void setCdCliente(BigInteger cdCliente) {
        this.cdCliente = cdCliente;
    }

    public String getNmNome() {
        return nmNome;
    }

    public void setNmNome(String nmNome) {
        this.nmNome = nmNome;
    }

    public String getNmSobrenome() {
        return nmSobrenome;
    }

    public void setNmSobrenome(String nmSobrenome) {
        this.nmSobrenome = nmSobrenome;
    }

    public String getDsCpf() {
        return dsCpf;
    }

    public void setDsCpf(String dsCpf) {
        this.dsCpf = dsCpf;
    }

    public String getDsRg() {
        return dsRg;
    }

    public void setDsRg(String dsRg) {
        this.dsRg = dsRg;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    public String getNrCelular() {
        return nrCelular;
    }

    public void setNrCelular(String nrCelular) {
        this.nrCelular = nrCelular;
    }

    public String getNrTelefone() {
        return nrTelefone;
    }

    public void setNrTelefone(String nrTelefone) {
        this.nrTelefone = nrTelefone;
    }

    
    
    
}

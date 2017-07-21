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
public class Cliente {

    private BigInteger cdCliente;
    private String nmNome;
    private String nmSobrenome;
    private Date dtNascimento;
    private String dsEmail;
    private String nrCelular;
    private String nrTelefone;
    private String tpSituacao;

    public Cliente(String nmNome, String nmSobrenome, String dsEmail, String nrCelular, String nrTelefone) {

        this.nmNome = nmNome;
        this.nmSobrenome = nmSobrenome;

        this.dsEmail = dsEmail;
        this.nrCelular = nrCelular;
        this.nrTelefone = nrTelefone;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
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

    public String getTpSituacao() {
        return tpSituacao;
    }

    public void setTpSituacao(String tpSituacao) {
        this.tpSituacao = tpSituacao;
    }

}

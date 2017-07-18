package com.pos.entity;

import java.math.BigInteger;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author antoniony.lima
 */
public class Usuario {

    private BigInteger cdUsuario;
    private String dsLogin;
    private String dsPassword;
    private BigInteger cdCliente;
    private Date dtCadastro;

    public Usuario() {
    }

    public Usuario(BigInteger cdUsuario, String dsLogin, String dsPassword, BigInteger cdCliente, Date dtCadastro) {
        this.cdUsuario = cdUsuario;
        this.dsLogin = dsLogin;
        this.dsPassword = dsPassword;
        this.cdCliente = cdCliente;
        this.dtCadastro = dtCadastro;
    }

    public Usuario(String dsLogin, String dsPassword) {
        this.dsLogin = dsLogin;
        this.dsPassword = dsPassword;
    }

    public Boolean isUser(Usuario login) {
        Boolean result = false;
        if (login.getDsLogin().equalsIgnoreCase("admin") && login.getDsPassword().equals("admin")) {
            result = true;
        }
        return result;
    }

    public BigInteger getCdUsuario() {
        return cdUsuario;
    }

    public void setCdUsuario(BigInteger cdUsuario) {
        this.cdUsuario = cdUsuario;
    }

    public String getDsLogin() {
        return dsLogin;
    }

    public void setDsLogin(String dsLogin) {
        this.dsLogin = dsLogin;
    }

    public String getDsPassword() {
        return dsPassword;
    }

    public void setDsPassword(String dsPassword) {
        this.dsPassword = dsPassword;
    }

    public BigInteger getCdCliente() {
        return cdCliente;
    }

    public void setCdCliente(BigInteger cdCliente) {
        this.cdCliente = cdCliente;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

}

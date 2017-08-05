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

    private BigInteger id;
    private String nome;
    private String email;
    private String senha;
    private Date dataRegistro;
    private Date dataAtualizacao;
    
    public Usuario() {
        
    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }   
    
    public Usuario(BigInteger id, String nome, String email, String senha, Date dataRegistro, Date dataAtualizacao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataRegistro = dataRegistro;
        this.dataAtualizacao = dataAtualizacao;
    }
    
    /*
    public Boolean isUser(Usuario login) {
        Boolean result = false;
        if (login.getDsLogin().equalsIgnoreCase("admin") && login.getDsPassword().equals("admin")) {
            result = true;
        }
        return result;
    }
    */

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

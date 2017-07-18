/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.dao;

import com.pos.entity.Usuario;
import com.pos.factory.ConnectionFactory;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author antoniony.lima
 */
public class UsuarioDAO extends DaoGenerico {

    private Connection conexao;

    @Override
    public void adiciona(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object find(Object id) {
        Usuario user = null;
        try {
            this.conexao = new ConnectionFactory().getConnection();
            // cria um preparedStatement
            String sql = "select * from usuario where cd_usuario = " + id;
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            // executa um select
            ResultSet rs = stmt.executeQuery();
            // itera no ResultSet
            while (rs.next()) {
                String cdCliente = rs.getString("cd_cliente");
                String cdUsuario = rs.getString("cd_usuario");
                String dsLogin = rs.getString("ds_login");
                String dsSenha = rs.getString("ds_senha");
                Date dtCadastro = rs.getDate("dt_cadastro");
                user = new Usuario(new BigInteger(cdUsuario),
                        dsLogin, dsSenha,
                        new BigInteger(cdCliente),
                        dtCadastro);
                System.out.println(cdCliente + " :: " + dtCadastro);
            }
            this.conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    public void deletar(Object id) {

        this.conexao = new ConnectionFactory().getConnection();
        // cria um preparedStatement
        String sql = "delete usuario where cd_usuario= " + id;
        PreparedStatement stmt;
        try {
            stmt = this.conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            this.conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            // executa um select
        }

    }

    @Override
    public List<Object> findAll() {
        List<Object> userL = new ArrayList<>();
        try {
            this.conexao = new ConnectionFactory().getConnection();
            // cria um preparedStatement
            String sql = "select * from usuario";
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            // executa um select
            ResultSet rs = stmt.executeQuery();
            // itera no ResultSet
            while (rs.next()) {
                String cdCliente = rs.getString("cd_cliente");
                String cdUsuario = rs.getString("cd_usuario");
                String dsLogin = rs.getString("ds_login");
                String dsSenha = rs.getString("ds_senha");
                Date dtCadastro = rs.getDate("dt_cadastro");
                userL.add(new Usuario(new BigInteger(cdUsuario),
                        dsLogin, dsSenha,
                        new BigInteger(cdCliente),
                        dtCadastro));
                System.out.println(cdCliente + " :: " + dtCadastro);
            }
            this.conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userL;
    }

    public Usuario findOneByUsuarioSenha(Usuario user) throws SQLException {
        Usuario usuario = null;
        try {
            this.conexao = new ConnectionFactory().getConnection();
            // cria um preparedStatement
            String sql = "select * from usuario where ds_login = '" + user.getDsLogin()
                    + "' AND ds_password='" + user.getDsPassword() + "'";
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            // executa um select
            ResultSet rs = stmt.executeQuery();
            // itera no ResultSet
            while (rs.next()) {
                String cdCliente = rs.getString("cd_cliente");
                String cdUsuario = rs.getString("cd_usuario");
                String dsLogin = rs.getString("ds_login");
                String dsSenha = rs.getString("ds_password");
                Date dtCadastro = rs.getDate("dt_cadastro");
                usuario = new Usuario(new BigInteger(cdUsuario),
                        dsLogin, dsSenha,
                        new BigInteger(cdCliente),
                        dtCadastro);
                System.out.println(cdCliente + " :: " + dtCadastro);
            }
            this.conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
        return usuario;

    }

}

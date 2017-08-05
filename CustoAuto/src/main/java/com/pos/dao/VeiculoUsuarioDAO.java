/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.dao;

import com.pos.entity.TipoVeiculo;
import com.pos.entity.VeiculoUsuario;
import com.pos.factory.ConnectionFactory;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author antoniony.lima
 */
public class VeiculoUsuarioDAO {

    private Connection conexao;

    public void add(VeiculoUsuario veiculo) throws SQLException {
        try {
            this.conexao = new ConnectionFactory().getConnection();
            this.conexao.setAutoCommit(false);
            PreparedStatement stmt;
            ResultSet rs;
            String sqlUsuario = "INSERT INTO veiculo_usuario(`usuario_id`, `tipo`, `descricao`, `placa`)"
                    + "VALUES(?, ?, ?);";
            stmt = this.conexao.prepareStatement(sqlUsuario);
            stmt.setBigDecimal(1, new BigDecimal(veiculo.getUsuario().getId()));
            stmt.setString(2, veiculo.getTipo().codigo());
            stmt.setString(3, veiculo.getDescricao());
            stmt.setString(4, veiculo.getPlaca());

            // executa um select
            stmt.executeUpdate(sqlUsuario);
            this.conexao.commit();
        } catch (Exception ex) {
            this.conexao.rollback();
            throw ex;
        } finally {
            this.conexao.close();
        }
    }

    public VeiculoUsuario findById(BigInteger id) {
        VeiculoUsuario veiculo = null;
        try {
            this.conexao = new ConnectionFactory().getConnection();
            // cria um preparedStatement
            String sql = "select * from veiculo_usuario where id = ?";
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setBigDecimal(0, new BigDecimal(id));

            // executa um select
            ResultSet rs = stmt.executeQuery();
            // itera no ResultSet
            while (rs.next()) {
                veiculo = new VeiculoUsuario(BigInteger.valueOf(rs.getLong("id")),
                        new UsuarioDAO().findById(BigInteger.valueOf(rs.getLong("usuario_id"))),
                        TipoVeiculo.valueOf(rs.getString("tipo")),
                        rs.getString("descricao"),
                        rs.getString("placa"),
                        rs.getDate("dataCadastro"),
                        rs.getDate("dataAtualizacao"));

            }
            this.conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return veiculo;
    }

    public void editar(VeiculoUsuario veiculo) throws SQLException {
        try {
            this.conexao = new ConnectionFactory().getConnection();
            this.conexao.setAutoCommit(false);
            PreparedStatement stmt;
            ResultSet rs;
            String sqlUsuario = "UPDATE  veiculo_usuario(`tipo`, `descricao`, `placa`,`dt_atualizacao`)"
                    + "VALUES(?, ?, ?,?) WHERE usuario_id = ?;";
            stmt = this.conexao.prepareStatement(sqlUsuario);

            stmt.setString(1, veiculo.getTipo().codigo());
            stmt.setString(2, veiculo.getDescricao());
            stmt.setString(3, veiculo.getPlaca());
            stmt.setDate(4, new Date(veiculo.getDataAtualizacao().getTime()));
            stmt.setBigDecimal(5, new BigDecimal(veiculo.getUsuario().getId()));

            // executa um select
            stmt.executeUpdate(sqlUsuario);
            this.conexao.commit();
        } catch (Exception ex) {
            this.conexao.rollback();
            throw ex;
        } finally {
            this.conexao.close();
        }
    }
}

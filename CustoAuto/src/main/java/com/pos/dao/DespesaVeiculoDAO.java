/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.dao;

import com.pos.entity.DespesaVeiculo;
import com.pos.entity.TipoDespesa;
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
 * @author jony
 */
public class DespesaVeiculoDAO {
        private Connection conexao;
    
    public void add(DespesaVeiculo despesa) throws SQLException {
        try {
            this.conexao = new ConnectionFactory().getConnection();
            this.conexao.setAutoCommit(false);
            PreparedStatement stmt;
            ResultSet rs;            
            String sqlInsert = "INSERT INTO despesa_veiculo(`veiculo_id`, `data_despesa`, `tipo`, `descricao`, `kilometragem`, `valor`)"
                    + "VALUES(?, ?, ?, ?, ?, ?);";
            stmt = this.conexao.prepareStatement(sqlInsert);
            stmt.setBigDecimal(1, new BigDecimal(despesa.getVeiculo().getId()) );
            stmt.setDate(2, (Date) despesa.getDataDespesa());
            stmt.setString(3, despesa.getTipo().codigo() );
            stmt.setString(4, despesa.getDescricao() );
            stmt.setInt(5, despesa.getKilometragem());
            stmt.setDouble(6, despesa.getValor());
            
            // executa um select
            stmt.executeUpdate(sqlInsert);
            this.conexao.commit();
        } catch (Exception ex) {
            this.conexao.rollback();
            throw ex;            
        } finally {
            this.conexao.close();
        }
    }
    
    public DespesaVeiculo findById(BigInteger id) {
        DespesaVeiculo despesa = null;
        try {
            this.conexao = new ConnectionFactory().getConnection();
            // cria um preparedStatement
            String sql = "select * from despesa_veiculo where id = ?";
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setBigDecimal(0, new BigDecimal(id) );
            
            // executa um select
            ResultSet rs = stmt.executeQuery();
            // itera no ResultSet
            while (rs.next()) {
                despesa = new DespesaVeiculo( BigInteger.valueOf(rs.getLong("id")), 
                        new VeiculoUsuarioDAO().findById( BigInteger.valueOf(rs.getLong("veiculo_id"))), 
                        rs.getDate("data_despesa"), 
                        TipoDespesa.valueOf(rs.getString("tipo")), 
                        rs.getString("descricao"), 
                        rs.getInt("kilometragem"), 
                        rs.getDouble("valor"), 
                        rs.getDate("data_registro"), 
                        rs.getDate("data_atualizacao"));
            }
            this.conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return despesa;
    }    
    
}

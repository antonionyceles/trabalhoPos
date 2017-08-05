package com.pos.dao;

import com.pos.entity.Usuario;
import com.pos.factory.ConnectionFactory;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author antoniony.lima
 */
public class UsuarioDAO {
    
    private Connection conexao;
    
    public void add(Usuario usuario) throws SQLException {
        try {
            this.conexao = new ConnectionFactory().getConnection();
            this.conexao.setAutoCommit(false);
            PreparedStatement stmt;
            ResultSet rs;            
            String sqlUsuario = "INSERT INTO usuario(`nome`, `email`, `senha`)"
                    + "VALUES(?, ?, md5(?));";
            stmt = this.conexao.prepareStatement(sqlUsuario);
            stmt.setString(1, usuario.getNome() );
            stmt.setString(2, usuario.getEmail() );
            stmt.setString(3, usuario.getSenha() );
            
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
    
    public Object findById(BigInteger id) {
        Usuario user = null;
        try {
            this.conexao = new ConnectionFactory().getConnection();
            // cria um preparedStatement
            String sql = "select * from usuario where cd_usuario = ?";
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setBigDecimal(0, new BigDecimal(id) );
            
            // executa um select
            ResultSet rs = stmt.executeQuery();
            // itera no ResultSet
            while (rs.next()) {
                user = new Usuario( BigInteger.valueOf( rs.getLong("id") ),
                                   rs.getString("nome"),
                                   rs.getString("email"),
                                   rs.getString("senha"),
                                   rs.getDate("data_registro"),
                                   rs.getDate("data_atualizacao") );
            }
            this.conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }
       
    public Usuario findOneByUsuarioSenha(Usuario user) throws SQLException {
        Usuario usuario = null;
        try {
            this.conexao = new ConnectionFactory().getConnection();
            // cria um preparedStatement
            String sql = "select * from usuario where email = ? AND password = md5(?);";            
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getSenha());
            // executa um select
            ResultSet rs = stmt.executeQuery();
            // itera no ResultSet
            while (rs.next()) {
                user = new Usuario( BigInteger.valueOf( rs.getLong("id") ),
                                   rs.getString("nome"),
                                   rs.getString("email"),
                                   rs.getString("senha"),
                                   rs.getDate("data_registro"),
                                   rs.getDate("data_atualizacao") );
            }
            this.conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
        return usuario;        
    }  
}

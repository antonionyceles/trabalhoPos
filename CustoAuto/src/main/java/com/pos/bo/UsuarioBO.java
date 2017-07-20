/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.bo;

import com.pos.dao.UsuarioDAO;
import com.pos.entity.Usuario;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 *
 * @author antoniony.lima
 */
public class UsuarioBO {
    
    protected UsuarioDAO userDAO;
    
    public Usuario isUser(Usuario user) throws Exception {
        userDAO = new UsuarioDAO();
        if (user.getDsPassword().equals("") || user.getDsLogin().equals("")) {
            throw new Exception("Usuário ou Senha inválido");
        }
        user.setDsPassword(getSenhaCriptografada(user.getDsPassword()));
        Usuario usuario = userDAO.findOneByUsuarioSenha(user);
        if (usuario == null) {
            throw new Exception("Usuário inválido");
        }
        return usuario;
    }
    
    private String getSenhaCriptografada(String senha) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(senha.getBytes(), 0, senha.length());
        senha = new BigInteger(1, m.digest()).toString(16);
        return senha;
    }
    
    
    public void savePreCadastro(String nome, String sobrenome, String senha, Date dtNascimento){
        
    }
    
}

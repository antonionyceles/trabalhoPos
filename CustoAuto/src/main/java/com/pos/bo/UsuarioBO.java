/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.bo;

import com.pos.dao.UsuarioDAO;
import com.pos.entity.Usuario;
import com.pos.session.SessionSingleton;
import com.pos.util.StringUtil;
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
        if (user.getSenha().equals("") || user.getEmail().equals("")) {
            throw new Exception("Usuário ou Senha inválido");
        }
        user.setSenha(getSenhaCriptografada(user.getSenha()));
        Usuario usuario = userDAO.findOneByUsuarioSenha(user);
        if (usuario == null) {
            throw new Exception("Usuário inválido");
        }
        if(SessionSingleton.getSession(user)){
            throw new Exception("Usuário já está conectado em outro dispositivo");
        }
        SessionSingleton.setSessionUsuario(user);
        return usuario;
    }

    private String getSenhaCriptografada(String senha) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(senha.getBytes(), 0, senha.length());
        senha = new BigInteger(1, m.digest()).toString(16);
        return senha;
    }

    public void savePreCadastro(Usuario usuario, String confirmacao) throws Exception {
        if (usuario.getNome() == null || usuario.getNome().equals("")) {
            throw new Exception("O campo nome é obrigatório");        
        } else if (usuario.getEmail()== null || usuario.getEmail().equals("")) {
            throw new Exception("O campo E-mail é obrigatório");
        } else if (usuario.getSenha() == null || usuario.getSenha().equals("")) {
            throw new Exception("O campo senha é obrigatório");
        } else if (confirmacao == null || confirmacao.equals("")) {
            throw new Exception("O campo confirmacao é obrigatório");
        } else if (!confirmacao.toLowerCase().equals(usuario.getSenha().toLowerCase())) {
            throw new Exception("O campo senha não corresponde com a confirmação");
        }
        
        usuario.setSenha(getSenhaCriptografada(usuario.getSenha()));
        userDAO = new UsuarioDAO();
        userDAO.add(usuario);

    }

}

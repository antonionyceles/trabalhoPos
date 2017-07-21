/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.bo;

import com.pos.dao.UsuarioDAO;
import com.pos.entity.Cliente;
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

    public void savePreCadastro(Cliente cliente, Usuario usuario,String confirmacao) throws Exception {
        if (cliente.getNmNome() == null || cliente.getNmNome().equals("")) {
            throw new Exception("O campo nome é obrigatório");
        } else if (cliente.getNmSobrenome() == null || cliente.getNmSobrenome().equals("")) {
            throw new Exception("O campo sobrenome é obrigatório");

        } else if (cliente.getNrTelefone() == null || cliente.getNrTelefone().equals("")) {
            throw new Exception("O campo telefone é obrigatório");

        } else if (cliente.getNrCelular()== null || cliente.getNrCelular().equals("")) {
            throw new Exception("O campo celular é obrigatório");

        } else if (usuario.getDsPassword() == null || usuario.getDsPassword() .equals("")) {
            throw new Exception("O campo senha é obrigatório");

        } else if (confirmacao == null || confirmacao.equals("")) {
            throw new Exception("O campo confirmacao é obrigatório");

        }else if(cliente.getDtNascimento().after(new Date())){
            
             throw new Exception("A data de Nascimento não pode ser maior que a data atual");
        }else if(!confirmacao.toLowerCase().equals(usuario.getDsPassword().toLowerCase())){
             throw new Exception("O campo senha não corresponde com a confirmação");
        }
        cliente.setTpSituacao("I");
        
        userDAO = new UsuarioDAO();
        userDAO.adiciona(usuario);
        
    }

}

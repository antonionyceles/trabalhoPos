/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.bo;

import com.pos.dao.UsuarioDAO;
import com.pos.entity.Usuario;

/**
 *
 * @author antoniony.lima
 */
public class UsuarioBO {
    
    protected UsuarioDAO userDAO ;
    public Usuario isUser(Usuario user) throws Exception{
        userDAO = new UsuarioDAO();
       Usuario usuario =  userDAO.findOneByUsuarioSenha(user);
       if(usuario==null){
           throw new Exception("Usuário inválido");
       }
       return usuario;
    }
    
}

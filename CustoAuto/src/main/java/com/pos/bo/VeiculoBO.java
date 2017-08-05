/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.bo;

import com.pos.dao.VeiculoUsuarioDAO;
import com.pos.entity.TipoVeiculo;
import com.pos.entity.VeiculoUsuario;

/**
 *
 * @author Antoniony
 */
public class VeiculoBO {

  protected  VeiculoUsuarioDAO veiculoDAO = new VeiculoUsuarioDAO();

    public void adicionar(VeiculoUsuario veiculoU) throws Exception {
        try {
            veiculoDAO.add(veiculoU);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void editar(VeiculoUsuario vc) throws Exception {
        try {
            veiculoDAO.editar(vc);
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public TipoVeiculo getTipoVeiculo(String codigo){
        TipoVeiculo[] tipos = TipoVeiculo.values();
        for (int i = 0; i < tipos.length; i++) {
            if (tipos[i].codigo().equals(codigo)) {
                return tipos[i];
            }            
        }
        return TipoVeiculo.Outros;
    }

}

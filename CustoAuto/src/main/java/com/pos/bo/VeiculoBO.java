/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.bo;

import com.pos.dao.VeiculoUsuarioDAO;
import com.pos.entity.TipoVeiculo;
import com.pos.entity.VeiculoUsuario;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

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
    
    public List<VeiculoUsuario> findByUser(BigInteger id) {
        List<VeiculoUsuario> veiculos = new ArrayList<VeiculoUsuario>();        
        try {
            veiculos = veiculoDAO.findByUser(id);
            return veiculos;
        } catch (Exception ex) {
            throw ex;
        }    
    }

}

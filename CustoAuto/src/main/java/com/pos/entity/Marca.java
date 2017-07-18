/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.entity;

import com.google.gson.annotations.SerializedName;
import java.math.BigInteger;

/**
 *
 * @author antoniony.lima
 */
public class Marca {

    @SerializedName("codigo")
    public BigInteger id;
    @SerializedName("nome")
    public String marca;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    

}

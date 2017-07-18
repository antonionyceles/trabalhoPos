/* * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.custoauto;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pos.entity.Marca;
import com.pos.util.GsonUtil;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author antoniony.lima
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Type listType = new TypeToken<ArrayList<Marca>>() {
            }.getType();
         List<Marca> marcaL = (List<Marca>) GsonUtil.getGsonFromUrl("https://fipe-parallelum.rhcloud.com/api/v1/carros/marcas",listType);
         System.out.println(marcaL.size());
    
    }
    
}

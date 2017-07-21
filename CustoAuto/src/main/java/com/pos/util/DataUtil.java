/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author antoniony.lima
 */
public class DataUtil {

    public static Date getDataFromString(String dtNascimento) throws Exception {
        Date data = null;
        if (dtNascimento == null || dtNascimento.equalsIgnoreCase("")) {
            throw new Exception("Campo data é obrigatorio");
        }
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            data = format.parse(dtNascimento);
        } catch (Exception ex) {
            throw ex;
        }
        return data ;
    }

}

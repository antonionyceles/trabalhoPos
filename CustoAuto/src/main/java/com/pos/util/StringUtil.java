/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.util;

/**
 *
 * @author Antoniony
 */
public class StringUtil {
    public static String retiraMaskTel(String tel){
        return tel.trim().replaceAll("[\\(\\)\\.\\s-]+","");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.util;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.URL;
import java.lang.reflect.Type;

/**
 *
 * @author antoniony.lima
 */
public class GsonUtil {

    public static Object getGsonFromUrl(String uri, Type listType) {
        Gson jsonObj = new Gson();
        StringBuilder gsonString = new StringBuilder();
        try {
            URL url = new URL(uri);
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line;
            while ((line = br.readLine()) != null) {
                gsonString.append(line);
            }

//            System.out.println(vc.size());
            System.out.println(gsonString.toString());
            br.close();
            is.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObj.fromJson(gsonString.toString(), listType);
    }

}

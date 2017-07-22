/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.session;

import com.pos.entity.Usuario;
import com.pos.redis.connection.ConexaoRedis;
import java.util.HashMap;
import java.util.Map;
import redis.clients.jedis.Jedis;

/**
 *
 * @author Antoniony
 */
public class SessionSingleton {

    public static Boolean getSession(Usuario user) {
        Boolean result = false;
        ConexaoRedis con = new ConexaoRedis();
        Jedis jedis = con.conectar();
        if (jedis.hexists("session:custoauto:" + user.getDsLogin(),"login")) {
            result = true;
        }
        return result;

    }

    public static void setSessionUsuario(Usuario user) {
        ConexaoRedis con = new ConexaoRedis();
        Jedis jedis = con.conectar();
        Map<String, String> usuario = new HashMap<>();
        usuario.put("login", user.getDsLogin());
        jedis.hmset("session:custoauto:" + user.getDsLogin(), usuario);
    }
    
    public static void deleteSession(Usuario user){
        
    }

}

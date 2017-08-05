/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.session;

import com.pos.entity.Usuario;
import com.pos.redis.connection.ConexaoRedis;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
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
        if (jedis.exists("session:custoauto:" + user.getEmail())) {
            result = true;
        }
        jedis.disconnect();
        return result;

    }

    public static void setSessionUsuario(Usuario user) {
        ConexaoRedis con = new ConexaoRedis();
        Jedis jedis = con.conectar();
        Map<String, String> usuario = new HashMap<>();
        Timestamp t = new Timestamp(new Date().getTime());
        usuario.put("login", user.getEmail());
        usuario.put("timestamp", String.valueOf(t.getTime()));
        jedis.hmset("session:custoauto:" + user.getEmail(), usuario);
        jedis.disconnect();
    }

    public static void deleteSession(Usuario user) {
        ConexaoRedis con = new ConexaoRedis();
        Jedis jedis = con.conectar();
        System.out.println(jedis.del("session:custoauto:" + user.getEmail()));
        jedis.disconnect();
    }

    public static void getAllKeys() {
        ConexaoRedis con = new ConexaoRedis();
        Jedis jedis = con.conectar();
        Set<String> keys = jedis.keys("session:custoauto:antoniony");
        keys.forEach(obj -> {
            System.out.println(obj);
            jedis.del(obj);
        });
        keys = jedis.keys("session:custoauto:antoniony");
        keys.forEach(obj -> {
            System.out.println("oiii");
            System.out.println(obj);

        });
        jedis.disconnect();

    }

}

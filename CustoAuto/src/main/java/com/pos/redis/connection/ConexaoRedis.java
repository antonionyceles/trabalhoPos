/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.redis.connection;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 *
 * @author Antoniony
 */
public class ConexaoRedis {

    private static final String redisHost = "redis-13598.c8.us-east-1-3.ec2.cloud.redislabs.com";
    private static final Integer redisPort = 13598;

    //the jedis connection pool..
    private static JedisPool pool = null;

    public Jedis conectar() {

        try {
            pool = new JedisPool(redisHost, redisPort);
            System.out.println("Conexao Aberta");
        } catch (Exception e) {
            System.out.println("ERRO" + e.getMessage());
            throw e;
        }
        return pool.getResource();
    }
}

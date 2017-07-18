/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author antoniony.lima
 */
public class ConnectionFactory {

    protected String url = "jdbc:mysql://localhost/dbcustoauto";
    protected String login = "root";
    protected String senha = "";

    public Connection getConnection() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver()); //Essa linha foi a diferença
            return DriverManager.getConnection(
                    url + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", login, senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

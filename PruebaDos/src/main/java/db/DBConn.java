/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author worte
 */
public class DBConn {
    private final String database_name = "practica_dp";
    private final String database_user = "root";
    private final String database_password = "";
    private final String connector_url = "jdbc:mysql://localhost/" + database_name;
    
    private Connection cn;
    static Statement st = null;
    static ResultSet rs;
    
    public Connection getConnection(){
        try{
            cn = DriverManager.getConnection(connector_url, database_user, database_password);
            System.out.println("Conexion exitosa");
        } catch(SQLException e){
            System.err.println(e);
        }
        return cn;
    }
}

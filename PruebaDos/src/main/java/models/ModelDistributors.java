/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static models.ModelAddresses.rs;
import static models.ModelAddresses.st;

/**
 *
 * @author worte
 */
public class ModelDistributors {
    private final String database_name = "practica_dp";
    private final String database_user = "user_practica";
    private final String database_password = "pass_practica.2022";
    private final String connector_url = "jdbc:mysql://localhost:3306/" + database_name;
    
    private Connection cn;
    static Statement st = null;
    static ResultSet rs;
    
    private String id;
    private String fecha_registro;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    
    public void conectarBD(){
        try{
            cn = DriverManager.getConnection(connector_url,database_user,database_password);
            st = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM addresses;";            
            rs = st.executeQuery(sql);
            rs.next();
        } catch(SQLException e){
            System.err.println(e);
        }
   }
   
   public void setValues(){
       try {
            id_distribuidor = rs.getString("Id_Distribuidor");
            calle = rs.getString("Calle");
            colonia = rs.getString("Colonia");
            numero_casa = rs.getString("Numero_Casa");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error Model addresses 001: " + err.getMessage());

        }
   }
   
   public void setFirst(){
       try{
            rs.first();
            setValues();
        } catch(SQLException err){
            JOptionPane.showMessageDialog(null,"Error Model addresses 002: "+ err.getMessage());
        }
   }
   
   public void setNext(){
       try {
            if (!rs.isLast()) {
                rs.next();
                setValues();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Model addresses 003: " + ex.getMessage());
        }
   }
   
   public void setPrevius(){
       try {
            if (!rs.isFirst()) {
                rs.previous();
                setValues();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Model addresses 004: " + ex.getMessage());
        }
   }
   
   public void setLast(){
       try {
            rs.last();
            setValues();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Model addresses 005" + ex.getMessage());
        }
   }
   
   public void insert(String Id_Distribuidor, String Calle, String Numero_Casa, String Colonia){
        try{
            String sql = "INSERT INTO addresses VALUES ('"+Id_Distribuidor+"','"+Calle+"','"+Numero_Casa+"','"+Colonia+"');";
            System.out.println(sql);
            st.executeUpdate(sql);
            this.conectarBD();
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error Model addresses 006: " + ex.getMessage());
        }
    }
   
   public void update(String Id_Distribuidor, String Calle, String Numero_Casa, String Colonia){
        try{
            String actual_id = this.getId_distribuidor();
            String sql = "UPDATE addresses SET Calle='"+Calle+"',Numero_Casa='"+Numero_Casa+"',Colonia='"+Colonia+"' WHERE Id_Distribuidor='"+actual_id+"';";
            st.executeUpdate(sql);
            this.conectarBD();
           } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error Model addresses 007: " + ex.getMessage());
        }
    }
   
   public void delete(String Id_Distribuidor){
        try{
            String sql= "DELETE FROM addresses WHERE Id_Distribuidor='"+Id_Distribuidor+"'";
            st.executeUpdate(sql);
            this.conectarBD();
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error Model addresses 008: " + ex.getMessage());
        }
    }
    
}

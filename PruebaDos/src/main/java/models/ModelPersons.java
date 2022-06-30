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

/**
 *
 * @author worte
 */
public class ModelPersons {
    private final String database_name = "practica_dp";
    private final String database_user = "user_practica";
    private final String database_password = "pass_practica.2022";
    private final String connector_url = "jdbc:mysql://localhost:3306/" + database_name;
    
    private Connection cn;
    static Statement st = null;
    static ResultSet rs;
    
   private String id_distribuidor;
   private String nombre;
   private String ap;
   private String am;

    public String getId_distribuidor() {
        return id_distribuidor;
    }

    public void setId_distribuidor(String id_distribuidor) {
        this.id_distribuidor = id_distribuidor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp() {
        return ap;
    }

    public void setAp(String ap) {
        this.ap = ap;
    }

    public String getAm() {
        return am;
    }

    public void setAm(String am) {
        this.am = am;
    }
   
      public void conectarBD(){
        try{
            cn = DriverManager.getConnection(connector_url,database_user,database_password);
            st = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM persons;";            
            rs = st.executeQuery(sql);
            rs.next();
        } catch(SQLException e){
            System.err.println(e);
        }
   }
   
   public void setValues(){
       try {
            id_distribuidor = rs.getString("Id_Distribuidor");
            nombre = rs.getString("Nombre");
            ap = rs.getString("Apellido_Paterno");
            am = rs.getString("Apellido_Materno");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error Model persons 001: " + err.getMessage());

        }
   }
   
   public void setFirst(){
       try{
            rs.first();
            setValues();
        } catch(SQLException err){
            JOptionPane.showMessageDialog(null,"Error Model persons 002: "+ err.getMessage());
        }
   }
   
   public void setNext(){
       try {
            if (!rs.isLast()) {
                rs.next();
                setValues();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Model persons 003: " + ex.getMessage());
        }
   }
   
   public void setPrevius(){
       try {
            if (!rs.isFirst()) {
                rs.previous();
                setValues();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Model persons 004: " + ex.getMessage());
        }
   }
   
   public void setLast(){
       try {
            rs.last();
            setValues();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Model persons 005" + ex.getMessage());
        }
   }
   
   public void insert(String Id_Distribuidor, String Nombre, String Apellido_Materno, String Apellido_Paterno){
        try{
            String sql = "INSERT INTO persons VALUES ('"+Id_Distribuidor+"','"+Nombre+"','"+Apellido_Materno+"','"+Apellido_Paterno+"');";
            System.out.println(sql);
            st.executeUpdate(sql);
            this.conectarBD();
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error Model persons 006: " + ex.getMessage());
        }
    }
   
   public void update(String Id_Distribuidor, String Nombre, String Apellido_Materno, String Apellido_Paterno){
        try{
            String actual_id = this.getId_distribuidor();
            String sql = "UPDATE persons SET Nombre='"+Nombre+"',Apellido_Materno='"+Apellido_Materno+"',Apellido_Paterno='"+Apellido_Paterno+"' WHERE Id_Distribuidor='"+actual_id+"';";
            st.executeUpdate(sql);
            this.conectarBD();
           } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error Model persons 007: " + ex.getMessage());
        }
    }
   
   public void delete(String Id_Distribuidor){
        try{
            String sql= "DELETE FROM persons WHERE Id_Distribuidor='"+Id_Distribuidor+"'";
            st.executeUpdate(sql);
            this.conectarBD();
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error Model persons 008: " + ex.getMessage());
        }
    }
}

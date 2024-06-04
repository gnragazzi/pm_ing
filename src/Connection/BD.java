/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author ezebe
 */
public class BD {
    
    public static Connection conexion;
    
    // Librería de MySQL

    public BD() {
    }
    

    public static void conexion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static String hola() throws SQLException{
        Statement sentencia=conexion.createStatement();
        ResultSet holaa=sentencia.executeQuery("select * from Planta");
        holaa.next();
        return holaa.getString("color");
    }
 
    
   public static void connect(){ 
            try{
                Class.forName("com.mysql.cj.jdbc.Driver"); 
                conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false","root","usuario");
                
            }
            catch(ClassNotFoundException | SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
}

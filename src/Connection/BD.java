/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;
import java.sql.*;
import pm_ingsw1.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    
    public static void enviarPlanta(String color, int superficie) throws SQLException{
        try{
        Statement sentencia=conexion.createStatement();
        ResultSet chequeo=sentencia.executeQuery("select Color from Planta where Color like '" + color + "'");
        if (!chequeo.next()){                                                                                                   //devuelve false si no encontro nada en select 
            PreparedStatement envio;
            envio = conexion.prepareStatement("insert into Planta (Color,Superficie) values ('" + color + "', '" + superficie + "')");
            envio.executeUpdate();
        }else
                System.out.println("No es posible");                                                                            // aca va un jpanel
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    
    public static ArrayList<Planta> listarPlanta() throws SQLException{
        ArrayList<Planta> planta;
        Planta aux= new Planta();
        Statement sentencia=conexion.createStatement();
        ResultSet lista=sentencia.executeQuery("select * from planta");
        while(lista.next()){
            aux.setColor(lista.getString("color"));
            aux.setSuperficie(lista.getInt("superficie"));
            
        }
    }
    
    public static void asignarPlanta(Maquina maquina, Planta planta){
        try{
            PreparedStatement envio=conexion.prepareStatement("insert into Planta(Planta_IdPlanta) values ..................  ");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
   public static void connect(){ 
            try{
                Class.forName("com.mysql.cj.jdbc.Driver"); 
                conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false","root","24103");
                
            }
            catch(ClassNotFoundException | SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
}

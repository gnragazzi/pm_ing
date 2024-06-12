/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;
import java.sql.*;
import pm_ingsw1.*;
import pm_ingsw1.Estado;
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
public class BD{
    
    public static Connection conexion;
    // Librería de MySQL
    public static ConnectionDemo gen = new ConnectionDemo();
    

    public BD() {
    }
    

    public static void conexion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
///////////////////////////////////////////////////////////////////Planta////////////////////////////////////////////////////////////////////////
    
    public static boolean chequearPlanta(String color) throws SQLException{
        try{
            System.out.println(conexion.toString());
            Statement sentencia=conexion.createStatement();
            ResultSet chequeo=sentencia.executeQuery("select Color from Planta where Color = '" + color + "'");
            if(chequeo.next())
                return true;
            else
                return false;
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
            
    public static void cargarPlanta(Planta planta) throws SQLException{
        try{                                                                                                  //devuelve false si no encontro nada en select 
            PreparedStatement envio;
            envio = conexion.prepareStatement("insert into Planta (Color,Superficie) values ('" + planta.getColor() + "', '" + planta.getSuperficie() + "')");
            envio.executeUpdate();  
            System.out.println("Ha cargado una planta");
// aca va un jpanel
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
 
    public static ArrayList<Planta> listarPlanta() throws SQLException{
        ArrayList<Planta> planta= new ArrayList<Planta>();
        int i=0;
        Statement sentencia=conexion.createStatement();
        ResultSet lista=sentencia.executeQuery("select * from Planta");
        while(lista.next()){
            Planta aux= new Planta();
            aux.setColor(lista.getString("Color"));
            aux.setSuperficie(lista.getInt("Superficie"));
            planta.add(i, aux);
            i++;
        }
        return planta;
    }
    
   
   
   
///////////////////////////////////////////////////////////////////Maquina////////////////////////////////////////////////////////////////////////

     public static ArrayList<Maquina> listarMaquina() throws SQLException{
        ArrayList<Maquina> maquina= new ArrayList<Maquina>();
        int i=0;
        Statement sentencia=conexion.createStatement();
        ResultSet lista=sentencia.executeQuery("select * from Maquina");
        while(lista.next()){
            Maquina aux= new Maquina();
            aux.setNroID(lista.getInt("NroID"));
            aux.setMarca(lista.getString("Marca"));
            aux.setModelo(lista.getString("Modelo"));
            if (lista.getString("Estado").equals("Activo"))
                aux.setEstado(Estado.ACTIVO);
            else 
                aux.setEstado(Estado.REPARACION);
            maquina.add(i, aux);
            i++;
        }
        /*
        */
        return maquina;
    }
     
    public static boolean chequearMaquina(int id) throws SQLException{
        try{
            Statement sentencia=conexion.createStatement();
            ResultSet chequeo=sentencia.executeQuery("select NroID from Maquina where NroID = '" + id + "'");
            if(chequeo.next())
                return true;
            else
                return false;
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
               

    public static void cargarMaquina(Maquina maquina) throws SQLException{
        Statement sentencia=conexion.createStatement();
        ResultSet id=sentencia.executeQuery("select Idplanta from Planta where Color like '" + maquina.getPlanta().getColor() + "' ");
        System.out.println(id);
        id.next();
        String carga= "insert into  Maquina(NroID,Marca,Modelo,Estado,Planta_IdPlanta) values('" + maquina.getNroID() + "' , '" + maquina.getMarca() + "' , '" + maquina.getModelo() + "' ,  '" + maquina.getEstado() + "' , '" + id.getInt("IdPlanta") + "')";     
        PreparedStatement envio=conexion.prepareStatement(carga);
        envio.executeUpdate();
        //System.out.println("Ha cargado una maquina");

    }
    
    public static boolean isemptyMaquina() throws SQLException{
        Statement sentencia=conexion.createStatement();
        ResultSet resultado=sentencia.executeQuery("select IdPlanta from Planta");
        if(!resultado.next()){
            return true;
        }
        else{
            return false;
        }
    }
    
    
    
    
    
///////////////////////////////////////////////////////////////////Tecnico////////////////////////////////////////////////////////////////////////
      public static ArrayList<Tecnico> listarTecnico() throws SQLException{
        ArrayList<Tecnico> tecnicos= new ArrayList<Tecnico>();
        /*
        int i=0;
        Statement sentencia=conexion.createStatement();
        ResultSet lista=sentencia.executeQuery("select * from tecnico");
        while(lista.next()){
            Tecnico_DNI
            Registro r[] = ;
            Tecnico aux= new Tecnico(lista.getString("Nombre"), lista.getString("Apellido"), lista.getInt("DNI"), lista.getString("Fec_Nac"), lista.getInt("Contacto"), );
            tecnico.add(i, aux);
            i++;
        }
        return tecnico;
            */
        for(int i = 1; i < 11; i++){
            ArrayList <Registro> r = new ArrayList<Registro>();
            Tecnico aux= new Tecnico("N"+i,"A"+i,i,"F"+i,i,r);
            tecnicos.add(i-1, aux);
        }
        return tecnicos;
    }

    public static boolean chequearTecnico(int dni) throws SQLException{
      try{
          Statement sentencia=conexion.createStatement();
          ResultSet chequeo=sentencia.executeQuery("select DNI from Tecnico where DNI = '" + dni + "'");
          if(chequeo.next())
              return true;
          else
              return false;
      }
      catch(SQLException e){
          System.out.println(e.getMessage());
      }
      return false;
     }

    public static void cargarTecnico(Tecnico tecnico) throws SQLException{
        try{
            PreparedStatement envio=conexion.prepareStatement("insert into  Tecnico (DNI, Nombre,Apellido,Fec_Nac,Contacto) values ('" + tecnico.getDni() + "' , '" + tecnico.getNombre() + "' , '" + tecnico.getApellido() + "' ,  '" + tecnico.getFec_nac() + "' , '" + tecnico.getContacto() + "') ;");
            envio.executeUpdate();
            System.out.println("Ha cargado un tecnico");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public static boolean isemptyTecnico() throws SQLException{
        Statement sentencia=conexion.createStatement();
        ResultSet resultado=sentencia.executeQuery("select Idtecnico from Tecnico");
        if(!resultado.next()){
            return true;
        }
        else{
            return false;
        }
    }
      
      
      
      
    
///////////////////////////////////////////////////////////////////Registro////////////////////////////////////////////////////////////////////////
/*
    */
    public static void asignarRegistro(Registro registro){
        /*
        try{
            PreparedStatement envio=conexion.prepareStatement("insert into  Registro (H_Inicio,H_Final,Turno,Maquina_NroID,Tecnico_DNI) values ('" + registro.getFec_inicio() + "' , '" + registro.getFec_final() + "' , '" + registro.getTurno() + "' ,  '" + registro.getMaquina().getNroID() + "' , '" + registro.getTecnico().getDni() + "') ;");
            envio.executeUpdate();
            System.out.println("Ha cargado un registro");

        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        */
        System.out.println("Registro Asignado!");
    }
    
        ///////////////////////////////////////////////////////////////////Conexion////////////////////////////////////////////////////////////////////////

   public static void connect() throws ClassNotFoundException{
       conexion = gen.getConexión();
        }
}

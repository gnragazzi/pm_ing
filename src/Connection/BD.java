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
    
    
    
///////////////////////////////////////////////////////////////////Planta////////////////////////////////////////////////////////////////////////
    
    public static boolean chequearPlanta(String color) throws SQLException{
        try{
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
            envio.executeUpdate();                                                                           // aca va un jpanel
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
 
    public static ArrayList<Planta> listarPlanta() throws SQLException{
        ArrayList<Planta> planta= new ArrayList<Planta>();
        /*int i=0;
        Statement sentencia=conexion.createStatement();
        ResultSet lista=sentencia.executeQuery("select * from planta");
        while(lista.next()){
            Planta aux= new Planta();
            aux.setColor(lista.getString("Color"));
            aux.setSuperficie(lista.getInt("Superficie"));
            planta.add(i, aux);
            i++;
        }
        return planta;
        */
        for(int i = 0; i < 5; i++){
            Planta aux= new Planta();
            aux.setColor("C" + i);
            aux.setSuperficie( (i+1)*(i+1));
            planta.add(i, aux);
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
               
    // creo que es innecesario pasar la planta como argumento, porque ya se encuentra como campo en el objeto (máquina.planta)
    public static void cargarMaquina(Maquina maquina, Planta planta) throws SQLException{ 
        System.out.println(maquina.toString());
        /*
        try{
            Statement sentencia=conexion.createStatement();
            ResultSet id=sentencia.executeQuery("select Idplanta from Planta where Color like '" + planta.getColor() + "' ");
            id.next();
            String carga= "insert into  Maquina (NroID,Marca,Modelo,Estado,Planta_IdPlanta) values ('" + maquina.getNroID() + "' , '" + maquina.getMarca() + "' , '" + maquina.getModelo() + "' ,  '" + maquina.getEstado() + "' , '" + id.getInt("IdPlanta") + "')";            PreparedStatement envio=conexion.prepareStatement(carga);
            envio.executeUpdate();
        }
        catch(SQLException e){
            System.out.println("holiss... todo salió mal");
            System.out.println(e.getMessage());
        }
        */
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
/*
      public static ArrayList<Tecnico> listarTecnico() throws SQLException{
        ArrayList<Tecnico> tecnico= new ArrayList<Tecnico>();
        int i=0;
        Statement sentencia=conexion.createStatement();
        ResultSet lista=sentencia.executeQuery("select * from tecnico");
        while(lista.next()){
            Tecnico aux= new Tecnico();
            aux.setNombre(lista.getString("Nombre"));
            aux.setApellido(lista.getString("Apellido"));
            aux.setDni(lista.getInt("DNI"));
            aux.setContacto(lista.getInt("Contacto"));
            aux.setFec_nac(lista.getString("Fec_Nac"));
            tecnico.add(i, aux);
            i++;
        }
        return tecnico;
    }
      */
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
    public static void asignarRegistro(Registro registro){
        try{
            PreparedStatement envio=conexion.prepareStatement("insert into  Registro (H_Inicio,H_Final,Turno,Maquina_NroID,Tecnico_DNI) values ('" + registro.getFec_inicio() + "' , '" + registro.getFec_final() + "' , '" + registro.getTurno() + "' ,  '" + registro.getMaquina().getNroID() + "' , '" + registro.getTecnico().getDni() + "') ;");
            envio.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    */
        ///////////////////////////////////////////////////////////////////Conexion////////////////////////////////////////////////////////////////////////

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

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
        ArrayList<Tecnico> tecnicos= new ArrayList<>();
        int i=0;
        Statement sentencia=conexion.createStatement();
        ResultSet lista=sentencia.executeQuery("select * from Tecnico");
        while(lista.next()){
            Tecnico aux= new Tecnico(lista.getString("Nombre"), lista.getString("Apellido"), lista.getInt("DNI"), lista.getString("Fec_Nac"), lista.getString("Contacto"), null);
            tecnicos.add(i, aux);
            i++;
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
        try{
            PreparedStatement envio=conexion.prepareStatement("insert into  Registro (H_Inicio,H_Final,Turno,Maquina_NroID,Tecnico_DNI) values ('" + registro.getFec_inicio() + "' , '" + registro.getFec_final() + "' , '" + registro.getTurno() + "' ,  '" + registro.getMaquina().getNroID() + "' , '" + registro.getTecnico().getDni() + "') ;");
            envio.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    
    
///////////////////////////////////////////////////////////////////eliminar y rellenar////////////////////////////////////////////////////////////////////////

    public static void eliminarBase() throws SQLException{
        try{
            PreparedStatement elimina=conexion.prepareStatement("delete from Registro");
            elimina.executeUpdate();
            elimina=conexion.prepareStatement("delete from Tecnico");
            elimina.executeUpdate();
            elimina=conexion.prepareStatement("delete from Maquina");
            elimina.executeUpdate();
            elimina=conexion.prepareStatement("delete from Planta");
            elimina.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        } 
    }
    
    public static void insertarBase(){
        try{
            PreparedStatement inserta=conexion.prepareStatement("ALTER TABLE Planta AUTO_INCREMENT = 1;");//planta
            inserta.executeUpdate();
            inserta=conexion.prepareStatement("ALTER TABLE Tecnico AUTO_INCREMENT = 1;");
            inserta.executeUpdate();
            inserta=conexion.prepareStatement("insert into Planta (color, superficie) values('Amarillo',30),('Azul', 40),('Verde',50),('Rojo',90),('Negro',100);");
            inserta.executeUpdate();
            inserta=conexion.prepareStatement("insert into Maquina(NroID, Marca, Modelo, Estado, Planta_IdPlanta) values(1,'CaterPillar', 'R570',1,1),(2,'Hyundai','MB1634',1,2),(3,'Volvo','FH-750',2,3),(4,'Daewoo','619',2,4),(5,'John Deere','T-113',1,5);");
            inserta.executeUpdate();
            inserta=conexion.prepareStatement("insert into Tecnico(DNI,Nombre,Apellido,Fec_Nac,Contacto) values (44993379,'Pablo','Alcaraz','30/09/2003','2664669561'),(45382516,'Ezequiel','Bernaldez','20/01/2004','2655077582'),(44643551,'Ezequiel','Nodar','24/01/2003','2665789899'),(23999999,'Sococho','Grosso','20/10/1986','2665788888')");
            inserta.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    
    
    
    
    
    
        ///////////////////////////////////////////////////////////////////Conexion////////////////////////////////////////////////////////////////////////

   public static void connect() throws ClassNotFoundException{
       conexion = gen.getConexión();
        }
}

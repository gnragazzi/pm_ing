package pm_ingsw1;

import Connection.BD;
import GUI.Ventana;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class PM_IngSw1 {
        
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        System.getProperty("java.classpath");
        BD.connect();
        Ventana principal = new Ventana(); 
        //Maquina maquina=new Maquina(1235,"sohso","sodchbslk",null,null,Estado.ACTIVO);
        Tecnico tecnico=new Tecnico("Pablito", "Alcaraz", 3000, "2004", 2665, null);
        //Registro registro=new Registro("1900","1901",maquina,tecnico,Turno.MAÑANA);
        //BD.asignarRegistro(registro);
        ArrayList<Tecnico> tecnicoo=new ArrayList<Tecnico>();
        tecnicoo=BD.listarTecnico();
        for(int i=0;i<tecnicoo.size();i++){
            System.out.println(tecnicoo.get(i).toString());
        }
           
        System.out.println(BD.chequearPlanta("amarillo"));
        Planta aux1=new Planta();
        //Maquina aux2=new Maquina(1235, "toyota", "3", null, null, Estado.ACTIVO);
        aux1.setColor("amarillo");
        aux1.setSuperficie(0);
        BD.cargarPlanta(aux1);
        //BD.cargarMaquina(aux2);
        BD.cargarTecnico(tecnico);
        BD.isemptyMaquina();
        
    }
}

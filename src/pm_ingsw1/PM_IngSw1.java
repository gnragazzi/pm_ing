package pm_ingsw1;

import Connection.BD;
import GUI.Ventana;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class PM_IngSw1 {
    public static void main(String[] args) throws SQLException {
        BD.connect();
        Ventana principal = new Ventana(); 
//        System.out.println(BD.chequearPlanta("amarillo"));
//        Planta aux1=new Planta();
//        Maquina aux2=new Maquina(1235, "toyota", "3", null, null, Estado.ACTIVO);
//        BD.cargarPlanta("amarillo", 0);
//        aux1.setColor("amarillo");
//        aux1.setSuperficie(0);
//        BD.cargarMaquina(aux2, aux1);
//        Tecnico tecnico=new Tecnico("Pablito", "Alcaraz", 3000, "2004", 2665, null);
//        BD.cargarTecnico(tecnico);
        
    }
    
}

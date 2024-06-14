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
        BD.eliminarBase();
        BD.insertarBase();
        Ventana principal = new Ventana(); 
    }
}

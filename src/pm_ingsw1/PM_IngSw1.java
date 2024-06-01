package pm_ingsw1;

import Connection.BD;
import GUI.Ventana;
import java.sql.SQLException;

public class PM_IngSw1 {
    public static void main(String[] args) throws SQLException {
        BD.connect();
        System.out.println(BD.hola());
        
    }
    
}

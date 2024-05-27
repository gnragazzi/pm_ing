package GUI;

import java.awt.Dimension;

public class Ventana extends javax.swing.JFrame {
    public static Panel_Principal cuerpo = new Panel_Principal();
    
    public Ventana(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setName("Práctico de Máquina - Ing.Sw 1");
        this.setContentPane(cuerpo);
        
        this.setMinimumSize(new Dimension(800,600));
        this.setPreferredSize(new Dimension(800,600));
        //this.setUndecorated(true);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
    }
}

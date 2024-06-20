package GUI;

import java.awt.Dimension;

public class Ventana extends javax.swing.JFrame {
    public Panel_Principal cuerpo = new Panel_Principal();
    private Modal modal = new Modal(this,"Confirmar", cuerpo);
    
    public Ventana(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setName("Práctico de Máquina - Ing.Sw 1");
        this.setContentPane(cuerpo);
        
        this.setMinimumSize(new Dimension(800,600));
        this.setPreferredSize(new Dimension(1400,800));
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        System.out.flush();
    }
    public Modal getModal()
    {
        return modal;
    }


}

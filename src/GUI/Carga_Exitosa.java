/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author gera
 */
public class Carga_Exitosa extends JPanel{
    private JLabel mensaje = new JLabel();

    public Carga_Exitosa() {
        this.add(mensaje);
        
    }

    public Carga_Exitosa(String s) {
        mensaje.setText(s);
        this.setLayout(new GridLayout(1,1));
        this.add(mensaje);
        this.setBackground(Constantes.COLOR_FONDO);
    }
    
    public void setTexto(String s)
    {
        this.mensaje.setText(s);
    }
        
}

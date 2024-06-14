/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author gera
 */
public class Pantalla_Mensaje extends JPanel{
    private JLabel mensaje;


    public Pantalla_Mensaje(String s) {
        mensaje = new JLabel(s,SwingConstants.CENTER);
        mensaje.setFont(Constantes.FUENTE_HEADER);
        this.setLayout(new GridLayout(1,1));
        this.add(mensaje);
        this.setBackground(Constantes.COLOR_FONDO);
    }
    
    public void setTexto(String s)
    {
        this.mensaje.setText(s);
    }
        
}

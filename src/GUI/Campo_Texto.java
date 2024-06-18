/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author gera
 */

public class Campo_Texto extends Campo{

    private final JLabel Nombre = new JLabel();
    
    public Campo_Texto(String n){
        super(n);
    }
    public boolean validarCampo(){
        if(this.getInput().getText().equals(""))
        {
            input.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.RED));
            return false;
        }
        else
        {
            input.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.COLOR_PRINCIPAL));
            return true;
        }
    }

    
}

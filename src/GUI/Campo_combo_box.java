/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author gera
 */

public class Campo_combo_box extends JPanel{

    private JLabel Nombre = new JLabel();
    private JComboBox<String> input = new JComboBox<String>();
    private GridLayout layout = new GridLayout(1,4);
    
    public Campo_combo_box(String n){
        this.setBackground(null);
        Nombre.setText(n);
        Nombre.setFont(Constantes.getFUENTE_CAMPO());
        Nombre.setForeground(Constantes.getCOLOR_MENU());
        Nombre.setHorizontalAlignment(JLabel.LEFT);
        Nombre.setVerticalAlignment(JLabel.BOTTOM);
        
        /*
        input.setMinimumSize(new Dimension(20,20));
        input.setDocument(new JTextFieldLimit(Constantes.getLIM()));
        input.setFont(Constantes.getFUENTE_CAMPO());
        input.setBorder(null);
        input.setBackground(null);
        input.setForeground(Constantes.getCOLOR_MENU());
        input.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.getCOLOR_MENU()));
        */
        
        this.add(Nombre);
        Nombre.setBorder(new EmptyBorder(0, 15, 0, 0));

        this.add(input);
        
        this.setLayout(layout);

    }
    
    public JComboBox getInput(){
        return input;
    }
    public boolean validarCampo(){
        if(input.getSelectedIndex() < 0)
        {
            input.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.RED));
            return false;
        }
        else
        {
            input.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.getCOLOR_MENU()));
            return true;
        }
    }
    public void limpiarCampo()
    {
        input.setSelectedIndex(-1);
        input.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.getCOLOR_MENU()));
    }
    
}

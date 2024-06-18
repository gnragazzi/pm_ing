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

public class Campo_combo_box extends Campo{

    private JComboBox<String> input_combo = new JComboBox<String>();
    
    public Campo_combo_box(String n){
        super(n);
        this.remove(input);
        
        this.add(input_combo);
        this.setLayout(layout);
    }

    public JComboBox getComboInput(){
        return input_combo;
    }
    @Override
    public boolean validarCampo(){
        if(input_combo.getSelectedIndex() < 0)
        {
            input_combo.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.RED));
            return false;
        }
        else
        {
            input_combo.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.COLOR_PRINCIPAL));
            return true;
        }
    }
    @Override
    public void limpiarCampo()
    {
        input_combo.setSelectedIndex(-1);
        input_combo.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.COLOR_PRINCIPAL));
    }
    
}

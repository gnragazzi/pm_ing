/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
/**
 *
 * @author gera
 */

public class Campo_combo_box extends Campo{

    private JComboBox<String> input_combo = new JComboBox<String>();
    
    public Campo_combo_box(String n){
        super(n);
        this.remove(input);
        
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 3;
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.BOTH;
        c.ipadx = 10;
        c.ipady = 10;
        c.insets = new Insets(10, 10, 10, 10);
        this.add(input_combo,c);
    }

    public JComboBox getComboInput(){
        return input_combo;
    }
    @Override
    public boolean validarCampo(){
        if(input_combo.getSelectedIndex() < 0)
        {
            input_combo.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.COLOR_ERROR));
            setMsjValidacion("Elija una Opción de la lista.");
            return false;
        }
        else
        {
            input_combo.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.COLOR_PRINCIPAL));
            setMsjValidacion(" ");

            return true;
        }
    }
    @Override
    public void limpiarCampo()
    {
        input_combo.setSelectedIndex(-1);
        setMsjValidacion(" ");
        input_combo.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.COLOR_PRINCIPAL));
    }
    
}

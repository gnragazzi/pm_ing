/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
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
            input.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.COLOR_ERROR));
            setMsjValidacion("Campo Obligatorio");
            return false;
        }
        else
        {
            input.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.COLOR_PRINCIPAL));
            setMsjValidacion(" ");
            return true;
        }
    }

    
}

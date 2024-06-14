/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import javax.swing.BorderFactory;

/**
 *
 * @author gera
 */
public class Campo_Num extends Campo_Texto{
    //private JTextField num = new JTextField();
    
    public Campo_Num(String n){
        super(n);
        this.getInput().setDocument(new JTextFieldLimit(20));
        //this.cambiaInput(num);
        
    }
    @Override
    public boolean validarCampo(){
        String number = this.getInput().getText().replaceAll("[^0-9]","");
        if(!number.isEmpty() && number.equals(this.getInput().getText()))
        {
            getInput().setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.getCOLOR_MENU()));
            return true;
        }
        else
        {
            getInput().setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.RED));
            return false;
        }
    }
}

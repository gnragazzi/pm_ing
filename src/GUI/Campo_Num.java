/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JFormattedTextField;

/**
 *
 * @author gera
 */
public class Campo_Num extends Campo{
    private NumberFormat nf = new DecimalFormat();
    private JFormattedTextField num = new JFormattedTextField(nf);
    
    public Campo_Num(String n){
        super(n);
        super.add(num);
        this.cambiaInput(num);
        
    }
    @Override
    public boolean validarCampo(){
        String number = this.num.getText().replaceAll("[^0-9]","");
        if(!number.isEmpty() && Integer.parseInt(number) > 0)
            return true;
        else
            return false;
    }

    public JFormattedTextField getNum() {
        return num;
    }
    
    
}

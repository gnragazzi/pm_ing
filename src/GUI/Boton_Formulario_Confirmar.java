/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

/**
 *
 * @author gera
 */
public class Boton_Formulario_Confirmar extends Boton{
    protected Administrar form;
    public Boton_Formulario_Confirmar(String n, Administrar f)
    {
        super(n,Constantes.getFUENTE_BOTON_LATERAL());
        this.form = f;
        this.setLayout(Constantes.getLAYOUT_CENTRADO());
        this.getNombre().setHorizontalAlignment(JLabel.CENTER);
        this.getNombre().setVerticalAlignment(JLabel.CENTER);
        
    }

    @Override
    public void mouseClick(MouseEvent evt){
        if(form.esValido())
        {
            Ventana v = (Ventana)this.getTopLevelAncestor();
            v.getModal().desplegarDialog("Confirmar Carga de Máquina", form);
        }
        else
            System.out.println("Invalido");
    };
    
    @Override
    public void mouseEntra(MouseEvent evt, Color c) {                                   
        super.mouseEntra(evt, c);
        this.getNombre().setForeground(Constantes.getCOLOR_MENU_Fuente());
    }                                  
    @Override
    public void mouseSale(MouseEvent evt, Color c) {                                  
        super.mouseEntra(evt, c);
        this.getNombre().setForeground(Constantes.getCOLOR_MENU());
    }    
        
    @Override
    public Color getCol(){
        return null;
    }
    
    @Override
    public Color getHighlight(){
        //setear color
        return Constantes.getCOLOR_MENU();
    }
    

}

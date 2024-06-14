/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import GUI.Constantes;
import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

/**
 *
 * @author gera
 */
public class Boton_Formulario_Agregar_ct extends Boton_Formulario_Confirmar{
    protected Administrar form;
    public Boton_Formulario_Agregar_ct(String n, Administrar f)
    {
        super(n,f);
        this.form = f;
        this.setLayout(Constantes.LAYOUT_CENTRADO);
        this.getNombre().setHorizontalAlignment(JLabel.CENTER);
        this.getNombre().setVerticalAlignment(JLabel.CENTER);
        
    }
    @Override
    public void mouseClick(MouseEvent evt){
        System.out.println("Retorno: " + String.valueOf(form.esValido()));
        if(form.esValido())
        {
            form.enviar();
        }
        else
        {
            
        }
    };
    @Override
    public void mouseEntra(MouseEvent evt, Color c) {                                   
        super.mouseEntra(evt, c);
    }                                  
    @Override
    public void mouseSale(MouseEvent evt, Color c) {                                  
        super.mouseEntra(evt, c);
        this.getNombre().setForeground(Constantes.COLOR_PRINCIPAL);
    }    
        
    @Override
    public Color getCol(){
        return null;
    }
    
    @Override
    public Color getHighlight(){
        //setear color
        return Constantes.COLOR_PRINCIPAL;
    }

}

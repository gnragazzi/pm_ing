/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

/**
 *
 * @author gera
 */
public class Boton_Tec extends Boton_Maq{
    protected Administrar form;
    public Boton_Tec(String n, Administrar f)
    {
        super(n,f);
        this.form = f;
        this.setLayout(Constantes.LAYOUT_CENTRADO);
        this.nombre.setHorizontalAlignment(JLabel.CENTER);
        this.nombre.setVerticalAlignment(JLabel.CENTER);
        
    }
    @Override
    public void mouseClick(MouseEvent evt){
        if(this.getTextoNombre().equals(Constantes.CANCELAR))
        {
            ((CardLayout)form.getCuerpo().getLayout()).show(form.getCuerpo(),"blank");            
        }
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
        this.nombre.setForeground(Constantes.COLOR_PRINCIPAL);
    }    
        
}

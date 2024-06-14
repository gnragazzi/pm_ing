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
public class Boton_modal extends Boton{
    private Modal diag;
    public Boton_modal(String n, Modal d)
    {
        super(n,Constantes.getFUENTE_BOTON_LATERAL());
        this.diag = d;
        this.setLayout(Constantes.getLAYOUT_CENTRADO());
        this.getNombre().setHorizontalAlignment(JLabel.CENTER);
        this.getNombre().setVerticalAlignment(JLabel.CENTER);
        
    }

    @Override
    public void mouseClick(MouseEvent evt){
        if(this.getTextoNombre()== "Aceptar")
            diag.getActual().enviar();
        diag.setVisible(false);
    };
    @Override
    public void mouseEntra(MouseEvent evt, Color c) {                                   
        super.mouseEntra(evt, Constantes.COLOR_SECUNDARIO);
    }                                  
    @Override
    public void mouseSale(MouseEvent evt, Color c) {                                  
        super.mouseSale(evt, null);

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

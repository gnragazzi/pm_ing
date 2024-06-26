/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.event.MouseEvent;

/**
 *
 * @author gera
 */
public class Boton_modal extends Boton{
    private Modal diag;
    public Boton_modal(String n, Modal d)
    {
        super(n,Constantes.FUENTE_BOTON_LATERAL);
        this.diag = d;
        this.setLayout(Constantes.LAYOUT_CENTRADO);
        this.nombre.setForeground(Constantes.COLOR_PRINCIPAL);
    }

    @Override
    public void mouseClick(MouseEvent evt){
        if(this.getTextoNombre().equals(Constantes.ACEPTAR))
            diag.getActual().enviar();
        else if(this.getTextoNombre().equals(Constantes.CANCELAR)) 
            diag.setVisible(false);
        else{
            diag.setVisible(false);
            diag.getCuerpo().cambiarPanel("Bienvenido");
        }
    };

    @Override
    public Color getCol(){
        return Constantes.COLOR_FONDO;
    }
    
    @Override
    public Color getHighlight(){
        //setear color
        return Constantes.COLOR_SECUNDARIO;
    }
    

}

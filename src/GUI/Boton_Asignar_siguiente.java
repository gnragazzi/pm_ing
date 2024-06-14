/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import GUI.Boton;
import GUI.Constantes;
import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

/**
 *
 * @author gera
 */
public class Boton_Asignar_siguiente extends Boton{
    private Administrar_registro padre;
    public Boton_Asignar_siguiente(String n, Administrar_registro f)
    {
        super(n,Constantes.getFUENTE_BOTON_LATERAL());
        padre = f;
        this.setLayout(Constantes.getLAYOUT_CENTRADO());
        this.getNombre().setHorizontalAlignment(JLabel.CENTER);
        this.getNombre().setVerticalAlignment(JLabel.CENTER);
        this.setFont(Constantes.FUENTE_HEADER);
    }

    @Override
    public void mouseClick(MouseEvent evt){
        padre.cambiarListado(1);
    };
    /*
    public Formulario_Texto getFormularioActual(){
        return this.formulario_actual;
    }
    */
    @Override
    public void mouseEntra(MouseEvent evt, Color c) {                                   
        this.nombre.setForeground(Constantes.COLOR_SELECCIÓN);
    }                                  
    @Override
    public void mouseSale(MouseEvent evt, Color c) {                                  
        this.nombre.setForeground(Constantes.COLOR_PRINCIPAL);
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

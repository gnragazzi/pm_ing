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
public class Boton_Formulario_Limpiar extends Boton_Formulario_Agregar {
    public Boton_Formulario_Limpiar(String n, Formulario_cargar_máquina f){
        super(n,f);
        this.getNombre().setHorizontalAlignment(JLabel.CENTER);
        this.getNombre().setVerticalAlignment(JLabel.CENTER);
    }
    @Override
    public void mouseClick(MouseEvent evt){
            //this.getFormularioActual().limpiarCampos();
            System.out.println("Otro Click");
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

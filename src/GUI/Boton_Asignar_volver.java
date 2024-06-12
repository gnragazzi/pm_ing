/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

//import static Ejecuciones.Lab2023.biblioteca;
import GUI.Boton;
import GUI.Constantes;
import java.awt.CardLayout;
//import static GUI.Menúes.Formularios.Boton_Header_Agregar.seleccionFormulario;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

/**
 *
 * @author gera
 */
public class Boton_Asignar_volver extends Boton{
    public Boton_Asignar_volver(String n)
    {
        super(n,Constantes.getFUENTE_BOTON_LATERAL());
        this.setLayout(Constantes.getLAYOUT_CENTRADO());
        this.getNombre().setHorizontalAlignment(JLabel.CENTER);
        this.getNombre().setVerticalAlignment(JLabel.CENTER);
        
    }

    @Override
    public void mouseClick(MouseEvent evt){
        Formulario_asignar_registro p = (Formulario_asignar_registro)this.getParent().getParent().getParent().getParent();
        p.cambiarListado(-1);
    };
    /*
    public Formulario_Texto getFormularioActual(){
        return this.formulario_actual;
    }
    */
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

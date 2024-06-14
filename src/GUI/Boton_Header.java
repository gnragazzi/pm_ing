/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import GUI.Boton;
import GUI.Constantes;
import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/**
 *
 * @author gera
 */
public class Boton_Header extends Boton{
    private JPanel padre;
    public Boton_Header(String nombre, JPanel cuerpo){
        super(nombre, Constantes.getFUENTE_BOTON_HEADER());
        padre = cuerpo;
        this.setLayout(Constantes.getLAYOUT_CENTRADO());
        this.getNombre().setForeground(Constantes.getCOLOR_MENU());
    }
    @Override
    public void mouseClick(MouseEvent evt){
        switch(this.getNombre().getText()){
            case "Cargar":
            {
                ((Administrar)padre.getParent()).limpiarCampos();
                ((Administrar)padre.getParent()).cargarDesdeBd();
                ((CardLayout)padre.getLayout()).show(padre,"Cargar");
            }break;
            default:
            {
                ((CardLayout)padre.getLayout()).show(padre,"en_construcción");
            }break;
        }
    }
    
    /*
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
    */
}

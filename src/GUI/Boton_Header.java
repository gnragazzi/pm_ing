/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import GUI.Boton;
import GUI.Constantes;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/**
 *
 * @author gera
 */
public class Boton_Header extends Boton{
    private JPanel padre;
    private Header header;
    public Boton_Header(String nombre, JPanel cuerpo,Header h){
        super(nombre, Constantes.FUENTE_BOTON_HEADER);
        padre = cuerpo;
        header = h;
        this.setLayout(Constantes.LAYOUT_CENTRADO);
        this.getNombre().setForeground(Constantes.COLOR_PRINCIPAL);
    }
    @Override
    public void mouseClick(MouseEvent evt){
        header.limpiarSelección();
        selección = true;
        this.setBackground(Constantes.COLOR_SELECCIÓN);
        switch(this.getTextoNombre()){
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
    
    @Override
    public void mouseEntra(MouseEvent evt, Color c) {                                   
        super.mouseEntra(evt, Constantes.COLOR_SECUNDARIO);
    }                                  
    @Override
    public void mouseSale(MouseEvent evt, Color c) {                                  
        super.mouseSale(evt, c);
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
    /*
    */
}

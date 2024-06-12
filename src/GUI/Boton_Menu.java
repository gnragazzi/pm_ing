/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import GUI.Contenedor_MenuPrincipal;

/**
 *
 * @author gera
 */
public class Boton_Menu extends Boton {


    public Boton_Menu(String texto, JLabel icono){
        super(texto, Constantes.getFUENTE_BOTON_LATERAL(),icono);
        this.getNombre().setBorder(new EmptyBorder(10, 10, 10, 10));

        this.getNombre().setForeground(Constantes.getCOLOR_MENU_Fuente());
        /*this.setMaximumSize(new Dimension(Ventana.getTamaño(Ventana.TAM.ANCHO_MAX.ordinal())/4, Constantes.getALT()));
        this.setMinimumSize(new Dimension(Ventana.getTamaño(Ventana.TAM.ANCHO_MIN.ordinal())/4, Constantes.getALT()));*/
        this.setPreferredSize(new Dimension(80, Constantes.getALT()));
    };
    @Override
    public void mouseClick(MouseEvent evt){
        Panel_Principal n = (Panel_Principal) this.getParent().getParent();
        n.cambiarPanel(this.getNombre().getText());
    }
    
    
    @Override
    public Color getCol(){
        return Constantes.getCOLOR_MENU();
    }
    @Override
    public Color getHighlight(){
        return Constantes.getCOLOR_MENU_HIGHLIGHT();
    }
    
}

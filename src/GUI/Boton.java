/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
/**
 *
 * @author gera
 */
public class Boton extends JPanel{
    protected final JLabel nombre;
    protected final String texto_nombre;
    private final BoxLayout layout = new BoxLayout(this, BoxLayout.LINE_AXIS);
    private static final Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    protected boolean selección = false;
    
    public Boton(String n, Font f){
        texto_nombre = n;
        this.nombre = new JLabel("<html><div style='text-align: center;'>" + texto_nombre + "</div></html>",SwingConstants.CENTER);
        
        nombre.setFont(f);
        this.setCursor(cursor);
        this.setBackground(null);
        this.add(nombre);
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                mouseEntra(evt, getHighlight());
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                mouseSale(evt, getCol());
            }
            @Override
            public void mouseClicked(MouseEvent evt){
                mouseClick(evt);
            }
        });
        
        this.setLayout(layout);
    }
    
    public String getTextoNombre()
    {
        return texto_nombre;
    }
    
    public void mouseEntra(MouseEvent evt, Color c) {  
        if(!selección)
            this.setBackground(c);
    }                                  

    public void mouseSale(MouseEvent evt, Color c) {                                  
        if(!selección)
            this.setBackground(c);
    }    
    public void mouseClick(MouseEvent evt){};
    /*
    */
    public Color getCol(){
        return null;
    }
    public Color getHighlight(){
        return null;
    }
    public void setSeleccion(boolean b){
        selección = b;
    }
}
    


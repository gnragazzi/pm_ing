/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author gera
 */
public class Boton extends JPanel{
    private final JLabel nombre;
    static private Ventana ventana;
    //static private Cuerpo cuerpo;
    private final BoxLayout layout = new BoxLayout(this, BoxLayout.LINE_AXIS);
    private static Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    
    //Constructor sin ícono
    public Boton(String n, Font f){
        this.nombre = new JLabel();
        nombre.setText(n);
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
        
        // LAYOUT********************
        this.setLayout(layout);
    }
    public Boton(String n, Font f, JLabel i){
        this.nombre = new JLabel();
        
        nombre.setText(n);
        nombre.setFont(f);
        this.setCursor(cursor);
        this.setBackground(null);
        this.add(Box.createRigidArea(Constantes.getAREA_RIGIDA_PEQUEÑA()));
        this.add(i);
        this.add(Box.createRigidArea(Constantes.getAREA_RIGIDA_PEQUEÑA()));
        
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
    public JLabel getNombre(){
        return this.nombre;
    }
    
    public void mouseEntra(MouseEvent evt, Color c) {                                   
        this.setBackground(c);
    }                                  

    public void mouseSale(MouseEvent evt, Color c) {                                  
        this.setBackground(c);
    }    
    public void mouseClick(MouseEvent evt){};
    public Color getCol(){
        return null;
    }
    public Color getHighlight(){
        return null;
    }
    
    static public void setVentana(Ventana v)
    {
        Boton.ventana = v;
    }

    public static Ventana getVentana() {
        return ventana;
    }
    /*
    public static Cuerpo getCuerpo() {
        return cuerpo;
    }
    */
    
}
    


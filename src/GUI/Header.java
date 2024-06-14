/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author gera
 */
public class Header extends JPanel{ 
    private JLabel titulo = new JLabel();
    private final JPanel div = new JPanel();
    private final JPanel botonera = new JPanel();
    private final JLabel info = new JLabel("Seleccione Operación: ");
    private final Boton_Header botones[] = new Boton_Header[4];
    
    public Header(String t, JPanel cuerpo){
        this.titulo.setText(t);
        this.setBorder(new EmptyBorder(20, 20, 0, 20));
        titulo.setFont(Constantes.getFUENTE_HEADER());
        titulo.setForeground(Constantes.getCOLOR_MENU());
        this.setLayout(new GridLayout(1, 2));
        this.add(titulo);
        this.setBackground(Constantes.getCOLOR_Header());
        
        info.setForeground(Constantes.getCOLOR_MENU());
        info.setVerticalAlignment(JLabel.BOTTOM);
        botones[0] = new Boton_Header("Cargar",cuerpo);
        botones[1] = new Boton_Header("Eliminar",cuerpo);
        botones[2] = new Boton_Header("Modificar",cuerpo);
        botones[3] = new Boton_Header("Consultar",cuerpo);
        this.configurarDiv();
        this.add(div);
        
    }
    private void configurarDiv()
    {
        
        div.setLayout(new GridLayout(2, 1));
        div.setBackground(null);
        this.botonera.setLayout(new GridLayout(1,botones.length));
        for (var botone : botones) {
            this.botonera.add(botone);
            botone.getNombre().setHorizontalAlignment(JLabel.CENTER);
        }
        div.add(info);
        info.setFont(Constantes.getFUENTE_INFO());
        botonera.setBackground(null);
        div.add(botonera);
    }
}

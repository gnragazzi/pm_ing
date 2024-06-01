/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 *
 * @author gera
 */
public class Contenedor_MenuPrincipal extends JPanel{
    private JPanel actual;
    public Contenedor_MenuPrincipal(){
        this.setBackground(Color.blue);
        actual = new Formulario("Agregar Máquina");
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(actual);
    }
}

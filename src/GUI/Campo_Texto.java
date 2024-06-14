/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import GUI.Constantes;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author gera
 */

public class Campo_Texto extends JPanel{

    private JLabel Nombre = new JLabel();
    private JPanel input_panel = new JPanel();
    private JPanel underline = new JPanel();
    private JTextField input = new JTextField();
    private GridLayout layout = new GridLayout(1,4);
    
    public Campo_Texto(String n){
        this.setBackground(null);
        Nombre.setText(n);
        Nombre.setFont(Constantes.getFUENTE_CAMPO());
        Nombre.setForeground(Constantes.COLOR_PRINCIPAL);
        Nombre.setHorizontalAlignment(JLabel.LEFT);
        Nombre.setVerticalAlignment(JLabel.BOTTOM);
        
        
        input.setMinimumSize(new Dimension(20,10));
        input.setPreferredSize(new Dimension(20,10));
        input.setMaximumSize(new Dimension(20,10));
        input.setDocument(new JTextFieldLimit(Constantes.getLIM()));
        input.setFont(Constantes.getFUENTE_CAMPO());
        input.setBorder(null);
        input.setBackground(null);
        input.setForeground(Constantes.COLOR_PRINCIPAL);
        input.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.COLOR_PRINCIPAL));
        
        
        this.add(Nombre);
        Nombre.setBorder(new EmptyBorder(0, 15, 0, 0));

        this.add(input);
        
        this.setLayout(layout);

    }
    
    public void setInput(JTextField t){
        this.input = t;
    }
    public JTextField getInput(){
        return input;
    }
    
    public JLabel getNombre(){
        return this.Nombre;
    }
    public void cambiaInput(JFormattedTextField t){
        this.remove(input);
        t.setMinimumSize(new Dimension(20,20));
        t.setDocument(new JTextFieldLimit(Constantes.getLIM()));
        t.setFont(Constantes.getFUENTE_CAMPO());
        t.setBorder(null);
        t.setBackground(null);
        t.setForeground(Constantes.COLOR_PRINCIPAL);
        t.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.COLOR_PRINCIPAL));
        this.add(t);
        
    }
    public boolean validarCampo(){
        if(this.getInput().getText().equals(""))
        {
            input.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.RED));
            return false;
        }
        else
        {
            input.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.COLOR_PRINCIPAL));
            return true;
        }
    }
    public void limpiarCampo()
    {
        input.setText("");
        input.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.COLOR_PRINCIPAL));
    }
    
}

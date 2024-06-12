/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Connection.BD;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;
import pm_ingsw1.Estado;
import pm_ingsw1.Maquina;
import pm_ingsw1.Planta;
import pm_ingsw1.Registro;
import pm_ingsw1.Tecnico;

/**
 *
 * @author gera
 */
public class Formulario_cargar_máquina extends JPanel{
    private JPanel titulo;
    private JPanel cuerpo;
    private Campo marca;
    private Campo modelo;
    private Campo_Num id;
    private Campo estado;
    private ArrayList<Planta> plantas_Cargadas;
    private Campo_combo_box plantas_combo;
    
    public Formulario_cargar_máquina(String t){
        titulo=new JPanel();
        titulo.setBackground(Color.ORANGE);
        titulo.setMaximumSize(new Dimension(6000,4000));
        titulo.setMinimumSize(new Dimension(600,20));
        titulo.setPreferredSize(new Dimension(600,40));
        JLabel text = new JLabel(t);
        titulo.add(text);
        this.add(titulo);
        
        
        cuerpo = new JPanel();
        //cuerpo.setBackground(Color.blue);

        //marca de la máquina, 
        marca = new Campo("Marca");
        cuerpo.add(marca);
        
        //el modelo del mismo, 
        modelo = new Campo("Modelo");
        cuerpo.add(modelo);
        
        //su número de identificación y 
        id = new Campo_Num("Número de Identificación");
        cuerpo.add(id);
        
        //el estado en que se encuentra. (E-2)        
        estado = new Campo("Estado");
        cuerpo.add(estado);

        // Asignar planta
        plantas_combo = new Campo_combo_box("Plantas");
        try {
            plantas_Cargadas = BD.listarPlanta();
        } catch (SQLException ex) {
            Logger.getLogger(Formulario_cargar_técnico.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i = 0; i < plantas_Cargadas.size(); i++){
            Planta p = plantas_Cargadas.get(i);
            String st = "id: "+ i +" color: " + p.getColor() + " superficie: " + p.getSuperficie() ;
            plantas_combo.getInput().addItem(st);
            //System.out.println("id: "+ i +" color: " + p.getColor() + " superficie: " + p.getSuperficie() );
        }
        cuerpo.add(plantas_combo);
        //div_botones
        
        JPanel div_botones = new JPanel();
        Boton_Formulario_Agregar boton = new Boton_Formulario_Agregar("Confirmar", this);
        Boton_Formulario_Limpiar b_limp = new Boton_Formulario_Limpiar("Cancelar", this);
        div_botones.add(boton);
        div_botones.add(b_limp);
        cuerpo.add(div_botones);
        
        
        cuerpo.setLayout(new BoxLayout(cuerpo,BoxLayout.PAGE_AXIS));
        this.add(cuerpo);
        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
    }
    
    public void enviarMaquina(){
        Planta p = plantas_Cargadas.get(plantas_combo.getInput().getSelectedIndex());
        Maquina m = new Maquina(Integer.parseInt(id.getNum().getText()), marca.getInput().getText(), modelo.getInput().getText(), p, null, Estado.ACTIVO);
        try {
            BD.cargarMaquina(m);
        } catch (SQLException ex) {
            Logger.getLogger(Formulario_cargar_máquina.class.getName()).log(Level.SEVERE, null, ex);
        }
    };
}
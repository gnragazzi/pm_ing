/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Connection.BD;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pm_ingsw1.Estado;
import pm_ingsw1.Maquina;
import pm_ingsw1.Planta;

/**
 *
 * @author gera
 */
public class Formulario_cargar_máquina extends Formulario{
    private JPanel titulo;
    private JPanel cuerpo;
    private Campo marca;
    private Campo modelo;
    private Campo_Num id;
    private ArrayList<Planta> plantas_Cargadas;
    private ArrayList<Maquina> maquinas;
    private Campo_combo_box estado;
    private Campo_combo_box plantas_combo;
    private JDialog confirmación;
    
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
        estado = new Campo_combo_box("Estado");
        estado.getInput().addItem("Activo");
        estado.getInput().addItem("En Reparación");
        estado.getInput().setSelectedIndex(-1);
        cuerpo.add(estado);

        // Asignar planta
        plantas_combo = new Campo_combo_box("Plantas");
        cargarDesdeBd();
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
    
    @Override
    public void enviar(){
        Planta p = plantas_Cargadas.get(plantas_combo.getInput().getSelectedIndex());
        Contenedor_MenuPrincipal c = ((Contenedor_MenuPrincipal)this.getParent());
        Maquina m = new Maquina(Integer.parseInt(id.getNum().getText()), marca.getInput().getText(), modelo.getInput().getText(), p, null, estado.getInput().getSelectedIndex() == 0 ? Estado.ACTIVO : Estado.REPARACION);
        try {
            BD.cargarMaquina(m);
            c.setPantallaCargaExitosa("Se cargo con Éxito la Máquina.");
            limpiarCampos();
        } catch (SQLException ex) {
            c.setPantallaCargaExitosa("ERROR DE BD: " + ex.getMessage());
        }
    };
    
    @Override
    public boolean esValido(){
        this.marca.getInput().setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.getCOLOR_MENU()));
        this.modelo.getInput().setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.getCOLOR_MENU()));
        this.id.getNum().setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.getCOLOR_MENU()));
        this.estado.getInput().setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.getCOLOR_MENU()));
        this.plantas_combo.getInput().setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.getCOLOR_MENU()));
        boolean ret = true;
        if(!marca.validarCampo())
        {
            ret = false;
            marca.getInput().setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.RED));
        }
        if(!modelo.validarCampo())
        {
            ret = false;
            modelo.getInput().setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.RED));
        }
        if(!id.validarCampo())
        {
            ret = false;
            id.getNum().setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.RED));
        }
        else if(!maquinas.isEmpty())
        {
            for(int i = 0; i < maquinas.size();i++)
            {
                if (maquinas.get(i).getNroID() == Integer.parseInt(id.getNum().getText()))
                {
                    id.getNum().setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.RED));
                    ret = false;
                    break;
                }
            }
        }
        if(!estado.validarCampo())
        {
            ret = false;
            estado.getInput().setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.RED));
        }
        if(!plantas_combo.validarCampo())
        {
            ret = false;
            plantas_combo.getInput().setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.RED));
        }
        return  ret;
    }
    @Override
    public void limpiarCampos(){
        this.marca.getInput().setText("");
        this.modelo.getInput().setText("");
        this.id.getNum().setText("");
        this.estado.getInput().setSelectedIndex(-1);
        this.plantas_combo.getInput().setSelectedIndex(-1);
        this.marca.getInput().setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.getCOLOR_MENU()));
        this.modelo.getInput().setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.getCOLOR_MENU()));
        this.id.getNum().setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.getCOLOR_MENU()));
        this.estado.getInput().setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.getCOLOR_MENU()));
        this.plantas_combo.getInput().setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.getCOLOR_MENU()));
    }
    public void cargarDesdeBd(){
        plantas_combo.getInput().removeAllItems();
        Contenedor_MenuPrincipal c = ((Contenedor_MenuPrincipal)this.getParent());
        try {
            plantas_Cargadas = BD.listarPlanta();
        } catch (SQLException ex) {
            c.setPantallaCargaExitosa("ERROR DE BD: " + ex.getMessage());
        }
        for(int i = 0; i < plantas_Cargadas.size(); i++){
            Planta p = plantas_Cargadas.get(i);
            String st = "id: "+ i +" color: " + p.getColor() + " superficie: " + p.getSuperficie() ;
            plantas_combo.getInput().addItem(st);
        }
        plantas_combo.getInput().setSelectedIndex(-1);
        //Cargar Máquinas
        try {
            maquinas = BD.listarMaquina();
        } catch (SQLException ex) {
            c.setPantallaCargaExitosa("ERROR DE BD: " + ex.getMessage());
        }
    }
}
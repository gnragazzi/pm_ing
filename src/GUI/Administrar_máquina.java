/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Connection.BD;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import pm_ingsw1.Estado;
import pm_ingsw1.Maquina;
import pm_ingsw1.Planta;

/**
 *
 * @author gera
 */
public class Administrar_máquina extends Administrar{
    private Campo_Texto marca;
    private Campo_Texto modelo;
    private Campo_Num id;
    private ArrayList<Planta> plantas_Cargadas;
    private ArrayList<Maquina> maquinas;
    private Campo_combo_box estado;
    private Campo_combo_box plantas_combo;
    private JDialog confirmación;
    
    public Administrar_máquina(String t){
        super(t);
        
        //construcción del formulario
        //marca de la máquina, 
        marca = new Campo_Texto("Marca");
        pestaña_cargar.add(marca);
        
        //el modelo del mismo, 
        modelo = new Campo_Texto("Modelo");
        pestaña_cargar.add(modelo);
        
        //su número de identificación y 
        id = new Campo_Num("Número de Identificación");
        pestaña_cargar.add(id);
        
        //el estado en que se encuentra. (E-2)        
        estado = new Campo_combo_box("Estado");
        estado.getInput().addItem("Activo");
        estado.getInput().addItem("En Reparación");
        estado.getInput().setSelectedIndex(-1);
        pestaña_cargar.add(estado);

        // Asignar planta
        plantas_combo = new Campo_combo_box("Plantas");
        cargarDesdeBd();
        pestaña_cargar.add(plantas_combo);
        //div_botones
        
        JPanel div_botones = new JPanel();
        Boton_Formulario_Confirmar boton = new Boton_Formulario_Confirmar("Confirmar", this);
        Boton_Formulario_Cancelar b_limp = new Boton_Formulario_Cancelar("Cancelar", this);
        div_botones.add(boton);
        div_botones.add(b_limp);
        
        pestaña_cargar.add(div_botones);
        pestaña_cargar.setLayout(new BoxLayout(pestaña_cargar,BoxLayout.PAGE_AXIS));
    }
    
    @Override
    public void enviar(){
        Planta p = plantas_Cargadas.get(plantas_combo.getInput().getSelectedIndex());
        Contenedor_MenuPrincipal c = ((Contenedor_MenuPrincipal)this.getParent());
        Maquina m = new Maquina(Integer.parseInt(id.getInput().getText()), marca.getInput().getText(), modelo.getInput().getText(), p, null, estado.getInput().getSelectedIndex() == 0 ? Estado.ACTIVO : Estado.REPARACION);
        try {
            BD.cargarMaquina(m);
            setPantallaCargaExitosa("Se cargo con Éxito la Máquina.");
        } catch (SQLException ex) {
            setPantallaCargaExitosa("ERROR DE BD: " + ex.getMessage());
        }
    };
    
    @Override
    public boolean esValido(){
        boolean ret = true;
        if(!marca.validarCampo())
            ret = false;
        if(!modelo.validarCampo())
            ret = false;
        if(!id.validarCampo())
            ret = false;
        else if(!maquinas.isEmpty())
        {
            for(int i = 0; i < maquinas.size();i++)
            {
                if (maquinas.get(i).getNroID() == Integer.parseInt(id.getInput().getText()))
                {
                    id.getInput().setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.RED));
                    ret = false;
                    break;
                }
            }
        }
        if(!estado.validarCampo())
            ret = false;
        if(!plantas_combo.validarCampo())
            ret = false;
        return  ret;
    }
    @Override
    public void limpiarCampos(){
        super.limpiarCampos();
        id.limpiarCampo();
        marca.limpiarCampo();
        modelo.limpiarCampo();
        estado.limpiarCampo();
        plantas_combo.limpiarCampo();
    }
    public void cargarDesdeBd(){
        plantas_combo.getInput().removeAllItems();
        Contenedor_MenuPrincipal c = ((Contenedor_MenuPrincipal)this.getParent());
        try {
            plantas_Cargadas = BD.listarPlanta();
        } catch (SQLException ex) {
            setPantallaCargaExitosa("ERROR DE BD: " + ex.getMessage());
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
            setPantallaCargaExitosa("ERROR DE BD: " + ex.getMessage());
        }
    }
}
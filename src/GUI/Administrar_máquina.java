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
import javax.swing.JPanel;
import pm_ingsw1.Estado;
import pm_ingsw1.Maquina;
import pm_ingsw1.Planta;

/**
 *
 * @author gera
 */
public class Administrar_máquina extends Administrar{
    private final Campo_Texto marca;
    private final Campo_Texto modelo;
    private final Campo_Num id;
    private ArrayList<Planta> plantas_Cargadas;
    private ArrayList<Maquina> maquinas;
    private final Campo_combo_box estado;
    private final Campo_combo_box plantas_combo;
    
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
        estado.getComboInput().addItem("Activo");
        estado.getComboInput().addItem("En Reparación");
        estado.getComboInput().setSelectedIndex(-1);
        pestaña_cargar.add(estado);

        // Asignar planta
        plantas_combo = new Campo_combo_box("Plantas");
        cargarDesdeBd();
        pestaña_cargar.add(plantas_combo);
        //div_botones
        
        JPanel div_botones = new JPanel();
        Boton_Maq boton = new Boton_Maq(Constantes.CONFIRMAR, this);
        Boton_Maq b_limp = new Boton_Maq(Constantes.CANCELAR, this);
        div_botones.add(boton);
        div_botones.add(b_limp);
        pestaña_cargar.add(div_botones);
        pestaña_cargar.setLayout(new BoxLayout(pestaña_cargar,BoxLayout.PAGE_AXIS));
    }
    
    @Override
    public void enviar(){
        Planta p = plantas_Cargadas.get(plantas_combo.getComboInput().getSelectedIndex());
        Contenedor_MenuPrincipal c = ((Contenedor_MenuPrincipal)this.getParent());
        Maquina m = new Maquina(Integer.parseInt(id.getInput().getText()), marca.getInput().getText(), modelo.getInput().getText(), p, null, estado.getComboInput().getSelectedIndex() == 0 ? Estado.ACTIVO : Estado.REPARACION);
        try {
            BD.cargarMaquina(m);
            setPantalla("Se cargo con Éxito la Máquina.");
        } catch (SQLException ex) {
            setPantalla("ERROR DE BD: " + ex.getMessage());
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
                    id.getInput().setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.COLOR_ERROR));
                    id.setMsjValidacion("Ya hay una máquina con este número de identificación.");
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
    @Override
    public void cargarDesdeBd(){
        plantas_combo.getComboInput().removeAllItems();
        Contenedor_MenuPrincipal c = ((Contenedor_MenuPrincipal)this.getParent());
        try {
            plantas_Cargadas = BD.listarPlanta();
        } catch (SQLException ex) {
            setPantalla("ERROR DE BD: " + ex.getMessage());
        }
        if(plantas_Cargadas.isEmpty())
        {
            c.error("ERROR No hay Plantas Cargadas.");
        }
        else
        {
            for(int i = 0; i < plantas_Cargadas.size(); i++){
                Planta p = plantas_Cargadas.get(i);
                String st = "id: "+ i +" color: " + p.getColor() + " superficie: " + p.getSuperficie() ;
                plantas_combo.getComboInput().addItem(st);
            }
            plantas_combo.getComboInput().setSelectedIndex(-1);
            //Cargar Máquinas
            try {
                maquinas = BD.listarMaquina();

            } catch (SQLException ex) {
                setPantalla("ERROR DE BD: " + ex.getMessage());
            }
        }
    }
}
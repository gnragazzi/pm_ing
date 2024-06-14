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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pm_ingsw1.Planta;
import pm_ingsw1.Tecnico;

/**
 *
 * @author gera
 */
public class Formulario_cargar_técnico extends Formulario{
    private JPanel titulo;
    private JPanel cuerpo;
    private Campo_Texto nombre;
    private Campo_Texto apellido;
    private Campo_Num dni;
    private Campo_fecha fecha_nac;
    private Campo_Num contacto;
    private ArrayList<Tecnico> tecnicos;
    
    public Formulario_cargar_técnico(String t){
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

        //nombre del técnico, 
        nombre = new Campo_Texto("Nombre");
        cuerpo.add(nombre);
        
        //Apellido
        apellido = new Campo_Texto("Apellido");
        cuerpo.add(apellido);
        
        //dni
        dni = new Campo_Num("DNI");
        cuerpo.add(dni);
        
        //fecha nac
        fecha_nac = new Campo_fecha("Fecha de Nacimiento",2006,1954,-1);
        cuerpo.add(fecha_nac);
        
        //contacto
        contacto = new Campo_Num("Contacto");
        cuerpo.add(contacto);

        //div_botones
        
        JPanel div_botones = new JPanel();
        Boton_Formulario_Agregar_ct boton = new Boton_Formulario_Agregar_ct("Confirmar", this);
        Boton_Formulario_Limpiar_ct b_limp = new Boton_Formulario_Limpiar_ct("Cancelar", this);
        div_botones.add(boton);
        div_botones.add(b_limp);
        cuerpo.add(div_botones);
        
        
        cuerpo.setLayout(new BoxLayout(cuerpo,BoxLayout.PAGE_AXIS));
        this.add(cuerpo);
        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
    }
    
    public void limpiarCampos(){
        this.nombre.limpiarCampo();
        this.apellido.limpiarCampo();
        this.dni.limpiarCampo();
        this.contacto.limpiarCampo();
        this.fecha_nac.limpiarCampo();
    }
        
    public boolean esValido(){
        boolean ret = true;
        if(!nombre.validarCampo())
            ret = false;
        if(!apellido.validarCampo())
            ret = false;
        if(!dni.validarCampo())
            ret = false;
        else if(!tecnicos.isEmpty())
        {
            for(int i = 0; i < tecnicos.size();i++)
            {
                if (tecnicos.get(i).getDni()== Integer.parseInt(dni.getInput().getText()))
                {
                    dni.getInput().setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.RED));
                    ret = false;
                    break;
                }
            }
        }
        if(!fecha_nac.validarCampo())
            ret = false;
        if(!contacto.validarCampo())
            ret = false;
        return  ret;
    };
    public void enviar(){
        Tecnico t = new Tecnico(nombre.getInput().getText(),apellido.getInput().getText(),Integer.parseInt(dni.getInput().getText()),fecha_nac.toString(),contacto.getInput().getText(),null);
        Contenedor_MenuPrincipal p = (Contenedor_MenuPrincipal) this.getParent();
        p.continuar_carga_Tecnico(t);  
    };
    
    public void cargarDesdeBd(){
        Contenedor_MenuPrincipal c = ((Contenedor_MenuPrincipal)this.getParent());
        try {
            tecnicos = BD.listarTecnico();
        } catch (SQLException ex) {
            c.setPantallaCargaExitosa("ERROR DE BD: " + ex.getMessage());
        }
    }

}



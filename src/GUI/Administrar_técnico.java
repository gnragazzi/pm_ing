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
import pm_ingsw1.Tecnico;

/**
 *
 * @author gera
 */
public class Administrar_técnico extends Administrar{
    private final Campo_Texto nombre;
    private final Campo_Texto apellido;
    private final Campo_Num dni;
    private final Campo_fecha fecha_nac;
    private final Campo_Num contacto;
    private ArrayList<Tecnico> tecnicos;
    
    public Administrar_técnico(String t){
        super(t);
        nombre = new Campo_Texto("Nombre");
        pestaña_cargar.add(nombre);
        //Apellido
        apellido = new Campo_Texto("Apellido");
        pestaña_cargar.add(apellido);
        
        //dni
        dni = new Campo_Num("DNI");
        pestaña_cargar.add(dni);
        
        //fecha nac
        fecha_nac = new Campo_fecha("Fecha de Nacimiento(d/m/a)",2006,1954,-1);
        pestaña_cargar.add(fecha_nac);
        
        //contacto
        contacto = new Campo_Num("Contacto");
        pestaña_cargar.add(contacto);

        //div_botones
        
        JPanel div_botones = new JPanel();
        Boton_Formulario_Agregar_ct boton = new Boton_Formulario_Agregar_ct("Confirmar", this);
        Boton_Formulario_Cancelar_ct b_limp = new Boton_Formulario_Cancelar_ct("Cancelar", this);
        div_botones.add(boton);
        div_botones.add(b_limp);
        pestaña_cargar.add(div_botones);
        pestaña_cargar.setLayout(new BoxLayout(pestaña_cargar,BoxLayout.PAGE_AXIS));
    }
    
    @Override
    public void limpiarCampos(){
        super.limpiarCampos();
        this.nombre.limpiarCampo();
        this.apellido.limpiarCampo();
        this.dni.limpiarCampo();
        this.contacto.limpiarCampo();
        this.fecha_nac.limpiarCampo();
    }
        
    @Override
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
    @Override
    public void enviar(){
        Tecnico t = new Tecnico(nombre.getInput().getText(),apellido.getInput().getText(),Integer.parseInt(dni.getInput().getText()),fecha_nac.toString(),contacto.getInput().getText(),null);
        Contenedor_MenuPrincipal p = (Contenedor_MenuPrincipal) this.getParent();
        p.continuar_carga_Tecnico(t);  
    };
    
    @Override
    public void cargarDesdeBd(){
        try {
            tecnicos = BD.listarTecnico();
        } catch (SQLException ex) {
            setPantalla("ERROR DE BD: " + ex.getMessage());
        }
    }

}



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Connection.BD;
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
        contenedor_campos.add(nombre);
        //Apellido
        apellido = new Campo_Texto("Apellido");
        contenedor_campos.add(apellido);
        
        //dni
        dni = new Campo_Num("DNI");
        contenedor_campos.add(dni);
        
        //fecha nac
        fecha_nac = new Campo_fecha("Fecha de Nacimiento(d/m/a)",2006,1954,-1);
        contenedor_campos.add(fecha_nac);
        
        //contacto
        contacto = new Campo_Num("Contacto");
        contenedor_campos.add(contacto);

        //div_botones
        
        JPanel div_botones = new JPanel();
        Boton_Tec boton = new Boton_Tec("Confirmar", this);
        Boton_Tec b_limp = new Boton_Tec("Cancelar", this);
        div_botones.add(boton);
        div_botones.add(b_limp);
        
        pestaña_cargar.setLayout(new BoxLayout(pestaña_cargar,BoxLayout.PAGE_AXIS));
        pestaña_cargar.add(contenedor_campos);
        pestaña_cargar.add(div_botones);
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
                    dni.getInput().setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.COLOR_ERROR));
                    dni.setMsjValidacion("Ya hay un técnico con este DNI.");
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



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Connection.BD;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pm_ingsw1.Maquina;
import pm_ingsw1.Registro;
import pm_ingsw1.Tecnico;
import pm_ingsw1.Turno;

/**
 *
 * @author gera
 */
public class Administrar_registro extends Administrar{
    private JPanel titulo;
    private JPanel subpestaña_listar;
    private JPanel lista_tec;
    private JPanel lista_maq;
    private ArrayList<Tecnico> tecnicos;
    private ArrayList<Maquina> maquinas;
    private int tecnico_seleccionado = -1;
    private int maquina_seleccionada = -1;
    private short pestaña = 0;
    private Campo_fecha fecha_inicio;
    private Campo_fecha fecha_fin;
    private Campo_combo_box turno;
    private String indicaciones[] = {"Seleccione un Técnico de la Lista", "Seleccione una Máquina de la Lista", "Para terminar, rellene el formulario"};
    private boolean cargarTecnico_flag = false;
    private JPanel contenedor_maq;
    private JPanel contenedor_tec;
    
    public Administrar_registro(String t) {
        super(t);
        titulo=new JPanel();
        titulo.setBackground(Color.ORANGE);
        titulo.setMaximumSize(new Dimension(6000,4000));
        titulo.setMinimumSize(new Dimension(600,20));
        titulo.setPreferredSize(new Dimension(600,40));
        JLabel text = new JLabel(indicaciones[0]);
        titulo.add(text);
        
        subpestaña_listar = new JPanel();
        subpestaña_listar.setLayout(new CardLayout());
        
        /************************************************/
        /************************************************/
        //              LISTA_TEC
        /************************************************/
        /************************************************/
       
        lista_tec = new JPanel();
        lista_tec.setLayout(new BoxLayout(lista_tec,BoxLayout.PAGE_AXIS));
        contenedor_tec = new JPanel();
        contenedor_tec.setLayout(new BoxLayout(contenedor_tec,BoxLayout.PAGE_AXIS));
        
        lista_tec.add(contenedor_tec);
        
        JPanel div_botones = new JPanel();
        Boton_Asignar_siguiente boton = new Boton_Asignar_siguiente("Siguiente",this);
        div_botones.add(boton);
        lista_tec.add(div_botones);

        /************************************************/
        /************************************************/
        //              LISTA_MAQ
        /************************************************/
        /************************************************/

        lista_maq = new JPanel();
        lista_maq.setLayout(new BoxLayout(lista_maq,BoxLayout.PAGE_AXIS));
        contenedor_maq = new JPanel();
        contenedor_maq.setLayout(new BoxLayout(contenedor_maq,BoxLayout.PAGE_AXIS));

        lista_maq.add(contenedor_maq);
        JPanel div_botones_maq = new JPanel();
        Boton_Asignar_siguiente boton_maq = new Boton_Asignar_siguiente("Siguiente",this);
        Boton_Asignar_volver boton_volver_maq = new Boton_Asignar_volver("Volver",this);
        div_botones_maq.add(boton_volver_maq);
        div_botones_maq.add(boton_maq);
        lista_maq.add(div_botones_maq);
        
        /************************************************/
        /************************************************/
        //              FORMULARIO
        /************************************************/
        /************************************************/
        
        JPanel formulario = new JPanel();
        fecha_inicio = new Campo_fecha("Fecha Inicio",2034,2024,1);
        fecha_fin = new Campo_fecha("Fecha Finalización",2034,2024,1);
        turno = new Campo_combo_box("Turno");
        turno.getInput().addItem(Turno.MAÑANA);
        turno.getInput().addItem(Turno.TARDE);
        turno.getInput().addItem(Turno.NOCHE);
        turno.getInput().setSelectedIndex(-1);
        
        formulario.add(fecha_inicio);
        formulario.add(fecha_fin);
        formulario.add(turno);
        formulario.setLayout(new BoxLayout(formulario,BoxLayout.PAGE_AXIS));
        JPanel div_botones_form = new JPanel();
        Boton_Formulario_Agregar_ar boton_form = new Boton_Formulario_Agregar_ar("Confirmar", this);
        Boton_Asignar_volver boton_volver_form = new Boton_Asignar_volver("Volver",this);
        div_botones_form.add(boton_volver_form);
        div_botones_form.add(boton_form);
        formulario.add(div_botones_form);
        
    
    
        /************************************************/
        /************************************************/
        //              Carga Exitosa
        /************************************************/
        /************************************************/    
        
        subpestaña_listar.add(lista_tec,"0");
        subpestaña_listar.add(lista_maq,"1");
        subpestaña_listar.add(formulario,"2");
        
        pestaña_cargar.add(titulo);
        pestaña_cargar.add(subpestaña_listar);
        pestaña_cargar.setLayout(new BoxLayout(pestaña_cargar,BoxLayout.PAGE_AXIS));

        
    }
    public void asignar_seleccion(Fila f){
        if(pestaña == 0)
        {
            for(int i = 1; i <= tecnicos.size();i++)
            {
                Fila temp= (Fila)contenedor_tec.getComponent(i);
                temp.setSelected(false);
                temp.setBackground(null);
            }
            tecnico_seleccionado = f.getIndice();
        }
        else if(pestaña == 1)
        {
            for(int i = 1; i <= maquinas.size();i++)
            {
                Fila temp= (Fila)contenedor_maq.getComponent(i);
                temp.setSelected(false);
                temp.setBackground(null);
            }
            maquina_seleccionada = f.getIndice();
        }
    }
    public void desasignar_seleccion(){
        if(pestaña == 0)
            tecnico_seleccionado = -1;
        else 
            maquina_seleccionada = -1;
    }
    public void cambiarListado(int direccion)
    {
        CardLayout cl = (CardLayout)(this.subpestaña_listar.getLayout());
        JLabel t = (JLabel)titulo.getComponent(0);
        if(direccion == 1)
        {
            if(pestaña == 0 && tecnico_seleccionado >= 0)
            {
                cl.show(this.subpestaña_listar, String.valueOf(++pestaña));
            }
            else if(pestaña == 1 && maquina_seleccionada >= 0)
            {
                cl.show(this.subpestaña_listar, String.valueOf(++pestaña));
            }
        }
        else
        {
            if(pestaña == 1 && cargarTecnico_flag)
            {
                Contenedor_MenuPrincipal p = (Contenedor_MenuPrincipal) this.getParent();
                this.pestaña = 0;
                t.setText(indicaciones[pestaña]);
                cl.show(subpestaña_listar, "0");
                p.cambiar_actual("Agregar Técnico",true);
                this.cargarTecnico_flag = false;
            }
            else if (pestaña == 1)
            {
                cl.show(this.subpestaña_listar, String.valueOf(--pestaña));
            }
            else if(pestaña == 2 )
            {
                cl.show(this.subpestaña_listar, String.valueOf(--pestaña));
            }
        }
        t.setText(this.indicaciones[pestaña]);
        
    }

    public void continuarCambiarTecnico(Tecnico e)
    {
        cargarTecnico_flag = true;
        layout_cuerpo.show(cuerpo, "Cargar");
        pestaña = 1;
        CardLayout cl = (CardLayout)(this.subpestaña_listar.getLayout());
        cl.show(this.subpestaña_listar, "1");
        JLabel t = (JLabel)titulo.getComponent(0);
        t.setText(this.indicaciones[pestaña]);
        tecnicos = new ArrayList<Tecnico>();
        tecnicos.add(e);
        tecnico_seleccionado = 0;
    }
    public void limpiarCampos(){
        super.limpiarCampos();
        pestaña = 0;
        CardLayout cl = (CardLayout)(this.subpestaña_listar.getLayout());
        cl.show(this.subpestaña_listar, String.valueOf(pestaña));
        this.cargarTecnico_flag = false;
        ((JLabel)titulo.getComponent(0)).setText(indicaciones[0]);
        
        tecnico_seleccionado = -1;
        maquina_seleccionada = -1;
        contenedor_maq.removeAll();
        contenedor_tec.removeAll();
        
        turno.limpiarCampo();
        fecha_inicio.limpiarCampo();
        fecha_fin.limpiarCampo();
    };
    @Override
    public boolean esValido(){
        boolean i_v = fecha_inicio.validarCampo();
        boolean f_v = fecha_fin.validarCampo();
        boolean ret = true;
        if(!turno.validarCampo())
            ret = false;
        if(!i_v || !f_v)
            ret = false;
        else if(!fecha_inicio.esAntes(fecha_fin))
        {
            System.out.println("NO es antes");
            fecha_inicio.setBackground(Color.red);
            fecha_fin.setBackground(Color.red);
            ret = false;
        }
        
        return  ret;
    };
    public void enviar(){
        Tecnico t = tecnicos.get(tecnico_seleccionado);
        Maquina m = maquinas.get(maquina_seleccionada);
        Registro r = new Registro(fecha_inicio.toString(),fecha_fin.toString(),m, t,turno.getInput().getSelectedIndex() == 0 ? Turno.MAÑANA : turno.getInput().getSelectedIndex() == 1 ? Turno.TARDE:Turno.NOCHE);
        if(cargarTecnico_flag)
        {
            try {
                BD.cargarTecnico(t);
            } catch (SQLException ex) {
                setPantallaCargaExitosa("ERROR DE BD: " + ex.getMessage());
            }
        }
        BD.asignarRegistro(r);
        setPantallaCargaExitosa("Asignación de Registro Exitosa.");
    };
    
    public void cargarDesdeBd(){
        try {
            tecnicos = BD.listarTecnico();
            
            String c_t[] = {"Nombre","Apellido","DNI","Fecha de Nacimiento", "Contacto"};
            Fila cat_t = new Fila(c_t,true,-1,this);
            contenedor_tec.add(cat_t);
            for(int i = 0; i < tecnicos.size();i++)
            {
                Tecnico temp = tecnicos.get(i);
                String aux[] = {temp.getNombre(),temp.getApellido(),String.valueOf(temp.getDni()),temp.getFec_nac(),String.valueOf(temp.getContacto())};
                Fila f = new Fila(aux,false,i,this);
                contenedor_tec.add(f);
            }
        } catch (SQLException ex) {
            setPantallaCargaExitosa("ERROR DE BD: " + ex.getMessage());
        }
        try {
            maquinas = BD.listarMaquina();
            // Carga las máquinas en el panel
            String c_m[] = {"NroID","Marca","Modelo","Planta", "Estado"};
            Fila cat_m = new Fila(c_m,true,-1,this);
            contenedor_maq.add(cat_m);
            for(int i = 0; i < maquinas.size();i++)
            {
                Maquina temp = maquinas.get(i);
                String aux[] = {String.valueOf(temp.getNroID()),temp.getMarca(),temp.getModelo(),String.valueOf(temp.getEstado())};
                Fila f = new Fila(aux,false,i,this);
                contenedor_maq.add(f);
            }
        } catch (SQLException ex) {
            setPantallaCargaExitosa("ERROR DE BD: " + ex.getMessage());
        }
    };
    public int getPestaña()
    {
        return pestaña;
    }
    public void setFormulario(){
        
    }
    public void setPestaña(){
        
    }
}

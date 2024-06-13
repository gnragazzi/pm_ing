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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
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
public class Formulario_asignar_registro extends Formulario{
    private JPanel titulo;
    private JPanel cuerpo;
    private JPanel lista_tec;
    private JPanel lista_maq;
    private ArrayList<Tecnico> tecnicos;
    private ArrayList<Maquina> maquinas;
    private int tecnico_seleccionado = -1;
    private int maquina_seleccionada = -1;
    private short pestaña = 0;
    private Campo_Texto fecha_inicio;
    private Campo_Texto fecha_fin;
    private Campo_combo_box turno;
    private String indicaciones[] = {"Seleccione un Técnico de la Lista", "Seleccione una Máquina de la Lista", "Para terminar, rellene el formulario"};
    private boolean cargarTecnico_flag = false;
    private JPanel contenedor_maq;
    private JPanel contenedor_tec;
    
    public Formulario_asignar_registro() {
        try {
            tecnicos = BD.listarTecnico();
        } catch (SQLException ex) {
            Logger.getLogger(Formulario_asignar_registro.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            maquinas = BD.listarMaquina();
        } catch (SQLException ex) {
            Logger.getLogger(Formulario_asignar_registro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        this.setBackground(Color.CYAN);
        titulo=new JPanel();
        titulo.setBackground(Color.ORANGE);
        titulo.setMaximumSize(new Dimension(6000,4000));
        titulo.setMinimumSize(new Dimension(600,20));
        titulo.setPreferredSize(new Dimension(600,40));
        JLabel text = new JLabel("Seleccione un Técnico de la lista: ");
        titulo.add(text);
        this.add(titulo);
        
        
        cuerpo = new JPanel();
        cuerpo.setLayout(new CardLayout());
        
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
        Boton_Asignar_siguiente boton = new Boton_Asignar_siguiente("Siguiente");
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
        Boton_Asignar_siguiente boton_maq = new Boton_Asignar_siguiente("Siguiente");
        Boton_Asignar_volver boton_volver_maq = new Boton_Asignar_volver("Volver");
        div_botones_maq.add(boton_volver_maq);
        div_botones_maq.add(boton_maq);
        lista_maq.add(div_botones_maq);
        
        /************************************************/
        /************************************************/
        //              FORMULARIO
        /************************************************/
        /************************************************/
        
        JPanel formulario = new JPanel();
        fecha_inicio = new Campo_Texto("Fecha Inicio");
        fecha_fin = new Campo_Texto("Fecha Finalización");
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
        Boton_Asignar_volver boton_volver_form = new Boton_Asignar_volver("Volver");
        div_botones_form.add(boton_volver_form);
        div_botones_form.add(boton_form);
        formulario.add(div_botones_form);
        
    
    
        /************************************************/
        /************************************************/
        //              Carga Exitosa
        /************************************************/
        /************************************************/    

        Carga_Exitosa pantalla_final = new Carga_Exitosa("El registro se cargo correctamente");
        
        
        cuerpo.add(lista_tec,"0");
        cuerpo.add(lista_maq,"1");
        cuerpo.add(formulario,"2");
        cuerpo.add(pantalla_final,"3");
        
        this.add(cuerpo);
        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
    }
    public void prueba(Fila f){
        if(pestaña == 0)
        {
            for(int i = 1; i <= tecnicos.size();i++)
            {
                Fila temp= (Fila)contenedor_tec.getComponent(i);
                temp.setSelected(false);
                temp.setBackground(Color.white);
            }
            tecnico_seleccionado = f.getIndice();
        }
        else if(pestaña == 1)
        {
            for(int i = 1; i <= maquinas.size();i++)
            {
                Fila temp= (Fila)contenedor_tec.getComponent(i);
                temp.setSelected(false);
                temp.setBackground(Color.white);
            }
            maquina_seleccionada = f.getIndice();
        }
    }
    public void cambiarListado(int direccion)
    {
        //System.out.println("Pestaña: "+pestaña + "maquina seleccionada: " + String.valueOf(maquina_seleccionada));
        CardLayout cl = (CardLayout)(this.cuerpo.getLayout());
        JLabel t = (JLabel)titulo.getComponent(0);
        if(direccion == 1)
        {
            if(pestaña == 0 && tecnico_seleccionado >= 0)
            {
                cl.show(this.cuerpo, String.valueOf(++pestaña));
            }
            else if(pestaña == 1 && maquina_seleccionada >= 0)
            {
                cl.show(this.cuerpo, String.valueOf(++pestaña));
            }
        }
        else
        {
            if(pestaña == 1 && cargarTecnico_flag)
            {
                Contenedor_MenuPrincipal p = (Contenedor_MenuPrincipal) this.getParent();
                this.pestaña = 0;
                t.setText(indicaciones[pestaña]);
                cl.show(cuerpo, "0");
                p.cambiar_actual("Agregar Técnico",true);
                this.cargarTecnico_flag = false;
            }
            else if (pestaña == 1)
            {
                cl.show(this.cuerpo, String.valueOf(--pestaña));
            }
            else if(pestaña == 2 )
            {
                cl.show(this.cuerpo, String.valueOf(--pestaña));
            }
        }
        t.setText(this.indicaciones[pestaña]);
        
    }

    public void continuarCambiarTecnico(Tecnico e)
    {
        cargarTecnico_flag = true;
        pestaña = 1;
        CardLayout cl = (CardLayout)(this.cuerpo.getLayout());
        cl.show(this.cuerpo, "1");
        JLabel t = (JLabel)titulo.getComponent(0);
        t.setText(this.indicaciones[pestaña]);
        tecnicos = new ArrayList<Tecnico>();
        tecnicos.add(e);
        tecnico_seleccionado = 0;
    }
    public void limpiarCampos(){
        pestaña = 0;
        this.turno.getInput().setSelectedIndex(-1);
        CardLayout cl = (CardLayout)(this.cuerpo.getLayout());
        cl.show(this.cuerpo, String.valueOf(pestaña));
        this.cargarTecnico_flag = false;
        tecnico_seleccionado = -1;
        for(int i = 1; i <= tecnicos.size();i++)
        {
            Fila temp= (Fila)contenedor_tec.getComponent(i);
            temp.setSelected(false);
            temp.setBackground(Color.white);
        }
        maquina_seleccionada = -1;
        contenedor_maq.removeAll();
        contenedor_tec.removeAll();
    };
    public boolean esValido(){
        //fecha inicio
        //fecha fin
        this.turno.getInput().setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.getCOLOR_MENU()));
        boolean ret = true;
        
        if(!turno.validarCampo())
        {
            ret = false;
            turno.getInput().setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.RED));
        }
        return  ret;
    };
    public void enviar(){
        Contenedor_MenuPrincipal c = ((Contenedor_MenuPrincipal)this.getParent());
        Tecnico t = tecnicos.get(tecnico_seleccionado);
        Maquina m = maquinas.get(maquina_seleccionada);
        Registro r = new Registro(fecha_inicio.getInput().getText(),fecha_fin.getInput().getText(),m, t,Turno.NOCHE);
        if(cargarTecnico_flag)
        {
            try {
                BD.cargarTecnico(t);
            } catch (SQLException ex) {
                c.setPantallaCargaExitosa("ERROR DE BD: " + ex.getMessage());
            }
        }
        BD.asignarRegistro(r);
        CardLayout cl = (CardLayout)(this.cuerpo.getLayout());
        cl.show(this.cuerpo,"3");
    };
    public void cargarDesdeBd(){
        Contenedor_MenuPrincipal c = ((Contenedor_MenuPrincipal)this.getParent());
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
            c.setPantallaCargaExitosa("ERROR DE BD: " + ex.getMessage());
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
                //String aux[] = {String.valueOf(temp.getNroID()),temp.getMarca(),temp.getModelo(),temp.getPlanta().getColor(),String.valueOf(temp.getEstado())};
                String aux[] = {String.valueOf(temp.getNroID()),temp.getMarca(),temp.getModelo(),String.valueOf(temp.getEstado())};
                Fila f = new Fila(aux,false,i,this);
                contenedor_maq.add(f);
            }
            /*
            System.out.println("Se carga las máquinas");
            for(int i = 0; i < maquinas.size();i++)
            {
                System.out.println(maquinas.get(i).getNroID());
            }
            */
        } catch (SQLException ex) {
            c.setPantallaCargaExitosa("ERROR DE BD: " + ex.getMessage());
        }
    };
}

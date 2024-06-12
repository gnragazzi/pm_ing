/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import pm_ingsw1.Tecnico;

/**
 *
 * @author gera
 */
public class Contenedor_MenuPrincipal extends JPanel{
    //private JPanel actual;
    private Formulario_cargar_máquina c_m = new Formulario_cargar_máquina("Agregar Máquina");
    private Formulario_cargar_técnico c_t = new Formulario_cargar_técnico("Agregar Técnico");
    private Formulario_asignar_registro l_t = new Formulario_asignar_registro();
    
    public Contenedor_MenuPrincipal(){
        //actual = c_m;
        this.setBackground(Color.blue);
        this.setLayout(new CardLayout());
        this.add(c_m,"Agregar Máquina");
        this.add(c_t,"Agregar Técnico");
        this.add(l_t,"Asignar Registro");
    }
    
    public void cambiar_actual(String s)
    {
        //System.out.println(s);
        CardLayout cl = (CardLayout)(this.getLayout());
        cl.show(this, s);
    }
    
    public void continuar_carga_Tecnico(Tecnico t){
        l_t.continuarCambiarTecnico(t);
        CardLayout cl = (CardLayout)(this.getLayout());
        cl.show(this, "Asignar Registro");
    }
            
}

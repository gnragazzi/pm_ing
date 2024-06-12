package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;
import pm_ingsw1.Tecnico;

public class Contenedor_MenuPrincipal extends JPanel{
    //private JPanel actual;
    private Formulario_cargar_máquina c_m = new Formulario_cargar_máquina("Agregar Máquina");
    private Formulario_cargar_técnico c_t = new Formulario_cargar_técnico("Agregar Técnico");
    private Formulario_asignar_registro l_t = new Formulario_asignar_registro();
    private CardLayout cl = new CardLayout();
    private Carga_Exitosa Pantalla_mensaje = new Carga_Exitosa();
    
    public Contenedor_MenuPrincipal(){
        //actual = c_m;
        this.setBackground(Color.blue);
        this.setLayout(cl);
        this.add(c_m,"Agregar Máquina");
        this.add(c_t,"Agregar Técnico");
        this.add(l_t,"Asignar Registro");
        this.add(Pantalla_mensaje,"Mensaje");
    }
    
    public void cambiar_actual(String s)
    {
        //System.out.println(s);
        cl.show(this, s);
    }
    
    public void continuar_carga_Tecnico(Tecnico t){
        l_t.continuarCambiarTecnico(t);
        cl.show(this, "Asignar Registro");
    }
    public void setPantallaCargaExitosa(String s)
    {
        Pantalla_mensaje.setTexto(s);
        this.cl.show(this,"Mensaje");
    }
}

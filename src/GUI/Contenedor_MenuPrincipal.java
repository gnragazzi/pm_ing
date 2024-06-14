package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;
import pm_ingsw1.Tecnico;

public class Contenedor_MenuPrincipal extends JPanel{
    private Formulario_cargar_máquina c_m = new Formulario_cargar_máquina("Agregar Máquina");
    private Formulario_cargar_técnico c_t = new Formulario_cargar_técnico("Agregar Técnico");
    private Formulario_asignar_registro l_t = new Formulario_asignar_registro();
    private Formulario actual;
    private CardLayout cl = new CardLayout();
    private Carga_Exitosa Pantalla_mensaje = new Carga_Exitosa();
    
    public Contenedor_MenuPrincipal(){
        this.setBackground(Color.blue);
        this.setLayout(cl);
        actual = c_m;
        this.add(c_m,"Agregar Máquina");
        this.add(c_t,"Agregar Técnico");
        this.add(l_t,"Asignar Registro");
        this.add(Pantalla_mensaje,"Mensaje");
    }
    
    public void cambiar_actual(String s, boolean paso_entre_Formuarios)
    {
        if(!paso_entre_Formuarios)
            actual.limpiarCampos();
        if(s.equals("Agregar Máquina"))
        {
            actual = c_m;
        }
        else if(s.equals("Agregar Técnico"))
            actual = c_t;
        else
        {
            actual = l_t;
        }
        actual.cargarDesdeBd();
        cl.show(this, s);
    }
    
    public void continuar_carga_Tecnico(Tecnico t){
        l_t.limpiarCampos();
        l_t.cargarDesdeBd();
        l_t.continuarCambiarTecnico(t);
        cl.show(this, "Asignar Registro");
    }
    public void setPantallaCargaExitosa(String s)
    {
        Pantalla_mensaje.setTexto(s);
        this.cl.show(this,"Mensaje");
    }
}

package GUI;

import static GUI.Boton.getVentana;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pm_ingsw1.Tecnico;

public class Contenedor_MenuPrincipal extends JPanel{
    private Administrar_máquina c_m = new Administrar_máquina("Administrar Máquina");
    private Administrar_técnico c_t = new Administrar_técnico("Administrar Técnico");
    private Administrar_registro l_t = new Administrar_registro("Administrar Registros");
    private Carga_Exitosa pant_default;
    private Administrar actual;
    private CardLayout cl = new CardLayout();
    
    public Contenedor_MenuPrincipal(){
        this.setMinimumSize(new Dimension(1100,800));
        this.setPreferredSize(new Dimension(1100,800));
        this.setMaximumSize(new Dimension(1100,800));
        this.setBackground(Color.blue);
        this.setLayout(cl);
        pant_default = new Carga_Exitosa("En construcción");
        
        actual = c_m;
        this.add(c_m,"Administrar Máquina");
        this.add(c_t,"Administrar Técnico");
        this.add(l_t,"Administrar Registros");
        this.add(pant_default,"default");
    }
    
    public void cambiar_actual(String s, boolean paso_entre_Formuarios)
    {
        if(s.equals("Administrar Máquina"))
            actual = c_m;
        else if(s.equals("Administrar Técnico"))
            actual = c_t;
        else if(s.equals("Administrar Registros"))
            actual = l_t;
        else if(s.equals("Salir"))
            ((Ventana)this.getTopLevelAncestor()).dispatchEvent(new WindowEvent((Ventana)this.getTopLevelAncestor(), WindowEvent.WINDOW_CLOSING));
        else
        {
            s = "default";
        }
            
        if(!paso_entre_Formuarios)
            actual.limpiarCampos();
        actual.cargarDesdeBd();
        cl.show(this, s);
    }
    
    public void continuar_carga_Tecnico(Tecnico t){
        l_t.limpiarCampos();
        l_t.cargarDesdeBd();
        l_t.continuarCambiarTecnico(t);
        actual = l_t;
        cl.show(this, "Administrar Registros");
    }
}

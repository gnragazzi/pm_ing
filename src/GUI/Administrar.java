/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author gera
 */
public abstract class Administrar extends JPanel{
    protected Header header;
    protected JPanel cuerpo;
    private JPanel pestaña_blank;
    protected JPanel pestaña_cargar;
    protected Pantalla_Mensaje pestaña_en_construcción;
    protected CardLayout layout_cuerpo;
    private Pantalla_Mensaje pantalla_mensaje;
    protected JLabel error_carga = new JLabel("",SwingConstants.CENTER);
    
    public Administrar(String t) {
        pestaña_blank = new JPanel();
        pestaña_cargar = new JPanel();
        pestaña_en_construcción = new Pantalla_Mensaje("En construcción");
        pantalla_mensaje = new Pantalla_Mensaje("");


        cuerpo = new JPanel();
        layout_cuerpo = new CardLayout();
        cuerpo.setLayout(layout_cuerpo);
        cuerpo.add(pestaña_blank, "blank");
        cuerpo.add(pestaña_cargar,"Cargar");
        cuerpo.add(pestaña_en_construcción,"en_construcción");
        cuerpo.add(pantalla_mensaje,"mensaje");
        header=new Header(t,cuerpo);
        this.add(header);
        
        this.add(cuerpo);
        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
    }

    public Administrar() {
    }
    
    
    public void limpiarCampos(){
        layout_cuerpo.show(cuerpo, "blank");
    };
    public boolean esValido(){
        return false;
    };
    public void enviar(){};
    public void cargarDesdeBd(){};
    public JPanel getCuerpo(){
        return cuerpo;
    }
    public void setPantallaCargaExitosa(String s)
    {
        pantalla_mensaje.setTexto(s);
        layout_cuerpo.show(cuerpo,"mensaje");
    }
}
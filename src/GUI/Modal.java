/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author gera
 */
public class Modal extends JDialog{
    private Administrar actual;
    private final JPanel modal = new JPanel();
    private final JPanel modal_confirmar = new JPanel();
    private final JPanel modal_mensaje = new JPanel();
    private final CardLayout layout = new CardLayout(); 
    private final JLabel msj_confirmación = new JLabel("", SwingConstants.CENTER);
    private final Panel_Principal cuerpo;
    
    public Modal(JFrame f, String s, Panel_Principal c) {
        super(f,s);
        cuerpo = c;
        JPanel text_container = new JPanel();
        JLabel text = new JLabel(s,SwingConstants.CENTER);
        text_container.add(text);
        text_container.setBackground(Constantes.COLOR_PRINCIPAL);
        text.setFont(Constantes.FUENTE_HEADER);
        text.setForeground(Constantes.COLOR_FONDO);
        
        
        JPanel div_boton = new JPanel();
        Boton_modal aceptar = new Boton_modal(Constantes.ACEPTAR,this);
        Boton_modal cancelar = new Boton_modal(Constantes.CANCELAR,this);
        div_boton.add(aceptar);
        div_boton.add(cancelar);
        div_boton.setLayout(new BoxLayout(div_boton, BoxLayout.X_AXIS));

        modal_confirmar.add(text_container);
        modal_confirmar.add(div_boton);
        modal_confirmar.setLayout(new GridLayout(2, 1));
        modal_confirmar.setBorder(new LineBorder(Constantes.COLOR_PRINCIPAL,1));
        
        msj_confirmación.setFont(Constantes.FUENTE_MSG_MODAL);
        modal_mensaje.add(msj_confirmación);
        Boton_modal volver = new Boton_modal("Volver",this);
        modal_mensaje.add(volver);
        modal_mensaje.setLayout(new GridLayout(2, 1));
        modal_mensaje.setBorder(new LineBorder(Constantes.COLOR_PRINCIPAL,1));
        
        modal.setLayout(layout);
        modal.add(modal_confirmar,"confirmar");
        modal.add(modal_mensaje,"mensaje");
        
        this.setContentPane(modal);
        this.setUndecorated(true);
        this.setMinimumSize(new Dimension(400,80));
        this.setPreferredSize(new Dimension(400,80));
        this.setLocationRelativeTo(this);
        this.setModal(true);
        this.pack();
    }
    
    public void desplegarDialog(String s, Administrar f)
    {
        layout.show(modal, "confirmar");
        actual = f;
        this.setVisible(true);
        System.out.flush();
    }
    
    public void confirmarCarga(String s)
    {
        layout.show(modal, "mensaje");
        msj_confirmación.setText(s);
    }
    
    public Administrar getActual()
    {
        return actual;
    }
    public Panel_Principal getCuerpo()
    {
        return cuerpo;
    }
}


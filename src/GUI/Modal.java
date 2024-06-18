/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author gera
 */
public class Modal extends JDialog{
    private Administrar actual;
    public Modal(JFrame f, String s) {
        super(f,s);
        JPanel modal = new JPanel();
        JLabel text = new JLabel(s,SwingConstants.CENTER);
        text.setFont(Constantes.FUENTE_HEADER);
        JPanel div_boton = new JPanel();
        Boton_modal aceptar = new Boton_modal(Constantes.ACEPTAR,this);
        Boton_modal cancelar = new Boton_modal(Constantes.CANCELAR,this);
        div_boton.add(aceptar);
        div_boton.add(cancelar);
        div_boton.setLayout(new BoxLayout(div_boton, BoxLayout.X_AXIS));

        modal.add(text);
        modal.add(div_boton);
        modal.setLayout(new GridLayout(2, 1));

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
        actual = f;
        this.setVisible(true);
        System.out.flush();
    }
    public Administrar getActual()
    {
        return actual;
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

/**
 *
 * @author gera
 */
public class Boton_Maq extends Boton{
    protected Administrar form;
    public Boton_Maq(String n, Administrar f)
    {
        super(n,Constantes.FUENTE_BOTON_LATERAL);
        this.form = f;
        this.setLayout(Constantes.LAYOUT_CENTRADO);
        this.nombre.setHorizontalAlignment(JLabel.CENTER);
        this.nombre.setVerticalAlignment(JLabel.CENTER);
        this.nombre.setForeground(Constantes.COLOR_PRINCIPAL);
        this.nombre.setFont(Constantes.FUENTE_HEADER);
    }

    @Override
    public void mouseClick(MouseEvent evt){
        if(this.getTextoNombre().equals(Constantes.CANCELAR))
        {
            form.header.limpiarSelección();
            ((CardLayout)form.getCuerpo().getLayout()).show(form.getCuerpo(),"blank");
        }
        else
        {
            if(form.esValido())
            {
                Ventana v = (Ventana)this.getTopLevelAncestor();
                v.getModal().desplegarDialog("Confirmar Carga de Máquina", form);
            }
            else
            {

            }
        }
    };
    
    @Override
    public void mouseEntra(MouseEvent evt, Color c) {                                   
        this.nombre.setForeground(Constantes.COLOR_SELECCIÓN);
    }                                  
    @Override
    public void mouseSale(MouseEvent evt, Color c) {                                  
        this.nombre.setForeground(Constantes.COLOR_PRINCIPAL);
    }    
}

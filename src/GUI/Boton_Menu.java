/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
/**
 *
 * @author gera
 */
public class Boton_Menu extends Boton {

    public Boton_Menu(String texto, JLabel icono){
        super(texto, Constantes.FUENTE_BOTON_LATERAL);
        this.getNombre().setBorder(new EmptyBorder(10, 10, 10, 10));
        this.getNombre().setForeground(Constantes.COLOR_PRINCIPAL);
    };
    @Override
    public void mouseClick(MouseEvent evt){
        ((Menu_Lateral)this.getParent()).limpiarSelección();
        selección = true;
        this.setBackground(Constantes.COLOR_SELECCIÓN);
        Panel_Principal n = (Panel_Principal) this.getParent().getParent();
        n.cambiarPanel(this.getTextoNombre());
    }
    
    @Override
    public Color getCol(){
        return Constantes.COLOR_FONDO;
    }
    @Override
    public Color getHighlight(){
        return Constantes.COLOR_SECUNDARIO;
    }
    public void setTamaño()
    {
        int parent_min_w = this.getParent().getMinimumSize().width;
        int parent_pre_w = this.getParent().getPreferredSize().width;
        int parent_max_w = this.getParent().getMaximumSize().width;
        
        this.setMinimumSize(new Dimension(parent_min_w -10, 100));
        this.setPreferredSize(new Dimension(parent_pre_w - 10, 100));
        this.setMaximumSize(new Dimension(parent_max_w -10, 100));
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author gera
 */
public class Fila extends JPanel{
    private ArrayList<String> col = new ArrayList<String>();
    private Administrar_registro form_actual;
    private boolean selected = false;
    private boolean esCabecera = false;
    private int indice;
    
    public Fila(String s[],boolean b, int indx, Administrar_registro f) {
        indice = indx;
        esCabecera = b;
        form_actual = f;
        
        if(esCabecera)
        {
            this.setBackground(Constantes.COLOR_PRINCIPAL);
            
        }
        
        for(int i = 0; i < s.length;i++)
        {
            JLabel temp = new JLabel(s[i],SwingConstants.CENTER);
            if(esCabecera)
                temp.setForeground(Constantes.COLOR_SECUNDARIO);
            temp.setBorder(new LineBorder(Constantes.COLOR_BORDE,1));
            col.add(s[i]);
            this.add(temp);
        }
        
        this.setLayout(new GridLayout(1,s.length));
        
        this.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent evt) {
                    mouseEntra(evt);
                }
                @Override
                public void mouseExited(MouseEvent evt) {
                    mouseSale(evt);
                }
                @Override
                public void mouseClicked(MouseEvent evt){
                    mouseClick(evt);
                }
            });
    }
    public void mouseEntra(MouseEvent evt) {                                   
        if(!this.selected && !esCabecera)
            this.setBackground(Constantes.COLOR_SECUNDARIO);
    }                                  

    public void mouseSale(MouseEvent evt) {                                  
        if(!this.selected && !esCabecera)
            this.setBackground(null);
    }    
    public void mouseClick(MouseEvent evt){
        if(this.selected)
        {
            this.selected = false;
            this.setBackground(null);
            form_actual.desasignar_seleccion();
        }
        else if(!this.selected && !esCabecera)
        {
            form_actual.asignar_seleccion(this);
            this.selected = true;
            this.setBackground(Constantes.COLOR_SELECCIÓN);
        }
    };
    public void setSelected(boolean b)
    {
        this.selected = b;
    }
    public ArrayList<String> getCol(){
        return col;
    }
    public int getIndice()
    {
        return indice;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author gera
 */
public class Menu_Lateral extends JPanel {
    private Boton_Menu []menu = new Boton_Menu[6];
    private String []menu_text = {
        "Administrar Máquina",
        "Administrar Técnico",
        "Administrar Registros",
        "Administrar Procesos",
        "Administrar Plantas",
        "Salir"
    };

    
    public Menu_Lateral(){
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBackground(Constantes.COLOR_FONDO);
        this.setBorder(new LineBorder(Constantes.COLOR_BORDE,1));
        this.setPreferredSize(new Dimension(600, 800));
        this.setMinimumSize(new Dimension(600, 800));
        this.setMaximumSize(new Dimension(600, 800));
        this.setMenuBotones();
    }
    private void setMenuBotones(){
        int longitud = this.menu.length;
        this.add(Box.createRigidArea(Constantes.AREA_RIGIDA_LATERAL));
        //this.add(logo_container);
        this.add(Box.createVerticalGlue());
        for(int i = 0;i < longitud ; i++)
        {
            if(i == longitud - 1)
                this.add(Box.createVerticalGlue());
            JLabel temp = new JLabel();
            menu[i] = new Boton_Menu(menu_text[i],temp);
            this.add(menu[i]);
        }
        for(int i = 0;i < longitud ; i++)
        {
            menu[i].setTamaño();
            menu[i].setBackground(Constantes.COLOR_FONDO);
        }
        
    }
    public void limpiarSelección()
    {
        int longitud = this.menu.length;
        for(int i = 0;i < longitud ; i++)
        {
            menu[i].setSeleccion(false);
            menu[i].setBackground(menu[i].getCol());
        }
    }
    /*
    private void setLogoContainer(){
        //this.logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Iconos/logo2.png"))); // NOI18N
        /*this.logo.setText("LabBiblio");
        this.logo.setFont(Constantes.FUENTE_HEADER);
        this.logo.setForeground(Constantes.getCOLOR_MENU_Fuente());//**********Color de Fuente
        this.logo.setHorizontalAlignment(JLabel.CENTER);
        this.logo.setVerticalAlignment(JLabel.CENTER);
        this.logo_container.add(logo);
        this.logo_container.setBackground(null);
        this.logo_container.setLayout(Constantes.LAYOUT_CENTRADO);
        
    }
*/
}

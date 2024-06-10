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

/**
 *
 * @author gera
 */
public class Menu_Lateral extends JPanel {
    private Boton_Menu []menu = new Boton_Menu[3];
    private String []menu_text = {
        "Agregar Máquina",
        "Agregar Técnico",
        "Asignar Registro",
    };
    private String []menu_iconos = {
        "/GUI/Iconos/home.png",
        "/GUI/Iconos/agregar.png",
        "/GUI/Iconos/buscarB.png",
        "/GUI/Iconos/explorar.png",
        "/GUI/Iconos/configuracion.png",
        "/GUI/Iconos/salir.png"
        
    };
    private JLabel logo = new JLabel();
    private JPanel logo_container = new JPanel();

    
    public Menu_Lateral(){
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBackground(Constantes.getCOLOR_MENU());

        this.setLogoContainer();
        this.setMenuBotones();
    }
    private void setMenuBotones(){
        int longitud = this.menu.length;
        this.add(Box.createRigidArea(Constantes.getAREA_RIGIDA_LATERAL()));
        this.add(logo_container);
        this.add(Box.createVerticalGlue());
        for(int i = 0;i < longitud ; i++)
        {
            if(i == longitud - 1)
                this.add(Box.createVerticalGlue());
            JLabel temp = new JLabel();
            //temp.setIcon(new javax.swing.ImageIcon(getClass().getResource(menu_iconos[i]))); // NOI18N
            menu[i] = new Boton_Menu(menu_text[i],temp);
            this.add(menu[i]);
        }
    }
    
    private void setLogoContainer(){
        //this.logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Iconos/logo2.png"))); // NOI18N
        /*this.logo.setText("LabBiblio");
        this.logo.setFont(Constantes.getFUENTE_HEADER());
        this.logo.setForeground(Constantes.getCOLOR_MENU_Fuente());//**********Color de Fuente*/
        this.logo.setHorizontalAlignment(JLabel.CENTER);
        this.logo.setVerticalAlignment(JLabel.CENTER);
        this.logo_container.add(logo);
        this.logo_container.setBackground(null);
        this.logo_container.setLayout(Constantes.getLAYOUT_CENTRADO());
        
    }
}

package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author gera
 */
public class Panel_Principal extends JPanel{
    public Contenedor_MenuPrincipal formulario_actual;
    public JPanel barraSuperior;
    public JPanel menuLateral;
    private GridBagConstraints menuLat = new GridBagConstraints();
    private GridBagConstraints c = new GridBagConstraints();
    
    public Panel_Principal() {
        //set layout
        this.setLayout(new GridBagLayout());
        //configuración de la barra superior
        barraSuperior = new JPanel();
        barraSuperior.setBackground(Color.green);
        //barraSuperior.setPreferredSize(new Dimension(680,40));
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 0.04;
        c.gridwidth = 2;
        this.add(barraSuperior,c);
        
        //Menú Lateral
        menuLateral = new JPanel();
        menuLateral.setBackground(Color.RED);
        menuLat.fill = GridBagConstraints.BOTH;
        menuLat.weightx = 0.3;
        menuLat.weighty = 0.950;
        menuLat.gridx = 0;
        menuLat.gridy = 1;
        this.add(menuLateral, menuLat);
        
        //configuración del formulario
        formulario_actual = new Contenedor_MenuPrincipal();
        GridBagConstraints formulario = new GridBagConstraints();
        
        formulario.gridx = 1;
        formulario.gridy = 1;
        formulario.gridwidth = GridBagConstraints.REMAINDER;
        formulario.gridheight = GridBagConstraints.REMAINDER;
        formulario.weightx = 0.7;
        formulario.weighty = 0.950;
        formulario.fill = GridBagConstraints.BOTH;
        //formulario.anchor = GridBagConstraints.LAST_LINE_END;
        this.add(formulario_actual,formulario);
        
        

        /*
        setBackground(Color.red);
        // setear barra superior
        */
        this.setPreferredSize(new Dimension(680,480));
    }
    
}

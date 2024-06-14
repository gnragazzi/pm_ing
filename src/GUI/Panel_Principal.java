package GUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author gera
 */
public class Panel_Principal extends JPanel{
    public Contenedor_MenuPrincipal formulario_actual;
    public JPanel barraSuperior;
    public Menu_Lateral menuLateral;
    private GridBagConstraints menuLat = new GridBagConstraints();
    private GridBagConstraints c = new GridBagConstraints();
    
    public Panel_Principal() {
        //set layout
        this.setLayout(new GridBagLayout());
        this.setBackground(Constantes.COLOR_FONDO);
        //configuración de la barra superior
        barraSuperior = new JPanel();
        JLabel tit = new JLabel("Empresa de Vidrios S.A.",SwingConstants.CENTER);
        tit.setFont(Constantes.FUENTE_TITULO);
        tit.setForeground(Constantes.COLOR_SECUNDARIO);
        barraSuperior.add(tit);
        
        barraSuperior.setBackground(Constantes.COLOR_PRINCIPAL);
        barraSuperior.setMinimumSize(new Dimension(1000,33));
        barraSuperior.setPreferredSize(new Dimension(1000,33));
        barraSuperior.setMaximumSize(new Dimension(1000,33));
        barraSuperior.setPreferredSize(new Dimension(680,40));
        barraSuperior.setLayout(new GridLayout(1,8));
        
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.5;
        c.weighty = 0.04;
        c.gridwidth = 2;
        this.add(barraSuperior,c);
        
        //Menú Lateral
        menuLateral = new Menu_Lateral();
        menuLat.fill = GridBagConstraints.BOTH;
        menuLat.weightx = 0.99;
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
        formulario.weightx = 0.1;
        formulario.weighty = 0.950;
        formulario.fill = GridBagConstraints.BOTH;
        //formulario.anchor = GridBagConstraints.LAST_LINE_END;
        this.add(formulario_actual,formulario);
        
        

        /*
        setBackground(Color.red);
        // setear barra superior
        */
        this.setPreferredSize(new Dimension(1600,800));
    }
    public void cambiarPanel(String s)
    {
        formulario_actual.cambiar_actual(s,false);
    }
    
}

package GUI;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author gera
 */
public class Panel_Principal extends JPanel{
    public Formulario formulario_actual;
    public Panel_Principal() {
        setBackground(Color.red);
        formulario_actual = new Formulario();
        this.setPreferredSize(new Dimension(680,480));
        this.add(formulario_actual);
    }
    
}


package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public abstract class Campo extends JPanel{

    protected final JLabel nombre = new JLabel();
    protected JTextField input = new JTextField();
    protected final GridLayout layout = new GridLayout(1,4);
    protected final JLabel msj_validacion = new JLabel("");
    
    public Campo(String n){
        nombre.setText(n);
        nombre.setFont(Constantes.FUENTE_CAMPO);
        nombre.setForeground(Constantes.COLOR_PRINCIPAL);
        
        input.setDocument(new JTextFieldLimit(Constantes.LIM));
        input.setFont(Constantes.FUENTE_CAMPO);
        input.setForeground(Constantes.COLOR_PRINCIPAL);
        input.setBackground(null);
        input.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.COLOR_PRINCIPAL));
        
        
        //msj_validacion.setText("Hola, Mundo!");
        msj_validacion.setFont(Constantes.FUENTE_INFO_VALIDACIÓN);
        msj_validacion.setForeground(Constantes.COLOR_ERROR);
        
        GridBagConstraints c = new GridBagConstraints();
        
        this.setLayout(new GridBagLayout());
        
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 3;
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.BOTH;
        c.ipadx = 10;
        c.ipady = 10;
        c.insets = new Insets(10, 10, 10, 10);
        this.add(nombre,c);

        c.gridx = 1;
        this.add(input,c);

        c.gridx = 1;
        c.gridy = 4;
        c.weighty = 0.1;
        c.weightx = 1.0;
        c.insets = new Insets(0, 0, 0, 0);
        this.add(msj_validacion,c);
        

    }
    public JTextField getInput(){
        return input;
    }
    
    public JLabel getNombre(){
        return this.nombre;
    }
    public boolean validarCampo(){return false;}
    public void limpiarCampo()
    {
        input.setText("");
        msj_validacion.setText("");
        input.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.COLOR_PRINCIPAL));
    }
    public void setMsjValidacion(String s)
    {
        this.msj_validacion.setText(s);
    }
}

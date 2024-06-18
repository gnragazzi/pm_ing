
package GUI;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.border.EmptyBorder;


public abstract class Campo extends JPanel{

    protected final JLabel Nombre = new JLabel();
    protected JTextField input = new JTextField();
    protected final GridLayout layout = new GridLayout(1,4);
    
    public Campo(String n){
        this.setBackground(null);
        Nombre.setText(n);
        Nombre.setFont(Constantes.FUENTE_CAMPO);
        Nombre.setForeground(Constantes.COLOR_PRINCIPAL);
        Nombre.setHorizontalAlignment(JLabel.LEFT);
        Nombre.setVerticalAlignment(JLabel.BOTTOM);
        
        
        input.setMinimumSize(new Dimension(20,20));
        input.setDocument(new JTextFieldLimit(Constantes.LIM));
        input.setFont(Constantes.FUENTE_CAMPO);
        input.setBorder(null);
        input.setBackground(null);
        input.setForeground(Constantes.COLOR_PRINCIPAL);
        input.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.COLOR_PRINCIPAL));
        
        
        this.add(Nombre);
        Nombre.setBorder(new EmptyBorder(0, 15, 0, 0));

        this.add(input);
        
        this.setLayout(layout);

    }
    public JTextField getInput(){
        return input;
    }
    
    public JLabel getNombre(){
        return this.Nombre;
    }
    public boolean validarCampo(){return false;}
    public void limpiarCampo()
    {
        input.setText("");
        input.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.COLOR_PRINCIPAL));
    }
}

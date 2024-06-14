package GUI;

import GUI.Boton;
import GUI.Constantes;
import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

/**
 *
 * @author gera
 */
public class Boton_Formulario_Agregar_ar extends Boton{
    private Administrar form;
    public Boton_Formulario_Agregar_ar(String n, Administrar f)
    {
        super(n,Constantes.FUENTE_BOTON_LATERAL);
        this.form = f;
        this.setLayout(Constantes.LAYOUT_CENTRADO);
        this.getNombre().setHorizontalAlignment(JLabel.CENTER);
        this.getNombre().setVerticalAlignment(JLabel.CENTER);
        this.setFont(Constantes.FUENTE_HEADER);

    }

    @Override
    public void mouseClick(MouseEvent evt){
        if(form.esValido())
        {
            Ventana v = (Ventana)this.getTopLevelAncestor();
            v.getModal().desplegarDialog("Confirmar Asignación de Registro", form);
        }
        else
            System.out.println("invalido");
    };
    @Override
    public void mouseEntra(MouseEvent evt, Color c) {                                   
        this.nombre.setForeground(Constantes.COLOR_SELECCIÓN);
    }                                  
    @Override
    public void mouseSale(MouseEvent evt, Color c) {                                  
        this.nombre.setForeground(Constantes.COLOR_PRINCIPAL);
    }    
        
    @Override
    public Color getCol(){
        return null;
    }
    
    @Override
    public Color getHighlight(){
        //setear color
        return Constantes.COLOR_PRINCIPAL;
    }
    

}

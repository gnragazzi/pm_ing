package GUI;

import java.awt.Color;
import javax.swing.BorderFactory;

/**
 *
 * @author gera
 */
public class Campo_Num extends Campo{
    
    public Campo_Num(String n){
        super(n);
        this.getInput().setDocument(new JTextFieldLimit(20));
    }
    @Override
    public boolean validarCampo(){
        String number = this.getInput().getText().replaceAll("[^0-9]","");
        if(!number.isEmpty() && number.equals(this.getInput().getText()))
        {
            getInput().setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.COLOR_PRINCIPAL));
            setMsjValidacion("");
            return true;
        }
        else
        {
            getInput().setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Constantes.COLOR_ERROR));
            setMsjValidacion("Este Campo no puede estar vacío");
            return false;
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.event.MouseEvent;
/**
 *
 * @author gera
 */
public class Boton_Nav extends Boton{
    private final Administrar_registro padre;
    public Boton_Nav(String n, Administrar_registro f)
    {
        super(n,Constantes.FUENTE_HEADER);
        padre = f;
        this.setLayout(Constantes.LAYOUT_CENTRADO);
        this.nombre.setForeground(Constantes.COLOR_PRINCIPAL);
    }

    @Override
    public void mouseClick(MouseEvent evt){
        if(this.getTextoNombre().equals(Constantes.SIGUIENTE))
            padre.cambiarListado(1);
        else if(this.getTextoNombre().equals(Constantes.VOLVER))
            padre.cambiarListado(-1);
        else
        {
            if(padre.esValido())
            {
                Ventana v = (Ventana)this.getTopLevelAncestor();
                v.getModal().desplegarDialog("Confirmar Asignación de Registro", padre);
            }
            else
                System.out.println("invalido");
        }

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

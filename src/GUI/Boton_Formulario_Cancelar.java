/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import GUI.Constantes;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

/**
 *
 * @author gera
 */
public class Boton_Formulario_Cancelar extends Boton_Formulario_Confirmar {
    
    public Boton_Formulario_Cancelar(String n, Administrar_máquina f){
        super(n,f);
        this.getNombre().setHorizontalAlignment(JLabel.CENTER);
        this.getNombre().setVerticalAlignment(JLabel.CENTER);
    }
    @Override
    public void mouseClick(MouseEvent evt){
            ((CardLayout)form.getCuerpo().getLayout()).show(form.getCuerpo(),"blank");
    };

}
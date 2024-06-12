/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.JPanel;

/**
 *
 * @author gera
 */
public abstract class Formulario extends JPanel{
    public void limpiarCampos(){};
    public boolean esValido(){
        return false;
    };
    public void enviar(){};
    public void cargarDesdeBd(){};
}
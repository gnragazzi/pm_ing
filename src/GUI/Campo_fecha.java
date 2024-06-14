/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicTreeUI;

/**
 *
 * @author gera
 */
public class Campo_fecha extends Campo{
    private JComboBox<Integer> dia = new JComboBox<>();
    private JComboBox<String> mes = new JComboBox<>();
    private JComboBox<Integer> año = new JComboBox<>();
    private JPanel contenedor = new JPanel();
    
    public Campo_fecha(String s, int lim_sup,int lim_inf, int orden) {
        super(s);
        this.remove(input);
        
        for(int i = 1; i <= 31; i++)
            dia.addItem(i);
        
        mes.addItem("Enero");
        mes.addItem("Febrero");
        mes.addItem("Marzo");
        mes.addItem("Abril");
        mes.addItem("Mayo");
        mes.addItem("Junio");
        mes.addItem("Julio");
        mes.addItem("Agosto");
        mes.addItem("Septiembre");
        mes.addItem("Octubre");
        mes.addItem("Noviembre");
        mes.addItem("Diciembre");
        
        
        if(orden < 0)
        {
            for(int i = lim_sup; i >= lim_inf; i--)
                año.addItem(i);
        }
        else
        {
            for(int i = lim_inf; i <= lim_sup; i++)
                año.addItem(i);
        }
        
        mes.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                int mes_seleccionado = mes.getSelectedIndex();
                int cant_dias = dia.getItemCount();
                if(mes_seleccionado == 3 || mes_seleccionado == 5 || mes_seleccionado == 8 ||mes_seleccionado == 10)
                {
                    if(cant_dias > 30)
                    {
                        dia.removeItemAt(30);
                    }
                    else
                    {
                        dia.addItem(29);
                        dia.addItem(30);
                    }
                }
                else if(mes_seleccionado == 1 && cant_dias > 28)
                    for(int i = dia.getItemCount(); i != 28; i--) dia.removeItemAt(i-1);
                else if(cant_dias < 31)
                    for(int i = dia.getItemCount(); i != 31; i++) dia.addItem(i+1);
         }
});
        limpiarCampo();
        contenedor.add(dia);
        contenedor.add(mes);
        contenedor.add(año);
        this.add(contenedor);
    }
    
    public boolean validarCampo(){
        if(dia.getSelectedIndex() < 0 || mes.getSelectedIndex() < 0 || año.getSelectedIndex() < 0)
        {
            this.setBackground(Color.red);
            return false;
        }
        else 
        {
            this.setBackground(Color.WHITE);
            return true;
        }
    }
    
    public void limpiarCampo()
    {
        this.setBackground(Color.white);
        dia.setSelectedIndex(-1);        
        mes.setSelectedIndex(-1);
        año.setSelectedIndex(-1);
    }
    @Override
    public String toString()
    {
        return String.valueOf(dia.getSelectedItem())+ "/"+ (mes.getSelectedIndex() + 1) + "/"+año.getSelectedItem();
    }

    public int getDia() {
        return dia.getSelectedIndex();
    }

    public int getMes() {
        return mes.getSelectedIndex();
    }

    public int getAño() {
        return año.getSelectedIndex();
    }
    
    public boolean esAntes(Campo_fecha f)
    {
        if(this.getAño() < f.getAño())
            return true;
        else if (this.getAño() > f.getAño())
            return false;
        else
        {
            if(this.getMes() < f.getMes())
                return true;
            else if (this.getMes() > f.getMes())
                return false;       
            else
                if(this.getDia() < f.getDia())
                    return true;
                else 
                    return false;
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author gera
 */
public class Constantes {
    private static final String fuente = "Open Sans";
    private static final GridLayout LAYOUT_CENTRADO= new GridLayout(1,1);
    public static Color COLOR_BORDE = new Color(202, 202, 202);
    public static Color COLOR_FONDO = new Color(242, 242, 242);
    public static Color COLOR_PRINCIPAL = new Color(31, 32, 65);
    public static Color COLOR_SECUNDARIO = new Color(147, 229, 171);
    public static Color COLOR_SELECCIÓN = new Color(127, 209, 151);
    public static Color COLOR_Header = new Color(207, 207, 207);
    
    
    private static Color COLOR_MENU = new Color(11, 79, 108);
    private static Color COLOR_MENU_HIGHLIGHT = new Color(99, 72, 110);
    private static Color COLOR_MENU_SELECCION = new Color(84, 57, 95);
    private static final int LIM = 20;
    private static final int ALT = 70;
    /*
    private static final int TAM = 1200;
    private static final float PROPORCION = 16/9;
    */
    //private static final Font FUENTE_HEADER = new Font(fuente,0,48);
    public static final Font FUENTE_HEADER = new Font(fuente,Font.BOLD,26);
   
    private static final Font FUENTE_INFO = new Font(fuente,Font.PLAIN,32);
    private static final Font FUENTE_CAMPO = new Font(fuente, Font.BOLD, 30);
    private static final Font FUENTE_BOTON_LATERAL = new Font(fuente, Font.BOLD, 18);
    private static final Font FUENTE_BOTON_HEADER = new Font(fuente,0,22);
    private static final Font FUENTE_TARJETA = new Font(fuente, Font.PLAIN, 24);
    private static final Font FUENTE_TARJETA_PEQUE = new Font(fuente, Font.PLAIN, 18);
    
    private static final Dimension AREA_RIGIDA = new Dimension(10,75);
    private static final Dimension AREA_RIGIDA_PEQUEÑA = new Dimension(10,10);
    private static final Dimension AREA_RIGIDA_LATERAL = new Dimension(1,25);
    private static final JPanel referencias = new JPanel();
    private static final JPanel blank = new JPanel();
    private static final JLabel []ref_String = {new JLabel("Código"),new JLabel("Nombre"), new JLabel("Tipo")};
    
    public Constantes(){
        this.configReferencias();
    }
    
    public static GridLayout getLAYOUT_CENTRADO() {
        return LAYOUT_CENTRADO;
    }


    public static Color getCOLOR_MENU_HIGHLIGHT() {
        return COLOR_MENU_HIGHLIGHT;
    }
    /*
    public static int getTAM() {
        return TAM;
    }

    public static float getPROPORCION() {
        return PROPORCION;
    }
    */
    public static Font getFUENTE_HEADER() {
        return FUENTE_HEADER;
    }
    public static Font getFUENTE_INFO() {
        return FUENTE_INFO;
    }

    public static Font getFUENTE_BOTON_HEADER() {
        return FUENTE_BOTON_HEADER;
    }

    public static Dimension getAREA_RIGIDA() {
        return AREA_RIGIDA;
    }
    public static int getLIM() {
        return LIM;
    }
    public static Dimension getAREA_RIGIDA_PEQUEÑA() {
        return AREA_RIGIDA_PEQUEÑA;
    }
    private void configReferencias(){
        referencias.removeAll();
        ref_String[0].setFont(Constantes.getFUENTE_BOTON_HEADER());
        ref_String[1].setFont(Constantes.getFUENTE_BOTON_HEADER());
        ref_String[2].setFont(Constantes.getFUENTE_BOTON_HEADER());
        referencias.add(ref_String[0]);
        referencias.add(ref_String[1]);
        referencias.add(ref_String[2]);
        referencias.add(Box.createRigidArea(Constantes.getAREA_RIGIDA_PEQUEÑA()));
        ref_String[0].setHorizontalAlignment(JLabel.CENTER);
        ref_String[0].setVerticalAlignment(JLabel.CENTER);
        ref_String[1].setHorizontalAlignment(JLabel.CENTER);
        ref_String[1].setVerticalAlignment(JLabel.CENTER);
        ref_String[2].setHorizontalAlignment(JLabel.CENTER);
        ref_String[2].setVerticalAlignment(JLabel.CENTER);
        referencias.setLayout(new GridLayout(1,3));
        referencias.setBackground(null);
    }
    public static JPanel getReferencias(){

        return referencias;
    }

    public static Font getFUENTE_TARJETA() {
        return FUENTE_TARJETA;
    }
    public static int getALT() {
        return ALT;
    }
    public static Font getFUENTE_BOTON_LATERAL() {
        return FUENTE_BOTON_LATERAL;
    }

    public static Dimension getAREA_RIGIDA_LATERAL() {
        return AREA_RIGIDA_LATERAL;
    }

    public static Color getCOLOR_MENU_Fuente() {
        return COLOR_SECUNDARIO;
    }

    public static Color getCOLOR_MENU_SELECCION() {
        return COLOR_MENU_SELECCION;
    }

    public static Font getFUENTE_CAMPO() {
        return FUENTE_CAMPO;
    }

    public static JPanel getBlank() {
        return blank;
    }

    public static Color getCOLOR_Header() {
        return COLOR_Header;
    }

    public static Font getFUENTE_TARJETA_PEQUE() {
        return FUENTE_TARJETA_PEQUE;
    }

    
    
    
    
    
}


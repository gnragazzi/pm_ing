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
    private static final String fuente = "Andale Mono";
    private static final GridLayout LAYOUT_CENTRADO= new GridLayout(1,1);
    private static Color COLOR_MENU = new Color(0, 0, 0);
    private static Color COLOR_SECUNDARIO = new Color(244, 237, 234);
    private static Color COLOR_MENU_HIGHLIGHT = new Color(99, 72, 110);
    private static Color COLOR_MENU_SELECCION = new Color(84, 57, 95);
    private static Color COLOR_Header = new Color(229, 218, 230);
    private static Color COLOR_MENU_DARK = new Color(25, 25, 35);
    private static Color COLOR_SECUNDARIO_DARK = new Color(244, 237, 234);
    private static Color COLOR_MENU_HIGHLIGHT_DARK = new Color(99, 72, 110);
    private static Color COLOR_MENU_SELECCION_DARK = new Color(84, 57, 95);
    private static Color COLOR_Header_DARK = new Color(229, 218, 230);
    private static final int TAM = 1200;
    private static final int LIM = 20;
    private static final int ALT = 70;
    private static final float PROPORCION = 16/9;
    //private static final Font FUENTE_HEADER = new Font(fuente,0,48);
    private static final Font FUENTE_HEADER = new Font(fuente,Font.BOLD,48);
    private static final Font FUENTE_INFO = new Font(fuente,Font.PLAIN,32);
    private static final Font FUENTE_CAMPO = new Font(fuente, Font.BOLD, 30);
    private static final Font FUENTE_BOTON_LATERAL = new Font(fuente, Font.PLAIN, 28);
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

    public static Color getCOLOR_MENU() {
        return COLOR_MENU;
    }

    public static Color getCOLOR_MENU_HIGHLIGHT() {
        return COLOR_MENU_HIGHLIGHT;
    }

    public static int getTAM() {
        return TAM;
    }

    public static float getPROPORCION() {
        return PROPORCION;
    }

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
    public static void cambiarColores(){
        Color aux;
        
        aux =COLOR_MENU;
        COLOR_MENU = COLOR_MENU_DARK;
        COLOR_MENU_DARK = aux;
        
        aux =COLOR_SECUNDARIO;
        COLOR_SECUNDARIO = COLOR_SECUNDARIO_DARK;
        COLOR_SECUNDARIO_DARK = aux;
        
        aux =COLOR_Header;
        COLOR_Header = COLOR_Header_DARK;
        COLOR_Header_DARK = aux;
        
        aux =COLOR_MENU_SELECCION;
        COLOR_MENU_SELECCION = COLOR_MENU_SELECCION_DARK;
        COLOR_MENU_SELECCION_DARK = aux;
        
        aux =COLOR_MENU_HIGHLIGHT;
        COLOR_MENU_HIGHLIGHT = COLOR_MENU_HIGHLIGHT_DARK;
        COLOR_MENU_HIGHLIGHT_DARK = aux;
        

    }
    
    
    
    
    
    
}


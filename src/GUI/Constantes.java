/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

/**
 *
 * @author gera
 */
public class Constantes {
    private static final String fuente = "Open Sans";
    public static final GridLayout LAYOUT_CENTRADO= new GridLayout(1,1);
    public static Color COLOR_BORDE = new Color(202, 202, 202);
    public static Color COLOR_FONDO = new Color(242, 242, 242);
    public static Color COLOR_PRINCIPAL = new Color(31, 32, 65);
    public static Color COLOR_SECUNDARIO = new Color(147, 229, 171);
    public static Color COLOR_SELECCIÓN = new Color(127, 209, 151);
    public static Color COLOR_Header = new Color(207, 207, 207);
    
    
    public static final int LIM = 20;
    private static final int ALT = 70;
    public static final Font FUENTE_HEADER = new Font(fuente,Font.BOLD,26);
    public static final Font FUENTE_TITULO = new Font(fuente,Font.BOLD,12);
   
    public static final Font FUENTE_INFO = new Font(fuente,Font.PLAIN,32);
    public static final Font FUENTE_CAMPO = new Font(fuente, Font.BOLD, 30);
    public static final Font FUENTE_BOTON_LATERAL = new Font(fuente, Font.BOLD, 18);
    public static final Font FUENTE_BOTON_HEADER = new Font(fuente,0,22);
    
    private static final Dimension AREA_RIGIDA = new Dimension(10,75);
    private static final Dimension AREA_RIGIDA_PEQUEÑA = new Dimension(10,10);
    public static final Dimension AREA_RIGIDA_LATERAL = new Dimension(1,25);
    
    
}


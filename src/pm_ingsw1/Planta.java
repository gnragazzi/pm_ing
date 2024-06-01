/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pm_ingsw1;

/**
 *
 * @author ezebe
 */
public class Planta {
    private String color;
    private int superficie;
    private Maquina[] maquinas;
    private Proceso[] procesos;

    public Planta(String color, int superficie, Maquina[] maquinas, Proceso[] procesos) {
        this.color = color;
        this.superficie = superficie;
        this.maquinas = maquinas;
        this.procesos = procesos;
    }

    public String getColor() {
        return color;
    }

    public int getSuperficie() {
        return superficie;
    }

    public Maquina[] getMaquinas() {
        return maquinas;
    }

    public Proceso[] getProcesos() {
        return procesos;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public void setMaquinas(Maquina[] maquinas) {
        this.maquinas = maquinas;
    }

    public void setProcesos(Proceso[] procesos) {
        this.procesos = procesos;
    }
    
    
    
}

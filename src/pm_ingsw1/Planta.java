/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pm_ingsw1;

import java.sql.SQLException;
import Connection.BD;
import java.util.ArrayList;
/**
 *
 * @author ezebe
 */
public class Planta {
    private String color;
    private int superficie;
    private ArrayList<Maquina> maquinas;
    private ArrayList<Proceso> procesos;

    public Planta(String color, int superficie, ArrayList<Maquina> maquinas, ArrayList<Proceso> procesos) {
        this.color = color;
        this.superficie = superficie;
        this.maquinas = maquinas;
        this.procesos = procesos;
    }

    public Planta() {
    }
    

    public String getColor() {
        return color;
    }

    public int getSuperficie() {
        return superficie;
    }

    public ArrayList<Maquina> getMaquinas() {
        return maquinas;
    }

    public ArrayList<Proceso> getProcesos() {
        return procesos;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public void setMaquinas(ArrayList<Maquina> maquinas) {
        this.maquinas = maquinas;
    }

    public void setProcesos(ArrayList<Proceso> procesos) {
        this.procesos = procesos;
    }
    
    public boolean cargarPlanta()throws SQLException{
        if(BD.chequearPlanta(this.getColor())){
            return false;
        }
        else{
            BD.cargarPlanta(this);
            return true;
        }
    }
    
}

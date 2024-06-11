/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pm_ingsw1;

import java.util.ArrayList;

/**
 *
 * @author ezebe
 */
public class Proceso {
    private String nombre;
    private int complejidad;
    private ArrayList<Planta> plantas=new ArrayList<>();

    public Proceso(String nombre, int complejidad, ArrayList<Planta> plantas) {
        this.nombre = nombre;
        this.complejidad = complejidad;
        this.plantas = plantas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getComplejidad() {
        return complejidad;
    }

    public ArrayList<Planta> getPlantas() {
        return plantas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setComplejidad(int complejidad) {
        this.complejidad = complejidad;
    }

    public void setPlantas(ArrayList<Planta> plantas) {
        this.plantas = plantas;
    }
    
}

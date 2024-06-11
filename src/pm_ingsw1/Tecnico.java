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
public class Tecnico {
    private String nombre;
    private String apellido;
    private int dni;
    private String fec_nac;
    private int contacto;
    private ArrayList<Registro> registro=new ArrayList<>();

    public Tecnico(String nombre, String apellido, int dni, String fec_nac, int contacto, ArrayList<Registro> registro) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fec_nac = fec_nac;
        this.contacto = contacto;
        this.registro = registro;
    }

    public Tecnico() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getDni() {
        return dni;
    }

    public String getFec_nac() {
        return fec_nac;
    }

    public int getContacto() {
        return contacto;
    }

    public ArrayList<Registro> getRegistro() {
        return registro;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setFec_nac(String fec_nac) {
        this.fec_nac = fec_nac;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    public void setRegistro(ArrayList<Registro> registro) {
        this.registro = registro;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", fec_nac=" + fec_nac + ", contacto=" + contacto;
    }
    
    
}

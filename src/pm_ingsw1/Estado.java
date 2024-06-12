/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pm_ingsw1;

/**
 *
 * @author ezebe
 */
public enum Estado {
        ACTIVO(1),
        REPARACION(2);

    private final int estado;

    Estado(int estado) {
        this.estado = estado;
    }
    
    public int getEstado() {
        return estado;
    }
}

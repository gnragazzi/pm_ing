/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pm_ingsw1;

/**
 *
 * @author ezebe
 */
public enum Turno {
        MAÑANA(1),
        TARDE(2),
        NOCHE(3);

    private final int turno;

    Turno(int turno) {
        this.turno = turno;
    }

    public int getTurno() {
        return turno;
    }
}


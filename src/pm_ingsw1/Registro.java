/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pm_ingsw1;

/**
 *
 * @author ezebe
 */
public class Registro {
    private String fec_inicio;
    private String fec_final;
    private Maquina maquina;
    private Tecnico tecnico;
    private enum turno{
        Mañana,Tarde,Noche
    }

    public Registro(String fec_inicio, String fec_final, Maquina maquina, Tecnico tecnico) {
        this.fec_inicio = fec_inicio;
        this.fec_final = fec_final;
        this.maquina = maquina;
        this.tecnico = tecnico;
    }

    public String getFec_inicio() {
        return fec_inicio;
    }

    public String getFec_final() {
        return fec_final;
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setFec_inicio(String fec_inicio) {
        this.fec_inicio = fec_inicio;
    }

    public void setFec_final(String fec_final) {
        this.fec_final = fec_final;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }
    
    
}

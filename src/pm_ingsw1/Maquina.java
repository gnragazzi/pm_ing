/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pm_ingsw1;
/**
 *
 * @author ezebe
 */
public class Maquina {
    private String NroID;
    private String Marca;
    private String Modelo;
    private Planta planta;
    private Registro[] registro;
    private enum Estado{
        Activa,Reparación
    }
    
    public Maquina(String NroID, String Marca, String Modelo, Planta planta,Registro[] registro) {
        this.NroID = NroID;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.planta = planta;
        this.registro=registro;
    }

    public String getNroID() {
        return NroID;
    }

    public String getMarca() {
        return Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setNroID(String NroID) {
        this.NroID = NroID;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }        

    public Registro[] getRegistro() {
        return registro;
    }

    public void setRegistro(Registro[] registro) {
        this.registro = registro;
    }
    
    
}

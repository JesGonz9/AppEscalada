package elements;

import java.io.Serializable;

public class Escuela implements Serializable {

    // Atributos
    private int idEscuela = -1;
    private String nombre = "";
    private String tipoRoca = "";
    private String provincia = "";
    private String localizacion = "";

    // Constructor
    public Escuela(int idEscuela, String nombre, String tipoRoca, String provincia, String localizacion) {
        this.idEscuela = idEscuela;
        this.nombre = nombre;
        this.tipoRoca = tipoRoca;
        this.provincia = provincia;
        this.localizacion = localizacion;
    }

    // Metodos
    public int getNumSectores() {
        return 0;
    }

    public int getId() {
        return this.idEscuela;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getTipoRoca() {
        return this.tipoRoca;
    }

    public String getProvincia() {
        return this.provincia;
    }

    public String getLocalizacion() {
        return this.localizacion;
    }
}

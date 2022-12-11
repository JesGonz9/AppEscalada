package elements;

public class Escuela {

    // Atributos
    private String nombre = "";
    private String tipoRoca = "";
    private String provincia = "";
    private String localizacion = "";

    // Constructor
    public Escuela(String nombre, String tipoRoca, String provincia, String localizacion) {
        this.nombre = nombre;
        this.tipoRoca = tipoRoca;
        this.provincia = provincia;
        this.localizacion = localizacion;
    }

    // Metodos
    public int getNumSectores() {
        return 0;
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

package elements;

// Clase que almacena todos los datos de un sector devueltos por la BD

public class Sector {

    // Atributos
    private int idSector = -1;
    private String nombre = "";
    private String tipoEscalada = "";

    // Constructor
    public Sector(int idSector, String nombre, String tipoEscalada) {
        this.idSector = idSector;
        this.nombre = nombre;
        this.tipoEscalada = tipoEscalada;
    }

    // GETTERS y SETTERS
    public String getNombre() {
        return this.nombre;
    }

    public String getTipoEscalada() {
        return this.tipoEscalada;
    }

    // METODOS
    public String getRangoGrado() {
        return "6a - 8a";
    }

    public int getTotalVias() {

        return 0;
    }
}

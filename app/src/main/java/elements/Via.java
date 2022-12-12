package elements;

public class Via {

    private int idVia = -1;
    private String nombre = "";
    private String grado = "";
    private int longitud = 0;
    private int numChapas = 0;
    private int numReuniones = 0;
    private int pegues = 0;
    private String descriptReunion = "";
    private int proyecto = 0;
    private int favorita = 0;
    private int idSector = 0;

    public Via(int idVia, String nom, String grado, int longitud, int numChapas, int numReuniones, String descriptReunion, int pegues, int proyecto, int favorita, int idSector) {
        this.nombre = nom;
        this.grado = grado;
        this.longitud = longitud;
        this.numChapas = numChapas;
        this.numReuniones = numReuniones;
        this.descriptReunion = descriptReunion;
        this.pegues = pegues;
        this.proyecto = proyecto;
        this.favorita = favorita;
        this.idSector = idSector;
    }

    // GETTERS Y SETTERS
    public int getIdVia() {
        return idVia;
    }

    public void setIdVia(int idVia) {
        this.idVia = idVia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getNumChapas() {
        return numChapas;
    }

    public void setNumChapas(int numChapas) {
        this.numChapas = numChapas;
    }

    public int getNumReuniones() {
        return numReuniones;
    }

    public void setNumReuniones(int numReuniones) {
        this.numReuniones = numReuniones;
    }

    public int getPegues() {
        return pegues;
    }

    public void setPegues(int pegues) {
        this.pegues = pegues;
    }

    public String getDescriptReunion() {
        return descriptReunion;
    }

    public void setDescriptReunion(String descriptReunion) {
        this.descriptReunion = descriptReunion;
    }

    public int getProyecto() {
        return proyecto;
    }

    public void setProyecto(int proyecto) {
        this.proyecto = proyecto;
    }

    public int getFavorita() {
        return favorita;
    }

    public void setFavorita(int favorita) {
        this.favorita = favorita;
    }

    public int getIdSector() {
        return idSector;
    }

    public void setIdSector(int idSector) {
        this.idSector = idSector;
    }
}

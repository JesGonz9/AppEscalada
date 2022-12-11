package elements;

public class Via {

    private String nom = "";
    private String grado = "";
    private int longitud = 0;
    private int numChapas = 0;
    private int numReuniones = 0;
    private int pegues = 0;
    private String descriptReunion = "";
    private int proyecto = 0;
    private int favorita = 0;
    private int idSector = 0;

    public Via(String nom, String grado, int longitud, int numChapas, int numReuniones, String descriptReunion, int pegues, int proyecto, int favorita, int idSector) {
        this.nom = nom;
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




}

package dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import elements.Sector;
import elements.Via;


public class ViasDB extends SQLiteOpenHelper {

    // Definicion de la base de datos
    private static final String DB_NAME = "climbingRoutes";
    private static final String TABLE_ESCUELAS = "escuelas";
    private static final String TABLE_SECTORES = "sectores";
    private static final String TABLE_VIAS = "vias";
    private static final String TABLE_ENCADENES = "encadenes";
    private static final String TABLE_COMENTARIOS = "comentarios";
    private static int version = 1;

    // Constructor
    public ViasDB(Context context) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Crear la tabla ESCUELAS
        db.execSQL("create table if not exists " + TABLE_ESCUELAS + "(" +
                "idEscuela integer primary key autoincrement, " +
                "nomEscuela varchar, " +
                "tipoRoca varchar, " +
                "provincia varchar, " +
                "localizacion varchar)");

        // Crear la tabla SECTORES
        db.execSQL("create table if not exists " + TABLE_SECTORES + "(" +
                "idSector integer primary key autoincrement, " +
                "nomSector varchar, " +
                "tipoEscalada varchar, " +
                "idEscuela integer, " +
                "foreign key(idEscuela) references " + TABLE_ESCUELAS + "(idEscuela))");

        // Crear la tabla VIAS
        db.execSQL("create table if not exists " + TABLE_VIAS + " (" +
                "idVia integer primary key autoincrement, " +
                "nomVia varchar, " +
                "grado varchar, " +
                "longitud integer, " +
                "numChapas integer, " +
                "numReuniones integer, " +
                "descriptReunion varchar, " +
                "pegues integer, " +
                "proyecto boolean, " +
                "favorita boolean, " +
                "idSector integer, foreign key (idSector) references " + TABLE_SECTORES + "(idSector))");

        // Crear la tabla ENCADENES
        db.execSQL("create table if not exists " + TABLE_ENCADENES + " (" +
                "idEncadene integer primary key autoincrement, " +
                "pegues integer, " +
                "fecha date, " +
                "idVia integer, " +
                "foreign key(idVia) references " + TABLE_VIAS + "(idVia))");

        // Crear la table COMENTARIOS
        db.execSQL("create table if not exists " + TABLE_COMENTARIOS + "(" +
                "idComentario integer primary key autoincrement, " +
                "fecha date, " +
                "contenido varchar, " +
                "idVia integer, " +
                "foreign key(idVia) references " + TABLE_VIAS + "(idVia))");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("drop table if exists " + TABLE_ESCUELAS);
        db.execSQL("drop table if exists " + TABLE_SECTORES);
        db.execSQL("drop table if exists " + TABLE_VIAS);
        db.execSQL("drop table if exists " + TABLE_ENCADENES);
        db.execSQL("drop table if exists " + TABLE_COMENTARIOS);

        onCreate(db);
    }

    // Añadir una escuela nueva
    public void addEscuela(String nombre,String tipoRoca, String provincia, String localizacion) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("nomEscuela", nombre);
        cv.put("tipoRoca", tipoRoca);
        cv.put("provincia", provincia);
        cv.put("localizacion", localizacion);

        db.insert(TABLE_ESCUELAS, null, cv);
    }

    // Añadir un sector nuevo
    public void addSector(String nombre, String tipoEscalada, int idEscuela) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("nomSector", nombre);
        cv.put("tipoEscalada", tipoEscalada);
        cv.put("idEscuela", idEscuela);

        db.insert(TABLE_SECTORES, null, cv);
    }

    // Añadir una via nueva
    public void addVia(String nombre, String grado, int longitud, int numChapas, int numReuniones, String tipoReunion,
                       int pegues, boolean proyecto, boolean favorita, int idSector) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("nomVia", nombre);
        cv.put("grado", grado);
        cv.put("longitud", longitud);
        cv.put("numChapas", numChapas);
        cv.put("numReuniones", numReuniones);
        cv.put("descriptReunion", tipoReunion);
        cv.put("pegues", pegues);
        cv.put("proyecto", proyecto);
        cv.put("favorita", favorita);
        cv.put("idSector", idSector);

        db.insert(TABLE_VIAS, null, cv);
    }

    // Metodo que devuelve un arrayList con todas las vías del sector indicado partir del id¿?
    // Devuelve null en caso de que el sector no exista
    public ArrayList<Via> getVias (int idSectorBuscar) {

        ArrayList<Via> vias = new ArrayList<Via>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM via NATURAL JOIN sector WHERE idSector = " + idSectorBuscar, null);
        if(!cursor.moveToFirst()) return null;

        do {

            int idViaPos = cursor.getColumnIndex("idVia");
            int nomPos = cursor.getColumnIndex("nomVia");
            int gradoPos = cursor.getColumnIndex("grado");
            int longitudPos = cursor.getColumnIndex("longitud");
            int numChapasPos = cursor.getColumnIndex("numChapas");
            int numReunionesPos = cursor.getColumnIndex("numReuniones");
            int descriptReunionPos = cursor.getColumnIndex("descriptReunion");
            int peguesPos = cursor.getColumnIndex("pegues");
            int proyectoPos = cursor.getColumnIndex("proyecto");
            int favoritaPos = cursor.getColumnIndex("favorita");
            int idSectorPos = cursor.getColumnIndex("idSector");

            int idVia = cursor.getInt(idViaPos);
            String nom = cursor.getString(nomPos);
            String grado = cursor.getString(gradoPos);
            int longitud = cursor.getInt(longitudPos);
            int numChapas = cursor.getInt(numChapasPos);
            int numReuniones = cursor.getInt(numReunionesPos);
            String descriptReunion = cursor.getString(descriptReunionPos);
            int pegues = cursor.getInt(peguesPos);
            int proyecto = cursor.getInt(proyectoPos);
            int favorita = cursor.getInt(favoritaPos);
            int idSector = cursor.getInt(idSectorPos);


            vias.add(new Via(idVia, nom, grado, longitud, numChapas, numReuniones, descriptReunion, pegues, proyecto, favorita, idSector));

        } while(cursor.moveToNext());

        return vias;
    }

    // Devuelve la escuela a partir del id

    // Devuelve un ArrayList de los sectores que contiene la escuela que le indiquemos con el id
    public ArrayList<Sector> getSectores(int idEscuelaBuscar) {

        ArrayList<Sector> sectores = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM sectores NATURAL JOIN escuelas WHERE idEscuela = " + idEscuelaBuscar, null);

        if(!cursor.moveToFirst()) return null;

        do {

            int idSectorPos = cursor.getColumnIndex("idSector");
            int nombrePos = cursor.getColumnIndex("nombreSector");
            int tipoEscaladaPos = cursor.getColumnIndex("tipoEscalada");

            int idSector = cursor.getInt(idSectorPos);
            String nombre = cursor.getString(nombrePos);
            String tipoEscalasa = cursor.getString(tipoEscaladaPos);

            sectores.add(new Sector(idSector, nombre, tipoEscalasa));

        } while(cursor.moveToNext());

        return sectores;
    }

}

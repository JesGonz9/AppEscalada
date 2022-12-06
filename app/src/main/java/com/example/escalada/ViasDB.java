package com.example.escalada;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class ViasDB extends SQLiteOpenHelper {

    // Definicion de la base de datos
    private static final String DB_NAME = "climbingRoutes";
    private static final String TABLE_ESCUELAS = "escuelas";
    private static final String TABLE_SECTORES = "sectores";
    private static final String TABLE_VIAS = "vias";
    private static final String TABLE_ENCADENES = "encadenes";
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
                "nombre varchar, " +
                "tipoRoca, " +
                "provincia varchar, " +
                "localizacion varchar)");

        // Crear la tabla SECTORES
        db.execSQL("create table if not exists " + TABLE_SECTORES + "(" +
                "idSector integer primary key autoincrement, " +
                "nombre varchar, " +
                "tipoEscalada, " +
                "idEscuela integer, " +
                "foreign key(idEscuela) references " + TABLE_ESCUELAS + "(idEscuela))");

        // Crear la tabla VIAS
        db.execSQL("create table if not exists " + TABLE_VIAS + " (" +
                "idVia integer primary key autoincrement, " +
                "nombre varchar, " +
                "grado varchar, " +
                "longitud integer, " +
                "numChapas integer, " +
                "numReuniones, " +
                "descriptReunion, " +
                "comentario varchar, " +
                "idSector integer, foreign key (idSector) references " + TABLE_SECTORES + "(idSector))");

        // Crear la tabla ENCADENES
        db.execSQL("create table if not exists " + TABLE_ENCADENES + " (" +
                "idEncadene integer primary key autoincrement, " +
                "pegues integer, " +
                "comentario varchar, " +
                "idVia integer, " +
                "foreign key(idVia) references " + TABLE_VIAS + "(idVia))");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        /*
        db.execSQL("drop table if exists " + TABLE_ESCUELAS);
        db.execSQL("drop table if exists " + TABLE_SECTORES);
        db.execSQL("drop table if exists " + TABLE_VIAS);
        db.execSQL("drop table if exists " + TABLE_ENCADENES);
         */
    }

    // Añadir una escuela nueva
    public void addEscuela(String nombre, String provincia, String localizacion) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("nombre", nombre);
        cv.put("provincia", provincia);
        cv.put("localizacion", localizacion);

        db.insert(TABLE_ESCUELAS, null, cv);
    }
}

package com.example.escalada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import dataBase.ViasDB;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* TODO
            asignar correctamente las claves ajenas
            Metodos para obtener los datos de los sectores mostrados en la activity escuelas
            Cuando clicke en un sector, se abra mostrando todas las escuelas
            al hacer click en una escuela, que se abra escuelasActivity
        */

        // Instanciar base de datos
        ViasDB viasDB = new ViasDB(this);

        // Boton de ver escuelas (prueba)
        Button btnEscuelas = findViewById(R.id.maBtnVerEscuelas);
        btnEscuelas.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), TodasEscuelasActivity.class);
            startActivity(intent);
        });
    }
}
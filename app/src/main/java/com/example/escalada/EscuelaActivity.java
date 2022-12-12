package com.example.escalada;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import adapters.AdapterSectores;
import dataBase.ViasDB;
import elements.Escuela;
import elements.Sector;

public class EscuelaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escuela);

        // Sacar escuela pulsada del intent
        Intent intentData = getIntent();
        Escuela escuelaElegida = (Escuela) intentData.getSerializableExtra("escuela");

        // Si hay algun error en la comunicacion con el intent se muestra en un Toast y se cierra la activity
        if(escuelaElegida == null) {
            Toast.makeText(this, "[LOG] Error. Escuela no encontrada.", Toast.LENGTH_SHORT).show();
            finish();
        }

        // Ponemos los datos de la escuela en la interfaz
        TextView tvNombreEscuela = findViewById(R.id.esTvNomEscuela);
        TextView tvLocalizacionEscuela = findViewById(R.id.esTvLocalizacion);
        TextView tvTipoRoca = findViewById(R.id.esTvTipoRoca);

        tvNombreEscuela.setText(escuelaElegida.getNombre());
        tvLocalizacionEscuela.setText(String.format("%s (%s)", escuelaElegida.getLocalizacion(), escuelaElegida.getProvincia()));
        tvTipoRoca.setText(escuelaElegida.getTipoRoca());

        // Ahora sacamos todos los sectores de la escuela que nos han pasado
        ViasDB db = new ViasDB(this);

        // Solo si no está vacio se genera el adapter
        ArrayList<Sector> sectores;
        //sectores.add(new Sector(1, "Belvedere", "Placa"));

        if((sectores = db.getSectores(escuelaElegida.getId())) != null) {

            // Adapter personalizado
            AdapterSectores adapterSectores = new AdapterSectores(sectores);

            // Instancia del rcv
            RecyclerView rcv = findViewById(R.id.esRcvSectores);

            // Colocarle un layout y el adapter
            rcv.setLayoutManager(new LinearLayoutManager(this));
            rcv.setAdapter(adapterSectores);

            // Agregar listener
            adapterSectores.setOnClickListener(view -> {

                // Abrir la activity sectores con el sector y sus vias correspondientes
                Intent intent = new Intent(this, SectorActivity.class);
                startActivity(intent);
            });

        }


    }
}
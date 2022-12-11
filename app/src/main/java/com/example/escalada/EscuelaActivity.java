package com.example.escalada;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import adapters.AdapterSectores;
import elements.Sector;

public class EscuelaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escuelas);

        // ArrayList prueba
        ArrayList<Sector> sectores = new ArrayList<>();
        sectores.add(new Sector("sector1", "placa desplomada"));
        sectores.add(new Sector("Dios me vino a ver", "Adherencia"));

        // Adapter personalizado
        AdapterSectores adapterSectores = new AdapterSectores(sectores);

        // Instancia del rcv
        RecyclerView rcv = findViewById(R.id.esRcvSectores);

        // Colocarle un layout y el adapter
        rcv.setLayoutManager(new LinearLayoutManager(this));
        rcv.setAdapter(adapterSectores);
    }
}
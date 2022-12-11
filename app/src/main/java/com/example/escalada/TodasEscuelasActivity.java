package com.example.escalada;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import adapters.AdapterEscuelas;
import elements.Escuela;

/*
    En esta activity se mostrara una lista (igual que los sectores) con todas las escuelas guardadas y una breve
    descripcion, al pinchar en una de ellas, se abrirá EscuelaActivity
 */

public class TodasEscuelasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todas_escuelas);

        // Lista de escuelas de prueba
        ArrayList<Escuela> escuelas = new ArrayList<>();
        escuelas.add(new Escuela("Aviados", "Caliza", "León", "Pueblo de Aviados"));

        // Adapter personalizado
        AdapterEscuelas adapterEscuelas = new AdapterEscuelas(escuelas);

        // RCV
        RecyclerView rcv = findViewById(R.id.esRcvEscuelas);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        rcv.setAdapter(adapterEscuelas);

    }
}
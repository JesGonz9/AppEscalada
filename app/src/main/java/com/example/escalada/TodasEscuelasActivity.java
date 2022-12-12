package com.example.escalada;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

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
        escuelas.add(new Escuela(0, "Aviados", "Caliza", "León", "Pueblo de Aviados"));

        // Adapter personalizado
        AdapterEscuelas adapterEscuelas = new AdapterEscuelas(escuelas);

        // RCV
        RecyclerView rcv = findViewById(R.id.esRcvEscuelas);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        rcv.setAdapter(adapterEscuelas);

        // Añadir listener al adapter
        adapterEscuelas.setOnClickListener(view -> {

            // Pasamos directamente la escuela elegida, ahorrandonos una consulta a la BD
            Escuela escuela = escuelas.get(rcv.getChildAdapterPosition(view));

            // Al pulsar en una escuela, se abrira su activity con la info correspondiente
            Intent intent = new Intent(this, EscuelaActivity.class);
            intent.putExtra("escuela", escuela);
            startActivity(intent);
        });


    }

}
package com.example.escalada;

/*
    Esta activity muestra los datos de un sector y todas sus vias
 */

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import adapters.AdapterVias;
import elements.Via;

public class SectorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector);

        //ArrayList con via de prueba
        ArrayList<Via> vias = new ArrayList<>();
        vias.add(new Via(0, "Tres Tristes Tigres", "7a", 35, 20, 2, "mosqueton", 2, 0, 0, 1));

        // RCV
        RecyclerView rcv = findViewById(R.id.secRcvVias);
        rcv.setLayoutManager(new LinearLayoutManager(this));

        // Adapter
        AdapterVias adapterVias = new AdapterVias(vias);

        adapterVias.setOnClickListener(view -> {
            Toast.makeText(this, "Via: " + vias.get(rcv.getChildAdapterPosition(view)).getNombre(), Toast.LENGTH_SHORT).show();
        });

        rcv.setAdapter(adapterVias);
    }
}
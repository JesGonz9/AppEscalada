package com.example.escalada;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViasDB viasDB = new ViasDB(this);
        viasDB.addEscuela("Hoces Free", "León", "Hoces de Vegacervera");
    }
}
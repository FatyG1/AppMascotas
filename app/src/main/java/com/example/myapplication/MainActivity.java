package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
       private Button btMiMascota, btVacunacion, btDesparasitacion, btTto, btHistorial, btMivet, btAlimentacion ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btMiMascota = findViewById(R.id.btMiMascota);
        btVacunacion = findViewById(R.id.btVacunacion);
        btDesparasitacion = findViewById(R.id.btDesparasitacion);
        btTto = findViewById(R.id.brTto);
        btHistorial = findViewById(R.id.btHistorial);
        btMivet = findViewById(R.id.btMiVet);
        btAlimentacion = findViewById(R.id.btAlimentacion);

        btMiMascota.setOnClickListener(this);
        btVacunacion.setOnClickListener(this);
        btDesparasitacion.setOnClickListener(this);
        btTto.setOnClickListener(this);
        btHistorial.setOnClickListener(this);
        btMivet.setOnClickListener(this);
        btAlimentacion.setOnClickListener(this);
        }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btMiMascota:
            Intent intent = new Intent(MainActivity.this, miMascota.class);
            startActivity(intent);
            break;
            case R.id.btVacunacion:
                intent = new Intent(MainActivity.this, Vacunacion.class);
                startActivity(intent);
                break;
            case R.id.btDesparasitacion:
                intent = new Intent(MainActivity.this, Desparasitacion.class);
                startActivity(intent);
                break;
            case R.id.brTto:
                intent = new Intent(MainActivity.this, Tto.class);
                startActivity(intent);
                break;
            case R.id.btHistorial:
                intent = new Intent(MainActivity.this, Historial.class);
                startActivity(intent);
                break;
            case R.id.btMiVet:
                intent = new Intent(MainActivity.this, MiVet.class);
                startActivity(intent);
                break;
            case R.id.btAlimentacion:
                intent = new Intent(MainActivity.this, Alimentacion.class);
                startActivity(intent);
                break;
        }

    }
}
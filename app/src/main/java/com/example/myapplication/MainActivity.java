package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
       private Button btMiMascota, btVacunacion, btDesparasitacion, btTto, btAlimentacion, btHistorial, btMivet ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btMiMascota = findViewById(R.id.btMiMascota);
        btVacunacion = findViewById(R.id.btVacunacion);
        btDesparasitacion = findViewById(R.id.btDesparasitacion);
        btTto = findViewById(R.id.brTto);
        btAlimentacion = findViewById(R.id.btAlimentacion);
        /*btHistorial = findViewById(R.id.btHistorial);
        btMivet = findViewById(R.id.btMiVet);*/

        btMiMascota.setOnClickListener(this);
        btVacunacion.setOnClickListener(this);
        btDesparasitacion.setOnClickListener(this);
        btTto.setOnClickListener(this);
        btAlimentacion.setOnClickListener(this);

       /* btHistorial.setVisibility(View.INVISIBLE);
        btMivet.setVisibility(View.INVISIBLE);*/
        }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btMiMascota:
            Intent intent = new Intent(MainActivity.this, miMascota.class);
            startActivity(intent);
            break;
            case R.id.btVacunacion:
                intent = new Intent(MainActivity.this, vacunacion.class);
                startActivity(intent);
                break;
            case R.id.btDesparasitacion:
                intent = new Intent(MainActivity.this, desparasitacion.class);
                startActivity(intent);
                break;
            case R.id.brTto:
                intent = new Intent(MainActivity.this, tratamiento.class);
                startActivity(intent);
                break;
            case R.id.btAlimentacion:
                intent = new Intent(MainActivity.this, alimentacion.class);
                startActivity(intent);
                break;
        }

    }
}
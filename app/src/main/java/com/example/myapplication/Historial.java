package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Historial extends AppCompatActivity implements View.OnClickListener{
    private EditText etNombreMascota, mlHistorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        etNombreMascota= findViewById(R.id.etNombreMascota);
        mlHistorial = findViewById(R.id.mlHistorial);
    }

    @Override
    public void onClick(View view) {

    }
}
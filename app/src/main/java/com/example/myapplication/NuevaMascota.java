package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.UUID;

public class NuevaMascota extends AppCompatActivity implements View.OnClickListener {
    private EditText etNombre, etChip, etEdad, etRaza, etPeso;
    private RadioButton rbSexM, rbSexH, rbEstS, rbEstN;
    private Button btGuardar, btBorrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_mascota);

        etNombre = findViewById(R.id.etNombre);
        etChip = findViewById(R.id.etChip);
        etEdad = findViewById(R.id.etEdad);
        etRaza = findViewById(R.id.etRaza);
        etPeso = findViewById(R.id.etPeso);
        rbSexM = findViewById(R.id.rbSexM);
        rbSexH = findViewById(R.id.rbSexH);
        rbEstS = findViewById(R.id.rbEstS);
        rbEstN = findViewById(R.id.rbEstN);
        btGuardar = findViewById(R.id.btGuardar);
        btBorrar = findViewById(R.id.btBorrar);

        btGuardar.setOnClickListener(this);
        btBorrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

        }
    }


}
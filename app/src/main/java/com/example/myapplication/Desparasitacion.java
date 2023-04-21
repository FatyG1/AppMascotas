package com.example.myapplication;

import static com.example.myapplication.R.id.btInsertarDesp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Desparasitacion extends AppCompatActivity implements View.OnClickListener{

        private EditText etNombreDesp, etDosisDesp, etFrecuenciaDesp;
        private Button btInsertarDesp;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desparasitacion);

        etNombreDesp = findViewById(R.id.etNombreDesp);
        etDosisDesp = findViewById(R.id.etDosisDesp);
        etFrecuenciaDesp = findViewById(R.id.etFrecuenciaDesp);
        btInsertarDesp = findViewById(R.id.btInsertarDesp);

        btInsertarDesp.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

    }
}
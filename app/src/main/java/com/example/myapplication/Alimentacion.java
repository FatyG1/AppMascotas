package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Alimentacion extends AppCompatActivity implements View.OnClickListener{
    private EditText etTipo, etCantidad, etTomas;
    private Button btInsertar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimentacion);

        etTipo = findViewById(R.id.etTipo);
        etCantidad = findViewById(R.id.etCantidad);
        etTomas = findViewById(R.id.etTomas);
        btInsertar = findViewById(R.id.btinsertar);

        btInsertar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

    }
}
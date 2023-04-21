package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class miMascota extends AppCompatActivity implements View.OnClickListener{
    private Button btNueva;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_mascota);

        btNueva = findViewById(R.id.btNueva);

        btNueva.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btNueva:
                Intent intent = new Intent(miMascota.this, NuevaMascota.class);
                startActivity(intent);
                break;

        }
    }
}
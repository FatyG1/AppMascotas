package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Adaptadores.ListaTratamientoAdapter;
import com.example.myapplication.Adaptadores.ListaVacunacionAdapter;
import com.example.myapplication.db.dbMascota;

import java.util.ArrayList;

public class tratamiento extends AppCompatActivity implements View.OnClickListener {
    private Button btNuevoTto;
    private RecyclerView rwTratamiento;

    private String nombreMascota;
    private String nombreTto;
    private String usoTto;
    private String dosisTto;
    private String frecuenciaTto;
    private String duracionTto;
    private ArrayList<tratamiento> listaArrayTratamiento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tratamiento);

        rwTratamiento = findViewById(R.id.rwTratamiento);
        btNuevoTto = findViewById(R.id.btNuevoTto);

        rwTratamiento.setLayoutManager(new LinearLayoutManager(this));
        btNuevoTto.setOnClickListener(this);

        dbMascota DbMascota = new dbMascota(this);

        listaArrayTratamiento = new ArrayList<>();

        ListaTratamientoAdapter adapter = new ListaTratamientoAdapter(DbMascota.mostrarTratamiento());

        rwTratamiento.setAdapter(adapter);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btNuevoTto:
                Intent intent = new Intent(tratamiento.this, NuevoTto.class);
                startActivity(intent);
                break;
        }
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getNombreTto() {
        return nombreTto;
    }

    public void setNombreTto(String nombreTto) {
        this.nombreTto = nombreTto;
    }

    public String getUsoTto() {
        return usoTto;
    }

    public void setUsoTto(String usoTto) {
        this.usoTto = usoTto;
    }

    public String getDosisTto() {
        return dosisTto;
    }

    public void setDosisTto(String dosisTto) {
        this.dosisTto = dosisTto;
    }

    public String getFrecuenciaTto() {
        return frecuenciaTto;
    }

    public void setFrecuenciaTto(String frecuenciaTto) {
        this.frecuenciaTto = frecuenciaTto;
    }

    public String getDuracionTto() {
        return duracionTto;
    }

    public void setDuracionTto(String duracionTto) {
        this.duracionTto = duracionTto;
    }

}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Adaptadores.ListaAlimentacionAdapter;
import com.example.myapplication.Adaptadores.ListaVacunacionAdapter;
import com.example.myapplication.db.dbMascota;

import java.util.ArrayList;

public class vacunacion extends AppCompatActivity implements View.OnClickListener {
    private Button btNuevaVac;
    private RecyclerView rwVacunacion;

    private String nombreMascota;
    private String nombreVac;
    private String FrecuenciaVac;
    private String FechaVac;
    private String FechaProxVac;
    private ArrayList<vacunacion> listaArrayVacunacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacunacion);

        rwVacunacion = findViewById(R.id.rwVacunacion);
        btNuevaVac = findViewById(R.id.btNuevaVac);

        rwVacunacion.setLayoutManager(new LinearLayoutManager(this));
        btNuevaVac.setOnClickListener(this);

        dbMascota DbMascota = new dbMascota(this);

        listaArrayVacunacion = new ArrayList<>();

        ListaVacunacionAdapter adapter = new ListaVacunacionAdapter(DbMascota.mostrarVacunacion());

        rwVacunacion.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btNuevaVac:
                Intent intent = new Intent(vacunacion.this, NuevaVacunacion.class);
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

    public String getNombreVac() {
        return nombreVac;
    }

    public void setNombreVac(String nombreVac) {
        this.nombreVac = nombreVac;
    }

    public String getFrecuenciaVac() {
        return FrecuenciaVac;
    }

    public void setFrecuenciaVac(String frecuenciaVac) {
        FrecuenciaVac = frecuenciaVac;
    }

    public String getFechaVac() {
        return FechaVac;
    }

    public void setFechaVac(String fechaVac) {
        FechaVac = fechaVac;
    }

    public String getFechaProxVac() {
        return FechaProxVac;
    }

    public void setFechaProxVac(String fechaProxVac) {
        FechaProxVac = fechaProxVac;
    }
}
package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adaptadores.ListaDesparasitacionAdapter;
import com.example.myapplication.Adaptadores.ListaVacunacionAdapter;
import com.example.myapplication.db.dbMascota;

import java.util.ArrayList;

public class desparasitacion extends AppCompatActivity implements View.OnClickListener {
    private Button btNuevaDesp;
    private RecyclerView rwDesparasitacion;

    private String nombreMascota;
    private String nombreDesp;
    private String frecuenciaDesp;
    private String tipoDesp;
    private String dosisDesp;
    private String fechaDesp;
    private String fechaProxDesp;
    private ArrayList<desparasitacion> listaArrayDesparasitacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desparasitacion);

        rwDesparasitacion = findViewById(R.id.rwDesparasitacion);
        btNuevaDesp = findViewById(R.id.btNuevaDesp);

        rwDesparasitacion.setLayoutManager(new LinearLayoutManager(this));
        btNuevaDesp.setOnClickListener(this);

        dbMascota DbMascota = new dbMascota(this);

        listaArrayDesparasitacion = new ArrayList<>();

        ListaDesparasitacionAdapter adapter = new ListaDesparasitacionAdapter(DbMascota.mostrarDesparasitacion());

        rwDesparasitacion.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btNuevaDesp:
                Intent intent = new Intent(desparasitacion.this, NuevaDesparasitacion.class);
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

    public String getNombreDesp() {
        return nombreDesp;
    }

    public void setNombreDesp(String nombreDesp) {
        this.nombreDesp = nombreDesp;
    }

    public String getFrecuenciaDesp() {
        return frecuenciaDesp;
    }

    public void setFrecuenciaDesp(String frecuenciaDesp) {
        this.frecuenciaDesp = frecuenciaDesp;
    }

    public String getTipoDesp() {
        return tipoDesp;
    }

    public void setTipoDesp(String tipoDesp) {
        this.tipoDesp = tipoDesp;
    }

    public String getFechaDesp() {
        return fechaDesp;
    }

    public void setFechaDesp(String fechaDesp) {
        this.fechaDesp = fechaDesp;
    }

    public String getFechaProxDesp() {
        return fechaProxDesp;
    }

    public void setFechaProxDesp(String fechaProxDesp) {
        this.fechaProxDesp = fechaProxDesp;
    }

    public String getDosisDesp() {
        return dosisDesp;
    }

    public void setDosisDesp(String dosisDesp) {
        this.dosisDesp = dosisDesp;
    }
}
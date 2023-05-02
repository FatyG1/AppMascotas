package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Adaptadores.ListaAlimentacionAdapter;
import com.example.myapplication.Adaptadores.ListaMascotaAdapter;
import com.example.myapplication.db.dbMascota;

import java.util.ArrayList;

public class alimentacion extends AppCompatActivity implements View.OnClickListener{
    private Button btNuevaAlim;
    private RecyclerView rwAlimentacion;

    private String nombreMascota;
    private String nombreAlimen;
    private String tipoAlimen;
    private String cantidadAlimen;
    private String tomasAlimen;
    private ArrayList<alimentacion> listaArrayAlimentacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimentacion);

        rwAlimentacion = findViewById(R.id.rwAlimentacion);
        btNuevaAlim = findViewById(R.id.btNuevaAlim);

        rwAlimentacion.setLayoutManager(new LinearLayoutManager(this));
        btNuevaAlim.setOnClickListener(this);

        dbMascota DbMascota = new dbMascota(this);

        listaArrayAlimentacion = new ArrayList<>();

        ListaAlimentacionAdapter adapter = new ListaAlimentacionAdapter(DbMascota.mostrarAlimentacion());

        rwAlimentacion.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btNuevaAlim:
                Intent intent = new Intent(alimentacion.this, NuevaAlimentacion.class);
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

    public String getNombreAlimen() {
        return nombreAlimen;
    }

    public void setNombreAlimen(String nombreAlimen) {
        this.nombreAlimen = nombreAlimen;
    }

    public String getTipoAlimen() {
        return tipoAlimen;
    }

    public void setTipoAlimen(String tipoAlimen) {
        this.tipoAlimen = tipoAlimen;
    }

    public String getCantidadAlimen() {
        return cantidadAlimen;
    }

    public void setCantidadAlimen(String cantidadAlimen) {
        this.cantidadAlimen = cantidadAlimen;
    }

    public String getTomasAlimen() {
        return tomasAlimen;
    }

    public void setTomasAlimen(String tomasAlimen) {
        this.tomasAlimen = tomasAlimen;
    }
}
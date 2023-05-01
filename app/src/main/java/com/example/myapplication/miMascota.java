package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Adaptadores.ListaMascotaAdapter;
import com.example.myapplication.db.dbMascota;

import java.util.ArrayList;

public class miMascota extends AppCompatActivity implements View.OnClickListener{
    private Button btNueva;
    private RecyclerView rwMascota;
    private ArrayList<miMascota> listaArraymascotas;
    private String nombre;
    private String chip;
    private String edad;
    private String raza;
    private String peso;
    private String sexo;
    private String esterilizado;
    private String nombreAlimen;
    private String nombreDesp;
    private String proxDesp;
    private String nombreTto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_mascota);

        rwMascota = findViewById(R.id.rwMascota);
        btNueva = findViewById(R.id.btNueva);

        rwMascota.setLayoutManager(new LinearLayoutManager(this));
        btNueva.setOnClickListener(this);

        dbMascota DbMascota = new dbMascota(this);

        listaArraymascotas = new ArrayList<>();

        ListaMascotaAdapter adapter = new ListaMascotaAdapter(DbMascota.mostrarMascotas());

        rwMascota.setAdapter(adapter);

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

    public Button getBtNueva() {
        return btNueva;
    }

    public void setBtNueva(Button btNueva) {
        this.btNueva = btNueva;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getEsterilizado() {
        return esterilizado;
    }

    public void setEsterilizado(String esterilizado) {
        this.esterilizado = esterilizado;
    }

    public String getNombreAlimen() {
        return nombreAlimen;
    }

    public void setNombreAlimen(String nombreAlimen) {
        this.nombreAlimen = nombreAlimen;
    }

    public String getNombreDesp() {
        return nombreDesp;
    }

    public void setNombreDesp(String nombreDesp) {
        this.nombreDesp = nombreDesp;
    }

    public String getProxDesp() {
        return proxDesp;
    }

    public void setProxDesp(String proxDesp) {
        this.proxDesp = proxDesp;
    }

    public String getNombreTto() {
        return nombreTto;
    }

    public void setNombreTto(String nombreTto) {
        this.nombreTto = nombreTto;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
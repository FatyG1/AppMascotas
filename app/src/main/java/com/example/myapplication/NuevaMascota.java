package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.db.dbHelper;
import com.example.myapplication.db.dbMascota;

import java.util.UUID;

public class NuevaMascota extends AppCompatActivity  implements View.OnClickListener {
    private EditText etNombre, etChip, etEdad, etRaza, etPeso, etSexo, etEsterilizado;
    private TextView tvNuevaMascota;
    private Button btGuardar, btBorrar, btModificar;

    miMascota mascota;
    String chip = null;
    String nombre= null;

    boolean correcto =false;
    dbMascota DbMascotas = new dbMascota(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_mascota);

        tvNuevaMascota = findViewById(R.id.tvNuevaMascota);
        etNombre = findViewById(R.id.etNombre);
        etChip = findViewById(R.id.etChip);
        etEdad = findViewById(R.id.etEdad);
        etRaza = findViewById(R.id.etRaza);
        etPeso = findViewById(R.id.etPeso);
        etEsterilizado = findViewById(R.id.etEsterilizado);
        etSexo = findViewById(R.id.etSexo);
        btGuardar = findViewById(R.id.btGuardar);
        btBorrar = findViewById(R.id.btBorrar);
        btModificar = findViewById(R.id.btModificar);

        btGuardar.setOnClickListener(this);
        btBorrar.setOnClickListener(this);
        btModificar.setOnClickListener(this);

        btModificar.setVisibility(View.INVISIBLE);
        btBorrar.setVisibility(View.INVISIBLE);

        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if(extras == null){
                nombre = null;
            }else {
                nombre = extras.getString("NOMBRE");
            }
        }else{
            nombre = (String) savedInstanceState.getSerializable("NOMBRE");
        }
        dbMascota DBMascota = new dbMascota(NuevaMascota.this);
        mascota = DBMascota.verMascotas(nombre);

        if(mascota != null){
            etNombre.setText(mascota.getNombre());
            etChip.setText(mascota.getChip());
            etEdad.setText(mascota.getEdad());
            etRaza.setText(mascota.getRaza());
            etPeso.setText(mascota.getPeso());
            etEsterilizado.setText(mascota.getEsterilizado());
            etSexo.setText(mascota.getSexo());
            btGuardar.setVisibility(View.INVISIBLE);
            btModificar.setVisibility(View.VISIBLE);
            btBorrar.setVisibility(View.VISIBLE);
            tvNuevaMascota.setText("EDITAR MASCOTA");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.btGuardar):
                //crea la bd
                dbHelper DbHelper= new dbHelper(this);
                SQLiteDatabase db = DbHelper.getWritableDatabase();

                // Inserta datos
                long id= DbMascotas.insertarMascota(etNombre.getText().toString(), etChip.getText().toString(), etEdad.getText().toString(),
                        etRaza.getText().toString(), etPeso.getText().toString(), etSexo.getText().toString(), etEsterilizado.getText().toString());

                if(id>0){
                    Toast.makeText(this, "Mascota guardada", Toast.LENGTH_LONG).show();
                    limpiar();
                }else{
                    Toast.makeText(this, "Error al guardar la mascota", Toast.LENGTH_LONG).show();
                }
                break;

            case(R.id.btModificar):
                if(!etNombre.getText().toString().equals("")){
                    correcto= DbMascotas.editarMascota(etNombre.getText().toString(), etChip.getText().toString(), etEdad.getText().toString(), etRaza.getText().toString(), etPeso.getText().toString(), etEsterilizado.getText().toString(), etSexo.getText().toString());
                    if(correcto){
                        Toast.makeText(NuevaMascota.this, "MASCOTA MODIFICADA", Toast.LENGTH_LONG).show();
                        verRegistro();
                    }else{
                        Toast.makeText(NuevaMascota.this, "ERROR AL MODIFICAR LA MASCOTA", Toast.LENGTH_LONG).show();
                    }
                }
                break;

            case(R.id.btBorrar):
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("¿Desea eliminar la mascota?").setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       if(DbMascotas.borrarMascota(nombre)){
                            verRegistro();
                       }
                    }
                }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                }).show();
                break;
            }
        }

    private void limpiar(){
        etChip.setText("");
        etNombre.setText("");
        etEdad.setText("");
        etRaza.setText("");
        etSexo.setText("");
        etEsterilizado.setText("");
        etPeso.setText("");
    }
    public void verRegistro(){
        Intent intent = new Intent(this, miMascota.class );
        startActivity(intent);
    }

}
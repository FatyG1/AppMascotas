package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class NuevoTto extends AppCompatActivity implements View.OnClickListener {
    private EditText etNombreMascota, etNombreTto, etDosisTto, etFrecuenciaTto, etUsoTto, etDuracionTto;
    private TextView tvNuevoTto;
    private Button btInsertarTto, btBorrar, btModificar;

    tratamiento tto;
    String nombreMascota= null;
    String nombreTto = null;
    boolean correcto =false;

    dbMascota DbMascotas = new dbMascota(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_tto);

        tvNuevoTto = findViewById(R.id.tvNuevoTto);
        etNombreMascota = findViewById(R.id.etNombreMascota);
        etNombreTto = findViewById(R.id.etNombreTto);
        etDosisTto = findViewById(R.id.etDosisTto);
        etFrecuenciaTto = findViewById(R.id.etFrecuenciaTto);
        etUsoTto = findViewById(R.id.etUsoTto);
        etDuracionTto = findViewById(R.id.etDuracionTto);
        btInsertarTto= findViewById(R.id.btInsertarTto);
        btBorrar = findViewById(R.id.btBorrar);
        btModificar = findViewById(R.id.btModificar);

        btInsertarTto.setOnClickListener(this);
        btBorrar.setOnClickListener(this);
        btModificar.setOnClickListener(this);

        btModificar.setVisibility(View.INVISIBLE);
        btBorrar.setVisibility(View.INVISIBLE);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                nombreMascota = null;
                nombreTto = null;
            } else {
                nombreMascota = extras.getString("NOMBREMASCOTA");
                nombreTto = extras.getString("NOMBRETTO");
            }
        } else {
            tto = (tratamiento) savedInstanceState.getSerializable("NOMBREMASCOTA");
            tto = (tratamiento) savedInstanceState.getSerializable("NOMBRETTO");
        }
        dbMascota DBMascota = new dbMascota(this);
        tto = DBMascota.verTto(nombreMascota, nombreTto);

        if (tto != null) {
            etNombreMascota.setText(tto.getNombreMascota());
            etNombreTto.setText(tto.getNombreTto());
            etDosisTto.setText(tto.getDosisTto());
            etFrecuenciaTto.setText(tto.getFrecuenciaTto());
            etUsoTto.setText(tto.getUsoTto());
            etDuracionTto.setText(tto.getDuracionTto());

            btInsertarTto.setVisibility(View.INVISIBLE);
            btModificar.setVisibility(View.VISIBLE);
            btBorrar.setVisibility(View.VISIBLE);
            tvNuevoTto.setText("EDITAR TRATAMIENTO");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.btInsertarTto):
                //crea la bd
                dbHelper DbHelper= new dbHelper(this);
                SQLiteDatabase db = DbHelper.getWritableDatabase();

                // Inserta datos
                long id = DbMascotas.insertarTto(etNombreMascota.getText().toString(), etNombreTto.getText().toString(), etDosisTto.getText().toString(), etFrecuenciaTto.getText().toString(),
                        etUsoTto.getText().toString(), etDuracionTto.getText().toString());

                if (id > 0) {
                    Toast.makeText(this, "Tratamiento guardada", Toast.LENGTH_LONG).show();
                    limpiar();
                } else {
                    Toast.makeText(this, "Error al guardar la tratamiento", Toast.LENGTH_LONG).show();
                }
                break;
            case(R.id.btModificar):
                if(!etNombreMascota.getText().toString().equals("") && !etNombreTto.getText().toString().equals("")){
                    correcto= DbMascotas.editarTto(etNombreMascota.getText().toString(), etNombreTto.getText().toString(), etDosisTto.getText().toString(), etFrecuenciaTto.getText().toString(),
                            etUsoTto.getText().toString(), etDuracionTto.getText().toString());

                    if(correcto){
                        Toast.makeText(this, "TRATAMIENTO MODIFICADO", Toast.LENGTH_LONG).show();
                        verRegistro();
                    }else{
                        Toast.makeText(this, "ERROR AL MODIFICAR EL TRATAMIENTO", Toast.LENGTH_LONG).show();
                    }
                }
                break;

            case(R.id.btBorrar):
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("¿Desea eliminar el tratamiento?").setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(DbMascotas.borrarTto(nombreMascota, nombreTto)){
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
        etNombreMascota.setText("");
        etNombreTto.setText("");
        etDosisTto.setText("");
        etFrecuenciaTto.setText("");
        etUsoTto.setText("");
        etDuracionTto.setText("");
    }
    public void verRegistro(){
        Intent intent = new Intent(this,tratamiento.class );
        startActivity(intent);
    }
}
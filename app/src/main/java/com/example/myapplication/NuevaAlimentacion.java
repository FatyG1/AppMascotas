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
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NuevaAlimentacion extends AppCompatActivity implements View.OnClickListener {
    private EditText etNombreMascota, etNombreAlimen, etTipoAlimen, etCantidadAlimen, etTomasAlimen;
    private TextView tvNuevaAlimentacion;
    //private Button btInsertarAlimen, btBorrar, btModificar;
    FloatingActionButton btModificar, btBorrar, btInsertarAlimen;

    alimentacion alimento;
    String nombreMascota= null;
    String nombreAlimen = null;
    boolean correcto =false;

    dbMascota DbMascotas = new dbMascota(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_alimentacion);

        tvNuevaAlimentacion = findViewById(R.id.tvNuevaAlimentacion);
        etNombreMascota = findViewById(R.id.etNombreMascota);
        etNombreAlimen = findViewById(R.id.etNombreAlimen);
        etTipoAlimen = findViewById(R.id.etTipoAlimen);
        etCantidadAlimen = findViewById(R.id.etCantidadAlimen);
        etTomasAlimen = findViewById(R.id.etTomasAlimen);
        btInsertarAlimen = findViewById(R.id.btInsertarAlimen);
        btBorrar = findViewById(R.id.btBorrar);
        btModificar = findViewById(R.id.btModificar);

        btInsertarAlimen.setOnClickListener(this);
        btBorrar.setOnClickListener(this);
        btModificar.setOnClickListener(this);

        btModificar.setVisibility(View.INVISIBLE);
        btBorrar.setVisibility(View.INVISIBLE);

        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if(extras == null){
                nombreMascota = null;
                nombreAlimen = null;
            }else {
                nombreMascota = extras.getString("NOMBREMASCOTA");
                nombreAlimen = extras.getString("NOMBREALIMEN");
            }
        }else{
            alimento = (alimentacion) savedInstanceState.getSerializable("NOMBREMASCOTA");
            alimento = (alimentacion) savedInstanceState.getSerializable("NOMBREALIMEN");
        }
        dbMascota DBMascota = new dbMascota(this);
        alimento = DBMascota.verAlimentacion(nombreMascota, nombreAlimen);

        if(alimento != null){
            etNombreMascota.setText(alimento.getNombreMascota());
            etNombreAlimen.setText(alimento.getNombreAlimen());
            etTipoAlimen.setText(alimento.getTipoAlimen());
            etCantidadAlimen.setText(alimento.getCantidadAlimen());
            etTomasAlimen.setText(alimento.getTomasAlimen());

            btInsertarAlimen.setVisibility(View.INVISIBLE);
            btModificar.setVisibility(View.VISIBLE);
            btBorrar.setVisibility(View.VISIBLE);
            tvNuevaAlimentacion.setText("EDITAR ALIMENTO");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.btInsertarAlimen):
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("¿Desea guardar la alimentación?").setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                //crea la bd
                dbHelper DbHelper = new dbHelper(NuevaAlimentacion.this);
                SQLiteDatabase db = DbHelper.getWritableDatabase();

                // Inserta datos
                long id = DbMascotas.insertarAlimen(etNombreMascota.getText().toString(), etNombreAlimen.getText().toString(), etCantidadAlimen.getText().toString(), etTomasAlimen.getText().toString(),
                        etTipoAlimen.getText().toString());

                if (id > 0) {
                    Toast.makeText(NuevaAlimentacion.this, "Alimentación guardada", Toast.LENGTH_LONG).show();
                    limpiar();
                } else {
                    Toast.makeText(NuevaAlimentacion.this, "Error al guardar la alimentación", Toast.LENGTH_LONG).show();
                }}
                }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                }).show();
                break;

            case(R.id.btModificar):
                builder = new AlertDialog.Builder(this);
                builder.setMessage("¿Desea guardar los cambios?").setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                if(!etNombreMascota.getText().toString().equals("") && !etNombreAlimen.getText().toString().equals("")){
                    correcto= DbMascotas.editarAlimentacion(etNombreMascota.getText().toString(), etNombreAlimen.getText().toString(), etCantidadAlimen.getText().toString(), etTomasAlimen.getText().toString(), etTipoAlimen.getText().toString());

                    if(correcto){
                        Toast.makeText(NuevaAlimentacion.this, "ALIMENTO MODIFICADO", Toast.LENGTH_LONG).show();
                        verRegistro();
                    }else{
                        Toast.makeText(NuevaAlimentacion.this, "ERROR AL MODIFICAR EL ALIMENTO", Toast.LENGTH_LONG).show();
                    }
                }}
                }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                }).show();
                break;

            case(R.id.btBorrar):
                builder = new AlertDialog.Builder(this);
                builder.setMessage("¿Desea eliminar el alimento?").setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(DbMascotas.borrarAlimentacion(nombreMascota, nombreAlimen)){
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

    private void limpiar() {
        etNombreMascota.setText("");
        etNombreAlimen.setText("");
        etCantidadAlimen.setText("");
        etTomasAlimen.setText("");
        etTipoAlimen.setText("");
    }

    public void verRegistro(){
        Intent intent = new Intent(this, alimentacion.class );
        startActivity(intent);
    }
}
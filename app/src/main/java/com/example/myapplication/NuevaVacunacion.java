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

public class NuevaVacunacion extends AppCompatActivity implements View.OnClickListener{
    private EditText etNombreMascota, etNombreVac, etFrecuenciaVac, etFechaVac, etFechaProxVac;
    private TextView tvNuevaVac;
    private Button btInsertarVac, btBorrar, btModificar;

    vacunacion vacuna;
    String nombreMascota= null;
    String nombreVac = null;
    boolean correcto =false;

    dbMascota DbMascotas = new dbMascota(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_vacunacion);

        etNombreMascota = findViewById(R.id.etNombreMascota);
        etNombreVac = findViewById(R.id.etNombreVac);
        etFrecuenciaVac = findViewById(R.id.etFrecuenciaVac);
        etFechaVac = findViewById(R.id.etFechaVac);
        etFechaProxVac = findViewById(R.id.etFechaProxVac);
        tvNuevaVac = findViewById(R.id.tvNuevaVac);
        btInsertarVac = findViewById(R.id.btInsertarVac);
        btBorrar = findViewById(R.id.btBorrar);
        btModificar = findViewById(R.id.btModificar);

        btInsertarVac.setOnClickListener(this);
        btBorrar.setOnClickListener(this);
        btModificar.setOnClickListener(this);

        btModificar.setVisibility(View.INVISIBLE);
        btBorrar.setVisibility(View.INVISIBLE);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                nombreMascota = null;
                nombreVac = null;
            } else {
                nombreMascota = extras.getString("NOMBREMASCOTA");
                nombreVac = extras.getString("NOMBREVAC");
            }
        } else {
            vacuna = (vacunacion) savedInstanceState.getSerializable("NOMBREMASCOTA");
            vacuna = (vacunacion) savedInstanceState.getSerializable("NOMBREVAC");
        }
        dbMascota DBMascota = new dbMascota(this);
        vacuna = DBMascota.verVacunacion(nombreMascota, nombreVac);

        if (vacuna != null) {
            etNombreMascota.setText(vacuna.getNombreMascota());
            etNombreVac.setText(vacuna.getNombreVac());
            etFrecuenciaVac.setText(vacuna.getFrecuenciaVac());
            etFechaVac.setText(vacuna.getFechaVac());
            etFechaProxVac.setText(vacuna.getFechaProxVac());

            btInsertarVac.setVisibility(View.INVISIBLE);
            btModificar.setVisibility(View.VISIBLE);
            btBorrar.setVisibility(View.VISIBLE);
            tvNuevaVac.setText("EDITAR VACUNA");

        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.btInsertarVac):
                //crea la bd
                dbHelper DbHelper= new dbHelper(this);
                SQLiteDatabase db = DbHelper.getWritableDatabase();

                // Inserta datos
                long id= DbMascotas.insertarVac(etNombreMascota.getText().toString(), etNombreVac.getText().toString(), etFrecuenciaVac.getText().toString(), etFechaVac.getText().toString(),
                        etFechaProxVac.getText().toString());

                if(id>0){
                    Toast.makeText(this, "Vacuna guardada", Toast.LENGTH_LONG).show();
                    limpiar();
                }else{
                    Toast.makeText(this, "Error al guardar la vacuna", Toast.LENGTH_LONG).show();
                }
                break;
            case(R.id.btModificar):
                if(!etNombreMascota.getText().toString().equals("") && !etNombreVac.getText().toString().equals("")){
                    correcto= DbMascotas.editarVacunacion(etNombreMascota.getText().toString(), etNombreVac.getText().toString(), etFrecuenciaVac.getText().toString(), etFechaVac.getText().toString(), etFechaProxVac.getText().toString());

                    if(correcto){
                        Toast.makeText(this, "VACUNA MODIFICADA", Toast.LENGTH_LONG).show();
                        verRegistro();
                    }else{
                        Toast.makeText(this, "ERROR AL MODIFICAR LA VACUNA", Toast.LENGTH_LONG).show();
                    }
                }
                break;

            case(R.id.btBorrar):
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("¿Desea eliminar la vacuna?").setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(DbMascotas.borrarVacunacion(nombreMascota, nombreVac)){
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
        etNombreVac.setText("");
        etFrecuenciaVac.setText("");
        etFechaVac.setText("");
        etFechaProxVac.setText("");
    }
    public void verRegistro(){
        Intent intent = new Intent(this,vacunacion.class );
        startActivity(intent);
    }
}
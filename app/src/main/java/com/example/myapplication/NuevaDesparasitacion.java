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

public class NuevaDesparasitacion extends AppCompatActivity implements View.OnClickListener{

        private EditText etNombreMascota, etNombreDesp, etDosisDesp, etFrecuenciaDesp, etTipoDesp, etFechaDesp, etFechaProxDesp;
        private TextView tvNuevaDesp;
        private Button btInsertarDesp, btBorrar, btModificar;

    desparasitacion desp;
    String nombreMascota= null;
    String nombreDesp = null;
    boolean correcto =false;

    dbMascota DbMascotas = new dbMascota(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_desparasitacion);

        tvNuevaDesp = findViewById(R.id.tvNuevaDesp);
        etNombreMascota = findViewById(R.id.etNombreMascota);
        etNombreDesp = findViewById(R.id.etNombreDesp);
        etDosisDesp = findViewById(R.id.etDosisDesp);
        etFrecuenciaDesp = findViewById(R.id.etFrecuenciaDesp);
        etTipoDesp = findViewById(R.id.etTipoDesp);
        etFechaDesp = findViewById(R.id.etFechaDesp);
        etFechaProxDesp = findViewById(R.id.etFechaProxDesp);
        btInsertarDesp = findViewById(R.id.btInsertarDesp);
        btBorrar = findViewById(R.id.btBorrar);
        btModificar = findViewById(R.id.btModificar);

        btInsertarDesp.setOnClickListener(this);
        btBorrar.setOnClickListener(this);
        btModificar.setOnClickListener(this);

        btModificar.setVisibility(View.INVISIBLE);
        btBorrar.setVisibility(View.INVISIBLE);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                nombreMascota = null;
                nombreDesp = null;
            } else {
                nombreMascota = extras.getString("NOMBREMASCOTA");
                nombreDesp = extras.getString("NOMBREDESP");
            }
        } else {
            desp = (desparasitacion) savedInstanceState.getSerializable("NOMBREMASCOTA");
            desp = (desparasitacion) savedInstanceState.getSerializable("NOMBREDESP");
        }
        dbMascota DBMascota = new dbMascota(this);
        desp = DBMascota.verDesparasitacion(nombreMascota, nombreDesp);

        if (desp != null) {
            etNombreMascota.setText(desp.getNombreMascota());
            etNombreDesp.setText(desp.getNombreDesp());
            etDosisDesp.setText(desp.getDosisDesp());
            etFrecuenciaDesp.setText(desp.getFrecuenciaDesp());
            etTipoDesp.setText(desp.getTipoDesp());
            etFechaDesp.setText(desp.getFechaDesp());
            etFechaProxDesp.setText(desp.getFechaProxDesp());

            btInsertarDesp.setVisibility(View.INVISIBLE);
            btModificar.setVisibility(View.VISIBLE);
            btBorrar.setVisibility(View.VISIBLE);
            tvNuevaDesp.setText("EDITAR DESPARASITACIÓN");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.btInsertarDesp):
                //crea la bd
                dbHelper DbHelper= new dbHelper(this);
                SQLiteDatabase db = DbHelper.getWritableDatabase();

                // Inserta datos
                long id = DbMascotas.insertarDesp(etNombreMascota.getText().toString(), etNombreDesp.getText().toString(), etDosisDesp.getText().toString(), etFrecuenciaDesp.getText().toString(),
                        etTipoDesp.getText().toString(), etFechaDesp.getText().toString(), etFechaProxDesp.getText().toString());

                if (id > 0) {
                    Toast.makeText(this, "Desparasitación guardada", Toast.LENGTH_LONG).show();
                    limpiar();
                } else {
                    Toast.makeText(this, "Error al guardar la desparasitación", Toast.LENGTH_LONG).show();
                }
                break;
            case(R.id.btModificar):
                if(!etNombreMascota.getText().toString().equals("") && !etNombreDesp.getText().toString().equals("")){
                    correcto= DbMascotas.editarDesparasitacion(etNombreMascota.getText().toString(), etNombreDesp.getText().toString(), etDosisDesp.getText().toString(), etFrecuenciaDesp.getText().toString(), etTipoDesp.getText().toString(), etFechaDesp.getText().toString(), etFechaProxDesp.getText().toString());

                    if(correcto){
                        Toast.makeText(this, "DESPARASITACIÓN MODIFICADA", Toast.LENGTH_LONG).show();
                        verRegistro();
                    }else{
                        Toast.makeText(this, "ERROR AL MODIFICAR LA DESPARASITACIÓN", Toast.LENGTH_LONG).show();
                    }
                }
                break;

            case(R.id.btBorrar):
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("¿Desea eliminar la desparasitación?").setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(DbMascotas.borrarDesparasitacion(nombreMascota, nombreDesp)){
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
        etNombreDesp.setText("");
        etDosisDesp.setText("");
        etFrecuenciaDesp.setText("");
        etTipoDesp.setText("");
        etFechaDesp.setText("");
        etFechaProxDesp.setText("");
    }
    public void verRegistro(){
        Intent intent = new Intent(this,desparasitacion.class );
        startActivity(intent);
    }
}

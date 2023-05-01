package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.myapplication.db.dbHelper;
import com.example.myapplication.db.dbMascota;

import java.util.UUID;

public class NuevaMascota extends AppCompatActivity  implements View.OnClickListener {
    private EditText etNombre, etChip, etEdad, etRaza, etPeso, etSexo, etEsterilizado;
    private RadioButton rbSexM, rbSexH, rbEstS, rbEstN;
    private Button btGuardar, btBorrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_mascota);

        etNombre = findViewById(R.id.etNombre);
        etChip = findViewById(R.id.etChip);
        etEdad = findViewById(R.id.etEdad);
        etRaza = findViewById(R.id.etRaza);
        etPeso = findViewById(R.id.etPeso);
        etEsterilizado = findViewById(R.id.etEsterilizado);
        etSexo = findViewById(R.id.etSexo);
        rbSexM = findViewById(R.id.rbSexM);
        rbSexH = findViewById(R.id.rbSexH);
        rbEstS = findViewById(R.id.rbEstS);
        rbEstN = findViewById(R.id.rbEstN);
        btGuardar = findViewById(R.id.btGuardar);
        btBorrar = findViewById(R.id.btBorrar);

        btGuardar.setOnClickListener(this);
        btBorrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.btGuardar):
                //crea la bd
                dbHelper DbHelper= new dbHelper(this);
                SQLiteDatabase db = DbHelper.getWritableDatabase();

                // Inserta datos
                dbMascota DbMascotas = new dbMascota(this);
                long id= DbMascotas.insertarMascota(etNombre.getText().toString(), etChip.getText().toString(), etEdad.getText().toString(),
                        etRaza.getText().toString(), etPeso.getText().toString(), etSexo.getText().toString(), etEsterilizado.getText().toString());

                if(id>0){
                    Toast.makeText(this, "Mascota guardada", Toast.LENGTH_LONG).show();
                    limpiar();
                }else{
                    Toast.makeText(this, "Error al guardar la mascota", Toast.LENGTH_LONG).show();
                }
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


}
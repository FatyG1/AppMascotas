package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.db.dbHelper;
import com.example.myapplication.db.dbMascota;

public class Tto extends AppCompatActivity implements View.OnClickListener {
    private EditText etNombreMascota, etNombreTto, etDosisTto, etFrecuenciaTto, etUsoTto, etDuracionTto;
    private Button btInsertarTto;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tto);

        etNombreMascota = findViewById(R.id.etNombreMascota);
        etNombreTto = findViewById(R.id.etNombreTto);
        etDosisTto = findViewById(R.id.etDosisTto);
        etFrecuenciaTto = findViewById(R.id.etFrecuenciaTto);
        etUsoTto = findViewById(R.id.etUsoTto);
        etDuracionTto = findViewById(R.id.etDuracionTto);
        btInsertarTto= findViewById(R.id.btInsertarTto);

        btInsertarTto.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.btInsertarTto):
                //crea la bd
                dbHelper DbHelper= new dbHelper(this);
                SQLiteDatabase db = DbHelper.getWritableDatabase();

                // Inserta datos
                dbMascota DbMascotas = new dbMascota(this);
                long id = DbMascotas.insertarTto(etNombreMascota.getText().toString(), etNombreTto.getText().toString(), etDosisTto.getText().toString(), etFrecuenciaTto.getText().toString(),
                        etUsoTto.getText().toString(), etDuracionTto.getText().toString());

                if (id > 0) {
                    Toast.makeText(this, "Tratamiento guardada", Toast.LENGTH_LONG).show();
                    limpiar();
                } else {
                    Toast.makeText(this, "Error al guardar la tratamiento", Toast.LENGTH_LONG).show();
                }
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
}
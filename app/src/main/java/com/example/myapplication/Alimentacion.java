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

public class Alimentacion extends AppCompatActivity implements View.OnClickListener {
    private EditText etNombreMascota, etNombreAlimen, etTipoAlimen, etCantidadAlimen, etTomasAlimen;
    private Button btInsertarAlimen;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimentacion);

        etNombreMascota = findViewById(R.id.etNombreMascota);
        etNombreAlimen = findViewById(R.id.etNombreAlimen);
        etTipoAlimen = findViewById(R.id.etTipoAlimen);
        etCantidadAlimen = findViewById(R.id.etCantidadAlimen);
        etTomasAlimen = findViewById(R.id.etTomasAlimen);
        btInsertarAlimen = findViewById(R.id.btinsertarAlimen);

        btInsertarAlimen.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.btinsertarAlimen):
                //crea la bd
                dbHelper DbHelper = new dbHelper(this);
                SQLiteDatabase db = DbHelper.getWritableDatabase();

                // Inserta datos
                dbMascota DbMascotas = new dbMascota(this);
                long id = DbMascotas.insertarAlimen(etNombreMascota.getText().toString(), etNombreAlimen.getText().toString(), etCantidadAlimen.getText().toString(), etTomasAlimen.getText().toString(),
                        etTipoAlimen.getText().toString());

                if (id > 0) {
                    Toast.makeText(this, "Alimentación guardada", Toast.LENGTH_LONG).show();
                    limpiar();
                } else {
                    Toast.makeText(this, "Error al guardar la alimentación", Toast.LENGTH_LONG).show();
                }
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
}
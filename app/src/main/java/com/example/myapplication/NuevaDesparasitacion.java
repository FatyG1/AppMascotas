package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.db.dbHelper;
import com.example.myapplication.db.dbMascota;

public class NuevaDesparasitacion extends AppCompatActivity implements View.OnClickListener{

        private EditText etNombreMascota, etNombreDesp, etDosisDesp, etFrecuenciaDesp, etTipoDesp, etFechaDesp, etFechaProxDesp;
        private Button btInsertarDesp;

   // @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_desparasitacion);

        etNombreMascota = findViewById(R.id.etNombreMascota);
        etNombreDesp = findViewById(R.id.etNombreDesp);
        etDosisDesp = findViewById(R.id.etDosisDesp);
        etFrecuenciaDesp = findViewById(R.id.etFrecuenciaDesp);
        etTipoDesp = findViewById(R.id.etTipoDesp);
        etFechaDesp = findViewById(R.id.etFechaDesp);
        etFechaProxDesp = findViewById(R.id.etFechaProxDesp);
        btInsertarDesp = findViewById(R.id.btInsertarDesp);

        btInsertarDesp.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.btInsertarDesp):
                //crea la bd
                dbHelper DbHelper= new dbHelper(this);
                SQLiteDatabase db = DbHelper.getWritableDatabase();

                // Inserta datos
                dbMascota DbMascotas = new dbMascota(this);
                long id = DbMascotas.insertarDesp(etNombreMascota.getText().toString(), etNombreDesp.getText().toString(), etDosisDesp.getText().toString(), etFrecuenciaDesp.getText().toString(),
                        etTipoDesp.getText().toString(), etFechaDesp.getText().toString(), etFechaProxDesp.getText().toString());

                if (id > 0) {
                    Toast.makeText(this, "Desparasitación guardada", Toast.LENGTH_LONG).show();
                    limpiar();
                } else {
                    Toast.makeText(this, "Error al guardar la desparasitación", Toast.LENGTH_LONG).show();
                }
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
}

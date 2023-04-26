package com.example.myapplication;

import static com.example.myapplication.R.id.btInsertarDesp;

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

public class Desparasitacion extends AppCompatActivity implements View.OnClickListener{

        private EditText etNombreDesp, etDosisDesp, etFrecuenciaDesp, etTipoDesp;
        private Button btInsertarDesp;

   // @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desparasitacion);

        etNombreDesp = findViewById(R.id.etNombreDesp);
        etDosisDesp = findViewById(R.id.etDosisDesp);
        etFrecuenciaDesp = findViewById(R.id.etFrecuenciaDesp);
        etTipoDesp = findViewById(R.id.etTipoDesp);
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
                if(db != null){
                    Toast.makeText(this, "Mascota creada", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "La mascota no se ha podido crear", Toast.LENGTH_LONG).show();
                }

                // Inserta datos
                dbMascota DbMascotas = new dbMascota(this);
                long id = DbMascotas.insertarDesp(etNombreDesp.getText().toString(), etDosisDesp.getText().toString(), etFrecuenciaDesp.getText().toString(),
                        etTipoDesp.getText().toString());

                if (id > 0) {
                    Toast.makeText(this, "Desp guardada", Toast.LENGTH_LONG).show();
                    limpiar();
                } else {
                    Toast.makeText(this, "Error al guardar la desp", Toast.LENGTH_LONG).show();
                }
                break;
        }
 }

    private void limpiar(){
        etNombreDesp.setText("");
        etDosisDesp.setText("");
        etFrecuenciaDesp.setText("");
        etTipoDesp.setText("");
}
}
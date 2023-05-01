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

public class Vacunacion extends AppCompatActivity implements View.OnClickListener{
    private EditText etNombreMascota, etNombreVac, etFrecuenciaVac, etFechaVac, etFechaProxVac;
    private Button btInsertarVac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacunacion);

        etNombreMascota = findViewById(R.id.etNombreMascota);
        etNombreVac = findViewById(R.id.etNombreVac);
        etFrecuenciaVac = findViewById(R.id.etFrecuenciaVac);
        etFechaVac = findViewById(R.id.etFechaVac);
        etFechaProxVac = findViewById(R.id.etFechaProxVac);
        btInsertarVac = findViewById(R.id.btInsertarVac);

        btInsertarVac.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.btInsertarVac):
                //crea la bd
                dbHelper DbHelper= new dbHelper(this);
                SQLiteDatabase db = DbHelper.getWritableDatabase();

                // Inserta datos
                dbMascota DbMascotas = new dbMascota(this);
                long id= DbMascotas.insertarVac(etNombreMascota.getText().toString(), etNombreVac.getText().toString(), etFrecuenciaVac.getText().toString(), etFechaVac.getText().toString(),
                        etFechaProxVac.getText().toString());

                if(id>0){
                    Toast.makeText(this, "Vacuna guardada", Toast.LENGTH_LONG).show();
                    limpiar();
                }else{
                    Toast.makeText(this, "Error al guardar la vacuna", Toast.LENGTH_LONG).show();
                }
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
}
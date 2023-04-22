package com.example.myapplication.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class dbMascota extends dbHelper{
    Context context;

    public dbMascota(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarMascota(String nombre, String chip, String edad, String raza, String peso, String sexo, String esterilizado){
        long id = 0;
        try {
            dbHelper DbHelper = new dbHelper(context);
            SQLiteDatabase db = DbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("chip", chip);
            values.put("edad", edad);
            values.put("raza", raza);
            values.put("peso", peso);
            values.put("sexo", sexo);
            values.put("esterilizado", esterilizado);

            id = db.insert(TABLA_MASCOTAS, null, values);
        } catch(Exception ex){
            ex.toString();
        }
        return id;
    }
}

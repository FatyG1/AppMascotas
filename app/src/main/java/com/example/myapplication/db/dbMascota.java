package com.example.myapplication.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.myapplication.miMascota;
import androidx.annotation.Nullable;

import java.util.ArrayList;

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
    public long insertarDesp(String nombreMascota, String nombreDesp, String dosisDesp, String frecuenciaDesp, String tipoDesp){
        long id = 0;
        try {
            dbHelper DbHelper = new dbHelper(context);
            SQLiteDatabase db = DbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombreMascota", nombreMascota);
            values.put("nombreDesp", nombreDesp);
            values.put("dosisDesp", dosisDesp);
            values.put("frecuenciaDesp", frecuenciaDesp);
            values.put("tipoDesp", tipoDesp);

            id = db.insert(TABLA_DESP, null, values);
        } catch(Exception ex){
            ex.toString();
        }
        return id;
    }
    public long insertarTto(String nombreMascota, String nombreTto, String dosisTto, String frecuenciaTto, String usoTto, String duracionTto){
        long id = 0;
        try {
            dbHelper DbHelper = new dbHelper(context);
            SQLiteDatabase db = DbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombreMascota", nombreMascota);
            values.put("nombreTto", nombreTto);
            values.put("dosisTto", dosisTto);
            values.put("frecuenciaTto", frecuenciaTto);
            values.put("duracionTto", duracionTto);
            values.put("usoTto", usoTto);

            id = db.insert(TABLA_TTO, null, values);
        } catch(Exception ex){
            ex.toString();
        }
        return id;
    }
    public long insertarAlimen(String nombreMascota, String nombreAlimen, String cantidadAlimen, String tomasAlimen, String tipoAlimen){
        long id = 0;
        try {
            dbHelper DbHelper = new dbHelper(context);
            SQLiteDatabase db = DbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombreMascota", nombreMascota);
            values.put("nombreAlimen", nombreAlimen);
            values.put("cantidadAlimen", cantidadAlimen);
            values.put("tomasAlimen", tomasAlimen);
            values.put("tipoAlimen", tipoAlimen);

            id = db.insert(TABLA_ALIMEN, null, values);
        } catch(Exception ex){
            ex.toString();
        }
        return id;
    }

    public long insertarVac(String nombreMascota, String nombreVac, String frecuenciaVac, String fechaVac, String fechaProxVac){
        long id = 0;
        try {
            dbHelper DbHelper = new dbHelper(context);
            SQLiteDatabase db = DbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombreMascota", nombreMascota);
            values.put("nombreVac", nombreVac);
            values.put("frecuenciaVac", frecuenciaVac);
            values.put("fechaVac", fechaVac);
            values.put("fechaProxVac", fechaProxVac);

            id = db.insert(TABLA_VAC, null, values);
        } catch(Exception ex){
            ex.toString();
        }
        return id;
    }

    public ArrayList<miMascota> mostrarMascotas(){
        dbHelper DbHelper = new dbHelper(context);
        SQLiteDatabase db = DbHelper.getWritableDatabase();

        ArrayList<miMascota> listaMascotas = new ArrayList<>();
        miMascota mascota = null;
        Cursor cursorMascotas = null;

        cursorMascotas = db.rawQuery("SELECT * FROM " + TABLA_MASCOTAS, null);

        if(cursorMascotas.moveToFirst()){
            do{
                mascota = new miMascota();
                mascota.setNombre(cursorMascotas.getString(0));
                mascota.setChip(cursorMascotas.getString(1));
                mascota.setEdad(cursorMascotas.getString(2));
                mascota.setRaza(cursorMascotas.getString(3));
                mascota.setPeso(cursorMascotas.getString(4));
                mascota.setSexo(cursorMascotas.getString(5));

                listaMascotas.add(mascota);
            }while(cursorMascotas.moveToNext());
        }

        cursorMascotas.close();

        return listaMascotas;
    }
}

package com.example.myapplication.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
//CLASE DE PRUEBA PARA CREAR BD
public class dbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "mascota.db";
    public static final String TABLA_MASCOTAS ="datos_mascota";


    public dbHelper(@Nullable Context context ) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLA_MASCOTAS + "(" +
                "chip TEXT PRIMARY KEY," +
                "nombre TEXT NOT NULL," +
                "edad TEXT," +
                "peso TEXT," +
                "raza TEXT," +
                "sexo TEXT," +
                "esterilizado TEXT)");
    }
    //MIN 7:43 Crear base de datos en Android Studio (SQLite)
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLA_MASCOTAS);
        onCreate(sqLiteDatabase);
    }
}

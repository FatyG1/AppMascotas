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
    public static final String TABLA_DESP = "Desparasitacion";
    public static final String TABLA_TTO = "Tratamiento";
    public static final String TABLA_ALIMEN = "Alimentación";
    public static final String TABLA_VAC = "Vacunación";


    public dbHelper(@Nullable Context context ) {
       super(context, DATABASE_NOMBRE, null, DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       sqLiteDatabase.execSQL("CREATE TABLE " + TABLA_MASCOTAS + "(" +
                "nombre TEXT PRIMARY KEY," +
                "chip TEXT," +
                "edad TEXT," +
                "peso TEXT," +
                "raza TEXT," +
                "sexo TEXT," +
                "esterilizado TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLA_DESP + "(" +
                "etNombreMascota TEXT, " +
                "nombreDesp TEXT PRIMARY KEY," +
                "tipoDesp TEXT," +
                "dosisDesp TEXT," +
                "frecuenciaDesp TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLA_TTO + "(" +
                "etNombreMascota TEXT, " +
                "nombreTto TEXT PRIMARY KEY," +
                "usoTto TEXT," +
                "dosisTto TEXT," +
                "frecuenciaTto TEXT," +
                "DuracionTto TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLA_ALIMEN + "(" +
                "etNombreMascota TEXT, " +
                "nombreAlimen TEXT PRIMARY KEY," +
                "cantidadAlimen TEXT," +
                "tomasAlimen TEXT," +
                "tipoAlimen TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLA_VAC + "(" +
                "etNombreMascota TEXT, " +
                "nombreVac TEXT PRIMARY KEY," +
                "frecuenciaVac TEXT," +
                "fechavac TEXT," +
                "fechaProxVac TEXT)");
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLA_MASCOTAS);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLA_DESP);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLA_TTO);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLA_ALIMEN);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLA_VAC);
        onCreate(sqLiteDatabase);
    }


}

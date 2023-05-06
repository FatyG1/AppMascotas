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
    //Creación de tablas
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
                "nombreMascota TEXT, " +
                "nombreDesp TEXT," +
                "tipoDesp TEXT," +
                "dosisDesp TEXT," +
                "frecuenciaDesp TEXT,"+
                "fechaDesp TEXT,"+
                "fechaProxDesp TEXT,"+
                "PRIMARY KEY (nombreMascota, nombreDesp))");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLA_TTO + "(" +
                "nombreMascota TEXT, " +
                "nombreTto TEXT," +
                "usoTto TEXT," +
                "dosisTto TEXT," +
                "frecuenciaTto TEXT," +
                "DuracionTto TEXT," +
                "PRIMARY KEY (nombreMascota, nombreTto))");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLA_ALIMEN + "(" +
                "nombreMascota TEXT, " +
                "nombreAlimen TEXT," +
                "cantidadAlimen TEXT," +
                "tomasAlimen TEXT," +
                "tipoAlimen TEXT,"  +
                "PRIMARY KEY (nombreMascota, nombreAlimen))");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLA_VAC + "(" +
                "nombreMascota TEXT, " +
                "nombreVac TEXT," +
                "frecuenciaVac TEXT," +
                "fechavac TEXT," +
                "fechaProxVac TEXT," +
                " PRIMARY KEY (nombreMascota, nombreVac))");
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

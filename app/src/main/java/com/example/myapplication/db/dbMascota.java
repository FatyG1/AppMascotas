package com.example.myapplication.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.alimentacion;
import com.example.myapplication.desparasitacion;
import com.example.myapplication.miMascota;
import com.example.myapplication.tratamiento;
import com.example.myapplication.vacunacion;

import androidx.annotation.Nullable;

import java.util.ArrayList;
public class dbMascota extends dbHelper {
    Context context;

    public dbMascota(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarMascota(String nombre, String chip, String edad, String raza, String peso, String sexo, String esterilizado) {
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
        } catch (Exception ex) {
            ex.toString();
        }
        return id;
    }

    public long insertarDesp(String nombreMascota, String nombreDesp, String dosisDesp, String frecuenciaDesp, String tipoDesp, String fechaDesp, String fechaProxDesp) {
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
            values.put("fechaDesp", fechaDesp);
            values.put("fechaProxDesp", fechaProxDesp);

            id = db.insert(TABLA_DESP, null, values);
        } catch (Exception ex) {
            ex.toString();
        }
        return id;
    }

    public long insertarTto(String nombreMascota, String nombreTto, String dosisTto, String frecuenciaTto, String usoTto, String duracionTto) {
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
        } catch (Exception ex) {
            ex.toString();
        }
        return id;
    }

    public long insertarAlimen(String nombreMascota, String nombreAlimen, String cantidadAlimen, String tomasAlimen, String tipoAlimen) {
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
        } catch (Exception ex) {
            ex.toString();
        }
        return id;
    }

    public long insertarVac(String nombreMascota, String nombreVac, String frecuenciaVac, String fechaVac, String fechaProxVac) {
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
        } catch (Exception ex) {
            ex.toString();
        }
        return id;
    }

    //Método para mostrar los datos de la mascota.
    public ArrayList<miMascota> mostrarMascotas() {
        dbHelper DbHelper = new dbHelper(context);
        SQLiteDatabase db = DbHelper.getWritableDatabase();

        ArrayList<miMascota> listaMascotas = new ArrayList<>();
        miMascota mascota = null;
        Cursor cursorMascotas = null;

        cursorMascotas = db.rawQuery("SELECT * FROM " + TABLA_MASCOTAS, null);

        if (cursorMascotas.moveToFirst()) {
            do {
                mascota = new miMascota();
                mascota.setNombre(cursorMascotas.getString(0));
                mascota.setChip(cursorMascotas.getString(1));
                mascota.setEdad(cursorMascotas.getString(2));
                mascota.setRaza(cursorMascotas.getString(4));
                mascota.setSexo(cursorMascotas.getString(6));
                mascota.setEsterilizado(cursorMascotas.getString(5));
                mascota.setPeso(cursorMascotas.getString(3));


                listaMascotas.add(mascota);
            } while (cursorMascotas.moveToNext());
        }

        cursorMascotas.close();

        return listaMascotas;
    }

    //Método para mostrar los datos de la alimentación de la mascota.
    public ArrayList<alimentacion> mostrarAlimentacion() {
        dbHelper DbHelper = new dbHelper(context);
        SQLiteDatabase db = DbHelper.getWritableDatabase();

        ArrayList<alimentacion> listaAlimentacion = new ArrayList<>();
        alimentacion alimento = null;
        Cursor cursorAlimentacion = null;

        cursorAlimentacion = db.rawQuery("SELECT * FROM " + TABLA_ALIMEN, null);

        if (cursorAlimentacion.moveToFirst()) {
            do {
                alimento = new alimentacion();
                alimento.setNombreMascota(cursorAlimentacion.getString(0));
                alimento.setNombreAlimen(cursorAlimentacion.getString(1));
                alimento.setCantidadAlimen(cursorAlimentacion.getString(2));
                alimento.setTomasAlimen(cursorAlimentacion.getString(3));
                alimento.setTipoAlimen(cursorAlimentacion.getString(4));


                listaAlimentacion.add(alimento);
            } while (cursorAlimentacion.moveToNext());
        }

        cursorAlimentacion.close();

        return listaAlimentacion;
    }

    //Método para mostrar los datos de la vacunación de la mascota.
    public ArrayList<vacunacion> mostrarVacunacion() {
        dbHelper DbHelper = new dbHelper(context);
        SQLiteDatabase db = DbHelper.getWritableDatabase();

        ArrayList<vacunacion> listaVacunacion = new ArrayList<>();
        vacunacion vacuna = null;
        Cursor cursorVacunacion = null;

        cursorVacunacion = db.rawQuery("SELECT * FROM " + TABLA_VAC, null);

        if (cursorVacunacion.moveToFirst()) {
            do {
                vacuna = new vacunacion();
                vacuna.setNombreMascota(cursorVacunacion.getString(0));
                vacuna.setNombreVac(cursorVacunacion.getString(1));
                vacuna.setFrecuenciaVac(cursorVacunacion.getString(2));
                vacuna.setFechaVac(cursorVacunacion.getString(3));
                vacuna.setFechaProxVac(cursorVacunacion.getString(4));

                listaVacunacion.add(vacuna);
            } while (cursorVacunacion.moveToNext());
        }

        cursorVacunacion.close();

        return listaVacunacion;
    }

    //Método para mostrar los datos de la desparasitacion de la mascota.
    public ArrayList<desparasitacion> mostrarDesparasitacion() {
        dbHelper DbHelper = new dbHelper(context);
        SQLiteDatabase db = DbHelper.getWritableDatabase();

        ArrayList<desparasitacion> listaDesparasitacion = new ArrayList<>();
        desparasitacion desp = null;
        Cursor cursorDesparasitacion = null;

        cursorDesparasitacion = db.rawQuery("SELECT * FROM " + TABLA_DESP, null);

        if (cursorDesparasitacion.moveToFirst()) {
            do {
                desp = new desparasitacion();
                desp.setNombreMascota(cursorDesparasitacion.getString(0));
                desp.setNombreDesp(cursorDesparasitacion.getString(1));
                desp.setTipoDesp(cursorDesparasitacion.getString(2));
                desp.setDosisDesp(cursorDesparasitacion.getString(3));
                desp.setFrecuenciaDesp(cursorDesparasitacion.getString(4));
                desp.setFechaDesp(cursorDesparasitacion.getString(5));
                desp.setFechaProxDesp(cursorDesparasitacion.getString(6));


                listaDesparasitacion.add(desp);
            } while (cursorDesparasitacion.moveToNext());
        }

        cursorDesparasitacion.close();

        return listaDesparasitacion;
    }

    //Método para mostrar los datos de los tratamientos de la mascota.
    public ArrayList<tratamiento> mostrarTratamiento() {
        dbHelper DbHelper = new dbHelper(context);
        SQLiteDatabase db = DbHelper.getWritableDatabase();

        ArrayList<tratamiento> listaTratamiento = new ArrayList<>();
        tratamiento Tto = null;
        Cursor cursorTratamiento = null;

        cursorTratamiento = db.rawQuery("SELECT * FROM " + TABLA_TTO, null);

        if (cursorTratamiento.moveToFirst()) {
            do {
                Tto = new tratamiento();
                Tto.setNombreMascota(cursorTratamiento.getString(0));
                Tto.setNombreTto(cursorTratamiento.getString(1));
                Tto.setUsoTto(cursorTratamiento.getString(2));
                Tto.setDosisTto(cursorTratamiento.getString(3));
                Tto.setFrecuenciaTto(cursorTratamiento.getString(4));
                Tto.setDuracionTto(cursorTratamiento.getString(5));

                listaTratamiento.add(Tto);
            } while (cursorTratamiento.moveToNext());
        }

        cursorTratamiento.close();

        return listaTratamiento;
    }

    //Método para ver los datos de una mascota concreta en el formulario
    public miMascota verMascotas(String nombre) {
        dbHelper DbHelper = new dbHelper(context);
        SQLiteDatabase db = DbHelper.getWritableDatabase();

        miMascota mascota = null;
        Cursor cursorMascotas = null;

        cursorMascotas = db.rawQuery("SELECT * FROM " + TABLA_MASCOTAS + " WHERE nombre  = '" + nombre + "'", null);

        if (cursorMascotas.moveToFirst()) {
                mascota = new miMascota();
                mascota.setNombre(cursorMascotas.getString(0));
                mascota.setChip(cursorMascotas.getString(1));
                mascota.setEdad(cursorMascotas.getString(2));
                mascota.setRaza(cursorMascotas.getString(4));
                mascota.setSexo(cursorMascotas.getString(6));
                mascota.setEsterilizado(cursorMascotas.getString(5));
                mascota.setPeso(cursorMascotas.getString(3));
            }

        cursorMascotas.close();

        return mascota;
    }
    //Método para ver los datos de una alimentación concreta en el formulario
    public alimentacion verAlimentacion(String nombreMascota, String nombreAlimen) {
        dbHelper DbHelper = new dbHelper(context);
        SQLiteDatabase db = DbHelper.getWritableDatabase();

        alimentacion alimento = null;
        Cursor cursorAlimentacion = null;
        cursorAlimentacion = db.rawQuery("SELECT * FROM " + TABLA_ALIMEN + " WHERE nombreMascota  = '" + nombreMascota + "' AND nombreAlimen  = '" + nombreAlimen + "'", null);

        if (cursorAlimentacion.moveToFirst()) {
            do {
                alimento = new alimentacion();
                alimento.setNombreMascota(cursorAlimentacion.getString(0));
                alimento.setNombreAlimen(cursorAlimentacion.getString(1));
                alimento.setCantidadAlimen(cursorAlimentacion.getString(2));
                alimento.setTomasAlimen(cursorAlimentacion.getString(3));
                alimento.setTipoAlimen(cursorAlimentacion.getString(4));

            } while (cursorAlimentacion.moveToNext());
        }

        cursorAlimentacion.close();

        return alimento;
    }

    //Método para ver los datos de una vacuna concreta en el formulario
    public vacunacion verVacunacion(String nombreMascota, String nombreVac) {
        dbHelper DbHelper = new dbHelper(context);
        SQLiteDatabase db = DbHelper.getWritableDatabase();

        vacunacion vacuna = null;
        Cursor cursorVacunacion = null;
        cursorVacunacion = db.rawQuery("SELECT * FROM " + TABLA_VAC + " WHERE nombreMascota  = '" + nombreMascota + "' AND nombreVac  = '" + nombreVac + "'", null);

        if (cursorVacunacion.moveToFirst()) {
            do {
                vacuna = new vacunacion();
                vacuna.setNombreMascota(cursorVacunacion.getString(0));
                vacuna.setNombreVac(cursorVacunacion.getString(1));
                vacuna.setFrecuenciaVac(cursorVacunacion.getString(2));
                vacuna.setFechaVac(cursorVacunacion.getString(3));
                vacuna.setFechaProxVac(cursorVacunacion.getString(4));

            } while (cursorVacunacion.moveToNext());
        }

        cursorVacunacion.close();

        return vacuna;
    }

    //Método para ver los datos de una desparasitación concreta en el formulario
    public desparasitacion verDesparasitacion(String nombreMascota, String nombreDesp) {
        dbHelper DbHelper = new dbHelper(context);
        SQLiteDatabase db = DbHelper.getWritableDatabase();

        desparasitacion desp = null;
        Cursor cursorDesparasitacion = null;
        cursorDesparasitacion = db.rawQuery("SELECT * FROM " + TABLA_DESP + " WHERE nombreMascota  = '" + nombreMascota + "' AND nombreDesp  = '" + nombreDesp + "'", null);

        if (cursorDesparasitacion.moveToFirst()) {
            do {
                desp = new desparasitacion();
                desp.setNombreMascota(cursorDesparasitacion.getString(0));
                desp.setNombreDesp(cursorDesparasitacion.getString(1));
                desp.setTipoDesp(cursorDesparasitacion.getString(2));
                desp.setDosisDesp(cursorDesparasitacion.getString(3));
                desp.setFrecuenciaDesp(cursorDesparasitacion.getString(4));
                desp.setFechaDesp(cursorDesparasitacion.getString(5));
                desp.setFechaProxDesp(cursorDesparasitacion.getString(6));

            } while (cursorDesparasitacion.moveToNext());
        }

        cursorDesparasitacion.close();

        return desp;
    }

    //Método para ver los datos de un tratamiento concreta en el formulario
    public tratamiento verTto(String nombreMascota, String nombreTto) {
        dbHelper DbHelper = new dbHelper(context);
        SQLiteDatabase db = DbHelper.getWritableDatabase();

       tratamiento Tto = null;
        Cursor cursorTratamiento = null;
        cursorTratamiento = db.rawQuery("SELECT * FROM " + TABLA_TTO + " WHERE nombreMascota  = '" + nombreMascota + "' AND nombreTto  = '" + nombreTto + "'", null);

        if (cursorTratamiento.moveToFirst()) {
            do {
                Tto = new tratamiento();
                Tto.setNombreMascota(cursorTratamiento.getString(0));
                Tto.setNombreTto(cursorTratamiento.getString(1));
                Tto.setUsoTto(cursorTratamiento.getString(2));
                Tto.setDosisTto(cursorTratamiento.getString(3));
                Tto.setFrecuenciaTto(cursorTratamiento.getString(4));
                Tto.setDuracionTto(cursorTratamiento.getString(5));

            } while (cursorTratamiento.moveToNext());
        }

        cursorTratamiento.close();

        return Tto;
    }
    //Método para editar mascota
    public boolean editarMascota(String nombre, String chip, String edad, String raza, String peso, String sexo, String esterilizado) {
        boolean correcto = false;

        dbHelper DbHelper = new dbHelper(context);
        SQLiteDatabase db = DbHelper.getWritableDatabase();

        try {
            db.execSQL(" UPDATE " + TABLA_MASCOTAS + " SET nombre = '" + nombre + "', chip = '" + chip + "', edad = '" + edad + "', raza = '" + raza + "', " +
                    "peso = '" + peso + "', sexo = '" + sexo + "', esterilizado = '" + esterilizado + "'" +
                    "WHERE nombre  = '" + nombre + "'");
            correcto = true;
        } catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }
        return correcto;
    }
    //Método para editar la alimentación
    public boolean editarAlimentacion(String nombreMascota, String nombreAlimen, String cantidadAlimen, String tomasAlimen, String tipoAlimen) {
        boolean correcto = false;

        dbHelper DbHelper = new dbHelper(context);
        SQLiteDatabase db = DbHelper.getWritableDatabase();

        try {
            db.execSQL(" UPDATE " + TABLA_ALIMEN + " SET nombreMascota  = '" + nombreMascota + "', nombreAlimen  = '" + nombreAlimen + "', cantidadAlimen  = '" + cantidadAlimen + "', tomasAlimen  = '" + tomasAlimen + "', tipoAlimen  = '" + tipoAlimen + "'" + " WHERE nombreMascota  = '" + nombreMascota + "' AND nombreAlimen  = '" + nombreAlimen + "'");

            correcto = true;
        }catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }

        return correcto;
    }
    //Método para editar la vacuna
    public boolean editarVacunacion(String nombreMascota, String nombreVac, String frecuenciaVac, String fechaVac, String fechaProxVac) {
        boolean correcto = false;

        dbHelper DbHelper = new dbHelper(context);
        SQLiteDatabase db = DbHelper.getWritableDatabase();

        try {
            db.execSQL(" UPDATE " + TABLA_VAC + " SET nombreMascota  = '" + nombreMascota + "', nombreVac  = '" + nombreVac + "', frecuenciaVac  = '" + frecuenciaVac + "', fechaVac  = '" + fechaVac + "', fechaProxVac  = '" + fechaProxVac + "'" + " WHERE nombreMascota  = '" + nombreMascota + "' AND nombreVac  = '" + nombreVac + "'");

            correcto = true;
        }catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }

        return correcto;
    }
    //Método para editar la desparasitacion
    public boolean editarDesparasitacion(String nombreMascota, String nombreDesp, String DosisDesp, String tipoDesp, String frecuenciaDesp, String fechaDesp, String fechaProxDesp) {
        boolean correcto = false;

        dbHelper DbHelper = new dbHelper(context);
        SQLiteDatabase db = DbHelper.getWritableDatabase();

        try {
            db.execSQL(" UPDATE " + TABLA_DESP + " SET nombreMascota  = '" + nombreMascota + "', nombreDesp  = '" + nombreDesp + "', DosisDesp  = '" + DosisDesp + "', tipoDesp  = '" + tipoDesp + "', frecuenciaDesp  = '" + frecuenciaDesp + "', fechaDesp  = '" +fechaDesp + "', fechaProxDesp =  '" + fechaProxDesp + "'" + " WHERE nombreMascota  = '" + nombreMascota + "' AND nombreDesp  = '" + nombreDesp + "'");

            correcto = true;
        }catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }

        return correcto;
    }
    //Método para editar el tratamiento
    public boolean editarTto(String nombreMascota, String nombreTto, String usoTto, String DosisTto, String frecuenciaTto, String duracionTto) {
        boolean correcto = false;

        dbHelper DbHelper = new dbHelper(context);
        SQLiteDatabase db = DbHelper.getWritableDatabase();

        try {
            db.execSQL(" UPDATE " + TABLA_TTO + " SET nombreMascota  = '" + nombreMascota + "', nombreTto  = '" + nombreTto + "', usoTto  = '" + usoTto + "', DosisTto  = '" + DosisTto + "', frecuenciaTto = '" + frecuenciaTto + "', duracionTto  = '" + duracionTto + "'" + " WHERE nombreMascota  = '" + nombreMascota + "' AND nombreTto  = '" + nombreTto + "'");

            correcto = true;
        }catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }

        return correcto;
    }
    //Método para borrar mascota
    public boolean borrarMascota(String nombre) {
        boolean correcto = false;

        dbHelper DbHelper = new dbHelper(context);
        SQLiteDatabase db = DbHelper.getWritableDatabase();

        try {
            db.execSQL(" DELETE FROM " + TABLA_MASCOTAS + " WHERE nombre  = '" + nombre + "'");
            correcto = true;
        } catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }
        return correcto;
    }

    //Método para borrar alimentación
    public boolean borrarAlimentacion(String nombreMascota, String nombreAlimen) {
        boolean correcto = false;

        dbHelper DbHelper = new dbHelper(context);
        SQLiteDatabase db = DbHelper.getWritableDatabase();

        try {
            db.execSQL(" DELETE FROM " + TABLA_ALIMEN + " WHERE nombreMascota  = '" + nombreMascota + "' AND nombreAlimen  = '" + nombreAlimen + "' ");
            correcto = true;
        } catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }
        return correcto;
    }
    //Método para borrar una vacuna
    public boolean borrarVacunacion(String nombreMascota, String nombreVac) {
        boolean correcto = false;

        dbHelper DbHelper = new dbHelper(context);
        SQLiteDatabase db = DbHelper.getWritableDatabase();

        try {
            db.execSQL(" DELETE FROM " + TABLA_VAC + " WHERE nombreMascota  = '" + nombreMascota + "' AND nombreVac  = '" + nombreVac + "' ");
            correcto = true;
        } catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }
        return correcto;
    }
    //Método para borrar una desparasitacion
    public boolean borrarDesparasitacion(String nombreMascota, String nombreDesp) {
        boolean correcto = false;

        dbHelper DbHelper = new dbHelper(context);
        SQLiteDatabase db = DbHelper.getWritableDatabase();

        try {
            db.execSQL(" DELETE FROM " + TABLA_DESP + " WHERE nombreMascota  = '" + nombreMascota + "' AND nombreDesp  = '" + nombreDesp + "' ");
            correcto = true;
        } catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }
        return correcto;
    }
    //Método para borrar un tratamiento
    public boolean borrarTto(String nombreMascota, String nombreTto) {
        boolean correcto = false;

        dbHelper DbHelper = new dbHelper(context);
        SQLiteDatabase db = DbHelper.getWritableDatabase();

        try {
            db.execSQL(" DELETE FROM " + TABLA_TTO + " WHERE nombreMascota  = '" + nombreMascota + "' AND nombreTto  = '" + nombreTto + "' ");
            correcto = true;
        } catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }
        return correcto;
    }
}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;

public class NuevaNotificacion extends AppCompatActivity implements View.OnClickListener{
    private TextView tvFechaNot, tvHoraNot;
    private Button btFechaNot, btHoraNot, btGuardar, btBorrar;
    private Calendar actual = Calendar.getInstance();
    private Calendar calendar = Calendar.getInstance();
    private int minutos, hora, mes, anio, dia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_notificacion);

        tvFechaNot = findViewById(R.id.tvFechaNot);
        tvHoraNot = findViewById(R.id.tvHoraNot);
        btFechaNot = findViewById(R.id.btFechaNot);
        btHoraNot = findViewById(R.id.btHoraNot);
        btGuardar = findViewById(R.id.btGuardar);
        btBorrar = findViewById(R.id.btBorrar);

        btFechaNot.setOnClickListener(this);
        btHoraNot.setOnClickListener(this);
        btGuardar.setOnClickListener(this);
        btBorrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.btFechaNot):
                anio= actual.get(Calendar.YEAR);
                mes= actual.get(Calendar.MONTH);
                dia= actual.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dataPickerDialog = new DatePickerDialog(view.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                        calendar.set(Calendar.DAY_OF_MONTH,d);
                        calendar.set(Calendar.MONTH,m);
                        calendar.set(Calendar.YEAR,y);

                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        String strDate = format.format(calendar.getTime());
                        tvFechaNot.setText(strDate);
                    }
                },anio, mes, dia);
                dataPickerDialog.show();


                break;
            case(R.id.btHoraNot):
                break;
            case(R.id.btGuardar):
                break;
            case(R.id.btBorrar):
                break;
        }

    }
}
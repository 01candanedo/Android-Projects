package com.example.avanzadospractica;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ProgressBar myProgressBar;
    DatePicker datePicker;
    TimePicker timePicker;
    EditText value;

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitControls();
        LoadDateTimePickers();
    }

    private void InitControls(){
        myProgressBar = (ProgressBar) findViewById(R.id.myBar);
        datePicker = (DatePicker) findViewById(R.id.date_picker);
        timePicker = (TimePicker) findViewById(R.id.time_picker);
        value = (EditText) findViewById(R.id.txtValor);
        result = (TextView) findViewById(R.id.txtResult);
    }

    private void LoadDateTimePickers(){


    }

    public void SetButton(View v){
       String valuedata = value.getText().toString();
       if(valuedata.isEmpty()){
           Toast.makeText(this, "Error en campo vacio", Toast.LENGTH_SHORT).show();
       }else{
           myProgressBar.setVisibility(View.VISIBLE);
           int x = Integer.parseInt(valuedata);
           //DatePickerVariables
           int year = datePicker.getYear();
           int month = datePicker.getMonth();
           int day = datePicker.getDayOfMonth();
           //TimePickerVariables
           int hour = timePicker.getHour();
           int minute = timePicker.getMinute();
           if((x>=0 && x <=100)){
               try {
                   new CountDownTimer(20000, 1){
                       int newProgress = 0;
                       @Override
                       public void onTick(long millisUntilFinished) {
                           if (newProgress == x) {
                               onFinish();
                           } else {
                               myProgressBar.setProgress(newProgress+1);
                               newProgress++;
                           }
                       }
                       @Override
                       public void onFinish() {}
                   }.start();
               }catch (Exception n){
                   Toast.makeText(this, "Error en el pb"+n, Toast.LENGTH_SHORT).show();
               }
           }
           else{
               Toast.makeText(this, "Error en el rango", Toast.LENGTH_SHORT).show();
           }
           result.setText("Hola, su fecha es: mes: "+month
                   +", dia: "+day
                   +", año: "+year
                   +", y en la hora: "+hour
                   +", con minutos: "+minute);
       }
    }

    public void ResetButton(View v){
        myProgressBar.setProgress(0);
        value.setText("");
        result.setText("");
        myProgressBar.setVisibility(View.GONE);
    }
    
}
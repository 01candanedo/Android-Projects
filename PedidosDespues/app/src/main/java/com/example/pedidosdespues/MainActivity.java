package com.example.pedidosdespues;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lstRest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstRest = (ListView) findViewById(R.id.lstRestaurantes);

        //Aqui declaramos el adapter simple
        ArrayAdapter<String> adapterSimple = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, LlenarListViewSimple());

        //Aqui declaramos el adapter Complejo
        AdapterRestaurante adapterComplejo = new AdapterRestaurante(getApplicationContext(), LlenarListViewComplejo());

        //Elejir uno de 2
        //lstRest.setAdapter(adapterSimple);
        //lstRest.setAdapter(adapterComplejo);
    }

    private List<String> LlenarListViewSimple(){
        List<String> restaurantes = new ArrayList<>();

        restaurantes.add("Macdonals");
        restaurantes.add("KF7");

        return restaurantes;
    }

    private List<Restaurante> LlenarListViewComplejo(){
        List<Restaurante> restaurantes = new ArrayList<Restaurante>();

        restaurantes.add(new Restaurante(R.drawable.ic_launcher_background,"Mecdonals", "54.00", "Paitilla", "6.8*"));
        restaurantes.add(new Restaurante(R.drawable.ic_launcher_background, "Patacon", "34.00", "West", "9.3*"));
        restaurantes.add(new Restaurante(R.drawable.ic_launcher_background, "Macarrones", "67.00", "Norte", "8.8*"));

        return restaurantes;
    }
}
package com.example.pedidosdespues;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AdapterRestaurante extends ArrayAdapter<Restaurante> {

    private List<Restaurante> opciones = new ArrayList<Restaurante>();

    public AdapterRestaurante(Context context, List<Restaurante> datos){
        super(context, R.layout.listview_restaurantes, datos);

        opciones = datos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_restaurantes, null);

        TextView nombre = (TextView) item.findViewById(R.id.txtNombre);
        nombre.setText(opciones.get(position).getNombre());

        TextView precio = (TextView) item.findViewById(R.id.txtPrecio);
        precio.setText(opciones.get(position).getPrecio());

        TextView location = (TextView) item.findViewById(R.id.txtLocation);
        location.setText(opciones.get(position).getPrecio());

        TextView rating = (TextView) item.findViewById(R.id.txtRatings);
        rating.setText(opciones.get(position).getRating());

        ImageView imagen = (ImageView) item.findViewById(R.id.imgLogo);
        imagen.setImageResource(opciones.get(position).getImagen());

        return item;
    }
}

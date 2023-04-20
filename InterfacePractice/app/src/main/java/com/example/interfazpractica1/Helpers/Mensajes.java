package com.example.interfazpractica1.Helpers;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class Mensajes extends DialogFragment {
    private String Titulo, Boton, Mensaje;

    public Mensajes(String titulo, String mensaje, String boton) {
        Titulo = titulo;
        Mensaje = mensaje;
        Boton = boton;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder constructor = new AlertDialog.Builder(getActivity());
        constructor.setTitle(Titulo)
                .setMessage(Mensaje)
                .setPositiveButton(Boton, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        return constructor.create();
    }
}

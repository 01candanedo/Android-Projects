package com.example.interfazpractica1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText txtNombre, txtDescripcion;
    CheckBox chkServ, chkCom, chkFar;
    RadioGroup rbgViable, rgbTiposRedes;
    Spinner spnPresupuesto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InicializarControles();
    }

    private void InicializarControles(){
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtDescripcion = (EditText) findViewById(R.id.txtDescripcion);

        chkServ = (CheckBox) findViewById(R.id.chkMensaje);
        chkCom = (CheckBox) findViewById(R.id.chkComida);
        chkFar = (CheckBox) findViewById(R.id.chkFarmacia);

        rbgViable = (RadioGroup) findViewById(R.id.rbgViable);

        spnPresupuesto = (Spinner) findViewById(R.id.spnPresupuesto);
    }

    public void InterfazPrincipal(View v){
        try {
            String nombre = txtNombre.getText().toString();
            String descripcion = txtDescripcion.getText().toString();
            String servicios = ObtenerCheckbox();
            String viable = "";

            switch(rbgViable.getCheckedRadioButtonId()){
                case R.id.rbtViableSi:
                    viable = "Si";
                    break;
                case R.id.rbtViableNo:
                    viable = "No";
                    break;
                default:
                    viable = "Por favor vete";
            }
            Toast.makeText(this, "Datitos : "+nombre+" "+descripcion+" "+servicios+" "+viable, Toast.LENGTH_LONG).show();
            new Mensajes("Titulo", "Mensaje", "Boton").show(getSupportFragmentManager(), "XD");
        }catch (Exception e){
            Toast.makeText(this, "Error brother: "+e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private String ObtenerCheckbox(){
        String seleccion = "";

        if(chkServ.isChecked()){
            seleccion += chkServ.getText().toString()+", ";
        }

        if(chkFar.isChecked()){
            seleccion += chkFar.getText().toString()+", ";
        }

        if(chkCom.isChecked()){
            seleccion += chkCom.getText().toString()+", ";
        }

        return seleccion;
    }

    public void CargarSpinner(View view){
        this.InicializarSpinner();
    }

    private List<String> ObtenerRedesSociales(){
        List<String> redes = new ArrayList<String>();
        redes.add("Twitch");
        redes.add("You");
        redes.add("Discord");
        redes.add("Github");
        redes.add("Gitlab");
        return redes;
    }

    private void InicializarSpinner(){
        ArrayAdapter<CharSequence> adapterPS5 = ArrayAdapter
                .createFromResource(getApplicationContext(),R.array.juegosPS5, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapterXBOX = ArrayAdapter
                .createFromResource(getApplicationContext(),R.array.juegosXbox, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterRedes =
                new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,this.ObtenerRedesSociales());

        switch (rgbTiposRedes.getCheckedRadioButtonId()){
            case R.id.rbtSwitch:
                spnPresupuesto.setAdapter(adapterRedes);
                break;
            case R.id.rbtPS5:
                spnJuegos.setAdapter(adapterPS5);
                break;
            case R.id.rbtXbox:
                spnJuegos.setAdapter(adapterXBOX);
                break;
        }
    }

}
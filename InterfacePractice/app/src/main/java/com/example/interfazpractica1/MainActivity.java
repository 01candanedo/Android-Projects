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
    RadioGroup rbgViable, rgbTiposEntretenimiento;
    Spinner spnEntretenimiento;

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
        rgbTiposEntretenimiento = (RadioGroup)findViewById(R.id.rgbTipoEntretenimiento);

        spnEntretenimiento = (Spinner) findViewById(R.id.spnPresupuesto);
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
        InicializarSpinner();
    }

    private void InicializarSpinner(){
        ArrayAdapter<String> adapterAnime =
                new ArrayAdapter<String>(getApplicationContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,this.GetAnime());

        ArrayAdapter<CharSequence> adapterSeries = ArrayAdapter
                .createFromResource(getApplicationContext(),R.array.datosSeries, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapterLudicos = ArrayAdapter
                .createFromResource(getApplicationContext(),R.array.datosLudicos, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);

        switch (rgbTiposEntretenimiento.getCheckedRadioButtonId()){
            case R.id.rbtAnime:
                spnEntretenimiento.setAdapter(adapterAnime);
                break;
            case R.id.rbtSeries:
                spnEntretenimiento.setAdapter(adapterSeries);
                break;
            case R.id.rbtLudicos:
                spnEntretenimiento.setAdapter(adapterLudicos);
                break;
        }
    }

    private List<String> GetAnime(){
        List<String> anm = new ArrayList<String>();
        anm.add("Tokyo Revengers");
        anm.add("Kimetsu no Yaiba");
        anm.add("One Piece");
        anm.add("Hunter x Hunter");
        anm.add("Evangelion");
        return anm;
    }

}
package com.andrealiznm.area_perimetro_volumen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText eLadoa, eLadob, eLadoc, eAltura, eRadio, eRespuesta;
    RadioButton rPerimetro, rArea, rVolumen, rCuadrado, rTriangulo, rCirculo, rCubo;
    RadioGroup rg1, rg2;
    Button bCalcular;
    int data, flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eLadoa = findViewById(R.id.eLadoa);
        eLadob = findViewById(R.id.eLadob);
        eLadoc = findViewById(R.id.eLadoc);
        eAltura = findViewById(R.id.eAltura);
        eRadio = findViewById(R.id.eRadio);
        eRespuesta = findViewById(R.id.eRespuesta);
        /*rPerimetro = findViewById(R.id.rPerimetro);
        rArea = findViewById(R.id.rArea);
        rVolumen = findViewById(R.id.rVolumen);
        rCuadrado = findViewById(R.id.rCuadrado);
        rCirculo = findViewById(R.id.rCirculo);
        rTriangulo = findViewById(R.id.rTriangulo);
        rCubo = findViewById(R.id.rCubo); */
        rg1 = findViewById(R.id.rg1);
        rg2 = findViewById(R.id.rg2);

    }

    public void onRadioButtonClicked(View view) {
        //Deshabilitar editText y limpiar editText
        eLadoa.setEnabled(false);
        eLadoa.setText("");
        eLadob.setEnabled(false);
        eLadob.setText("");
        eLadoc.setEnabled(false);
        eLadoc.setText("");
        eAltura.setEnabled(false);
        eAltura.setText("");
        eRadio.setEnabled(false);
        eRadio.setText("");
        eRespuesta.setEnabled(false);
        eRespuesta.setText("");

        if ((rg1.getCheckedRadioButtonId() == R.id.rCuadrado) && (rg2.getCheckedRadioButtonId() == R.id.rArea)) {
            eLadoa.setEnabled(true);
            eLadob.setEnabled(true);
            flag = 1;
        }
        if ((rg1.getCheckedRadioButtonId() == R.id.rCuadrado) && (rg2.getCheckedRadioButtonId() == R.id.rPerimetro)) {
            eLadoa.setEnabled(true);
            eLadob.setEnabled(true);
            flag = 11;
        }
        if ((rg1.getCheckedRadioButtonId() == R.id.rTriangulo) && (rg2.getCheckedRadioButtonId() == R.id.rArea)) {
            eLadoa.setEnabled(true);
            eAltura.setEnabled(true);
            flag = 2;
        }
        if ((rg1.getCheckedRadioButtonId() == R.id.rTriangulo) && (rg2.getCheckedRadioButtonId() == R.id.rPerimetro)) {
            eLadoa.setEnabled(true);
            eLadob.setEnabled(true);
            eLadoc.setEnabled(true);
            flag = 22;
        }
        if ((rg1.getCheckedRadioButtonId() == R.id.rCirculo) && (rg2.getCheckedRadioButtonId() == R.id.rArea)) {
            eRadio.setEnabled(true);
            flag = 3;
        }
        if ((rg1.getCheckedRadioButtonId() == R.id.rCirculo) && (rg2.getCheckedRadioButtonId() == R.id.rPerimetro)) {
            eRadio.setEnabled(true);
            flag = 33;
        }
        if ((rg1.getCheckedRadioButtonId() == R.id.rCubo) && (rg2.getCheckedRadioButtonId() == R.id.rVolumen)) {
            eLadoa.setEnabled(true);
            flag = 4;
        }

    }

    //Operaciones
    public void calcular(View view) {
        int id = view.getId();

        if (id == R.id.bCalcular && flag == 1){ //Area Cuadrado
            int a = Integer.parseInt(eLadoa.getText().toString());
            int b = Integer.parseInt(eLadob.getText().toString());
            data = a * b;
            eRespuesta.setText(String.valueOf(data));
        } else if (id == R.id.bCalcular && flag == 11) { // Perimetro Cuadrado
            int a = Integer.parseInt(eLadoa.getText().toString());
            int b = Integer.parseInt(eLadob.getText().toString());
            data = 2*a + 2*b;
            eRespuesta.setText(String.valueOf(data));
        } else if (id == R.id.bCalcular && flag == 2) { //Area Triangulo
            int a = Integer.parseInt(eLadoa.getText().toString());
            int h = Integer.parseInt(eAltura.getText().toString());
            data = (a*h)/2;
            eRespuesta.setText(String.valueOf(data));
        } else if (id == R.id.bCalcular && flag == 22) { // Perimetro Triangulo
            int a = Integer.parseInt(eLadoa.getText().toString());
            int b = Integer.parseInt(eLadob.getText().toString());
            int c = Integer.parseInt(eLadoc.getText().toString());
            data = a + b + c;
            eRespuesta.setText(String.valueOf(data));
        } else if (id == R.id.bCalcular && flag == 3) { // Area Circulo
            int r = Integer.parseInt(eRadio.getText().toString());
            double dat = Math.PI*Math.pow(r,2);
            eRespuesta.setText(String.valueOf(dat));
        } else if (id == R.id.bCalcular && flag == 33) { // Perimetro Circulo
            int r = Integer.parseInt(eRadio.getText().toString());
            double dat = 2*Math.PI*r;
            eRespuesta.setText(String.valueOf(dat));
        } else if (id == R.id.bCalcular && flag == 4) { // Vol Cubo
            int a = Integer.parseInt(eLadoa.getText().toString());
            double dat = Math.pow(a,3);
            eRespuesta.setText(String.valueOf(dat));
        }

    }
}
package com.example.calculocuotasvivienda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {
    Button btnCalcular, btnLimpiarCampos;
    EditText etValorInmueble, etPeriodoPagos;
    TextView txvValorCuotaInicial, txvValorCuotaMensual;

    private void inicializarCampos() {
        etValorInmueble = findViewById(R.id.etValorInmueble);
        etPeriodoPagos = findViewById(R.id.etPeriodoPagos);
        txvValorCuotaInicial = findViewById(R.id.txvValorCuotaInicial);
        txvValorCuotaMensual = findViewById(R.id.txvValorCuotaMensual);
        btnCalcular =  findViewById(R.id.btnCalcular);
        btnLimpiarCampos = findViewById(R.id.btnLimpiarCampos);
        btnCalcular.setOnClickListener(this);
        btnLimpiarCampos.setOnClickListener(this);
    }

    private void limpiarCampos() {
        etValorInmueble.getText().clear();
        etPeriodoPagos.getText().clear();
        txvValorCuotaInicial.setText("");
        txvValorCuotaMensual.setText("");
        btnCalcular.setVisibility(View.VISIBLE);
        btnLimpiarCampos.setVisibility(View.GONE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarCampos();
        btnLimpiarCampos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpiarCampos();
            }
        });
        btnLimpiarCampos.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View view) {
        int valorInmueble, periodoPagos;
        int cuotaInicial, cuotaRestante, cuotaMensual;

        valorInmueble = Integer.parseInt(etValorInmueble.getText().toString());
        periodoPagos = Integer.parseInt(etPeriodoPagos.getText().toString());

        // Opción para probar con valores de tipo Entero
        cuotaInicial = (int) (valorInmueble * 0.3);
        cuotaRestante = (int) (valorInmueble * 0.7);
        cuotaMensual = ((cuotaRestante) / (periodoPagos * 12));

        // Opción para probar con valores de tipo Double
        //double cuotaInicial = (valorInmueble * 0.3);
        //double cuotaRestante = (valorInmueble * 0.7);
        //double cuotaMensual = ((cuotaRestante) / (periodoPagos * 12));

        DecimalFormat formateador = new DecimalFormat(",###");
        txvValorCuotaInicial.setText(" " + formateador.format(cuotaInicial) + " COP");
        txvValorCuotaMensual.setText(" " + formateador.format(cuotaMensual) + " COP");
        Toast.makeText(getApplicationContext(), "Se ha calculado correctamente la Cuota", Toast.LENGTH_LONG).show();
        btnCalcular.setVisibility(View.GONE);
        btnLimpiarCampos.setVisibility(View.VISIBLE);
    }
}
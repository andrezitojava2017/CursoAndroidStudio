package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText precoGasolina;
    private EditText precoAlcool;
    private TextView resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoAlcool = findViewById(R.id.editAlcool);
        precoGasolina = findViewById(R.id.editGasolina);
        resultado= findViewById(R.id.textResultado);

        Button calcular = findViewById(R.id.btnCalcular);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularPreco(view);
            }
        });
    }

    public void calcularPreco(View view){

        double alcool = Double.parseDouble(precoAlcool.getText().toString());
        double gasolina = Double.parseDouble(precoGasolina.getText().toString());

        /* Formula de calculo: (alcool / gasolina)
            se resultado >= 0.7 melhor utilizar gasolina
            senao melhor utilizar alcool
         */
        double result = (alcool / gasolina);

        if(result >= 0.7){
            resultado.setText("Melhor utilizar GASOLINA!");
        } else {
            resultado.setText("Melhor utilizar ALCOOL!");
        }

    }
}
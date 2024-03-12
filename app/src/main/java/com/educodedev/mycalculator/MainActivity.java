package com.educodedev.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_suma;
    private Button btn_resta;
    private Button btn_multiplicacion;
    private Button btn_division;
    private Button btn_limpiar;
    private Button btn_factorial;


    private TextView text_resultado;
    private EditText edit_numero_uno;
    private EditText edit_numero_dos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_limpiar = findViewById(R.id.btn_limpiar);
        btn_limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();
            }
        });


        btn_factorial = findViewById(R.id.btn_factorial);
        btn_factorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_resultado.setText(factorial
                        (Double.parseDouble(edit_numero_uno.getText().toString())) + "");
            }
        });

        btn_suma = findViewById(R.id.button_suma);
        btn_suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_resultado.setText(suma
                        (Double.parseDouble(edit_numero_uno.getText().toString()),
                                Double.parseDouble(edit_numero_dos.getText().toString())) + "");
            }
        });

        btn_resta = findViewById(R.id.button_resta);
        btn_resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_resultado.setText(resta
                        (Double.parseDouble(edit_numero_uno.getText().toString()),
                                Double.parseDouble(edit_numero_dos.getText().toString())) + "");
            }
        });

        btn_multiplicacion = findViewById(R.id.button_multiplicacion);
        btn_multiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_resultado.setText(multiplicacion
                        (Double.parseDouble(edit_numero_uno.getText().toString()),
                                Integer.parseInt(edit_numero_dos.getText().toString())) + "");
            }
        });

        btn_division = findViewById(R.id.button_division);
        btn_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_resultado.setText(division
                        (Double.parseDouble(edit_numero_uno.getText().toString()),
                                Integer.parseInt(edit_numero_dos.getText().toString())) + "");
            }
        });

        text_resultado = findViewById(R.id.resultado);

        edit_numero_uno = findViewById(R.id.numero1);
        edit_numero_dos = findViewById(R.id.numero2);

    }

    public void limpiar() {
        edit_numero_uno.setText("");
        edit_numero_dos.setText("");
        Toast.makeText(getApplicationContext(), "Comienza de nuevo"
                , Toast.LENGTH_LONG).show();
    }

    public double suma(double a, double b) {
        return a + b;
    }

    public double resta(double a, double b) {
        return a - b;
    }

    public double multiplicacion(double a, double b) {
        return a * b;
    }

    public double factorial(double a) {
        edit_numero_dos.setText("");
        double fact = a;
        for (int i = 1; i < a; i++) {
           fact = fact *(i);
        }
      
            Toast.makeText(getApplicationContext(), "Lo cálcula en base al número en el campo de arriba"
                    , Toast.LENGTH_LONG).show();


        return fact;
    }

    public double division(double a, double b) {
        double respuesta = 0;

        if (b != 0) {
            respuesta = a / b;
        } else {
            Toast.makeText(getApplicationContext(), "No se pueden dividir números por CERO ¿Eres tonto?!!"
                    , Toast.LENGTH_LONG).show();
        }
        return respuesta;
    }
}
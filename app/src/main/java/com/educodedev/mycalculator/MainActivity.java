package com.educodedev.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    double firstNum;
    String operation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button num0 = findViewById(R.id.num0);
        Button num1 = findViewById(R.id.num1);
        Button num2 = findViewById(R.id.num2);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button num3 = findViewById(R.id.num3);
        Button num4 = findViewById(R.id.num4);
        Button num5 = findViewById(R.id.num5);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button num6 = findViewById(R.id.num6);
        Button num7 = findViewById(R.id.num7);
        Button num8 = findViewById(R.id.num8);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button num9 = findViewById(R.id.num9);

        Button percent = findViewById(R.id.percent);
        Button plusMinus = findViewById(R.id.plusMinus);
        Button ac = findViewById(R.id.ac);
        Button div = findViewById(R.id.div);
        Button times = findViewById(R.id.times);
        Button min = findViewById(R.id.min);
        Button plus = findViewById(R.id.plus);
        Button equal = findViewById(R.id.equal);
        Button point = findViewById(R.id.point);

        TextView screen = findViewById(R.id.screen);


        ac.setOnClickListener(view -> {
            firstNum = 0;
            screen.setText("0");
        });


        ArrayList<Button> nums = new ArrayList<>();
        nums.add(num0);
        nums.add(num1);
        nums.add(num2);
        nums.add(num3);
        nums.add(num4);
        nums.add(num5);
        nums.add(num6);
        nums.add(num7);
        nums.add(num8);
        nums.add(num9);

        for (Button b : nums) {
            b.setOnClickListener(View -> {
                if (!screen.getText().toString().equals("0")) {
                    screen.setText(screen.getText().toString() + b.getText().toString());
                } else {
                    screen.setText(b.getText().toString());
                }
            });
        }
        ArrayList<Button> operators = new ArrayList<>();
        operators.add(div);
        operators.add(times);
        operators.add(plus);
        operators.add(min);

        for (Button b : operators) {
            b.setOnClickListener(view -> {
                firstNum = Double.parseDouble(screen.getText().toString());
                operation = b.getText().toString();
                screen.setText("0");
            });
        }


        point.setOnClickListener(view -> {
            if (!screen.getText().toString().contains(".")) {
                screen.setText(screen.getText().toString() + ".");
            }
        });


        plusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String currentText = screen.getText().toString();

                if (currentText.startsWith("-")) {
                    screen.setText(currentText.substring(1));
                } else {
                    screen.setText("-" + currentText);
                }
            }
        });

        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = screen.getText().toString();

                double currentNum = Double.parseDouble(currentText);

                double percent = firstNum * (currentNum / 100);

                screen.setText(String.valueOf(percent));
            }
        });


        equal.setOnClickListener(view -> {
            double secondNum = Double.parseDouble(screen.getText().toString());
            double resultado;
            switch (operation) {
                case "÷":
                    if (secondNum == 0) {
                        resultado = 0;
                        break;
                    } else {
                        resultado = firstNum / secondNum;
                    }
                    break;
                case "X":
                    resultado = firstNum * secondNum;
                    break;
                case "+":
                    resultado = firstNum + secondNum;
                    break;
                case "-":
                    resultado = firstNum - secondNum;
                    break;
                default:
                    resultado = firstNum + secondNum;
                    break;
            }
            screen.setText(String.valueOf(resultado));
            firstNum = resultado;
        });

    }

}
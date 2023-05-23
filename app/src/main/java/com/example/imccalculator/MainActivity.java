package com.example.imccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextWeight, editTextHeight;
    private Button buttonCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);
        buttonCalculate = findViewById(R.id.buttonCalculate);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateIMC();
            }
        });
    }

    private void calculateIMC() {
        String weightString = editTextWeight.getText().toString();
        String heightString = editTextHeight.getText().toString();

        if (weightString.isEmpty() || heightString.isEmpty()) {
            Toast.makeText(this, "Por favor, insira os valores da altura e peso corretamente.", Toast.LENGTH_SHORT).show();
            return;
        }

        float weight = Float.parseFloat(weightString);
        float height = Float.parseFloat(heightString) / 100; // convert cm to meters

        float imc = weight / (height * height);

        String imcCategory;
        if (imc < 18.5) {
            imcCategory = "Magreza";
        } else if (imc < 24.9) {
            imcCategory = "Normal";
        } else if (imc < 29.9) {
            imcCategory = "Sobrepeso";
        } else if (imc < 34.9) {
            imcCategory = "Obesidade";
        } else if (imc < 39.9) {
            imcCategory = "Obesidade severa";
        } else {
            imcCategory = "Obesidade mórbida";
        }

        String result = "Seu IMC é: " + String.format("%.1f", imc) + "kg/m²." + "\nCategoria: " + imcCategory;
        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
    }
}
package com.example.calculadoradeimc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.calculadoradeimc.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        TextView resultado = findViewById(R.id.exibirResultado);

        TextView classificacao = findViewById(R.id.classificacaoIMC);

        Button botaoIMC = findViewById(R.id.calcular);
        botaoIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculaIMC();
            }
            private void calculaIMC(){
                EditText valorAltura = findViewById(R.id.inputAltura);
                EditText valorPeso = findViewById(R.id.inputPeso);

                double CalculoIMC = Double.parseDouble(valorPeso.getText().toString())/(Double.parseDouble(valorAltura.getText().toString())*Double.parseDouble(valorAltura.getText().toString()));
                if (CalculoIMC <= 18.5){
                    classificacao.setText(String.valueOf("Abaixo do peso!"));
                } else if (CalculoIMC <= 24.9) {
                    classificacao.setText(String.valueOf("Peso ideal!"));
                } else if (CalculoIMC <= 29.9) {
                    classificacao.setText(String.valueOf("Sobrepeso!"));
                } else if (CalculoIMC <= 34.9) {
                    classificacao.setText(String.valueOf("Obesidade Grau I!"));
                } else if (CalculoIMC <= 39.9) {
                    classificacao.setText(String.valueOf("Obesidade Grau II(severa)!"));
                } else {
                    classificacao.setText(String.valueOf("Obesidade Grau II(mórbida)!"));
                }
                classificacao.setVisibility(View.VISIBLE);

                resultado.setText(String.valueOf(CalculoIMC));
                resultado.setVisibility(View.VISIBLE);
            }
        });
    }
}
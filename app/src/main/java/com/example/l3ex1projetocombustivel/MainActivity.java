package com.example.l3ex1projetocombustivel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etGasolina;
    private EditText etEtanol;
    private TextView tvMelhor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etGasolina = findViewById(R.id.etGasolina);
        etGasolina.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etEtanol = findViewById(R.id.etEtanol);
        etEtanol.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Button btnComparar = findViewById(R.id.btnComparar);
        tvMelhor = findViewById(R.id.tvMelhor);
        tvMelhor.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        btnComparar.setOnClickListener(op -> comparar());
    }

    private void comparar(){
        double gasolina = Double.parseDouble(etGasolina.getText().toString());
        double etanol = Double.parseDouble(etEtanol.getText().toString());
        double comp = gasolina * 0.7;
        String res;

        if (etanol > comp){
            res = getString(R.string.gasolina);
            tvMelhor.setText(res);
        }
        else{
            res = getString(R.string.etanol);
            tvMelhor.setText(res);
        }
    }
}
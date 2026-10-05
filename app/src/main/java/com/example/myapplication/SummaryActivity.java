package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    TextView textViewKlient;
    TextView textViewRozmiar;
    TextView textViewSer;
    Button buttonPowrot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        textViewKlient = findViewById(R.id.textViewKlient);
        textViewRozmiar = findViewById(R.id.textViewRozmiar);
        textViewSer = findViewById(R.id.textViewSer);
        buttonPowrot = findViewById(R.id.buttonPowrot);

        String klient = getIntent().getStringExtra("KLIENT");
        String rozmiar = getIntent().getStringExtra("ROZMIAR");
        boolean dodatkowySer = getIntent().getBooleanExtra("SER", false);

        textViewKlient.setText("Klient: " + klient);
        textViewRozmiar.setText("Rozmiar pizzy: " + rozmiar);

        if (dodatkowySer) {
            textViewSer.setText("Dodatkowy ser: Tak");
        } else {
            textViewSer.setText("Dodatkowy ser: Nie");
        }

        buttonPowrot.setOnClickListener(v -> finish());
    }
}
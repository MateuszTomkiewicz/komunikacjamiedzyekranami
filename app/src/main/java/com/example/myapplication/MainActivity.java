package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextKlient;
    RadioGroup radioGroupRozmiar;
    CheckBox checkBoxSer;
    Button buttonPodsumowanie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextKlient = findViewById(R.id.editTextKlient);
        radioGroupRozmiar = findViewById(R.id.radioGroupRozmiar);
        checkBoxSer = findViewById(R.id.checkBoxSer);
        buttonPodsumowanie = findViewById(R.id.buttonPodsumowanie);

        buttonPodsumowanie.setOnClickListener(v -> {

            String klient = editTextKlient.getText().toString().trim();

            if (klient.isEmpty()) {
                editTextKlient.setError("Wpisz nazwę klienta");
                editTextKlient.requestFocus();
                return;
            }

            int selectedId = radioGroupRozmiar.getCheckedRadioButtonId();

            if (selectedId == -1) {
                return;
            }

            RadioButton radioButton = findViewById(selectedId);
            String rozmiar = radioButton.getText().toString();

            boolean dodatkowySer = checkBoxSer.isChecked();

            Intent intent = new Intent(MainActivity.this, SummaryActivity.class);

            intent.putExtra("KLIENT", klient);
            intent.putExtra("ROZMIAR", rozmiar);
            intent.putExtra("SER", dodatkowySer);

            startActivity(intent);
        });
    }
}
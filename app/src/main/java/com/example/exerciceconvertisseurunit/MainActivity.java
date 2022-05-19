package com.example.exerciceconvertisseurunit;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner spfrom, spto;
    EditText e;
    Button b;
    TextView tres;
    String[] unites;
    float[] valunits = {1000, 100, 10, 1, 0.1f, 0.01f, 0.001f};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spfrom = findViewById(R.id.spFrom);
        spto = findViewById(R.id.spTo);
        e = findViewById(R.id.eval);
        b = findViewById(R.id.btn);
        tres = findViewById(R.id.tres);

        unites = getResources().getStringArray(R.array.unites);
        ArrayAdapter<String> ad = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, unites);
        spfrom.setAdapter(ad);
        spto.setAdapter(ad);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (e.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Valeur vide", Toast.LENGTH_SHORT).show();
                    return;
                }

                double val = Double.valueOf(e.getText().toString());
                int posFrom = spfrom.getSelectedItemPosition();
                int posTo = spto.getSelectedItemPosition();

                double res = val * (valunits[posFrom] / valunits[posTo]);

                tres.setText(String.format("Resultat : %.2f",res));

            }
        });

    }
}
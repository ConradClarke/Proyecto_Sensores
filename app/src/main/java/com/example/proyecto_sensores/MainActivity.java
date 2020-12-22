package com.example.proyecto_sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView Bienvenida, Descripcion;
    Button Proximidad, Acelerometro, Huella;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bienvenida = findViewById(R.id.textView);
        Descripcion = findViewById(R.id.textView2);
        Proximidad = findViewById(R.id.button);
        Acelerometro = findViewById(R.id.button2);
        Huella = findViewById(R.id.button3);
        Proximidad.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Sensor_Proximidad.class);
            startActivity(intent);
        });
        Acelerometro.setOnClickListener(v -> {
            Intent intent1 = new Intent(MainActivity.this, Sensor_Acelerometro.class);
            startActivity(intent1);
        });
        Huella.setOnClickListener(v -> {
            Intent intent2 = new Intent(MainActivity.this, Huella_Digital.class);
            startActivity(intent2);
        });
}
}
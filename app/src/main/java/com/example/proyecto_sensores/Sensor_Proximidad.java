package com.example.proyecto_sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class Sensor_Proximidad extends AppCompatActivity implements SensorEventListener{
    SensorManager sm;
    Sensor proxSensor;
    TextView proxText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor__proximidad);
        this.setTitle(R.string.titulo2);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        proxSensor = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        proxText   = findViewById(R.id.proximityTextview);
        sm.registerListener(this, proxSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        String proxText1 = String.valueOf(event.values[0]);
        proxText.setText(proxText1);
        float valor = Float.parseFloat(proxText1);
        if (valor==0){
            proxText.setBackgroundColor(Color.CYAN);
        }
        else
        {
            proxText.setBackgroundColor(Color.GRAY);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}

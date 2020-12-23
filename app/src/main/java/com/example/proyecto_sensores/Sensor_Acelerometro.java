package com.example.proyecto_sensores;

import java.util.List;
import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Sensor_Acelerometro extends AppCompatActivity implements SensorEventListener{
    private Sensor mAccelerometer;
    TextView x,y,z;
    ImageView img1,img2,img3,img4,img5,img6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor__acelerometro);
        this.setTitle(R.string.titulo1);
        x= (TextView)findViewById(R.id.txtx);
        y= (TextView)findViewById(R.id.txty);
        z= (TextView)findViewById(R.id.txtz);
        img1=findViewById(R.id.imgF);
        img2=findViewById(R.id.imgFi);
        img3=findViewById(R.id.imgRight);
        img4=findViewById(R.id.imgLeft);
        img5=findViewById(R.id.imgUp);
        img6=findViewById(R.id.imgDown);
    }
    //Método para recibir entrada
    protected void onResume() {
        super.onResume();
        SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensors = sm.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (sensors.size()> 0){ //Verificar si tiene sensor
            sm.registerListener(this, sensors.get(0),SensorManager.SENSOR_DELAY_GAME);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        this.x.setText("X = "+event.values[SensorManager.DATA_X]);
        this.y.setText("Y = "+event.values[SensorManager.DATA_Y]);
        this.z.setText("Z = "+event.values[SensorManager.DATA_Z]);
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];


        if (x<-5 ){
            getWindow().getDecorView().setBackgroundColor(Color.BLUE);
            img3.setVisibility(View.VISIBLE);
            img1.setVisibility(View.INVISIBLE);
            img2.setVisibility(View.INVISIBLE);
            img6.setVisibility(View.INVISIBLE);
            img4.setVisibility(View.INVISIBLE);
            img5.setVisibility(View.INVISIBLE);

        } else if (x>5) {
            getWindow().getDecorView().setBackgroundColor(Color.RED);
            img4.setVisibility(View.VISIBLE);
            img1.setVisibility(View.INVISIBLE);
            img2.setVisibility(View.INVISIBLE);
            img3.setVisibility(View.INVISIBLE);
            img5.setVisibility(View.INVISIBLE);
            img6.setVisibility(View.INVISIBLE);
        }

        if (y<-5 ){
            getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
            img2.setVisibility(View.VISIBLE);
            img1.setVisibility(View.INVISIBLE);
            img3.setVisibility(View.INVISIBLE);
            img4.setVisibility(View.INVISIBLE);
            img5.setVisibility(View.INVISIBLE);
            img6.setVisibility(View.INVISIBLE);

        } else if (y>5) {
            getWindow().getDecorView().setBackgroundColor(Color.rgb(	255,165,0));
            img1.setVisibility(View.VISIBLE);
            img2.setVisibility(View.INVISIBLE);
            img3.setVisibility(View.INVISIBLE);
            img4.setVisibility(View.INVISIBLE);
            img5.setVisibility(View.INVISIBLE);
            img6.setVisibility(View.INVISIBLE);
        }

        if (z<-5 ){
            getWindow().getDecorView().setBackgroundColor(Color.MAGENTA);
            img6.setVisibility(View.VISIBLE);
            img1.setVisibility(View.INVISIBLE);
            img2.setVisibility(View.INVISIBLE);
            img3.setVisibility(View.INVISIBLE);
            img4.setVisibility(View.INVISIBLE);
            img5.setVisibility(View.INVISIBLE);

        } else if (z>5) {
            getWindow().getDecorView().setBackgroundColor(Color.GREEN);
            img5.setVisibility(View.VISIBLE);
            img1.setVisibility(View.INVISIBLE);
            img2.setVisibility(View.INVISIBLE);
            img3.setVisibility(View.INVISIBLE);
            img4.setVisibility(View.INVISIBLE);
            img6.setVisibility(View.INVISIBLE);
        }
    }


    protected void onPause() {
        SensorManager mSensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        mSensorManager.unregisterListener(this, mAccelerometer);
        super.onPause();
    }

    protected void onStop() {
        SensorManager mSensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        mSensorManager.unregisterListener(this, mAccelerometer);
        super.onStop();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
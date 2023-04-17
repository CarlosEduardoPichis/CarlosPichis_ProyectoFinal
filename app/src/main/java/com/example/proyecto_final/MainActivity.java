package com.example.proyecto_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer intro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Ocultar ActionBar superior
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main);
        //iniciamos el sonido de entrada
        intro = MediaPlayer.create(this, R.raw.inicio);
        intro.start();
        //Agregamos el tiempo de espera para la siguiente ventana
        TimerTask entrada = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, EntradaActivity.class);
                startActivity(intent);// esto es para que se pase a la otra ventana
                finish();//finalizamos para que no vuelva a mostrar
                intro.stop();//termina el sonido
            }
        };
        Timer tiempo = new Timer();
        tiempo.schedule(entrada, 5000);//Espera 5 segundos y pase a la siguiente ventana
    }
}
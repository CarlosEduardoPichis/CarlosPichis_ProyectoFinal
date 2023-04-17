package com.example.proyecto_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;

public class ChannelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Ocultar ActionBar superior
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_channel);

        botonCanales();
    }

    public void botonCanales(){// Obtener referencia al botón
        ImageButton launoButton = findViewById(R.id.launo);
        ImageButton ladosButton = findViewById(R.id.lados);
        ImageButton fdfButton = findViewById(R.id.fdf);
        ImageButton cuatroButton = findViewById(R.id.cuatro);
        ImageButton boingButton = findViewById(R.id.boing);
        ImageButton clanButton = findViewById(R.id.clan);
        ImageButton energyButton = findViewById(R.id.energy);
        ImageButton tv3Button = findViewById(R.id.tv3);
        ImageButton veinticuatroButton = findViewById(R.id.veinticuatro);
        ImageButton telecincoButton = findViewById(R.id.telecinco);

        // Botón canal La 1
        // Configurar el botón para abrir el WebView y cargar la URL del stream en vivo
        launoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Abrir la actividad "ReproduccioActivity" y pasar la URL correspondiente
                Intent intent = new Intent(ChannelActivity.this, ReproduccioActivity.class);
                intent.putExtra("url", "https://www.rtve.es/play/videos/directo/canales-lineales/la-1/");
                // Inicia una nueva actividad "ReproduccioActivity"
                startActivity(intent);
            }
        });

        // Botón canal La 2
        // Configurar el botón para abrir el WebView y cargar la URL del stream en vivo
        ladosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Abrir la actividad "ReproduccioActivity" y pasar la URL correspondiente
                Intent intent = new Intent(ChannelActivity.this, ReproduccioActivity.class);
                intent.putExtra("url", "https://www.rtve.es/play/videos/directo/canales-lineales/la-2/");
                startActivity(intent);
            }
        });

        // Botón canal FDF
        fdfButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Abrir la actividad "ReproduccioActivity" y pasar la URL correspondiente
                Intent intent = new Intent(ChannelActivity.this, ReproduccioActivity.class);
                intent.putExtra("url", "https://www.mitele.es/directo/fdf/");
                startActivity(intent);
            }
        });
        // Botón canal Cuatro
        cuatroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Abrir la actividad "ReproduccioActivity" y pasar la URL correspondiente
                Intent intent = new Intent(ChannelActivity.this, ReproduccioActivity.class);
                intent.putExtra("url", "https://www.mitele.es/directo/cuatro/");
                startActivity(intent);
            }
        });
        // Botón canal Boing
        boingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Abrir la actividad "ReproduccioActivity" y pasar la URL correspondiente
                Intent intent = new Intent(ChannelActivity.this, ReproduccioActivity.class);
                intent.putExtra("url", "https://www.mitele.es/directo/boing/");
                startActivity(intent);
            }
        });
        // Botón canal Clan
        clanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Abrir la actividad "ReproduccioActivity" y pasar la URL correspondiente
                Intent intent = new Intent(ChannelActivity.this, ReproduccioActivity.class);
                intent.putExtra("url", "https://www.rtve.es/play/videos/directo/canales-lineales/clan/");
                startActivity(intent);
            }
        });
        // Botón canal Energy
        energyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Abrir la actividad "ReproduccioActivity" y pasar la URL correspondiente
                Intent intent = new Intent(ChannelActivity.this, ReproduccioActivity.class);
                intent.putExtra("url", "https://www.mitele.es/directo/energy/");
                startActivity(intent);
            }
        });
        // Botón canal TV3
        tv3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Abrir la actividad "ReproduccioActivity" y pasar la URL correspondiente
                Intent intent = new Intent(ChannelActivity.this, ReproduccioActivity.class);
                intent.putExtra("url", "https://www.ccma.cat/tv3/directe/tv3/");
                startActivity(intent);
            }
        });
        // Botón canal 24h
        veinticuatroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Abrir la actividad "ReproduccioActivity" y pasar la URL correspondiente
                Intent intent = new Intent(ChannelActivity.this, ReproduccioActivity.class);
                intent.putExtra("url", "https://www.rtve.es/play/videos/directo/canales-lineales/24h/");
                startActivity(intent);
            }
        });
        // Botón canal Telecinco
        telecincoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Abrir la actividad "ReproduccioActivity" y pasar la URL correspondiente
                Intent intent = new Intent(ChannelActivity.this, ReproduccioActivity.class);
                intent.putExtra("url", "https://www.mitele.es/directo/telecinco/");
                startActivity(intent);
            }
        });
    }
}
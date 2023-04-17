package com.example.proyecto_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


public class EntradaActivity extends AppCompatActivity {
    private EditText usuari, clave;
    private Button inicio, registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Ocultar ActionBar superior
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_entrada);
        // Llama a los metodos creados
        iniciView();
        nextClass();
        botonRedes();
    }
    private void iniciView(){
        // Busca los elementos de la vista y los inicializa en la actividad actual
        usuari = findViewById(R.id.editCorreo);
        clave = findViewById(R.id.editPass);
        inicio = findViewById(R.id.entrada);
        registro = findViewById(R.id.register);
    }
    private void nextClass(){
        // Configura el comportamiento del botón de inicio de sesión
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verifica si los campos de usuario y contraseña están vacíos
                if(usuari.getText().toString().isEmpty() && clave.getText().toString().isEmpty()){
                    Toast.makeText(EntradaActivity.this, "Complete los campos para iniciar sesión", Toast.LENGTH_SHORT).show();
                }else if(usuari.getText().toString().equals("admin") && clave.getText().toString().equals("admin")){
                    // Inicia la actividad ChannelActivity
                    startActivity(new Intent(EntradaActivity.this,ChannelActivity.class));
                }
            }
        });// Configura el comportamiento del botón de registro
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inicia la actividad RegisterActivity
                startActivity(new Intent(EntradaActivity.this,RegisterActivity.class));
            }
        });
    }

    public void botonRedes(){
        // Busca los botones de las redes sociales y les configura el comportamiento
        ImageButton facebookButton = findViewById(R.id.imageButton);
        ImageButton googleButton = findViewById(R.id.imageButton2);
        ImageButton twitterButton = findViewById(R.id.imageButton3);

        // Botón de Facebook
        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Abrir página de Facebook
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/login.php"));
                startActivity(intent);
            }
        });
        // Botón de Google
        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Abrir página de Google
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://accounts.google.com/signin/v2"));
                startActivity(intent);
            }
        });
        // Botón de Twitter
        twitterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Abrir página de Twitter
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.twitter.com/i/flow/login"));
                startActivity(intent);
            }
        });
    }
}
package com.example.proyecto_final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ReproduccioActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Ocultar la barra de estado del sistema movil
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        //Ocultar ActionBar superior
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_reproduccio);

        // Obtener referencia al WebView
        webView = findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        // Habilitar la carga de la página completa y el ancho de vista amplia
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);

        // Habilitar el almacenamiento DOM para que la página web pueda funcionar correctamente.
        // Es útil para las aplicaciones web que necesitan almacenar datos del usuario en el dispositivo
        webView.getSettings().setDomStorageEnabled(true);

        // Obtener la URL pasada como parámetro
        String url = getIntent().getStringExtra("url");

        // Cargar la URL en el WebView
        webView.loadUrl(url);
        webView.setVisibility(View.VISIBLE);
    }

    // Métodos onPause() y onResume() para pausar y reanudar la reproducción del video respectivamente
    @Override
    protected void onPause() {
        super.onPause();
        webView.onPause();
    }
    @Override
    protected void onResume() {
        super.onResume();
        webView.onResume();
    }
    // Método onDestroy() para asegurar de que se liberen todos los recursos cuando el usuario abandone la actividad
    @Override
    protected void onDestroy() {
        super.onDestroy();
        webView.destroy();
    }
}
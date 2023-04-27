package com.example.proyecto_final;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    private EditText nombre, correo, clave;
    private ImageButton volver;
    private Button guardar;
    // VARIABLES DE LOS DATOS A REGISTRAR
    private FirebaseFirestore mfirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Ocultar ActionBar superior
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_register);
        // Llama a los metodos creados
        iniciarVar();
        buttonUse();
    }

    private void iniciarVar(){
        // Inicializar y asignar valores a las variables de la actividad en la que se encuentra
        nombre = findViewById(R.id.editTextNombre);
        correo = findViewById(R.id.editTextCorreo);
        clave = findViewById(R.id.editTextClave);
        volver = findViewById(R.id.atras);
        guardar = findViewById(R.id.btn_add);
        mfirestore = FirebaseFirestore.getInstance();

    }
    private void buttonUse(){
        // Asignamos una funcion al boton "volver" para iniciar una nueva actividad
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inicia la actividad EntradaActivity
                startActivity(new Intent(RegisterActivity.this,EntradaActivity.class));
            }
        });
        // Asignamos una funcion al boton "guardar" para registrar al usuario en la base de datos
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nombre.getText().toString().trim();
                String email = correo.getText().toString().trim();
                String password = clave.getText().toString().trim();
                // Si los campos estan vacios mostramos un mensaje emergente
                if(name.isEmpty() && email.isEmpty() && password.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Ingrese los datos", Toast.LENGTH_SHORT).show();
                }else{ // Inicia el metodo creado
                    registerUser(name, email, password);
                }
            }
        });
    }

    private void registerUser(String name, String email, String password) {
        // Creamos un mapa con los datos del usuario
        Map<String, Object> map = new HashMap<>();
        map.put("nombre", name);
        map.put("correo", email);
        map.put("clave", password);
        // Agregamos los datos del usuario a la base de datos
        mfirestore.collection("usuarios").add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                // Imprimimos el texto "Creado extosamente " y inicia la actividad ChannelActivity
                Toast.makeText(getApplicationContext(),"Creado exitosamente", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterActivity.this,ChannelActivity.class));
            }
        //En caso que falle nos arrojara el texto de Error
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"Error al ingresar", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
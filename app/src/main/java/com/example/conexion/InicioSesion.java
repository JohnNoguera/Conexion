package com.example.conexion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class InicioSesion extends AppCompatActivity {

    private EditText etCorreo;
    private EditText etPassword;
    private Button btIngresar;

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
        etCorreo = findViewById(R.id.etCorreo);
        etPassword = findViewById(R.id.etPassword);
        btIngresar = findViewById(R.id.btIngresar);
        firebaseAuth = FirebaseAuth.getInstance();
        btIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etCorreo.getText().toString();
                String password = etPassword.getText().toString();

                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {


                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        Toast.makeText(InicioSesion.this, "ingreso exitoso", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                });

            }
        });

    }

    public void PantallaActualizarPassw(View view) {
        Intent i = new Intent(this, ActualizarContrasena.class);
        startActivity(i);
    }

    public void PantallaRegistro(View view) {
        Intent i = new Intent(this, RegistrarseActivity.class);
        startActivity(i);


    }
}
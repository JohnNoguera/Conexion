package com.example.conexion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this,InicioSesion.class);
                startActivity(i);
            }


        },3000);

    }





    public void PantallaLogueo(View view) {
        Intent i = new Intent(this, InicioSesion.class);
        startActivity(i);
    }


    }


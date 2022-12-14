package com.example.conexion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegistrarseActivity extends AppCompatActivity {

    private EditText editTextnombre;
    private EditText editTextapellido;
    private EditText editTextNumero;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private EditText editTextEmailAddress;
    private EditText editTextFechanacimiento;
    private EditText editTextAlias;
    private EditText editTextTelefono;
    private EditText editTextPassword;
    private EditText eTPasswordConfir;
    private Button btRegistrarse;
    FirebaseFirestore Conexion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        editTextnombre=findViewById(R.id.editTextnombre);
        editTextapellido=findViewById(R.id.editTextapellido);
        editTextNumero=findViewById(R.id.editTextNumero);
        checkBox1=findViewById(R.id.checkBox1);
        checkBox2=findViewById(R.id.checkBox2);
        editTextTelefono=findViewById(R.id.editTextTelefono);
        editTextEmailAddress=findViewById(R.id.editTextEmailAddress);
        editTextAlias=findViewById(R.id.editTextAlias);
        editTextPassword=findViewById(R.id.editTextPassword);
        eTPasswordConfir=findViewById(R.id.eTPasswordConfir);
        editTextFechanacimiento=findViewById(R.id.editTextFechanacimiento);
        btRegistrarse=findViewById(R.id.btRegistrarse);
        Conexion = FirebaseFirestore.getInstance();
        btRegistrarse.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                String nombre1 = editTextnombre.getText().toString();
                String apellido1 = editTextapellido.getText().toString();
                String numero1 = editTextNumero.getText().toString();
                String contrasena1 = editTextPassword.getText().toString();
                String contrasena2 = eTPasswordConfir.getText().toString();
                String lista1 = checkBox1.getText().toString();
                String lista2 = checkBox2.getText().toString();
                String telefono = editTextTelefono.getText().toString();
                String correo1= editTextEmailAddress.getText().toString();
                String alias= editTextAlias.getText().toString();
                String fechanaci= editTextFechanacimiento.getText().toString();



            }
        });



    }

    public boolean onOptionsItemSelected(MenuItem item){
        String nombre1 = editTextnombre.getText().toString();
        String apellido1 = editTextapellido.getText().toString();
        String numero1 = editTextNumero.getText().toString();
        String contrasena1 = editTextPassword.getText().toString();
        String contrasena2 = eTPasswordConfir.getText().toString();
        String lista1 = checkBox1.getText().toString();
        String lista2 = checkBox2.getText().toString();
        String telefono = editTextTelefono.getText().toString();
        String correo1= editTextEmailAddress.getText().toString();
        String alias= editTextAlias.getText().toString();
        String fechanaci= editTextFechanacimiento.toString().toString();



        int num=item.getItemId();
        if (num==R.id.btRegistrarse){
            validacion();
            registrar(nombre1, apellido1, numero1, contrasena1, contrasena2, lista1, lista2, telefono, correo1, alias, fechanaci);

        }
        return super.onOptionsItemSelected(item);
    }

    private void registrar(String nombre1, String apellido1, String numero1, String contrasena1, String contrasena2, String lista1, String lista2, String telefono,
                           String correo1, String alias, String fechanaci) {
        Map<String, Object> map=new HashMap<>();
        map.put("nombre",nombre1);
        map.put("apellido",apellido1);
        map.put("numero",numero1);
        map.put("correo",correo1);
        map.put("contrasena",contrasena1);
        map.put("confirmar",contrasena2);
        map.put("alias",alias);
        map.put("lista",lista1);
        map.put("lista2",lista2);
        map.put("telefono",telefono);
        map.put("nacimiento",fechanaci);


        Conexion.collection("Personas").add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(getApplicationContext(),"registro guardado", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void validacion() {
        String nombre1 = editTextnombre.getText().toString();
        String apellido1 = editTextapellido.getText().toString();
        String numero1 = editTextNumero.getText().toString();
        String contrasena1 = editTextPassword.getText().toString();
        String contrasena2 = eTPasswordConfir.getText().toString();
        String lista1 = checkBox1.getText().toString();
        String lista2 = checkBox2.getText().toString();
        String telefono = editTextTelefono.getText().toString();
        String correo1= editTextEmailAddress.getText().toString();
        String alias= editTextAlias.getText().toString();
        String fechanaci= editTextFechanacimiento.getText().toString();

        if (nombre1.equals("")) {
            editTextnombre.setError("required");
        }
        if (apellido1.equals("")) {
            editTextapellido.setError("required");
        }

        if (numero1.equals("")) {
            editTextNumero.setError("required");
        }

        if (contrasena1.equals("")) {
            editTextPassword.setError("required");
        }

        if (contrasena2.equals("")) {
            eTPasswordConfir.setError("required");
        }

        if (lista1.equals("")) {
            checkBox1.setError("required");
        }
        if (lista2.equals("")) {
            checkBox2.setError("required");
        }

        if (telefono.equals("")) {
            editTextTelefono.setError("required");
        }

        if (correo1.equals("")) {
            editTextEmailAddress.setError("required");
        }

        if (alias.equals("")) {
            editTextAlias.setError("required");
        }

        if (fechanaci.equals("")) {
            editTextFechanacimiento.setError("required");
        }
    }

    public void PantallaLogueo(View view){
        Intent i = new Intent(this, InicioSesion.class);
        startActivity(i);

    }



}
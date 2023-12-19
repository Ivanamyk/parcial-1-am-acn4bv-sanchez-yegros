package com.example.parcial_1_am_acn4bv_sanchez_yegros;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Login extends AppCompatActivity {

    private FirebaseAuth mAuth;
    public void login(String email, String password){
        mAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(getApplicationContext(),Main_Page.class);
                            startActivity(intent);

                        } else {
                            Toast.makeText(Login.this, "Error en el ingreso.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    public void LoginButtonClick(View view){

        EditText emailInput = findViewById(R.id.mail);
        EditText passInput = findViewById(R.id.password);

        String email = emailInput.getText().toString();
        String password = passInput.getText().toString();

        this.login(email,password);

    }
    public void GoRegisterActivity(View view){
        mAuth.signOut();
        Intent intent = new Intent(this, RegisterNewAccount.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
    }
}
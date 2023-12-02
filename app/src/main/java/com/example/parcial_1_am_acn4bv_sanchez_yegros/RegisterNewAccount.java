package com.example.parcial_1_am_acn4bv_sanchez_yegros;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterNewAccount extends AppCompatActivity {

    private FirebaseAuth mAuth;
    public void register(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(RegisterNewAccount.this,"Nuevo Usuario",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(RegisterNewAccount.this, "Error en el ingreso.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void RegisterButtonClick(View view){
        EditText mailInput = findViewById(R.id.mailNewAccount);
        EditText passInput = findViewById(R.id.passwordNewAccount);

        String email = mailInput.getText().toString();
        String password = passInput.getText().toString();

        this.register(email,password);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_new_account);
        mAuth = FirebaseAuth.getInstance();
    }

    public void backToLogin(View view){
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }
}
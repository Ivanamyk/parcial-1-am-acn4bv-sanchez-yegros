package com.example.parcial_1_am_acn4bv_sanchez_yegros;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.Map;
import java.util.HashMap;

public class RegisterNewAccount extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    private void addToFirestore(String email, String password,String uid) {
        Map<String, Object> user = new HashMap<>();
        user.put("email", email);
        user.put("password", password);
        user.put("uid", uid);

        // Add a new document with a generated ID
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("TAG", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("TAG", "Error adding document", e);
                    }
                });
    }

    public void register(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(RegisterNewAccount.this,"Nuevo Usuario",Toast.LENGTH_LONG).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            if (user != null) {
                                // Obtener el UID del usuario
                                String uid = user.getUid();

                                // Almacenar el UID en Firestore
                                addToFirestore(email, password,uid);

                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);}
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
        db = FirebaseFirestore.getInstance();
    }

    public void backToLogin(View view){
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }
}
package com.example.parcial_1_am_acn4bv_sanchez_yegros;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class Screen_ContactUs extends AppCompatActivity {
    EditText et_subject, et_message;
    Button btn;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    private Usuario user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_contact_us);

        et_subject = (EditText) findViewById(R.id.email_subject);
        et_message = (EditText) findViewById(R.id.email_message);

        btn = findViewById(R.id.email_send);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String subject = et_subject.getText().toString().trim();
            String message = et_message.getText().toString().trim();
            String email = "ivana.yegros@davinci.edu.ar";

            if(subject.isEmpty()) {
                Toast.makeText(Screen_ContactUs.this, "Favor de agregar un Asunto", Toast.LENGTH_SHORT).show();
            }
            else if(message.isEmpty()) {
                Toast.makeText(Screen_ContactUs.this, "Favor de agregar un Mensaje", Toast.LENGTH_SHORT).show();
                }
            else{
                String mail = "mailto:" + email +
                        "?&subject" + Uri.encode(subject) +
                        "&body=" + Uri.encode(message);

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse(mail));

                try {
                    startActivity(Intent.createChooser(intent, "Enviar Email"));
                }catch(Exception e){
                    Toast.makeText(Screen_ContactUs.this, "Exception: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                 }
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            String uid = currentUser.getUid();
            db
                    .collection("users")
                    .whereEqualTo("uid",uid)
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if(task.isSuccessful()){
                                for(QueryDocumentSnapshot documento: task.getResult()){
                                    String id = documento.getId();
                                    Object data = documento.getData();
                                    user = documento.toObject(Usuario.class);
                                    TextView textViewUser = findViewById(R.id.textViewUserContacto);
                                    if (textViewUser != null) {
                                        textViewUser.setText(user.getUserName());
                                    }

                                }
                            }
                        }
                    });
        }}
    public void backMainPage(View view){
        Intent intent = new Intent(this,Main_Page.class);
        startActivity(intent);
    }

    public void LogOuTClick(View view){
        mAuth.signOut();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
package com.example.parcial_1_am_acn4bv_sanchez_yegros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Screen_ContactUs extends AppCompatActivity {
    EditText et_subject, et_message;
    Button btn;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
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
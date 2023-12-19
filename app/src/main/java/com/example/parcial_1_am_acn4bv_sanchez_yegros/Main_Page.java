package com.example.parcial_1_am_acn4bv_sanchez_yegros;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.auth.User;

public class Main_Page extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    private Usuario user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        ImageView imagePearl = findViewById(R.id.pearl);

        imagePearl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Pelicula Terror/Slasher",Toast.LENGTH_LONG).show();
            }
        });
        ImageView imageMidSommar = findViewById(R.id.midSommar);
        imageMidSommar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Pelicula Drama/Terror", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView imageJoker = findViewById(R.id.joker);
        imageJoker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Pelicula Drama/Crimen", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView imageJoy = findViewById(R.id.joy);
        imageJoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Pelicula Drama/Comedia", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView imageMoon = findViewById(R.id.moonlight);
        imageMoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Pelicula Independiente/Drama",Toast.LENGTH_SHORT).show();
            }
        });

        ImageView imageBackFut = findViewById(R.id.BackToTheFuture);
        imageBackFut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Pelicula Ciencia Ficcion/Comedia", Toast.LENGTH_SHORT).show();
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
                                    TextView textViewUser = findViewById(R.id.textViewUser);
                                    if (textViewUser != null) {
                                        textViewUser.setText(user.getUserName());
                                    }


                                }
                            }
                        }
                    });
    }}

    public void backMain(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void goToInfoJoker(View view){
        Intent intent = new Intent(this, Screen_Info_Joker.class);
        startActivity(intent);
    }
    public void goToInfoPearl(View view){
        Intent intent = new Intent(this, Screen_Info_Pearl.class);
        startActivity(intent);
    }

    public void goToInfoJoy(View view){
        Intent intent = new Intent(this, Screen_Info_Joy.class);
        startActivity(intent);
    }

    public void goToInfoMoonlight(View view){
        Intent intent = new Intent(this, Screen_Info_Moonlight.class);
        startActivity(intent);
    }

    public void goToInfoMid(View view){
        Intent intent = new Intent(this, Screen_Info_Midsommar.class);
        startActivity(intent);
    }

    public void goToInfoBack(View view){
        Intent intent = new Intent(this, Screen_Info_Back.class);
        startActivity(intent);
    }

    public void goToContactUs(View view){
        Intent intent = new Intent(this, Screen_ContactUs.class);
        startActivity(intent);
    }

    public void LogOuTClick(View view){
        mAuth.signOut();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
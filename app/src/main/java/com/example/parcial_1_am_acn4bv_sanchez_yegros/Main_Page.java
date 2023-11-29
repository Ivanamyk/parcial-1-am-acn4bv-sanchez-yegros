package com.example.parcial_1_am_acn4bv_sanchez_yegros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Main_Page extends AppCompatActivity {

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        mAuth = FirebaseAuth.getInstance();
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
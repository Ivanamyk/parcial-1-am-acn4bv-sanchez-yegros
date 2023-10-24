package com.example.parcial_1_am_acn4bv_sanchez_yegros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Main_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

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
}
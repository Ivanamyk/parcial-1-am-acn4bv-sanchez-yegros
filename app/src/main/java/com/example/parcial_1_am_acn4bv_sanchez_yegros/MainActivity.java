package com.example.parcial_1_am_acn4bv_sanchez_yegros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layout = findViewById(R.id.content); // Reemplaza 'content' con el ID de tu LinearLayout
        Button myButton = new Button(this);
        myButton.setText("Mi Botón");

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.gravity = Gravity.CENTER; // Esto centrará el botón en el LinearLayout
        myButton.setLayoutParams(layoutParams);

        layout.addView(myButton);
    }
}
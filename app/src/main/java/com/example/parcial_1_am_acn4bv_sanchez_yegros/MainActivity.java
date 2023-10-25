package com.example.parcial_1_am_acn4bv_sanchez_yegros;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Animation scaleUp, scaleDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layout = findViewById(R.id.content); // Reemplaza 'content' con el ID de tu LinearLayout

        TextView textoIntro = new TextView(this);

        textoIntro.setId(View.generateViewId());

        textoIntro.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        textoIntro.setText(getResources().getString(R.string.Text_Start));
        textoIntro.setGravity(Gravity.CENTER);
        textoIntro.setPadding(0,0,0,50);
        textoIntro.setTextColor(getResources().getColor(R.color.white));
        textoIntro.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
        //ConstraintLayout constraintLayout = findViewById(R.id.constraint);
        //constraintLayout.addView(textoIntro);
        layout.addView(textoIntro);

        //image effect
        imageView = findViewById(R.id.imageView);
        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    imageView.startAnimation(scaleUp);

                }else if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    imageView.startAnimation(scaleDown);
                }

                return true;
            }

        });

    }

    public void openHome(View view){
        Intent intent = new Intent(this,Main_Page.class);
        startActivity(intent);
    }
}
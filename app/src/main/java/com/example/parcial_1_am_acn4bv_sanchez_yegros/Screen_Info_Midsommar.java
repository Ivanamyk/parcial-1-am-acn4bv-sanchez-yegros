package com.example.parcial_1_am_acn4bv_sanchez_yegros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.firebase.auth.FirebaseAuth;

public class Screen_Info_Midsommar extends AppCompatActivity {

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_midsommar);

        VideoView videoView = findViewById(R.id.videoViewMid);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.mid;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

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
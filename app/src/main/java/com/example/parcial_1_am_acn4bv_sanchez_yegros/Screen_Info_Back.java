package com.example.parcial_1_am_acn4bv_sanchez_yegros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class Screen_Info_Back extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_back);

        VideoView videoView = findViewById(R.id.videoViewBack);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.back;
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
}
package com.example.parcial_1_am_acn4bv_sanchez_yegros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class Screen_Info_Joy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_joy);

        VideoView videoView = findViewById(R.id.videoViewJoy);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.joy;
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
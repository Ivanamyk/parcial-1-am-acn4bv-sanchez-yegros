package com.example.parcial_1_am_acn4bv_sanchez_yegros;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class Screen_Info_Joker extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private Usuario user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_joker);

        //joker trailer
        VideoView videoView = findViewById(R.id.videoViewJoker);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.joker;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);



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
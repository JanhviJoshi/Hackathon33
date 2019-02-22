package com.example.user.hackathon3;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.VideoView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class MainActivity extends AppCompatActivity {

    private StorageReference mStorageReference;
    private Button button;
    private VideoView videoView;
    private Uri videoUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStorageReference= FirebaseStorage.getInstance().getReference();
       videoView= findViewById(R.id.viewvideo);
       button= findViewById(R.id.button);
       videoUri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/hackathon3-abfe1.appspot.com/o/hackathon1.mp4?alt=media&token=9b025d50-5c9c-4099-97c3-c827265948b0");

       videoView.setVideoURI(videoUri);
       videoView.requestFocus();
       videoView.start();




    }
}

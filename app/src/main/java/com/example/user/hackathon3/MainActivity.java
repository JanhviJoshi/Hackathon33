package com.example.user.hackathon3;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.VideoView;

import com.example.user.hackathon3.VideoViewAdapter.Callback;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements VideoViewAdapter.Callback{

    private StorageReference mStorageReference;
    private RecyclerView recyclerView;
    private VideoViewAdapter videoViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("demo");

        //videoView= (VideoView)findViewById(R.id.viewvideo);
        // button= findViewById(R.id.playButton);
       recyclerView= findViewById(R.id.recylerview);

      // videoUri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/hackathon3-abfe1.appspot.com/o/hackathon1.mp4?alt=media&token=9b025d50-5c9c-4099-97c3-c827265948b0");

      /* videoView.setVideoURI(videoUri);
       videoView.requestFocus();
       videoView.start();
       isPlaying = true;

       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(isPlaying){
                   videoView.pause();
               }
           }
       });*/
        LinearLayoutManager layoutManager= new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        //sending reference of this activity to our adapter
        //it is received in a reference of type Callback(which is an interface; it has been implemented
        //by this activity
        videoViewAdapter = new VideoViewAdapter(this);
        recyclerView.setAdapter(videoViewAdapter);
        recyclerView.setHasFixedSize(true);


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<String> mVideo = new ArrayList<>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    mVideo.add(ds.child("check").getValue(String.class));
                }
                videoViewAdapter.setData(mVideo);
            }

                @Override
                public void onCancelled (DatabaseError databaseError) {

                }
        });
            }

    @Override
    public void friendCallback() {
        Intent intent= new Intent(this, VeiwVideo.class);
        startActivity(intent);
    }
}




package com.example.user.hackathon3;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

public class VeiwVideo extends AppCompatActivity {
    private VideoView mainvideoView;
    private ImageView playbtn;
    private TextView currentTimer;
    private TextView durationTimer;
    private ProgressBar currentProgress;
    private ProgressBar bufferProgress;

    private Uri videoUri;
    private boolean isPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veiw_video);

        isPlaying= false;

        mainvideoView = (VideoView) findViewById(R.id.mainvideoView);
        playbtn= (ImageView) findViewById(R.id.playbtn);
        currentProgress = (ProgressBar) findViewById(R.id.currentProgress);
        currentTimer = (TextView) findViewById(R.id.currentTimer);
        durationTimer = (TextView) findViewById(R.id.durationTimer);
       // bufferProgress = (ProgressBar)findViewById(R.id.bufferProgress);

        Button button= findViewById(R.id.button3);

        videoUri= Uri.parse("https://firebasestorage.googleapis.com/v0/b/hackathon3-abfe1.appspot.com/o/hackathon1.mp4?alt=media&token=9b025d50-5c9c-4099-97c3-c827265948b0");
        mainvideoView.setVideoURI(videoUri);
        mainvideoView.requestFocus();


        mainvideoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i1) {

                if(i == mediaPlayer.MEDIA_INFO_BUFFERING_START ) {

                   //
                    // bufferProgress.setVisibility(View.VISIBLE);

                } else if(i == mediaPlayer.MEDIA_INFO_BUFFERING_START)

                    bufferProgress.setVisibility(View.INVISIBLE);

                return false;
            }
        });

        mainvideoView.start();
        isPlaying = true;
        playbtn.setImageResource(R.mipmap.ic_pause);playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isPlaying){

                    mainvideoView.pause();
                    isPlaying = false;
                    playbtn.setImageResource(R.drawable.ic_play_arrow);

                }

                else
                {
                    mainvideoView.start();
                    isPlaying = true;
                    playbtn.setImageResource(R.mipmap.ic_pause);
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Uri gmmIntentUri= Uri.parse("google.navigation:q=28.7041, 77.1025");
                 Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                 mapIntent.setPackage("com.google.android.apps.maps");
                 startActivity(mapIntent);
             }
         });

    }
}

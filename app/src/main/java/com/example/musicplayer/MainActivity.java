package com.example.musicplayer;

import static android.media.AudioManager.STREAM_MUSIC;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button pause, play, stp;
        pause = findViewById(R.id.pause);
        play = findViewById(R.id.play);

        MediaPlayer mp = new MediaPlayer();
        mp.setAudioStreamType(STREAM_MUSIC);
        String apath = "android.resource://" + getPackageName() + "/raw/hoor";
        String onlineaudio="";
        Uri audiouri = Uri.parse(apath);
        try {


            mp.setDataSource(this, audiouri);
            mp.prepare();
        } catch (IOException e) {
            System.out.println("Exception occured");
        }

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
mp.pause();
            }
        });

    }
}
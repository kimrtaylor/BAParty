package com.example.ktaylor.baparty;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class PartyPage extends Activity {

    String link = "https://partywebapp.firebaseapp.com/";
    String messageText = "Hey, I just booked a BA Flight to Ibiza! Come join me! ";
    String messageSubject = "Your subject here";
    String sharerTitle = "Share the party!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_party_page);
        final Button button = findViewById(R.id.invite_button);
        final MediaPlayer mPlayer = MediaPlayer.create(this.getApplicationContext(), R.raw.ibiza_test1);
        mPlayer.start();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = messageText + link;
                String shareSub = messageSubject;
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, sharerTitle));

                mPlayer.stop();
            }
        });


    }
}

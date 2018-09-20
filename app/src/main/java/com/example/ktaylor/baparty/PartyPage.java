package com.example.ktaylor.baparty;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PartyPage extends Activity {

    String link = "https://www.ba.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_page);
        final Button button = findViewById(R.id.invite_button);
        final MediaPlayer mPlayer = MediaPlayer.create(this.getApplicationContext(), R.raw.come_fly_with_me);
        mPlayer.start();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Hey, I just booked a BA Flight to Ibiza! Come join me! " + link;
                String shareSub = "Your subject here";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share the party!"));

                mPlayer.stop();
            }
        });


    }
}

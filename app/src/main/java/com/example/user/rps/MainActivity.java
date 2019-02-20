package com.example.user.rps;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends Activity {

    TextView t;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.starup);
        init();

        MediaPlayer player = MediaPlayer.create(this, R.raw.music);
        player.setLooping(true);
        player.start();


        t = (TextView)findViewById(R.id.tittle);
        Typeface myFont = Typeface.createFromAsset(getAssets(),"fonts/Capture_it.ttf");
        t.setTypeface(myFont);

        b = (Button)findViewById(R.id.play);
        Typeface myFont2 = Typeface.createFromAsset(getAssets(),"fonts/Capture_it.ttf");
        b.setTypeface(myFont2);




    }


    public Button btn;
    public void init() {
        btn = (Button)findViewById(R.id.play);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextPage = new Intent(MainActivity.this, page2.class);
                startActivity(nextPage);
            }
        });
    }

}

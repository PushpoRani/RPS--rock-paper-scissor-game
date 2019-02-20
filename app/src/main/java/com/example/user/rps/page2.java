package com.example.user.rps;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.Delayed;

public class page2 extends AppCompatActivity {

    Button b_rock, b_paper, b_scissors, b, ptr;
    ImageView iv_cpu, iv_me, iv;
    TextView t, c, m;
    int me=0 , cp=0;

    String myChoice, cpuChoice, result;
    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        t = (TextView)findViewById(R.id.txtme);
        Typeface myFont4 = Typeface.createFromAsset(getAssets(),"fonts/Capture_it_2.ttf");
        t.setTypeface(myFont4);

        t = (TextView)findViewById(R.id.txtcpu);
        Typeface myFont5 = Typeface.createFromAsset(getAssets(),"fonts/Capture_it_2.ttf");
        t.setTypeface(myFont5);

        t = (TextView)findViewById(R.id.txtpoint);
        Typeface myF = Typeface.createFromAsset(getAssets(),"fonts/Capture_it.ttf");
        t.setTypeface(myF);

        t = (TextView)findViewById(R.id.txtpoint2);
        Typeface myF1 = Typeface.createFromAsset(getAssets(),"fonts/Capture_it.ttf");
        t.setTypeface(myF1);

        t = (TextView)findViewById(R.id.point);
        Typeface myF2 = Typeface.createFromAsset(getAssets(),"fonts/Capture_it.ttf");
        t.setTypeface(myF2);

        t = (TextView)findViewById(R.id.point2);
        Typeface myF3 = Typeface.createFromAsset(getAssets(),"fonts/Capture_it.ttf");
        t.setTypeface(myF3);

        b = (Button)findViewById(R.id.b_rock);
        Typeface myFont1 = Typeface.createFromAsset(getAssets(),"fonts/Capture_it.ttf");
        b.setTypeface(myFont1);

        b = (Button)findViewById(R.id.b_paper);
        Typeface myFont2 = Typeface.createFromAsset(getAssets(),"fonts/Capture_it.ttf");
        b.setTypeface(myFont2);

        b = (Button)findViewById(R.id.b_scissors);
        Typeface myFont3 = Typeface.createFromAsset(getAssets(),"fonts/Capture_it.ttf");
        b.setTypeface(myFont3);

        ptr= (Button)findViewById(R.id.btnpoint);
        Typeface myFont6 = Typeface.createFromAsset(getAssets(),"fonts/Capture_it.ttf");
        ptr.setTypeface(myFont6);

        ptr.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
               Intent intent= new Intent(page2.this, Pop.class);
                intent.putExtra("point1",m.getText());
                intent.putExtra("point2",c.getText());
                startActivity(intent);
            }
        });


        iv_cpu = (ImageView) findViewById(R.id.iv_cpu);
        iv_me = (ImageView) findViewById(R.id.iv_me);
        iv = (ImageView) findViewById(R.id.iv);

        b_rock = (Button) findViewById(R.id.b_rock);
        b_paper = (Button) findViewById(R.id.b_paper);
        b_scissors = (Button) findViewById(R.id.b_scissors);

        c=(TextView)findViewById(R.id.point);
        m=(TextView)findViewById(R.id.point2);


        r = new Random();

        b_rock.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                myChoice = "rock";
                iv_me.setImageResource(R.drawable.rock);
                calculate();

            }
        });
        b_paper.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                myChoice = "paper";
                iv_me.setImageResource(R.drawable.paper);
                calculate();

            }
        });
        b_scissors.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                myChoice = "scissors";
                iv_me.setImageResource(R.drawable.scissor);
                calculate();

            }
        });


    }
    public void clock(){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.blink);
        iv.startAnimation(animation);
        //blink();
    }
    public void blink(){
        Animation anima = AnimationUtils.loadAnimation(this, R.anim.clockwise);
        iv.startAnimation(anima);
    }



    public void calculate(){

        int cpu = r.nextInt(3);
        if (cpu == 0) {
            cpuChoice = "rock";
            iv_cpu.setImageResource(R.drawable.rock);
        }else if (cpu == 1){
            cpuChoice = "paper";
            iv_cpu.setImageResource(R.drawable.paper);
        }else if (cpu == 2){
            cpuChoice = "scissors";
            iv_cpu.setImageResource(R.drawable.scissor);
        }

        if(myChoice.equals("rock")  && cpuChoice.equals("paper")){
            result = "You Lose";

            cp++;
            c.setText(String.valueOf(cp));
            m.setText(String.valueOf(me));
            iv.setImageResource(R.drawable.lose);
            clock();
            MediaPlayer player = MediaPlayer.create(this, R.raw.lose);
            player.start();
        }else
        if(myChoice.equals("rock") && cpuChoice.equals("scissors")){
            result = "You Win";
            me++;

            c.setText(String.valueOf(cp));
            m.setText(String.valueOf(me));
            clock();
            iv.setImageResource(R.drawable.win);
            MediaPlayer player = MediaPlayer.create(this, R.raw.winner);
            player.start();
        }else

        if(myChoice.equals("paper") && cpuChoice.equals("rock")){
            result = "You Win";
            me++;

            c.setText(String.valueOf(cp));
            m.setText(String.valueOf(me));
            clock();
            iv.setImageResource(R.drawable.win);
            MediaPlayer player = MediaPlayer.create(this, R.raw.winner);
            player.start();
        }else
        if(myChoice.equals("paper") && cpuChoice.equals("scissors")){
            result = "You Lose";

            cp++;
            c.setText(String.valueOf(cp));
            m.setText(String.valueOf(me));
            clock();
            iv.setImageResource(R.drawable.lose);
            MediaPlayer player = MediaPlayer.create(this, R.raw.lose);
            player.start();
        }else

        if(myChoice.equals("scissors") && cpuChoice.equals("paper")){
            result = "You Win";
            me++;

            c.setText(String.valueOf(cp));
            m.setText(String.valueOf(me));
            clock();
            iv.setImageResource(R.drawable.win);
            MediaPlayer player = MediaPlayer.create(this, R.raw.winner);
            player.start();
        }
        else if(myChoice.equals("scissors") && cpuChoice.equals("rock")){
            result = "You Lose";

            cp++;
            c.setText(String.valueOf(cp));
            m.setText(String.valueOf(me));
            clock();
            iv.setImageResource(R.drawable.lose);
            MediaPlayer player = MediaPlayer.create(this, R.raw.lose);
            player.start();
        }

        else if(myChoice.equals("rock") && cpuChoice.equals("rock")){
            result = "Draw";
            clock();
            iv.setImageResource(R.drawable.draw);
            MediaPlayer player = MediaPlayer.create(this, R.raw.draw);
            player.start();
        }
        else if(myChoice.equals("scissors") && cpuChoice.equals("scissors")){
            result = "Draw";
            clock();
            iv.setImageResource(R.drawable.draw);
            MediaPlayer player = MediaPlayer.create(this, R.raw.draw);
            player.start();
        }

        else if(myChoice.equals("paper") && cpuChoice.equals("paper")){
            result = "Draw";
            clock();
            iv.setImageResource(R.drawable.draw);
            MediaPlayer player = MediaPlayer.create(this, R.raw.draw);
            player.start();
        }

        Toast.makeText(page2.this, result, Toast.LENGTH_SHORT).show();

    }
}

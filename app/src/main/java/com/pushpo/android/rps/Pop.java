package com.pushpo.android.rps;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by User on 01-Jun-17.
 */
public class Pop extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popout);

        TextView textView = (TextView) findViewById(R.id.tv);
        Typeface myFont2 = Typeface.createFromAsset(getAssets(),"fonts/Capture_it.ttf");
        textView.setTypeface(myFont2);

        TextView textView2 = (TextView) findViewById(R.id.tv2);
        Typeface myFont3 = Typeface.createFromAsset(getAssets(),"fonts/Capture_it.ttf");
        textView2.setTypeface(myFont3);

        TextView textView3 = (TextView) findViewById(R.id.tv3);
        Typeface myFont4 = Typeface.createFromAsset(getAssets(),"fonts/Capture_it.ttf");
        textView3.setTypeface(myFont4);

        TextView textView4 = (TextView) findViewById(R.id.tv4);
        Typeface myFont5 = Typeface.createFromAsset(getAssets(),"fonts/Capture_it.ttf");
        textView4.setTypeface(myFont5);


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width =dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.4));

        TextView pointview = (TextView)findViewById(R.id.tv2);
        pointview.setText(getIntent().getExtras().getString("point1"));

        TextView pointview1 = (TextView)findViewById(R.id.tv4);
        pointview1.setText(getIntent().getExtras().getString("point2"));

    }
}

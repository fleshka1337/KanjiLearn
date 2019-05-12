package com.example.kanjilearn;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    public static int TIME_OUT = 1600;

    private TextView textView;
    private ProgressBar progressBar;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //getSupportActionBar().hide();

        textView = (TextView)findViewById(R.id.splash_Text);
        progressBar = (ProgressBar)findViewById(R.id.splash_Progress);
        imageView = (ImageView)findViewById(R.id.splash_Image);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.splash_transition);

        textView.startAnimation(animation);
        progressBar.startAnimation(animation);
        imageView.startAnimation(animation);

        if (Build.VERSION.SDK_INT >= 21) {
            //Статус бар - вверху
            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.Grey));
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },TIME_OUT);
    }
}

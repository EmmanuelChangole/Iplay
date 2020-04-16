package com.iplaymusic.iplay.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.iplaymusic.iplay.R;

public class SplashActivity extends AppCompatActivity {
    private static final long SPLASH_DURATION = 1300;
    Animation topAnimation,bottomAnimation;
    ImageView imgLogo;
    TextView tvlogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        hideActionBar();
        initWidgets();
        loadAnim();
        handler();

    }

    private void handler()
    {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_DURATION);


    }

    private void initWidgets()
    {
        imgLogo=findViewById(R.id.imgLogo);
        tvlogo=findViewById(R.id.tvDesc);

    }

    private void loadAnim()
    {
        topAnimation= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnimation=AnimationUtils.loadAnimation(this,R.anim.bottom_navigation);
        imgLogo.setAnimation(bottomAnimation);
        tvlogo.setAnimation(topAnimation);


    }

    private void hideActionBar()
    {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }


}

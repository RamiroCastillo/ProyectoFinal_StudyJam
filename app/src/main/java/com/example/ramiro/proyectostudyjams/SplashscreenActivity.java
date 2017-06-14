package com.example.ramiro.proyectostudyjams;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashscreenActivity extends AppCompatActivity {


    private ImageView imageView;
    private Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        getSupportActionBar().hide();

        imageView = (ImageView)findViewById(R.id.ivLogotipo);
        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.splashcreen);
        imageView.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        //animacion = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.splashscreen);
    }
}

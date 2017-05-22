package com.example.echolin.week7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class WelcomeActivity extends AppCompatActivity implements ViewPropertyAnimatorListener {

    private ImageView welcome_iv;
    private SharedPreferences welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        welcome = getSharedPreferences("welcome", MODE_PRIVATE);
        welcome_iv = (ImageView) findViewById(R.id.welcome_iv);
        welcome_iv.post(new Runnable() {
            @Override
            public void run() {
                ViewCompat.setPivotX(welcome_iv, (long) (welcome_iv.getWidth()) / 2);
                ViewCompat.setPivotY(welcome_iv, (long) (welcome_iv.getHeight()) / 2);
                ViewCompat.animate(welcome_iv).scaleX(1.4f).scaleY(1.4f).setDuration(2000).setListener(WelcomeActivity.this).start();
            }
        });

    }


    @Override
    public void onAnimationStart(View view) {

    }

    @Override
    public void onAnimationEnd(View view) {
        boolean isFirst = welcome.getBoolean("isFirst", true);
        if (isFirst){
//            welcome.edit().putBoolean("isFirst",false).commit();
            Intent intent = new Intent(this,GuideActivity.class);
            startActivity(intent);
            finish();
        }else{
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onAnimationCancel(View view) {

    }



}

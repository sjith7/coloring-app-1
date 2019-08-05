package com.colorchooser;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class splashscreen extends AppCompatActivity {

    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        TextView textView = (TextView) findViewById(R.id.textView2);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/HennyPenny-Regular.ttf");
        textView.setTypeface(typeface);
        lottieAnimationView= (LottieAnimationView) findViewById(R.id.LottieAnimationView);
        startCheckAnimation();
        CountDownTimer ct = new CountDownTimer(5000,100) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();

            }
        };
        ct.start();
    }
    private void startCheckAnimation(){
        ValueAnimator animator=ValueAnimator.ofFloat(0f,1f).setDuration(1500);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                lottieAnimationView.setProgress((Float)animation.getAnimatedValue());
            }
        });
        if(lottieAnimationView.getProgress()==0f){
            animator.setStartDelay(100);
            animator.start();
        }else {
            lottieAnimationView.setProgress(0f);
        }
    }
}


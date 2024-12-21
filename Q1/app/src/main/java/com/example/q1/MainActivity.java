package com.example.q1;

import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private View box;
    private RelativeLayout.LayoutParams layoutParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        box = findViewById(R.id.box);
        layoutParams = (RelativeLayout.LayoutParams) box.getLayoutParams();

        Button upButton = findViewById(R.id.button_up);
        Button downButton = findViewById(R.id.button_down);
        Button leftButton = findViewById(R.id.button_left);
        Button rightButton = findViewById(R.id.button_right);

        upButton.setOnClickListener(v -> animateBox(0, -200));
        downButton.setOnClickListener(v -> animateBox(0, 200));
        leftButton.setOnClickListener(v -> animateBox(-200, 0));
        rightButton.setOnClickListener(v -> animateBox(200, 0));
    }

    private void animateBox(float deltaX, float deltaY) {
        TranslateAnimation animation = new TranslateAnimation(0, deltaX, 0, deltaY);
        animation.setDuration(500);
        animation.setFillAfter(true);
        box.startAnimation(animation);

        layoutParams.leftMargin += deltaX;
        layoutParams.topMargin += deltaY;
        box.setLayoutParams(layoutParams);
    }
}

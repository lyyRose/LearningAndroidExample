package com.tangcco.animation_example;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_frame_animation).setOnClickListener(this);
        findViewById(R.id.btn_tween_animation).setOnClickListener(this);
        findViewById(R.id.btn_property_animation).setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn_frame_animation:
                startActivity(FrameAnimActivity.class);
                break;
            case R.id.btn_tween_animation:
                startActivity(TweenAnimActivity.class);
                break;
            case R.id.btn_property_animation:
                startActivity(PropertyAnimActivity.class);
                break;
        }
    }

    private void startActivity(Class<? extends Activity> clazz){
        Intent intent = new Intent(this,clazz);
        startActivity(intent);
    }
}

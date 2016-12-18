package com.tangcco.animation_example;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

public class FrameAnimActivity extends AppCompatActivity {

    private Button btnStartAnimation;
    private ImageView ivFrameGirl;
    private AnimationDrawable frameAnimationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_anim);

        ivFrameGirl = (ImageView) findViewById(R.id.iv_frame_girl);
        //设置动画
        ivFrameGirl.setImageResource(R.drawable.anim_frame_demo);
        //取得动画Drawable对象
        frameAnimationDrawable = (AnimationDrawable) ivFrameGirl.getDrawable();

        btnStartAnimation = (Button) findViewById(R.id.btn_start_frame_anim);
        btnStartAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (frameAnimationDrawable.isRunning()){
                    btnStartAnimation.setText("播放动画");
                    //停止动画
                    frameAnimationDrawable.stop();

                }else {
                    btnStartAnimation.setText("停止动画");
                    //开启动画
                    frameAnimationDrawable.start();
                }

            }

        });


    }

    @Override
    protected void onPause() {
        super.onPause();
        //此时应该停止动画
        if (frameAnimationDrawable.isRunning()){
            frameAnimationDrawable.stop();
        }

    }
}

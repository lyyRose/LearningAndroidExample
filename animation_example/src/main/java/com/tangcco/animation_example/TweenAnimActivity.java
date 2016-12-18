package com.tangcco.animation_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class TweenAnimActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnAlpha;
    private Button btnTranslate;
    private Button btnScale;
    private Button btnRotate;
    private ImageView ivDemo1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_anim);

        initView();

    }



    @Override
    public void onClick(View view) {

        Animation anim = null;

        switch (view.getId()){
            case R.id.btn_alpha_anim:
                anim = AnimationUtils.loadAnimation(this,R.anim.anim_alpha_demo);
                //设置重复次数 INFINITE 无限循环  或者是一个确定的数值
                //anim.setRepeatCount(2);  //我这里此处代码设置失效

                //设置重复模式 在repeatCount > 0 或者是 INFINITE时有效
                //RESTART从头开始到结束   REVERSE 翻转模式  重结束到开始
                anim.setRepeatMode(Animation.RESTART); //我这里 XML 文件中不没有声明该属性 代码设置无效 ，如果XML中声明 ，代码优先级高于XML
                break;
            case R.id.btn_translate_anim:
                anim = AnimationUtils.loadAnimation(this,R.anim.anim_translate_demo);
                break;
            case R.id.btn_scale_anim:
                anim = AnimationUtils.loadAnimation(this,R.anim.anim_scale_demo);
                break;
            case R.id.btn_rotate_anim:
                anim = AnimationUtils.loadAnimation(this,R.anim.anim_rotate_demo);
                break;

        }

        //设置动画监听
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //动画开始
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //动画结束
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //动画重复
            }
        });

        //开始动画
//        ivDemo1.setAnimation(anim);
//        ivDemo1.getAnimation().start();

        ivDemo1.startAnimation(anim);

    }

    private void initView() {

        btnAlpha = (Button) findViewById(R.id.btn_alpha_anim);
        btnTranslate = (Button) findViewById(R.id.btn_translate_anim);
        btnScale = (Button) findViewById(R.id.btn_scale_anim);
        btnRotate = (Button) findViewById(R.id.btn_rotate_anim);
        ivDemo1 = (ImageView) findViewById(R.id.iv_tween_demo_1);

        btnAlpha.setOnClickListener(this);
        btnTranslate.setOnClickListener(this);
        btnScale.setOnClickListener(this);
        btnRotate.setOnClickListener(this);
    }
}

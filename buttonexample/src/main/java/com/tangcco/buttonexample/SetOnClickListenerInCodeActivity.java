package com.tangcco.buttonexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SetOnClickListenerInCodeActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn1,btn2,btn3,btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_on_click_listener_in_code);
        //找到button 对象
        btn1 = (Button) findViewById(R.id.btn_button_1);
        btn2 = (Button) findViewById(R.id.btn_button_2);
        btn3 = (Button) findViewById(R.id.btn_button_3);
        btn4 = (Button) findViewById(R.id.btn_button_4);
        //设置监听
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    //实现 View.OnClickListener 接口中的 onClick方法
    @Override
    public void onClick(View view) {
        String toastMsg = "";
        switch (view.getId()){
            case R.id.btn_button_1:
                toastMsg = "点击了BUTTON1";
                break;
            case R.id.btn_button_2:
                toastMsg = "点击了BUTTON2";
                break;
            case R.id.btn_button_3:
                toastMsg = "点击了BUTTON3";
                break;
            case R.id.btn_button_4:
                toastMsg = "点击了BUTTON4";
                break;
        }
        Toast.makeText(this, toastMsg, Toast.LENGTH_SHORT).show();
    }

}

//    Button btnAnonymous = (Button) findViewById(R.id.btn_anonymous);
//    btnAnonymous.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            Toast.makeText(SetOnClickListenerInCodeActivity.this, "匿名类对象方式设置监听", Toast.LENGTH_SHORT).show();
//        }
//    });

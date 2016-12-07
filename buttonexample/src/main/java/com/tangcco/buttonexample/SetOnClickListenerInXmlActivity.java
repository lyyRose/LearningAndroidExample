package com.tangcco.buttonexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SetOnClickListenerInXmlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_on_click_listener_in_xml);
    }


    /**
     * 这个方法的方法名必须跟xml中<Button>标签中 android:onclick 属性值一样
     * @param v 必须要有 详情参考 View.OnClickListener接口
     */
    public void setListenerInXml(View v){

        Toast.makeText(this, "xml中注册点击事件", Toast.LENGTH_SHORT).show();
    }
}

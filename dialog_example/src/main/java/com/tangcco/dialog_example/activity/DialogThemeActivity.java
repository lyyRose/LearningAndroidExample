package com.tangcco.dialog_example.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tangcco.dialog_example.R;


/**
 * 通过设置Activity主题 让activity以Dialog样式显示
 * 在mainfest文件中配置activity的 theme
 * 如果activity 继承自  android.app.Activity  theme 的值是@android:style/Theme.Dialog
 * 如果继承自 android.support.v7.app.AppCompatActivity  theme的值是@style/Theme.AppCompat.Dialog
 */
public class DialogThemeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_theme);
        setTitle("DialogTheme");
    }
}

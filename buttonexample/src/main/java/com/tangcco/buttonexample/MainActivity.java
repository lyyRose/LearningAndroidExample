package com.tangcco.buttonexample;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_in_xml).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(SetOnClickListenerInXmlActivity.class);
            }
        });

        findViewById(R.id.btn_in_code).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(SetOnClickListenerInCodeActivity.class);
            }
        });

    }


    private void startActivity(Class<? extends Activity> clazz){
        Intent intent = new Intent(this,clazz);
        startActivity(intent);
    }
}
